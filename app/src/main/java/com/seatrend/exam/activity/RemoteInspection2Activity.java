package com.seatrend.exam.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.widget.TextView;

import com.google.gson.JsonSyntaxException;
import com.hikvision.sdk.VMSNetSDK;
import com.hikvision.sdk.consts.HttpConstants;
import com.hikvision.sdk.net.bean.LoginData;
import com.hikvision.sdk.net.business.OnVMSNetSDKBusiness;
import com.hikvision.sdk.utils.SDKUtil;
import com.seatrend.exam.R;
import com.seatrend.exam.adapter.RemoteInspection2Adapter;
import com.seatrend.exam.common.Constants;
import com.seatrend.exam.common.MyApplication;
import com.seatrend.exam.common.view.SpacingItemDecoration;
import com.seatrend.exam.entity.TempDatas;
import com.seatrend.exam.presenter.GetPresenter;
import com.seatrend.exam.response.BaseResponse;
import com.seatrend.exam.response.ExamRoomRemoteResponse;
import com.seatrend.exam.response.KTUsageResponse;
import com.seatrend.exam.response.VehicleUsageResponse;
import com.seatrend.exam.utils.LogUtil;
import com.seatrend.exam.utils.Utils;
import com.seatrend.exam.view.GetView;

import java.io.Serializable;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.List;

import butterknife.BindView;

public class RemoteInspection2Activity extends BaseActivity {
//    @BindView(R.id.m_tv_used)
//    TextView mTvUsed;
//    @BindView(R.id.m_tv_free)
//    TextView mTvFree;
//    @BindView(R.id.m_tv_fault)
//    TextView mTvFault;
//    @BindView(R.id.m_tv_shutdown)
//    TextView mTvShutdown;
    @BindView(R.id.m_recycler)
    RecyclerView mRecycler;

    int use = 0;
    int free = 0;
    int fault = 0;
    int shutdown = 0;
    private String kskm;
    private RemoteInspection2Adapter mAdapter;
    private ViewHandler mHandler;

    /**
     * 登录成功
     */
    public static final int LOGIN_SUCCESS = 1;

    /**
     * 登录失败
     */
    public static final int LOGIN_FAILED = 2;
//    private List<KTUsageResponse.DataBean> data;
//    private List<VehicleUsageResponse.DataBean.ListBean> list;
    private int mPosition;
    private List<ExamRoomRemoteResponse.DataBean.SeaExamSiteCameraBean> seaExamSiteCamera;
    private List<ExamRoomRemoteResponse.DataBean.SeaExamRoadCameraBean> seaExamRoadCamera;

    @Override
    public int getLayout() {
        return R.layout.activity_remote_inspection_2;
    }

    @Override
    public void initView(Bundle savedInstanceState) {
        setTitle(intent.getStringExtra("kcmc"));
        kskm = intent.getStringExtra("kskm");

        //登陆海康
        mHandler = new ViewHandler(this);

//        GetPresenter getPresenter = new GetPresenter(this);
//
//        if ("1".equals(kskm) || "4".equals(kskm)) {
//            mRecycler.setLayoutManager(new GridLayoutManager(this, 8));
//            mRecycler.addItemDecoration(new SpacingItemDecoration(8, Utils.dip2px(this, 5), false));
//
//            HashMap<String, String> map = new HashMap<>();
//            map.put("kcdm", intent.getStringExtra("kcdm"));
//            mLoading.show();
//            getPresenter.doNetworkTask(map, Constants.SELECT_KT_USAGE);
//
//        } else {
//            mRecycler.setLayoutManager(new GridLayoutManager(this, 4));
//            mRecycler.addItemDecoration(new SpacingItemDecoration(4, Utils.dip2px(this, 5), false));
//
//            HashMap<String, String> map = new HashMap<>();
//            map.put("curpage", "1");
//            map.put("pageSize", "40");
//            map.put("kcbaxh", intent.getStringExtra("kcxh"));
//            mLoading.show();
//            getPresenter.doNetworkTask(map, Constants.SELECT_VEHICLE_PAGES);
//        }


        mRecycler.setLayoutManager(new GridLayoutManager(this, 3));
        mRecycler.addItemDecoration(new SpacingItemDecoration(3, Utils.dip2px(this, 5), false));

        mAdapter = new RemoteInspection2Adapter(this);
        mRecycler.setAdapter(mAdapter);
        mAdapter.setOnItemClickListener(new RemoteInspection2Adapter.OnItemClickListener() {
            @Override
            public void onClick(int position) {
                if ("1".equals(kskm) || "4".equals(kskm)) {
                    loginOpt(seaExamSiteCamera.get(position).getCameraNumber());

                }else {
                    loginOpt(seaExamRoadCamera.get(position).getCameraNumber());
                }
            }
        });

        ExamRoomRemoteResponse.DataBean dataBean = (ExamRoomRemoteResponse.DataBean) intent.getSerializableExtra("data");

        if ("1".equals(kskm) || "4".equals(kskm)) {
            seaExamSiteCamera = dataBean.getSeaExamSiteCamera();
            mAdapter.setKTData(seaExamSiteCamera);

        }else {
            seaExamRoadCamera = dataBean.getSeaExamRoadCamera();
            mAdapter.setVehicleData(seaExamRoadCamera);
        }
    }

    /***
     * 登录方法
     */
    private void loginOpt(final String cameraNumber) {
        final String url = "11.121.35.24";
        String userName = "admin";
        String password = "Abcd12345";

        String macAddress = MyApplication.getMacAddress();
        // 检查登录参数合法性
        if (TextUtils.isEmpty(macAddress)) {
            showToast("MAC为空");
            return;
        }

        //https 证书验证
//        openHttps();
        // 登录请求
        String loginAddress = HttpConstants.HTTPS + url;
//        String loginAddress = "http://" + url;

        LogUtil.i(loginAddress);

        mLoading.show();
        VMSNetSDK.getInstance().Login(loginAddress, userName, password, macAddress, new OnVMSNetSDKBusiness() {
            @Override
            public void onFailure() {
                mHandler.sendEmptyMessage(LOGIN_FAILED);
            }

            @Override
            public void onSuccess(Object obj) {
                if (obj instanceof LoginData) {
                    mHandler.sendEmptyMessage(LOGIN_SUCCESS);
                    //存储登录数据
                    TempDatas.getIns().setLoginData((LoginData) obj);
                    TempDatas.getIns().setLoginAddr(url);

                    //解析版本号
                    String appVersion = ((LoginData) obj).getVersion();
                    SDKUtil.analystVersionInfo(appVersion);

                    //跳转资源列表页面
                    Intent intent = new Intent(RemoteInspection2Activity.this, InspectionActivity.class);
                    intent.putExtra("cameraNumber", cameraNumber);

//                    if (data != null) {
//                        Constants.mKcdm = data.get(mPosition).getKcdm();
//                        Constants.mksjh = data.get(mPosition).getKsjh();
//                        Constants.mListKTUsage = data;
//                    }
//
//                    if (list != null) {
//                        Constants.mKcxh = list.get(mPosition).getKcbaxh();
//                        Constants.mKchp = list.get(mPosition).getHphm();
//                        Constants.mListVehicleUsage = list;
//                    }
//                    Constants.mKskm = kskm;

                    startActivity(intent);
                }
            }
        });
    }

    /***
     * UI处理Handler
     */
    private class ViewHandler extends Handler {
        private final WeakReference<Context> mActivity;

        ViewHandler(Context context) {
            mActivity = new WeakReference<>(context);
        }

        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case LOGIN_SUCCESS:
                    // 登录成功
                    mLoading.dismiss();
                    showToast("登陆成功");
                    break;

                case LOGIN_FAILED:
                    // 登录失败
                    mLoading.dismiss();
                    showToast("登陆失败");
                    break;

                default:
                    break;
            }
        }
    }

    @Override
    public int setBarColor() {
        return R.color.blue;
    }

//    @Override
//    public void getSuccess(BaseResponse response) {
//        try {
//            mLoading.dismiss();
//            if (Constants.SELECT_KT_USAGE.equals(response.getUrl())) {
//                KTUsageResponse mResponse = gson.fromJson(response.getResponseString(), KTUsageResponse.class);
//                if (mResponse.getCode() == 0) {
//                    data = mResponse.getData();
//
//                    if (data.size() > 0) {
//                        mAdapter.setKTData(data);
//
//                        for (int i = 0; i < data.size(); i++) {
//                            if ("0".equals(data.get(i).getZt())) {
//                                free += 1;
//
//                            } else if ("1".equals(data.get(i).getZt()) || "2".equals(data.get(i).getZt()) || "3".equals(data.get(i).getZt()) || "4".equals(data.get(i).getZt()) ||
//                                    "5".equals(data.get(i).getZt()) || "6".equals(data.get(i).getZt()) || "7".equals(data.get(i).getZt()) || "8".equals(data.get(i).getZt())) {
//                                use += 1;
//
//                            } else if ("10".equals(data.get(i).getZt())) {
//                                fault += 1;
//
//                            } else if ("9".equals(data.get(i).getZt())) {
//                                shutdown += 1;
//                            }
//                        }
//
//                        mTvUsed.setText(String.valueOf(use));
//                        mTvFree.setText(String.valueOf(free));
//                        mTvFault.setText(String.valueOf(fault));
//                        mTvShutdown.setText(String.valueOf(shutdown));
//
//                    } else {
//                        showEmpty();
//                    }
//                }
//
//            } else {
//                VehicleUsageResponse usageResponse = gson.fromJson(response.getResponseString(), VehicleUsageResponse.class);
//                if (usageResponse.getCode() == 0) {
//                    list = usageResponse.getData().getList();
//                    if (list.size() > 0) {
//                        mAdapter.setVehicleData(list);
//
//                        for (int i = 0; i < list.size(); i++) {
//                            if ("正常".equals(list.get(i).getZt())) {
//                                use += 1;
//                            } else {
//                                fault += 1;
//                            }
//                        }
//
//                        mTvUsed.setText(String.valueOf(use));
//                        mTvFree.setText(String.valueOf(free));
//                        mTvFault.setText(String.valueOf(fault));
//                        mTvShutdown.setText(String.valueOf(shutdown));
//
//                    } else {
//                        showEmpty();
//                    }
//                }
//            }
//
//        } catch (JsonSyntaxException e) {
//            showErrorDialog("JsonSyntaxException  " + e.getMessage());
//        }
//    }
//
//    @Override
//    public void getFailed(BaseResponse response) {
//        mLoading.dismiss();
//        showErrorDialog(response.getResponseString());
//    }
}
