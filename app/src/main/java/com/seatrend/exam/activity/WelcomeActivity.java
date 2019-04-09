package com.seatrend.exam.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;

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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;

/**
 * 欢迎页
 * Created by Administrator on 2018/11/21 0021.
 */
public class WelcomeActivity extends BaseActivity implements LoginView, GetView {

    @BindView(R.id.viewpager)
    ViewPager viewpager;
    @BindView(R.id.m_view)
    ImageView mView;
    private GetPresenter getPresenter;
    private LoginPresenter presenter;
    private HashMap<String, String> map;

    @Override
    public int getLayout() {
        return R.layout.activity_welcome;
    }

    @Override
    public void initView(Bundle savedInstanceState) {
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        presenter = new LoginPresenter(this);
        getPresenter = new GetPresenter(this);

        ArrayList<View> list = new ArrayList<>();
        list.add(getLayoutInflater().inflate(R.layout.tab1, null));
        list.add(getLayoutInflater().inflate(R.layout.tab2, null));
        list.add(getLayoutInflater().inflate(R.layout.tab3, null));
        list.add(getLayoutInflater().inflate(R.layout.tab4, null));
        list.add(getLayoutInflater().inflate(R.layout.tab5, null));

        viewpager.setAdapter(new ViewPagerAdapter(list));
        viewpager.addOnPageChangeListener(new ViewPagerPageChangeListener());

        if (SharedPreferencesUtils.IsFirst()) {
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    SharedPreferencesUtils.setIsFirst(false);
                    start();
                }
            }, 1000);

        } else {
            if (TextUtils.isEmpty(SharedPreferencesUtils.getUsername()) || TextUtils.isEmpty(SharedPreferencesUtils.getPassword())) {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        start();
                    }
                }, 1000);

            } else {
                if (Utils.isSameData(SharedPreferencesUtils.getLoginTime(), String.valueOf(System.currentTimeMillis()))) {
                    Map<String, String> map = new HashMap<>();
                    map.put("username", SharedPreferencesUtils.getUsername());
                    map.put("password", SharedPreferencesUtils.getPassword());
                    map.put("client", "2");
                    presenter.doNetworkTask(map, Constants.USER_LOGIN);

                }else {
                    start();
                }
            }
        }
    }

    @Override
    public int setBarColor() {
        return R.color.transparent;
    }

    @Override
    public void loginSuccess(BaseResponse response) {
        try {
            LoginResponse loginResponse = gson.fromJson(response.getResponseString(), LoginResponse.class);
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
            start();
        }
    }

    @Override
    public void loginFailed(BaseResponse response) {
        mLoading.dismiss();
        start();
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

//            if (Constants.taskTop != null && (Constants.catalogue1 != null || Constants.catalogue2 != null) && Constants.secondData != null) {
//                mLoading.dismiss();
//
//            }

        } catch (JsonSyntaxException e) {
            start();
        }
    }

    @Override
    public void getFailed(BaseResponse response) {
        mLoading.dismiss();
        start();
    }

    class ViewPagerAdapter extends PagerAdapter {
        private
        List<View> list;

        public ViewPagerAdapter(List<View> list) {
            this.list = list;
        }

        @Override
        public int getCount() {
            return list.size();
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            container.addView(list.get(position));
            return list.get(position);
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView(list.get(position));
        }

        @Override
        public boolean isViewFromObject(View arg0, Object arg1) {
            return arg0 == arg1;
        }
    }

    class ViewPagerPageChangeListener implements ViewPager.OnPageChangeListener {
        @Override
        public void onPageScrollStateChanged(int state) {
        }

        @Override
        public void onPageScrolled(int page, float positionOffset, int positionOffsetPixels) {
        }

        @Override
        public void onPageSelected(int page) {
            if (page == 4) {
                SharedPreferencesUtils.setIsFirst(false);
                start();
            }
        }
    }

    private void start() {
        if (TextUtils.isEmpty(SharedPreferencesUtils.getUsername()) || TextUtils.isEmpty(SharedPreferencesUtils.getPassword())) {
            startActivity(new Intent(this, LoginActivity.class));
        }else {
            startActivity(new Intent(this, FingerprintLoginActivity.class));
        }
        finish();
    }
}
