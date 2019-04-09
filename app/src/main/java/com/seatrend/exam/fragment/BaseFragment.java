package com.seatrend.exam.fragment;

import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.seatrend.exam.R;
import com.seatrend.exam.common.view.CommonDialog;
import com.seatrend.exam.common.view.Loading;
import com.seatrend.exam.view.BaseView;

import butterknife.ButterKnife;
import butterknife.Unbinder;
import me.yokeyword.fragmentation.SupportFragment;

/**
 * base fragment
 * Created by Administrator on 2017/11/29 0029.
 */
public abstract class BaseFragment extends SupportFragment implements BaseView {

    protected Unbinder unbinder;
    protected Loading mLoading;
    protected Gson gson;
    protected LinearLayout mLlNetworkError;
    protected LinearLayout mLlEmpty;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(getLayout(), null);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mLoading = new Loading(getActivity());
        gson = new Gson();

        mLlNetworkError = view.findViewById(R.id.m_ll_network_error);
        mLlEmpty = view.findViewById(R.id.m_ll_empty);

        initView(savedInstanceState);
    }

    public abstract int getLayout();

    public abstract void initView(Bundle savedInstanceState);

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
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

    @Override
    public void showToast(String msg) {
        Toast.makeText(getActivity(), msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showToast(int msgId) {
        Toast.makeText(getActivity(), getString(msgId), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showErrorDialog(String msg) {
        try {
            final Dialog dialog = CommonDialog.CenterDialog(getActivity(), R.layout.dialog_info, false);
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
}
