package com.seatrend.exam.network;

import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.seatrend.exam.common.Constants;
import com.seatrend.exam.common.MyApplication;
import com.seatrend.exam.entity.BaseEntity;
import com.seatrend.exam.entity.CheckLoginEntity;
import com.seatrend.exam.entity.ErrorEntity;
import com.seatrend.exam.module.BaseModule;
import com.seatrend.exam.response.BaseResponse;
import com.seatrend.exam.response.CommonResponse;
import com.seatrend.exam.utils.SharedPreferencesUtils;
import com.seatrend.exam.utils.Utils;

import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * Created by seatrend on 2018/8/20.
 */

public class NetworkService {

    private static NetworkService mHttpService;
    private BaseModule mBaseModule;
//    public static String httpUrl = "http://seatrend.f3322.org:8089";
//    public static String httpUrl = "http://11.121.35.24";
    public static String httpUrl = "http://"+ SharedPreferencesUtils.getIpAddress() + ":" + SharedPreferencesUtils.getPort();

//    public static String httpUrl = "http://11.121.35.193:8089";//

    private final int SUCCESS_CODE = 0;
    private final int FAILED_CODE = 1;

    private final int TIME_OUT = 60 * 1000;

    private Gson gson = new Gson();

    private OkHttpClient mOkHttpClient = new OkHttpClient.Builder()
            .readTimeout(TIME_OUT, TimeUnit.MILLISECONDS)
            .writeTimeout(TIME_OUT, TimeUnit.MILLISECONDS)
            .connectTimeout(20 * 1000, TimeUnit.MILLISECONDS)
            .build();

    public static NetworkService getInstance() {
        if (mHttpService == null) {
            synchronized (NetworkService.class) {
                if (mHttpService == null) {
                    mHttpService = new NetworkService();
                }
            }
        }
        return mHttpService;
    }

    private Handler mHandler = new Handler(new Handler.Callback() {
        @Override
        public boolean handleMessage(Message msg) {
            switch (msg.what) {
                case SUCCESS_CODE:
                    BaseResponse baseResponse1 = (BaseResponse) msg.obj;
                    mBaseModule.doWorkResults(baseResponse1, true);
                    break;

                case FAILED_CODE:
                    BaseResponse baseResponse2 = (BaseResponse) msg.obj;
                    mBaseModule.doWorkResults(baseResponse2, false);
                    break;
            }
            return false;
        }
    });

    public void getDataFromServer(Map<String, String> map, final String url, String method, BaseModule module) {
        httpUrl = "http://"+ SharedPreferencesUtils.getIpAddress() + ":" + SharedPreferencesUtils.getPort();

        this.mBaseModule = module;
        if(TextUtils.isEmpty(SharedPreferencesUtils.getIpAddress())|| TextUtils.isEmpty(SharedPreferencesUtils.getPort())){
            Message message = Message.obtain();
            message.what=FAILED_CODE;
            CommonResponse commonResponse=new CommonResponse();
            commonResponse.setUrl(url);
            commonResponse.setResponseString("请先设置服务器IP地址和端口号");
            message.obj=commonResponse;
            mHandler.sendMessage(message);
            return;
        }

        final String finalUrl = httpUrl + url;

        if (!Utils.isNetworkConnected(MyApplication.getMyApplicationContext())){
            Message message = Message.obtain();
            message.what=FAILED_CODE;
            CommonResponse commonResponse=new CommonResponse();
            commonResponse.setUrl(url);
            commonResponse.setResponseString("您的设备未联网");
            message.obj=commonResponse;
            mHandler.sendMessage(message);
            return;
        }

        Request request;
        try {
            if (method.equals(Constants.GET)) {
                StringBuilder buffer = new StringBuilder();
                buffer.append("?");
                for (Map.Entry<String, String> entry : map.entrySet()) {
                    buffer.append(entry.getKey().trim()).append("=").append(entry.getValue().trim()).append("&");
                }
                String s = buffer.toString();
                String parameter = s.substring(0, s.length() - 1);
                request = new Request.Builder()
                        .url(finalUrl + parameter)
                        .addHeader("Authorization", Constants.authorization)
                        .get()
                        .build();

                Log.i("发送成功", finalUrl + parameter);

            } else {
                FormBody.Builder builder = new FormBody.Builder();
                for (Map.Entry<String, String> entry : map.entrySet()) {
                    builder.add(entry.getKey().trim(), entry.getValue().trim());
                }

                RequestBody requestBody = builder.build();

                if(url.contains(Constants.USER_LOGIN)) {
                    request = new Request.Builder()
                            .url(finalUrl)
                            .post(requestBody)
                            .build();
                }else {
                    request = new Request.Builder()
                            .url(finalUrl)
                            .addHeader("Authorization", Constants.authorization)
                            .post(requestBody)
                            .build();
                }

                Log.i("发送成功", finalUrl);
            }
        } catch (Exception e) {
            Message message = Message.obtain();
            message.what = FAILED_CODE;
            BaseResponse baseResponse = new BaseResponse();
            baseResponse.setUrl(url);
            baseResponse.setResponseString(e.getMessage());
            message.obj = baseResponse;
            mHandler.sendMessage(message);
            return;
        }

        mOkHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Message message = Message.obtain();
                message.what = FAILED_CODE;
                BaseResponse baseResponse = new BaseResponse();
                baseResponse.setUrl(url);
                baseResponse.setResponseString(e.getMessage());
                message.obj = baseResponse;
                mHandler.sendMessage(message);
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                Message message = Message.obtain();
                String resp = response.body().string();

                Log.i("接收成功", resp);

                if (TextUtils.isEmpty(resp)) {
                    message.what = FAILED_CODE;
                    BaseResponse baseResponse = new BaseResponse();
                    baseResponse.setUrl(url);
                    baseResponse.setResponseString("服务器响应内容为空");
                    message.obj = baseResponse;
                    mHandler.sendMessage(message);
                    return;
                }
                try {
                    if (url.equals(Constants.USER_LOGIN)) {
                        CheckLoginEntity baseEntity = gson.fromJson(resp, CheckLoginEntity.class);
                        //登录接口返回的数据 与其他接口得不同 单独处理
                        boolean success = baseEntity.isSuccess();
                        if (success) {
                            message.what = SUCCESS_CODE;
                        } else {
                            message.what = FAILED_CODE;
                        }
                        BaseResponse baseResponse = new BaseResponse();
                        baseResponse.setUrl(url);
                        baseResponse.setResponseString(resp);
                        message.obj = baseResponse;
                    } else {
                        BaseEntity baseEntity = gson.fromJson(resp, BaseEntity.class);
                        //虽然响应成功，有可能数据不对
                        boolean status = baseEntity.isStatus();
                        int code = baseEntity.getCode();
                        if (status && code == 0) {
                            message.what = SUCCESS_CODE;
                        } else {
                            message.what = FAILED_CODE;
                        }
                        BaseResponse baseResponse = new BaseResponse();
                        baseResponse.setUrl(url);
                        baseResponse.setResponseString(resp);
                        message.obj = baseResponse;
                    }

                } catch (JsonSyntaxException e) {
                    try {
                        ErrorEntity errorEntity = gson.fromJson(resp, ErrorEntity.class);
                        message.what = FAILED_CODE;
                        BaseResponse baseResponse = new BaseResponse();
                        baseResponse.setUrl(url);
                        baseResponse.setResponseString("JsonSyntaxException " + errorEntity.toString());
                        message.obj = baseResponse;
                    } catch (JsonSyntaxException e1) {
                        message.what = FAILED_CODE;
                        BaseResponse baseResponse = new BaseResponse();
                        baseResponse.setUrl(url);
                        baseResponse.setResponseString("JsonSyntaxException" + e1.getMessage());
                        message.obj = baseResponse;
                    }
                }
                mHandler.sendMessage(message);
            }
        });
    }

    public void uploadFileToServer(final String url, File file, String type, BaseModule module) {
        httpUrl = "http://"+ SharedPreferencesUtils.getIpAddress() + ":" + SharedPreferencesUtils.getPort();

        this.mBaseModule = module;
        final String finalUrl = httpUrl + url;

        Log.i("发送成功", finalUrl);

        Request request;
        try {
            MultipartBody.Builder builder = new MultipartBody.Builder();
            builder.setType(MultipartBody.FORM);

            if (file.exists()) {
                RequestBody requestBody = RequestBody.create(MediaType.parse("application/octet-stream"), file);
                builder.addFormDataPart("file", file.getName(), requestBody);
                builder.addFormDataPart("type", type);
            }
            request = new Request.Builder()
                    .url(finalUrl)
                    .addHeader("Authorization", Constants.authorization)
                    .post(builder.build())
                    .build();
        } catch (Exception e) {
            Message message = Message.obtain();
            message.what = FAILED_CODE;
            BaseResponse commonResponse = new BaseResponse();
            commonResponse.setUrl(url);
            commonResponse.setResponseString(e.getMessage());
            message.obj = commonResponse;
            mHandler.sendMessage(message);
            return;
        }

        mOkHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Message message = Message.obtain();
                message.what = FAILED_CODE;
                BaseResponse commonResponse = new BaseResponse();
                commonResponse.setUrl(url);
                commonResponse.setResponseString(e.getMessage());
                message.obj = commonResponse;
                mHandler.sendMessage(message);
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                Message message = Message.obtain();
                String resp = response.body().string();

                Log.i("接收成功", resp);

                if (TextUtils.isEmpty(resp)) {
                    message.what = FAILED_CODE;
                    BaseResponse commonResponse = new BaseResponse();
                    commonResponse.setUrl(url);
                    commonResponse.setResponseString("服务器响应内容为空");
                    message.obj = commonResponse;
                    mHandler.sendMessage(message);
                    return;
                }
                try {
                    BaseEntity baseEntity = gson.fromJson(resp, BaseEntity.class);
                    //虽然响应成功，有可能数据不对
                    boolean status = baseEntity.isStatus();
                    int code = baseEntity.getCode();
                    if (status && code == 0) {
                        message.what = SUCCESS_CODE;
                    } else {
                        message.what = FAILED_CODE;
                    }
                    BaseResponse commonResponse = new BaseResponse();
                    commonResponse.setUrl(url);
                    commonResponse.setResponseString(resp);
                    message.obj = commonResponse;

                } catch (JsonSyntaxException e) {
                    try {
                        ErrorEntity errorEntity = gson.fromJson(resp, ErrorEntity.class);
                        message.what = FAILED_CODE;
                        BaseResponse commonResponse = new BaseResponse();
                        commonResponse.setUrl(url);
                        commonResponse.setResponseString("JsonSyntaxException " + errorEntity.toString());
                        message.obj = commonResponse;

                    } catch (JsonSyntaxException e1) {
                        message.what = FAILED_CODE;
                        BaseResponse commonResponse = new BaseResponse();
                        commonResponse.setUrl(url);
                        commonResponse.setResponseString("JsonSyntaxException" + e1.getMessage());
                        message.obj = commonResponse;
                    }
                }
                mHandler.sendMessage(message);
            }
        });
    }

    public void getDataFromServerByJson(String json, final String url, BaseModule module) {
        httpUrl = "http://"+ SharedPreferencesUtils.getIpAddress() + ":" + SharedPreferencesUtils.getPort();

        this.mBaseModule = module;

        final String finalUrl = httpUrl + url;

        Request request;
        try {
            MediaType mjson = MediaType.parse("application/json; charset=utf-8");
            RequestBody requestBody = RequestBody.create(mjson, json);

            request = new Request.Builder()
                    .url(finalUrl)
                    .addHeader("Authorization", Constants.authorization)
                    .post(requestBody)
                    .build();

            Log.i("接收成功", finalUrl);

        } catch (Exception e) {
            Message message = Message.obtain();
            message.what = FAILED_CODE;
            CommonResponse commonResponse = new CommonResponse();
            commonResponse.setUrl(url);
            commonResponse.setResponseString(e.getMessage());
            message.obj = commonResponse;
            mHandler.sendMessage(message);
            return;
        }

        mOkHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Message message = Message.obtain();
                message.what = FAILED_CODE;
                CommonResponse commonResponse = new CommonResponse();
                commonResponse.setUrl(url);
                commonResponse.setResponseString(e.getMessage());
                message.obj = commonResponse;
                mHandler.sendMessage(message);
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                Message message = Message.obtain();
                String resp = response.body().string();

                Log.i("接收成功", resp);

                if (TextUtils.isEmpty(resp)) {
                    message.what = FAILED_CODE;
                    CommonResponse commonResponse = new CommonResponse();
                    commonResponse.setUrl(url);
                    commonResponse.setResponseString("服务器响应内容为空");
                    message.obj = commonResponse;
                    mHandler.sendMessage(message);
                    return;
                }
                try {
                    BaseEntity baseEntity = gson.fromJson(resp, BaseEntity.class);
                    //虽然响应成功，有可能数据不对
                    boolean status = baseEntity.isStatus();
                    int code = baseEntity.getCode();
                    if (status && code == 0) {
                        message.what = SUCCESS_CODE;
                    } else {
                        message.what = FAILED_CODE;
                    }
                    CommonResponse commonResponse = new CommonResponse();
                    commonResponse.setUrl(url);
                    commonResponse.setResponseString(resp);
                    message.obj = commonResponse;

                } catch (JsonSyntaxException e) {
                    try {
                        ErrorEntity errorEntity = gson.fromJson(resp, ErrorEntity.class);
                        message.what = FAILED_CODE;
                        CommonResponse commonResponse = new CommonResponse();
                        commonResponse.setUrl(url);
                        commonResponse.setResponseString("JsonSyntaxException " + errorEntity.toString());
                        message.obj = commonResponse;
                    } catch (JsonSyntaxException e1) {
                        message.what = FAILED_CODE;
                        CommonResponse commonResponse = new CommonResponse();
                        commonResponse.setUrl(url);
                        commonResponse.setResponseString("JsonSyntaxException" + e1.getMessage());
                        message.obj = commonResponse;
                    }
                }
                mHandler.sendMessage(message);
            }
        });
    }
}
