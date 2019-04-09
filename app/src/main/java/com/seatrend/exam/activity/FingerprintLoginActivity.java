package com.seatrend.exam.activity;

import android.annotation.TargetApi;
import android.app.KeyguardManager;
import android.content.Intent;
import android.hardware.fingerprint.FingerprintManager;
import android.os.Build;
import android.os.Bundle;
import android.security.keystore.KeyGenParameterSpec;
import android.security.keystore.KeyProperties;
import android.support.v4.hardware.fingerprint.FingerprintManagerCompat;
import android.text.TextUtils;
import android.view.View;
import android.widget.Toast;

import com.google.gson.JsonSyntaxException;
import com.seatrend.exam.R;
import com.seatrend.exam.common.Constants;
import com.seatrend.exam.fragment.FingerprintDialogFragment;
import com.seatrend.exam.presenter.GetPresenter;
import com.seatrend.exam.presenter.LoginPresenter;
import com.seatrend.exam.response.BaseResponse;
import com.seatrend.exam.response.CatalogueResponse;
import com.seatrend.exam.response.ExamRoomRemoteResponse;
import com.seatrend.exam.response.LoginResponse;
import com.seatrend.exam.response.TaskTopResponse;
import com.seatrend.exam.utils.SharedPreferencesUtils;
import com.seatrend.exam.view.GetView;
import com.seatrend.exam.view.LoginView;

import java.security.KeyStore;
import java.util.HashMap;
import java.util.Map;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class FingerprintLoginActivity extends BaseActivity implements LoginView, GetView {

    private static final String DEFAULT_KEY_NAME = "default_key";
    KeyStore keyStore;
    private Cipher cipher;
    private LoginPresenter presenter;
    private GetPresenter getPresenter;

    @Override
    public int getLayout() {
        return R.layout.activity_finger_print_login;
    }

    @Override
    public void initView(Bundle savedInstanceState) {
        presenter = new LoginPresenter(this);
        getPresenter = new GetPresenter(this);

        if (supportFingerprint()) {
            initKey();
            initCipher();
        }
    }

    @Override
    public int setBarColor() {
        return R.color.white;
    }

    @OnClick({R.id.m_ll_finger_login, R.id.m_tv_username_login, R.id.m_tv_set_ip})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.m_ll_finger_login:
                showFingerPrintDialog(cipher);
                break;

            case R.id.m_tv_username_login:
                startActivity(new Intent(this, LoginActivity.class));
                finish();
                break;

            case R.id.m_tv_set_ip:
                startActivity(new Intent(this, IPSettingActivity.class));
                finish();
                break;
        }
    }

    public boolean supportFingerprint() {
        if (Build.VERSION.SDK_INT < 23) {
            Toast.makeText(this, "您的系统版本过低，不支持指纹功能", Toast.LENGTH_SHORT).show();
            return false;
        } else {
            KeyguardManager keyguardManager = getSystemService(KeyguardManager.class);
            FingerprintManager fingerprintManager = getSystemService(FingerprintManager.class);
            if (!fingerprintManager.isHardwareDetected()) {
                Toast.makeText(this, "您的手机不支持指纹功能", Toast.LENGTH_SHORT).show();
                return false;
            } else if (!keyguardManager.isKeyguardSecure()) {
                Toast.makeText(this, "您还未设置锁屏，请先设置锁屏并添加一个指纹", Toast.LENGTH_SHORT).show();
                return false;
            } else if (!fingerprintManager.hasEnrolledFingerprints()) {
                Toast.makeText(this, "您至少需要在系统设置中添加一个指纹", Toast.LENGTH_SHORT).show();
                return false;
            }
        }
        return true;
    }

    @TargetApi(23)
    private void initKey() {
        try {
            keyStore = KeyStore.getInstance("AndroidKeyStore");
            keyStore.load(null);
            KeyGenerator keyGenerator = KeyGenerator.getInstance(KeyProperties.KEY_ALGORITHM_AES, "AndroidKeyStore");
            KeyGenParameterSpec.Builder builder = new KeyGenParameterSpec.Builder(DEFAULT_KEY_NAME,
                    KeyProperties.PURPOSE_ENCRYPT |
                            KeyProperties.PURPOSE_DECRYPT)
                    .setBlockModes(KeyProperties.BLOCK_MODE_CBC)
                    .setUserAuthenticationRequired(true)
                    .setEncryptionPaddings(KeyProperties.ENCRYPTION_PADDING_PKCS7);
            keyGenerator.init(builder.build());
            keyGenerator.generateKey();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @TargetApi(23)
    private void initCipher() {
        try {
            SecretKey key = (SecretKey) keyStore.getKey(DEFAULT_KEY_NAME, null);
            cipher = Cipher.getInstance(KeyProperties.KEY_ALGORITHM_AES + "/"
                    + KeyProperties.BLOCK_MODE_CBC + "/"
                    + KeyProperties.ENCRYPTION_PADDING_PKCS7);
            cipher.init(Cipher.ENCRYPT_MODE, key);
            showFingerPrintDialog(cipher);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private void showFingerPrintDialog(Cipher cipher) {
        FingerprintDialogFragment fragment = new FingerprintDialogFragment();
        fragment.setCipher(cipher);
        fragment.show(getFragmentManager(), "fingerprint");

    }

    public void onAuthenticated() {
        Map<String, String> map = new HashMap<>();
        map.put("username", SharedPreferencesUtils.getUsername());
        map.put("password", "Li0ypWPQ^mAjy84E");
        map.put("client", "4");
        presenter.doNetworkTask(map, Constants.USER_LOGIN);

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

            HashMap<String, String> map = new HashMap<>();
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
            showErrorDialog("JsonSyntaxException" + e.getMessage());
        }
    }

    @Override
    public void getSuccess(BaseResponse response) {
        try {
            if (Constants.GET_CATALOGUE.equals(response.getUrl())) {
                CatalogueResponse catalogueResponse = gson.fromJson(response.getResponseString(), CatalogueResponse.class);

                Constants.catalogue1 = catalogueResponse.getData().getCatalogue1();
                Constants.catalogue2 = catalogueResponse.getData().getCatalogue2();

                HashMap<String, String> map = new HashMap<>();
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
                HashMap<String, String> map = new HashMap<>();
                map.put("type", "5");
                if ("2".equals(Constants.ssjs)) {
                    map.put("kcmc", Constants.kcxh);
                }
                getPresenter.doNetworkTask(map, Constants.SELECT_EXAMINATION_SITE_CARMERA_LIST);

            } else {
                ExamRoomRemoteResponse mResponse = gson.fromJson(response.getResponseString(), ExamRoomRemoteResponse.class);
                Constants.secondData = mResponse.getData();

                finish();
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

}
