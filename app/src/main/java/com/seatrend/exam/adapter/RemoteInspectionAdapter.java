package com.seatrend.exam.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.seatrend.exam.R;
import com.seatrend.exam.activity.RemoteInspection2Activity;
import com.seatrend.exam.response.ExamRoomRemoteResponse;

import java.io.Serializable;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RemoteInspectionAdapter extends RecyclerView.Adapter<RemoteInspectionAdapter.ViewHolder> {

    private Context context;
    private List<ExamRoomRemoteResponse.DataBean> data;

    public RemoteInspectionAdapter(Context context, List<ExamRoomRemoteResponse.DataBean> data) {
        this.context = context;
        this.data = data;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_remote_inspection, parent, false);
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
        @BindView(R.id.m_tv_exam_room)
        TextView mTvExamRoom;

        ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);

            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
//                    Intent intent = new Intent(context, RemoteInspection2Activity.class);
//                    intent.putExtra("kcdm", data.get(getAdapterPosition()).getKcdddh());
//                    intent.putExtra("kskm", data.get(getAdapterPosition()).getKskm());
//                    intent.putExtra("kcxh", data.get(getAdapterPosition()).getXh());
//
//                    context.startActivity(intent);

                    Intent intent = new Intent(context, RemoteInspection2Activity.class);
                    intent.putExtra("kcmc", data.get(getAdapterPosition()).getKcmc());
                    intent.putExtra("kskm", data.get(getAdapterPosition()).getKskm());
                    intent.putExtra("data", data.get(getAdapterPosition()));

                    context.startActivity(intent);

                }
            });
        }

        public void init() {
            mTvExamRoom.setText(data.get(getAdapterPosition()).getKcmc());
        }
    }
}
