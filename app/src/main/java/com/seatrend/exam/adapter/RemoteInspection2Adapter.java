package com.seatrend.exam.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.seatrend.exam.R;
import com.seatrend.exam.response.ExamRoomRemoteResponse;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RemoteInspection2Adapter extends RecyclerView.Adapter<RemoteInspection2Adapter.ViewHolder> {

    private Context context;
    private List<ExamRoomRemoteResponse.DataBean.SeaExamSiteCameraBean> seaExamSiteCamera;
    private List<ExamRoomRemoteResponse.DataBean.SeaExamRoadCameraBean> seaExamRoadCamera;

    public RemoteInspection2Adapter(Context context) {
        this.context = context;
//        this.seaExamSiteCamera = seaExamSiteCamera;
//        this.seaExamRoadCamera = seaExamRoadCamera;
    }

    public void setKTData(List<ExamRoomRemoteResponse.DataBean.SeaExamSiteCameraBean> seaExamSiteCamera) {
        this.seaExamSiteCamera = seaExamSiteCamera;
        notifyDataSetChanged();
    }

    public void setVehicleData(List<ExamRoomRemoteResponse.DataBean.SeaExamRoadCameraBean> seaExamRoadCamera) {
        this.seaExamRoadCamera = seaExamRoadCamera;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_remote_inspection_2, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.init();
    }

    @Override
    public int getItemCount() {
        if (seaExamSiteCamera != null) {
            return seaExamSiteCamera.size();
        }
        if (seaExamRoadCamera != null) {
            return seaExamRoadCamera.size();
        }
        return 0;
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.m_tv_remote)
        TextView mTvRemote;

        ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);

            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    listener.onClick(getAdapterPosition());
                }
            });
        }

        public void init() {
            if (seaExamSiteCamera != null) {
                mTvRemote.setText(seaExamSiteCamera.get(getAdapterPosition()).getCameraName());

            } else if (seaExamRoadCamera != null) {
                mTvRemote.setText(seaExamRoadCamera.get(getAdapterPosition()).getCameraName());
            }


//            if (data != null) {
//                mTvRemote.setText(data.get(getAdapterPosition()).getKsjh());
//
//                if ("0".equals(data.get(getAdapterPosition()).getZt())) {
//                    mTvRemote.setBackgroundColor(context.getResources().getColor(R.color.blue));
//
//                } else if ("1".equals(data.get(getAdapterPosition()).getZt()) || "2".equals(data.get(getAdapterPosition()).getZt()) || "3".equals(data.get(getAdapterPosition()).getZt()) || "4".equals(data.get(getAdapterPosition()).getZt()) ||
//                        "5".equals(data.get(getAdapterPosition()).getZt()) || "6".equals(data.get(getAdapterPosition()).getZt()) || "7".equals(data.get(getAdapterPosition()).getZt()) || "8".equals(data.get(getAdapterPosition()).getZt())) {
//                    mTvRemote.setBackgroundColor(context.getResources().getColor(R.color.green));
//
//                } else if ("10".equals(data.get(getAdapterPosition()).getZt())) {
//                    mTvRemote.setBackgroundColor(context.getResources().getColor(R.color.dark_orange));
//
//                } else if ("9".equals(data.get(getAdapterPosition()).getZt())) {
//                    mTvRemote.setBackgroundColor(context.getResources().getColor(R.color.gray));
//                }
//
//            }else if (list != null) {
//                mTvRemote.setText(list.get(getAdapterPosition()).getHphm());
//
//                if ("正常".equals(list.get(getAdapterPosition()).getZt())) {
//                    mTvRemote.setBackgroundColor(context.getResources().getColor(R.color.green));
//
//                } else {
//                    mTvRemote.setBackgroundColor(context.getResources().getColor(R.color.dark_orange));
//
//                }
//            }
        }
    }

    public OnItemClickListener listener;

    public interface OnItemClickListener {
        void onClick(int position);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.listener = listener;
    }
}
