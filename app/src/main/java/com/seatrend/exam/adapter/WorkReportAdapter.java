package com.seatrend.exam.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.seatrend.exam.R;
import com.seatrend.exam.response.WorkReportResponse;
import com.seatrend.exam.utils.Utils;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class WorkReportAdapter extends RecyclerView.Adapter<WorkReportAdapter.ViewHolder> {

    private Context context;
    private List<WorkReportResponse.DataBean.ListBean> list;

    public WorkReportAdapter(Context context, List<WorkReportResponse.DataBean.ListBean> list) {
        this.context = context;
        this.list = list;
    }

    public void refresh(List<WorkReportResponse.DataBean.ListBean> list) {
        this.list = list;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_work_report, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.init();
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.m_avatar)
        ImageView mAvatar;
        @BindView(R.id.m_tv_username)
        TextView mTvUsername;
        @BindView(R.id.m_tv_exam_room)
        TextView mTvExamRoom;
        @BindView(R.id.m_tv_content)
        TextView mTvContent;
        @BindView(R.id.m_tv_type)
        TextView mTvType;
        @BindView(R.id.m_tv_time)
        TextView mTvTime;

        ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }

        public void init() {
            WorkReportResponse.DataBean.ListBean listBean = list.get(getAdapterPosition());
            mTvUsername.setText(listBean.getUserName());
            mTvExamRoom.setText(listBean.getExamSiteName());
            mTvContent.setText(listBean.getReport());

            if ("1".equals(listBean.getReportType())) {
                mTvType.setText("日报");
                mTvType.setBackgroundResource(R.drawable.my_bg_blue);

            } else if ("2".equals(listBean.getReportType())) {
                mTvType.setText("周报");
                mTvType.setBackgroundResource(R.drawable.my_bg_orange);

            } else if ("3".equals(listBean.getReportType())) {
                mTvType.setText("月报");
                mTvType.setBackgroundResource(R.drawable.my_bg_pink);
            }

            mTvTime.setText(Utils.formatTime(listBean.getReportTime()));

        }
    }
}
