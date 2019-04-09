package com.seatrend.exam.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.TextView;

import com.seatrend.exam.R;
import com.seatrend.exam.entity.PicEntity;
import com.seatrend.exam.fragment.BigImageFragment;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


/**
 * 查看大图片
 * Created by Administrator on 2017/1/17.
 */
public class BigImageActivity extends BaseActivity implements View.OnClickListener {

    @BindView(R.id.m_viewPager)
    ViewPager mViewPager;
    @BindView(R.id.m_tv_indicator)
    TextView mIndicator;

    @Override
    public int getLayout() {
        return R.layout.activity_big_image;
    }

    @Override
    public void initView(Bundle savedInstanceState) {

        ArrayList<PicEntity> picEntities = (ArrayList<PicEntity>) intent.getSerializableExtra("picEntity");

        MyViewPagerAdapter mAdapter = new MyViewPagerAdapter(getSupportFragmentManager(), picEntities);
        mViewPager.setAdapter(mAdapter);

        //获取到下标
        String text = getString(R.string.indicator, 1, mViewPager.getAdapter().getCount());
        mIndicator.setText(text);
        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }

            @Override
            public void onPageSelected(int position) {
                //获取到下标
                String text = getString(R.string.indicator, position + 1, mViewPager.getAdapter().getCount());
                mIndicator.setText(text);
            }

            @Override
            public void onPageScrollStateChanged(int state) {
            }
        });
        mViewPager.setCurrentItem(0);
    }

    @Override
    public int setBarColor() {
        return R.color.black;
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.m_iv_left:
                finish();
                break;
        }
    }

    class MyViewPagerAdapter extends FragmentStatePagerAdapter {
        private List<PicEntity> path;

        public MyViewPagerAdapter(FragmentManager fm, List<PicEntity> path) {
            super(fm);
            this.path = path;
        }

        @Override
        public int getCount() {
            return path.size();
        }

        @Override
        public Fragment getItem(int position) {
            return BigImageFragment.newInstance(path.get(position).getUrl(), path.get(position).isNetwork());
        }
    }
}
