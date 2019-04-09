package com.seatrend.exam.fragment;

import android.os.Bundle;
import android.widget.RadioGroup;

import com.seatrend.exam.R;
import com.seatrend.exam.common.Constants;
import com.seatrend.exam.utils.Utils;

import butterknife.BindView;
import me.yokeyword.fragmentation.SupportFragment;

public class FirstFragment extends BaseFragment {

    @BindView(R.id.m_radio_group)
    RadioGroup mRg;

    private int mSelectPosition, mCurrentPosition = 0;
    private SupportFragment[] mFragments = new SupportFragment[2];
    private static final int FIRST = 0;
    private static final int SECOND = 1;

    public static FirstFragment newInstance() {
        Bundle bundle = new Bundle();
        FirstFragment fragment = new FirstFragment();
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public int getLayout() {
        return R.layout.fragment_first;
    }

    @Override
    public void initView(Bundle savedInstanceState) {
        mRg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.m_rb_first:
                        mSelectPosition = 0;
                        showHideFragment(mFragments[mSelectPosition], mFragments[mCurrentPosition]);
                        mCurrentPosition = 0;
                        break;

                    case R.id.m_rb_second:
                        if ("2".equals(Constants.ssjs)) {
                            Utils.showToast(getActivity(), "您没有权限操作该功能");

                        } else {
                            mSelectPosition = 1;
                            showHideFragment(mFragments[mSelectPosition], mFragments[mCurrentPosition]);
                            mCurrentPosition = 1;
                        }
                        break;
                }
            }
        });

        if (savedInstanceState == null) {
            mFragments[FIRST] = TaskFragment.newInstance();
            mFragments[SECOND] = SuperviseFragment.newInstance();
            loadMultipleRootFragment(R.id.frameLayout, FIRST,
                    mFragments[FIRST],
                    mFragments[SECOND]);

        } else {
            mFragments[FIRST] = findChildFragment(TaskFragment.class);
            mFragments[SECOND] = findChildFragment(SuperviseFragment.class);
        }
    }
}
