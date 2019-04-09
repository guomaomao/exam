package com.seatrend.exam.activity;

import android.Manifest;
import android.app.Dialog;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v4.app.ActivityCompat;
import android.support.v4.view.ViewCompat;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.seatrend.exam.R;
import com.seatrend.exam.common.ActivityCollector;
import com.seatrend.exam.common.view.CommonDialog;
import com.seatrend.exam.common.view.Loading;
import com.seatrend.exam.view.BaseView;

import butterknife.ButterKnife;
import me.yokeyword.fragmentation.SupportActivity;

public abstract class BaseActivity extends SupportActivity implements BaseView {

    protected ImageView mLeft;
    protected TextView mTitle;
    protected Button mButton;
    protected Loading mLoading;
    protected Gson gson;
    private LinearLayout mLlNetworkError;
    private LinearLayout mLlEmpty;
    private Button mBtnLeft;
    private Button mBtnRight;
    protected Intent intent;
    private TextView mTvRight;

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(getLayout());
        ButterKnife.bind(this);
//        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);// 横屏
//        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);//竖屏
        ActivityCollector.addActivity(this);

        if (checkSelfPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED
                || checkSelfPermission(Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED
                || checkSelfPermission(Manifest.permission.RECORD_AUDIO) != PackageManager.PERMISSION_GRANTED
                || checkSelfPermission(Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(BaseActivity.this, new String[]{
                    Manifest.permission.WRITE_EXTERNAL_STORAGE,
                    Manifest.permission.READ_EXTERNAL_STORAGE,
                    Manifest.permission.RECORD_AUDIO,
                    Manifest.permission.CAMERA}, 1);
        }

        if (Build.VERSION.SDK_INT > Build.VERSION_CODES.LOLLIPOP) {
            setStatusBarColor(getColor(setBarColor()));
        }

        mLoading = new Loading(this);
        gson = new Gson();
        intent = getIntent();

        initCommonTitle();
        initView(savedInstanceState);

    }

    public abstract int getLayout();

    public abstract void initView(Bundle savedInstanceState);

    public abstract int setBarColor();


    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    private void setStatusBarColor(int statusColor) {
        Window window = getWindow();
        //取消状态栏透明
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        //添加Flag把状态栏设为可绘制模式
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        //设置状态栏颜色
        window.setStatusBarColor(statusColor);
        //设置系统状态栏处于可见状态
        window.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_VISIBLE);
        //让view不根据系统窗口来调整自己的布局
        ViewGroup mContentView = window.findViewById(Window.ID_ANDROID_CONTENT);
        View mChildView = mContentView.getChildAt(0);
        if (mChildView != null) {
            ViewCompat.setFitsSystemWindows(mChildView, false);
            ViewCompat.requestApplyInsets(mChildView);
        }
    }

    public void initCommonTitle() {
        mLeft = findViewById(R.id.m_iv_left);
        mTitle = findViewById(R.id.m_tv_title);
        mTvRight = findViewById(R.id.m_tv_right);
        mButton = findViewById(R.id.m_button);
        mBtnLeft = findViewById(R.id.m_btn_left);
        mBtnRight = findViewById(R.id.m_btn_right);

        mLlNetworkError = findViewById(R.id.m_ll_network_error);
        mLlEmpty = findViewById(R.id.m_ll_empty);

        if (mLeft != null) {
            mLeft.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    finish();
                }
            });
        }
    }

    public void setTitle(String str) {
        if (mTitle != null) {
            mTitle.setText(str);
        }
    }

    public void setRight(String str) {
        if (mTvRight != null) {
            mTvRight.setText(str);
        }
    }

    public void setButton(String str) {
        if (mButton != null) {
            mButton.setText(str);
        }
    }

    public void setLeftButton(String str) {
        if (mBtnLeft != null) {
            mBtnLeft.setText(str);
        }
    }

    public void setRightButton(String str) {
        if (mBtnRight != null) {
            mBtnRight.setText(str);
        }
    }

    public void showNetworkError() {
        if (mLlNetworkError != null) {
            mLlNetworkError.setVisibility(View.VISIBLE);
        }
    }

    public void showEmpty() {
        if (mLlEmpty != null) {
            mLlEmpty.setVisibility(View.VISIBLE);
        }
    }

    public void notShowEmpty() {
        if (mLlEmpty != null) {
            mLlEmpty.setVisibility(View.GONE);
        }
    }


    @Override
    public void showToast(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showToast(int msgId) {
        Toast.makeText(this, getString(msgId), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showErrorDialog(String msg) {
        try {
            final Dialog dialog = CommonDialog.CenterDialog(this, R.layout.dialog_info, false);
            dialog.show();

            TextView mTvText = dialog.findViewById(R.id.m_tv_info);
            mTvText.setText(msg);

            Button mBtn = dialog.findViewById(R.id.m_button);
            mBtn.setText("确定");
            mBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    dialog.dismiss();
                }
            });

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ActivityCollector.removeActivity(this);
    }
}
