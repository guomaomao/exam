package com.seatrend.exam.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.seatrend.exam.R;
import com.seatrend.exam.response.CameraSubjectTwoResponse;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class PointRecordSubjectTwoAdapter extends RecyclerView.Adapter<PointRecordSubjectTwoAdapter.ViewHolder> {

    private Context context;
    private List<CameraSubjectTwoResponse.DataBean.ResDrvCodeExamsBean> resDrvCodeExams;

    public PointRecordSubjectTwoAdapter(Context context, List<CameraSubjectTwoResponse.DataBean.ResDrvCodeExamsBean> resDrvCodeExams) {
        this.context = context;
        this.resDrvCodeExams = resDrvCodeExams;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_point_record_subject_two, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.init();
    }

    @Override
    public int getItemCount() {
        return resDrvCodeExams.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.m_tv_subject_item)
        TextView mTvSubjectItem;
        @BindView(R.id.m_tv_subject_code)
        TextView mTvSubjectCode;
        @BindView(R.id.m_tv_subject_deduction)
        TextView mTvSubjectDeduction;

        ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }

        public void init() {
            CameraSubjectTwoResponse.DataBean.ResDrvCodeExamsBean examsBean = resDrvCodeExams.get(getAdapterPosition());
            mTvSubjectItem.setText(examsBean.getXmfl());
            mTvSubjectCode.setText(examsBean.getXmdm());
            mTvSubjectDeduction.setText(examsBean.getXmmc());
        }
    }
}
