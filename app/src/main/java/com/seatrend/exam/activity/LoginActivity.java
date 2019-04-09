package com.seatrend.exam.activity;

import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ScrollView;

import com.google.gson.JsonSyntaxException;
import com.seatrend.exam.R;
import com.seatrend.exam.common.Constants;
import com.seatrend.exam.presenter.GetPresenter;
import com.seatrend.exam.presenter.LoginPresenter;
import com.seatrend.exam.response.BaseResponse;
import com.seatrend.exam.response.CatalogueResponse;
import com.seatrend.exam.response.ExamRoomRemoteResponse;
import com.seatrend.exam.response.LoginResponse;
import com.seatrend.exam.response.TaskTopResponse;
import com.seatrend.exam.utils.SharedPreferencesUtils;
import com.seatrend.exam.utils.Utils;
import com.seatrend.exam.view.GetView;
import com.seatrend.exam.view.LoginView;

import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.OnClick;

public class LoginActivity extends BaseActivity implements LoginView, GetView, View.OnTouchListener {

    @BindView(R.id.m_scroll_view)
    ScrollView mScrollView;
    @BindView(R.id.m_et_account)
    EditText mEtAccount;
    @BindView(R.id.m_iv_clear_account)
    ImageView mIvClearAccount;
    @BindView(R.id.m_et_password)
    EditText mEtPassword;
    @BindView(R.id.m_iv_clear_password)
    ImageView mIvClearPassword;
    @BindView(R.id.m_cb_eye)
    CheckBox mCbEye;

    private LoginPresenter presenter;
    private GetPresenter getPresenter;
    private HashMap<String, String> map;

    @Override
    public int getLayout() {
        return R.layout.activity_login;
    }

    @Override
    public void initView(Bundle savedInstanceState) {
        presenter = new LoginPresenter(this);
        getPresenter = new GetPresenter(this);

        setButton(getString(R.string.login));

        mEtAccount.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                if (b) {
                    mIvClearAccount.setVisibility(View.VISIBLE);
                } else {
                    mIvClearAccount.setVisibility(View.GONE);
                }
            }
        });

        mEtPassword.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                if (b) {
                    mIvClearPassword.setVisibility(View.VISIBLE);
                    mCbEye.setVisibility(View.VISIBLE);
                } else {
                    mIvClearPassword.setVisibility(View.GONE);
                    mCbEye.setVisibility(View.GONE);
                }
            }
        });

        mCbEye.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    mEtPassword.setInputType(InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);
                } else {
                    mEtPassword.setInputType(InputType.TYPE_TEXT_VARIATION_PASSWORD | InputType.TYPE_CLASS_TEXT);
                }
            }
        });

        mEtAccount.setText(SharedPreferencesUtils.getUsername());
        mEtPassword.setText(SharedPreferencesUtils.getPassword());

        mScrollView.setOnTouchListener(this);

    }

    @Override
    public int setBarColor() {
        return R.color.white;
    }

    @OnClick({R.id.m_iv_clear_account, R.id.m_iv_clear_password, R.id.m_button, R.id.m_tv_forget_password, R.id.m_tv_set_ip})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.m_iv_clear_account:
                mEtAccount.setText("");
                break;

            case R.id.m_iv_clear_password:
                mEtPassword.setText("");
                break;

            case R.id.m_button:
                String account = mEtAccount.getText().toString();
                String pwd = mEtPassword.getText().toString();
                if (TextUtils.isEmpty(account)) {
                    showToast("请输入用户名");
                    return;
                }
                if (TextUtils.isEmpty(pwd)) {
                    showToast("请输入密码");
                    return;
                }

//                if (TextUtils.isEmpty(SharedPreferencesUtils.getIpAddress()) || TextUtils.isEmpty(SharedPreferencesUtils.getPort())) {
//                    showToast("请先设置IP地址");
//                    return;
//                }

                mLoading.show();

                SharedPreferencesUtils.setUsername(account);
                SharedPreferencesUtils.setPassword(pwd);

                Map<String, String> map = new HashMap<>();
                map.put("username", account);
                map.put("password", pwd);
                map.put("client", "2");
                presenter.doNetworkTask(map, Constants.USER_LOGIN);
                break;

            case R.id.m_tv_forget_password:
                startActivity(new Intent(this, ForgetPasswordActivity.class));
                break;

            case R.id.m_tv_set_ip:
                startActivity(new Intent(this, IPSettingActivity.class));
                break;
        }
    }

    @Override
    public void loginSuccess(BaseResponse response) {
        try {
            LoginResponse loginResponse = gson.fromJson(response.getResponseString(), LoginResponse.class);
            if (!loginResponse.isSuccess()) {
                showErrorDialog(loginResponse.getMessage());
                return;
            }

            LoginResponse.ApplicationUserBean.SysUserBean sysUser = loginResponse.getApplicationUser().getSysUser();
            Constants.authorization = loginResponse.getAuthorization();
            Constants.sfzmhm = sysUser.getSfzmhm();
            Constants.xm = sysUser.getXm();
            Constants.yhdh = sysUser.getYhdh();
            Constants.bmmc = sysUser.getBmmc();
            Constants.ssjs = sysUser.getSsjs();
            Constants.kcxh = sysUser.getKcxh();
            Constants.glbm = sysUser.getGlbm();
            Constants.sjbm = sysUser.getSjbm();
            Constants.qxms = sysUser.getQxms();
            Constants.ipstart = sysUser.getIpstart();
            Constants.ipend = sysUser.getIpend();
            Constants.pwd = sysUser.getPwd();
            Constants.zt = sysUser.getZt();
            Constants.ssxt = sysUser.getSsxt();
            Constants.klyzms = sysUser.getKlyzms();
            Constants.mmyxqz = sysUser.getMmyxqz();
            Constants.zhyxqz = sysUser.getZhyxqz();
            Constants.gdip1 = sysUser.getGdip1();
            Constants.gdip2 = sysUser.getGdip2();
            Constants.gdip3 = sysUser.getGdip3();
            Constants.photo = sysUser.getPhoto();
            Constants.cjsj = sysUser.getCjsj();
            Constants.gxsj = sysUser.getGxsj();

            map = new HashMap<>();
            map.put("jsdh", Constants.ssjs);
            map.put("ksrq", Constants.ksrq);
            map.put("sfzmhm", Constants.sfzmhm);
            getPresenter.doNetworkTask(map, Constants.GET_CATALOGUE);

        } catch (JsonSyntaxException e) {
            showErrorDialog("JsonSyntaxException" + e.getMessage());
        }
    }

    @Override
    public void loginFailed(BaseResponse response) {
        mLoading.dismiss();
        try {
            LoginResponse loginResponse = gson.fromJson(response.getResponseString(), LoginResponse.class);
            if (!loginResponse.isSuccess()) {
                showErrorDialog(loginResponse.getMessage());
            }
        } catch (JsonSyntaxException e) {
            showErrorDialog(response.getResponseString());
        }
    }

    @Override
    public void getSuccess(BaseResponse response) {
        try {
            if (Constants.GET_CATALOGUE.equals(response.getUrl())) {
                CatalogueResponse catalogueResponse = gson.fromJson(response.getResponseString(), CatalogueResponse.class);

                Constants.catalogue1 = catalogueResponse.getData().getCatalogue1();
                Constants.catalogue2 = catalogueResponse.getData().getCatalogue2();

                map = new HashMap<>();
                map.put("jsdh", Constants.ssjs);
                map.put("ksrq", Constants.ksrq);
                map.put("kcxh", Constants.kcxh);
                getPresenter.doNetworkTask(map, Constants.GET_PDA_NUMBERS);


            } else if (Constants.GET_PDA_NUMBERS.equals(response.getUrl())) {
                TaskTopResponse topResponse = gson.fromJson(response.getResponseString(), TaskTopResponse.class);
                if (topResponse.getCode() == 0) {
                    Constants.taskTop = topResponse.getData();
                }

                //远程巡考 考场
                map = new HashMap<>();
                map.put("type", "5");
                if ("2".equals(Constants.ssjs)) {
                    map.put("kcmc", Constants.kcxh);
                }
                getPresenter.doNetworkTask(map, Constants.SELECT_EXAMINATION_SITE_CARMERA_LIST);

            } else {
                ExamRoomRemoteResponse mResponse = gson.fromJson(response.getResponseString(), ExamRoomRemoteResponse.class);
                Constants.secondData = mResponse.getData();

                startActivity(new Intent(this, MainActivity.class));
                finish();
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
    public boolean onTouch(View view, MotionEvent motionEvent) {
        Utils.hideSoftInput(this);
        return false;
    }
}
