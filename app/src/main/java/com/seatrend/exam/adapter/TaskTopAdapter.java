package com.seatrend.exam.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.seatrend.exam.R;
import com.seatrend.exam.common.view.SemicircleProgressBar;
import com.seatrend.exam.response.TaskTopResponse;

import java.text.DecimalFormat;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class TaskTopAdapter extends RecyclerView.Adapter<TaskTopAdapter.ViewHolder> {

    private Context context;
    private List<TaskTopResponse.DataBean> data;

    public TaskTopAdapter(Context context, List<TaskTopResponse.DataBean> data) {
        this.context = context;
        this.data = data;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_task_top, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.init();
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.m_tv_project_num)
        TextView mTvProjectNum;
        @BindView(R.id.progressbar)
        SemicircleProgressBar progressbar;
        @BindView(R.id.m_tv_pass_rate)
        TextView mTvPassRate;
        @BindView(R.id.m_tv_exam_num)
        TextView mTvExamNum;
        @BindView(R.id.m_tv_waiting_num)
        TextView mTvWaitingNum;

        ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }

        public void init(){
            TaskTopResponse.DataBean dataBean = data.get(getAdapterPosition());
            if ("1".equals(dataBean.getKskm())) {
                mTvProjectNum.setText("科目一");

            }else if ("2".equals(dataBean.getKskm())) {
                mTvProjectNum.setText("科目二");

            }else if ("3".equals(dataBean.getKskm())) {
                mTvProjectNum.setText("科目三");

            }else if ("4".equals(dataBean.getKskm())) {
                mTvProjectNum.setText("科目四");
            }

            mTvExamNum.setText(dataBean.getYkrs());
            mTvWaitingNum.setText(dataBean.getDkrs());
            DecimalFormat df1 = new DecimalFormat("##.00%");    //##.00%
            if (dataBean.getHgl() != null) {
                mTvPassRate.setText(df1.format(Double.parseDouble(dataBean.getHgl())));
                progressbar.setProgress(Double.parseDouble(dataBean.getHgl()) * 100);
            }
        }
    }
}
