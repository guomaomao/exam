package com.seatrend.exam.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.seatrend.exam.R;
import com.seatrend.exam.common.Constants;
import com.seatrend.exam.network.NetworkService;

import java.util.Objects;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;


/**
 * 多张图片的大图
 * Created by Administrator on 2017/1/17.
 */

public class BigImageFragment extends BaseFragment {
    @BindView(R.id.m_iv_preview)
    ImageView mIvPreview;

    private String mImageUrl;

    public static BigImageFragment newInstance(String imageUrl, boolean isNetwork) {
        final BigImageFragment f = new BigImageFragment();
        final Bundle args = new Bundle();
        args.putString("url", imageUrl);
        args.putBoolean("isNetwork", isNetwork);
        f.setArguments(args);
        return f;
    }

    @Override
    public int getLayout() {
        return R.layout.fragment_picture_preview;
    }

    @Override
    public void initView(Bundle savedInstanceState) {
        mImageUrl = getArguments() != null ? getArguments().getString("url") : null;
        boolean isNetwork = getArguments() != null && getArguments().getBoolean("isNetwork");

        if (isNetwork) {
            Glide.with(Objects.requireNonNull(getActivity())).load(NetworkService.httpUrl + Constants.DOWNLOAD_FILE_BY_ID + "?fileId=" + mImageUrl).into(mIvPreview);

        }else {
            Glide.with(Objects.requireNonNull(getActivity())).load(mImageUrl).into(mIvPreview);
        }
    }
}
