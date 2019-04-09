package com.seatrend.exam.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.seatrend.exam.R;
import com.seatrend.exam.response.CatalogueResponse;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class TaskAdapter extends RecyclerView.Adapter<TaskAdapter.ViewHolder> {

    private Context context;
    private List<CatalogueResponse.DataBean.Catalogue1Bean> list;

    public TaskAdapter(Context context, List<CatalogueResponse.DataBean.Catalogue1Bean> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_today_mission, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        CatalogueResponse.DataBean.Catalogue1Bean entity = list.get(holder.getAdapterPosition());

        holder.mTvTodo.setText(entity.getName());

        if ("1".equals(entity.getNumber())) {
            holder.mLlCompleted.setVisibility(View.VISIBLE);
            holder.mLlWait.setVisibility(View.GONE);

        } else if ("0".equals(entity.getNumber())) {
            holder.mLlCompleted.setVisibility(View.GONE);
            holder.mLlWait.setVisibility(View.VISIBLE);

        } else {
            holder.mLlCompleted.setVisibility(View.GONE);
            holder.mLlWait.setVisibility(View.GONE);
        }

        switch (entity.getName()) {
            case "考试计划确认": //考试计划
                holder.mColor.setBackgroundColor(context.getResources().getColor(R.color.task_1));
                break;

            case "考前检查": //考前检查
                holder.mColor.setBackgroundColor(context.getResources().getColor(R.color.task_2));
                break;

            case "考中检查": //考中检查
                holder.mColor.setBackgroundColor(context.getResources().getColor(R.color.task_3));
                break;

            case "考后检查": //考后检查
                holder.mColor.setBackgroundColor(context.getResources().getColor(R.color.task_4));
                break;

            case "远程巡考": //远程巡考
                holder.mColor.setBackgroundColor(context.getResources().getColor(R.color.task_5));
                break;

            case "回访考生": //回访考生
                holder.mColor.setBackgroundColor(context.getResources().getColor(R.color.task_6));
                break;

            case "工作报告": //工作报告
                holder.mColor.setBackgroundColor(context.getResources().getColor(R.color.task_7));
                break;
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.m_tv_todo)
        TextView mTvTodo;
        @BindView(R.id.m_ll_wait)
        LinearLayout mLlWait;
        @BindView(R.id.m_ll_completed)
        LinearLayout mLlCompleted;
        @BindView(R.id.m_color)
        TextView mColor;

        public ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    listener.onClick(getAdapterPosition());
                }
            });
        }
    }

    public OnClickListener listener;

    public interface OnClickListener {
        void onClick(int position);
    }

    public void setOnClickListener(OnClickListener listener) {
        this.listener = listener;
    }

}
