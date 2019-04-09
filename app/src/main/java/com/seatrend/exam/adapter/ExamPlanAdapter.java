package com.seatrend.exam.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.seatrend.exam.R;
import com.seatrend.exam.response.ExamPlanResponse;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 任务==》考试计划
 */
public class ExamPlanAdapter extends RecyclerView.Adapter<ExamPlanAdapter.ViewHolder> {

    private Context context;
    private List<ExamPlanResponse.DataBean> list;

    public ExamPlanAdapter(Context context, List<ExamPlanResponse.DataBean> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_exam_plan, parent, false);
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
        @BindView(R.id.m_tv_scene)
        TextView mTvScene;
        @BindView(R.id.m_tv_name)
        TextView mTvName;
        @BindView(R.id.m_tv_type)
        TextView mTvType;
        @BindView(R.id.m_tv_number)
        TextView mTvNumber;

        ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }

        public void init(){
            ExamPlanResponse.DataBean dataBean = list.get(getAdapterPosition());
            mTvScene.setText(dataBean.getKscc());
            mTvName.setText(dataBean.getKcxh());
            mTvType.setText(dataBean.getKscx());
            mTvNumber.setText(dataBean.getCount());

        }
    }
}
