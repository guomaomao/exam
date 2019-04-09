package com.seatrend.exam.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.seatrend.exam.R;
import com.seatrend.exam.activity.CheckDetailActivity;
import com.seatrend.exam.common.Constants;
import com.seatrend.exam.network.NetworkService;
import com.seatrend.exam.response.PrepareResponse;
import com.seatrend.exam.utils.Utils;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 监管==》考前准备
 */
public class PrepareAdapter extends RecyclerView.Adapter<PrepareAdapter.ViewHolder> {

    private Context context;
    private List<PrepareResponse.DataBean.PreparesBean> prepares;

    public PrepareAdapter(Context context, List<PrepareResponse.DataBean.PreparesBean> prepares) {
        this.context = context;
        this.prepares = prepares;
    }

    @NonNull
    @Override
    public PrepareAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_prepare, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PrepareAdapter.ViewHolder holder, int position) {
        holder.init();
    }

    public void setData(int position, List<PrepareResponse.DataBean.PreparesBean> prepares){
        this.prepares = prepares;
        notifyItemChanged(position);
    }

    @Override
    public int getItemViewType(int position) {
        return R.layout.item_prepare;
    }

    @Override
    public int getItemCount() {
        return prepares.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.m_tv_name)
        TextView mTvName;
        @BindView(R.id.m_tv_subject)
        TextView mTvSubject;
        @BindView(R.id.m_tv_examiner)
        TextView mTvExaminer;
        @BindView(R.id.m_tv_plan_time)
        TextView mTvPlanTime;
        @BindView(R.id.m_iv_sign)
        ImageView mIvSign;
        @BindView(R.id.m_tv_result)
        TextView mTvResult;
        @BindView(R.id.m_btn_left)
        Button mBtnLeft;
        @BindView(R.id.m_btn_right)
        Button mBtnRight;

        ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }

        public void init() {

            final PrepareResponse.DataBean.PreparesBean preparesBean = prepares.get(getAdapterPosition());
            mTvName.setText(preparesBean.getExamSite());
            mTvExaminer.setText(preparesBean.getKsy());
            mTvSubject.setText(preparesBean.getExamSubject());
            mTvPlanTime.setText(Utils.formatTime(preparesBean.getConfirmTime()));

            if ("0".equals(preparesBean.getCheckResult())) {
                mTvResult.setText("正常");
                mTvResult.setTextColor(context.getResources().getColor(R.color.green));

            } else {
                mTvResult.setText("异常");
                mTvResult.setTextColor(context.getResources().getColor(R.color.dark_orange));
            }

            Glide.with(context).load(NetworkService.httpUrl + Constants.DOWNLOAD_FILE_BY_ID + "?fileId=" + preparesBean.getPhoto()).into(mIvSign);

            mBtnLeft.setText("检查详情");
            mBtnRight.setText("开始考试");

            if ("2".equals(preparesBean.getCheckState())) {
                mBtnLeft.setEnabled(false);
                mBtnRight.setEnabled(false);
                mBtnLeft.setTextColor(context.getResources().getColor(R.color.white));
                mBtnLeft.setBackgroundColor(context.getResources().getColor(R.color.light_gray));
                mBtnRight.setBackgroundColor(context.getResources().getColor(R.color.light_gray));

            } else {
                mBtnLeft.setEnabled(true);
                mBtnRight.setEnabled(true);
            }

            mBtnLeft.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    context.startActivity(new Intent(context, CheckDetailActivity.class).putExtra("checkId", preparesBean.getCheckId()));
                }
            });

            mBtnRight.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    listener.onClick(getAdapterPosition(), preparesBean.getCheckId());
                }
            });
        }
    }

    public OnItemClickListener listener;

    public interface OnItemClickListener {
        void onClick(int position, String id);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.listener = listener;
    }

}
