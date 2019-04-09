package com.seatrend.exam.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.seatrend.exam.R;
import com.seatrend.exam.response.RoomExamResponse;

import java.util.List;

import butterknife.ButterKnife;

/**
 * 考后检查
 */
public class AfterExamEditAdapter extends RecyclerView.Adapter<AfterExamEditAdapter.ViewHolder> {

    private Context context;
    private List<RoomExamResponse.DataBean.ListBean.ProjectBean> project;

    public AfterExamEditAdapter(Context context, List<RoomExamResponse.DataBean.ListBean.ProjectBean> project) {
        this.context = context;
        this.project = project;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_after_exam_edit, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return project.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }
}
