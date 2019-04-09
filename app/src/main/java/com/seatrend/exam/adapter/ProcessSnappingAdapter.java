package com.seatrend.exam.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.seatrend.exam.R;
import com.seatrend.exam.response.CameraSubjectOneResponse;
import com.seatrend.exam.response.CameraSubjectTwoResponse;
import com.seatrend.exam.utils.Utils;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ProcessSnappingAdapter extends RecyclerView.Adapter<ProcessSnappingAdapter.ViewHolder> {

    private Context context;
    private List<CameraSubjectOneResponse.DataBean.ResExamKszpTempBean> resExamKszpTemp;
    private List<CameraSubjectTwoResponse.DataBean.ResDrvMonExamPhotosBean> resDrvMonExamPhotos;

    public ProcessSnappingAdapter(Context context) {
        this.context = context;

    }

    public void setSubjectOneData(List<CameraSubjectOneResponse.DataBean.ResExamKszpTempBean> resExamKszpTemp) {
        this.resExamKszpTemp = resExamKszpTemp;
    }

    public void setSubjectTwoData(List<CameraSubjectTwoResponse.DataBean.ResDrvMonExamPhotosBean> resDrvMonExamPhotos) {
        this.resDrvMonExamPhotos = resDrvMonExamPhotos;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_process_snapping, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.init();
    }

    @Override
    public int getItemCount() {
        if (resExamKszpTemp != null) {
            return resExamKszpTemp.size();
        }
        if (resDrvMonExamPhotos != null) {
            return resDrvMonExamPhotos.size();
        }
        return 0;
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.m_iv_pic)
        ImageView mIvPic;
        @BindView(R.id.m_tv_time)
        TextView mTvTime;
        @BindView(R.id.m_tv_auth)
        TextView mTvAuth;

        ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }

        public void init() {
            if (resExamKszpTemp != null) {
                CameraSubjectOneResponse.DataBean.ResExamKszpTempBean bean = resExamKszpTemp.get(getAdapterPosition());
                Glide.with(context).load(Utils.base64ToBitmap(bean.getZp())).error(R.color.light_gray).into(mIvPic);

                mTvTime.setText(Utils.formatTime(bean.getGxsj()));
                if ("1".equals(bean.getResult())) {
                    mTvAuth.setText("人像对比通过");
                } else {
                    mTvAuth.setText("人像对比失败");
                }
            }

            if (resDrvMonExamPhotos != null) {
                CameraSubjectTwoResponse.DataBean.ResDrvMonExamPhotosBean bean = resDrvMonExamPhotos.get(getAdapterPosition());
                Glide.with(context).load(Utils.base64ToBitmap(bean.getZp())).error(R.color.light_gray).into(mIvPic);

                mTvTime.setText(Utils.formatTime(bean.getZpsj()));

                if ("1".equals(bean.getResult())) {
                    mTvAuth.setText("人像对比通过");
                } else {
                    mTvAuth.setText("人像对比失败");
                }
            }
        }
    }
}
