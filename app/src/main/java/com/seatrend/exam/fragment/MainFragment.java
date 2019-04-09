package com.seatrend.exam.fragment;

import android.os.Bundle;

import com.seatrend.exam.R;
import com.seatrend.exam.common.view.ViewBottomBar;

import butterknife.BindView;
import me.yokeyword.fragmentation.SupportFragment;

public class MainFragment extends BaseFragment {
    @BindView(R.id.m_bottomBar)
    ViewBottomBar mBottomBar;

    private int mSelectPosition, mCurrentPosition = 0;
    private SupportFragment[] mFragments = new SupportFragment[3];
    private static final int FIRST = 0;
    private static final int SECOND = 1;
    private static final int THIRD = 2;

    public static MainFragment newInstance() {
        Bundle bundle = new Bundle();
        MainFragment fragment = new MainFragment();
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public int getLayout() {
        return R.layout.fragment_main;
    }

    @Override
    public void initView(Bundle savedInstanceState) {
        mBottomBar.setOnBottomBarOnclick(new ViewBottomBar.OnBottomBarClick() {
            @Override
            public void onFirstClick() {
                mSelectPosition = 0;
                showHideFragment(mFragments[mSelectPosition], mFragments[mCurrentPosition]);
                mCurrentPosition = 0;
            }

            @Override
            public void onSecondClick() {
                mSelectPosition = 1;
                showHideFragment(mFragments[mSelectPosition], mFragments[mCurrentPosition]);
                mCurrentPosition = 1;
            }

            @Override
            public void onThirdClick() {
                mSelectPosition = 2;
                showHideFragment(mFragments[mSelectPosition], mFragments[mCurrentPosition]);
                mCurrentPosition = 2;
            }
        });

        if (savedInstanceState == null) {
            mFragments[FIRST] = FirstFragment.newInstance();
            mFragments[SECOND] = SecondFragment.newInstance();
            mFragments[THIRD] = ThirdFragment.newInstance();
            loadMultipleRootFragment(R.id.m_fl_container, FIRST,
                    mFragments[FIRST],
                    mFragments[SECOND],
                    mFragments[THIRD]);

        } else {
            mFragments[FIRST] = findChildFragment(FirstFragment.class);
            mFragments[SECOND] = findChildFragment(SecondFragment.class);
            mFragments[THIRD] = findChildFragment(ThirdFragment.class);
        }
    }
}
