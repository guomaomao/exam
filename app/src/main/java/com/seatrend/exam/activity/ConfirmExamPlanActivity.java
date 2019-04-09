package com.seatrend.exam.activity;

import android.Manifest;
import android.app.Dialog;
import android.content.ContentValues;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.gson.JsonSyntaxException;
import com.seatrend.exam.R;
import com.seatrend.exam.common.Constants;
import com.seatrend.exam.common.view.CommonDialog;
import com.seatrend.exam.presenter.GetPresenter;
import com.seatrend.exam.presenter.SignPresenter;
import com.seatrend.exam.response.BaseResponse;
import com.seatrend.exam.response.CommonResponse;
import com.seatrend.exam.response.ConfigResponse;
import com.seatrend.exam.utils.Utils;
import com.seatrend.exam.view.GetView;
import com.seatrend.exam.view.SignView;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import butterknife.BindView;
import butterknife.OnClick;

public class ConfirmExamPlanActivity extends BaseActivity implements SignView, GetView {

    private static final int INTENT_SIGN = 10;
    public static final int PHOTO_REQUEST_CAMERA = 11;

    @BindView(R.id.m_iv_photo)
    ImageView mIvPhoto;
    @BindView(R.id.m_ll_photo)
    LinearLayout mLlPhoto;
    @BindView(R.id.m_iv_sign)
    ImageView mIvSign;

    private Uri imageUri;
    private File tempFile;

    private SignPresenter presenter;
    private GetPresenter getPresenter;
    private boolean isSigned = false;


    @Override
    public int getLayout() {
        return R.layout.activity_confirm_exam_plan;
    }

    @Override
    public void initView(Bundle savedInstanceState) {
        presenter = new SignPresenter(this);
        getPresenter = new GetPresenter(this);

        setTitle("考试计划确认");
        setButton("提交");

        mLeft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!isSigned) {
                    finish();
                    return;
                }

                final Dialog dialog = CommonDialog.CenterDialog(ConfirmExamPlanActivity.this, R.layout.dialog_tips, false);
                dialog.show();

                TextView mTvText = dialog.findViewById(R.id.m_tv_text);
                mTvText.setText("即将退出，点击保存按钮保存本次签字。本次签字仅对今日成绩有效");

                Button mBtnLeft = dialog.findViewById(R.id.m_btn_left);
                mBtnLeft.setText("取消");
                mBtnLeft.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dialog.dismiss();
                        finish();
                    }
                });

                Button mBtnRight = dialog.findViewById(R.id.m_btn_right);
                mBtnRight.setText("保存");
                mBtnRight.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dialog.dismiss();
                        uploadBitmap();
                    }
                });
            }
        });

        mLoading.show();
        Map<String, String> map = new HashMap<>();
        map.put("moduleId", "0404");
        map.put("functionId", "02");
        getPresenter.doNetworkTask(map, Constants.SELECT_CONFIG);
    }

    @Override
    public int setBarColor() {
        return R.color.blue;
    }

    @OnClick({R.id.m_button, R.id.m_tv_take_picture, R.id.m_tv_sign})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.m_button:
                if (!isSigned) {
                    showToast("请先签名");
                    return;
                }
                if (imageUri == null) {
                    showToast("请先拍照");
                    return;
                }

                uploadBitmap();
                break;

            case R.id.m_tv_take_picture:
                openCamera();
                break;

            case R.id.m_tv_sign:
                startActivityForResult(new Intent(this, SignActivity.class), INTENT_SIGN);
                break;
        }
    }

    private void uploadBitmap() {
        mLoading.show();
        Map<String, String> map = new HashMap<>();
        map.put("sfzh", Constants.sfzmhm);
        map.put("type", "1");
        map.put("qmfs", "1");
        map.put("kcxh", Constants.kcxh);
        map.put("base64Data", Utils.bitmapToBase64(Constants.mSign));
        map.put("xczpBase64", Utils.pathToBase64(tempFile.getPath()));
        presenter.doNetworkTask(map, Constants.SET_AUTOGRAPH);
    }

    @Override
    public void success(BaseResponse response) {
        try {
            mLoading.dismiss();
            CommonResponse baseEntity = gson.fromJson(response.getResponseString(), CommonResponse.class);
            if (baseEntity.isStatus() && baseEntity.getCode() == 0) {
                showToast(baseEntity.getMessage());
                setResult(RESULT_OK);
                finish();

            } else {
                showToast(baseEntity.getMessage());
            }

        } catch (JsonSyntaxException e) {
            showErrorDialog("JsonSyntaxException" + e.getMessage());
        }
    }

    @Override
    public void failed(BaseResponse response) {
        mLoading.dismiss();
        showErrorDialog(response.getResponseString());
    }

    @Override
    public void getSuccess(BaseResponse response) {
        try {
            mLoading.dismiss();

            ConfigResponse mResponse = gson.fromJson(response.getResponseString(), ConfigResponse.class);
            if (mResponse.isStatus() && mResponse.getCode() == 0) {
                List<ConfigResponse.DataBean> data = mResponse.getData();
                if (data.size() > 0) {
                    String content = data.get(0).getContent();
                    if ("1".equals(content)) {
                        mLlPhoto.setVisibility(View.VISIBLE);
                    } else if ("0".equals(content)) {
                        mLlPhoto.setVisibility(View.GONE);

                    }
                }

            } else {
                showToast(mResponse.getMessage());
            }

        } catch (JsonSyntaxException e) {
            showErrorDialog("JsonSyntaxException" + e.getMessage());
        }
    }

    @Override
    public void getFailed(BaseResponse response) {
        mLoading.dismiss();
        showErrorDialog(response.getResponseString());
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            if (requestCode == INTENT_SIGN) {
                isSigned = true;
                Glide.with(this).load(Constants.mSign).into(mIvSign);

            }else if (requestCode == PHOTO_REQUEST_CAMERA) {

                Log.i("成功", tempFile.getPath());

                Glide.with(this).load(imageUri).into(mIvPhoto);
            }
        }
    }

    public void openCamera() {
        // 激活相机
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        // 判断存储卡是否可以用，可用进行存储
        if (Utils.hasSdcard()) {
            SimpleDateFormat timeStampFormat = new SimpleDateFormat("" + System.currentTimeMillis(), Locale.CHINA);
            String filename = timeStampFormat.format(new Date());
            tempFile = new File(Environment.getExternalStorageDirectory(), filename + ".jpg");
            if (android.os.Build.VERSION.SDK_INT < Build.VERSION_CODES.N) {
                // 从文件中创建uri
                imageUri = Uri.fromFile(tempFile);
                intent.putExtra(MediaStore.EXTRA_OUTPUT, imageUri);
            } else {
                //兼容android7.0 使用共享文件的形式
                ContentValues contentValues = new ContentValues(1);
                contentValues.put(MediaStore.Images.Media.DATA, tempFile.getAbsolutePath());
                //检查是否有存储权限，以免崩溃
                if (ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
                    //申请WRITE_EXTERNAL_STORAGE权限
                    Utils.showToast(this, "请开启存储权限");
                    return;
                }
                imageUri = getContentResolver().insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, contentValues);
                intent.putExtra(MediaStore.EXTRA_OUTPUT, imageUri);
            }
        }
        startActivityForResult(intent, PHOTO_REQUEST_CAMERA);
    }
}
