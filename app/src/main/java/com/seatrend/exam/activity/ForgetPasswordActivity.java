package com.seatrend.exam.activity;

import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.text.TextUtils;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;

import com.google.gson.JsonSyntaxException;
import com.seatrend.exam.R;
import com.seatrend.exam.common.Constants;
import com.seatrend.exam.presenter.GetPresenter;
import com.seatrend.exam.response.BaseResponse;
import com.seatrend.exam.response.CommonResponse;
import com.seatrend.exam.response.UploadImageResponse;
import com.seatrend.exam.utils.SharedPreferencesUtils;
import com.seatrend.exam.view.GetView;

import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.OnClick;

public class ForgetPasswordActivity extends BaseActivity implements GetView {

    @BindView(R.id.m_et_account)
    EditText mEtAccount;
    @BindView(R.id.m_et_id)
    EditText mEtId;
    @BindView(R.id.m_et_new_password)
    EditText mEtNewPassword;
    @BindView(R.id.m_iv_clear_password)
    ImageView mIvClearPassword;
    @BindView(R.id.m_cb_eye)
    CheckBox mCbEye;
    @BindView(R.id.m_et_confirm_password)
    EditText mEtConfirmPassword;
    @BindView(R.id.m_iv_clear_confirm_password)
    ImageView mIvClearConfirmPassword;
    @BindView(R.id.m_cb_confirm_eye)
    CheckBox mCbConfirmEye;
    @BindView(R.id.m_iv_clear_account)
    ImageView mIvClearAccount;
    @BindView(R.id.m_iv_clear_id)
    ImageView mIvClearId;
    private GetPresenter presenter;

    @Override
    public int getLayout() {
        return R.layout.activity_forget_password;
    }

    @Override
    public void initView(Bundle savedInstanceState) {
        presenter = new GetPresenter(this);

        setButton(getString(R.string.ok));

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

        mEtId.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                if (b) {
                    mIvClearId.setVisibility(View.VISIBLE);
                } else {
                    mIvClearId.setVisibility(View.GONE);
                }
            }
        });

        mEtNewPassword.setOnFocusChangeListener(new View.OnFocusChangeListener() {
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
                    mEtNewPassword.setInputType(InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);
                } else {
                    mEtNewPassword.setInputType(InputType.TYPE_TEXT_VARIATION_PASSWORD | InputType.TYPE_CLASS_TEXT);
                }
            }
        });

        mEtConfirmPassword.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                if (b) {
                    mIvClearConfirmPassword.setVisibility(View.VISIBLE);
                    mCbConfirmEye.setVisibility(View.VISIBLE);
                } else {
                    mIvClearConfirmPassword.setVisibility(View.GONE);
                    mCbConfirmEye.setVisibility(View.GONE);
                }
            }
        });

        mCbConfirmEye.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    mEtConfirmPassword.setInputType(InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);
                } else {
                    mEtConfirmPassword.setInputType(InputType.TYPE_TEXT_VARIATION_PASSWORD | InputType.TYPE_CLASS_TEXT);
                }
            }
        });
    }

    @Override
    public int setBarColor() {
        return R.color.white;
    }

    @OnClick({R.id.m_iv_clear_account, R.id.m_iv_clear_id, R.id.m_iv_clear_password, R.id.m_iv_clear_confirm_password, R.id.m_button})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.m_iv_clear_account:
                mEtAccount.setText("");
                break;

            case R.id.m_iv_clear_id:
                mEtId.setText("");
                break;

            case R.id.m_iv_clear_password:
                mEtNewPassword.setText("");
                break;

            case R.id.m_iv_clear_confirm_password:
                mEtConfirmPassword.setText("");
                break;

            case R.id.m_button:
                String account = mEtAccount.getText().toString().trim();
                String id = mEtId.getText().toString().trim();
                String newPassword = mEtNewPassword.getText().toString().trim();
                String confirmPassword = mEtConfirmPassword.getText().toString().trim();

                if (TextUtils.isEmpty(account)) {
                    showToast("请输入账号");
                    return;
                }

                if (TextUtils.isEmpty(id)) {
                    showToast("请输入身份证号码");
                    return;
                }

                if (TextUtils.isEmpty(newPassword)) {
                    showToast("请输入新密码");
                    return;
                }

                if (TextUtils.isEmpty(confirmPassword)) {
                    showToast("请输入确认密码");
                    return;
                }

                mLoading.show();

                SharedPreferencesUtils.setAdmin(account);
                Map<String, String> map = new HashMap<>();
                map.put("userName", account);
                map.put("newPwd", confirmPassword);
                map.put("sfzmhm ", id);
                presenter.doNetworkTask(map, Constants.CHANGE_PASSWORD_PDA);
                break;
        }
    }

    @Override
    public void getSuccess(BaseResponse response) {
        try {
            mLoading.dismiss();
            CommonResponse mResponse = gson.fromJson(response.getResponseString(), CommonResponse.class);
            showToast(mResponse.getMessage());
            if (mResponse.getCode() == 0) {
                SharedPreferencesUtils.setPassword("");
                startActivity(new Intent(this, LoginActivity.class));
                finish();
            }
        } catch (JsonSyntaxException e) {
            showErrorDialog("JsonSyntaxException  " + e.getMessage());
        }
    }

    @Override
    public void getFailed(BaseResponse response) {
        mLoading.dismiss();
        showErrorDialog(response.getResponseString());
    }
}
