package com.seatrend.exam.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.seatrend.exam.R;
import com.seatrend.exam.common.Constants;
import com.seatrend.exam.network.NetworkService;
import com.seatrend.exam.response.RoomExamResponse;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ImageAdapter extends RecyclerView.Adapter<ImageAdapter.ViewHolder> {

    private Context context;
    private List<RoomExamResponse.DataBean.ListBean.ProjectsBean> projects ;

    public ImageAdapter(Context context, List<RoomExamResponse.DataBean.ListBean.ProjectsBean> projects ) {
        this.context = context;
        this.projects = projects;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_image, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Glide.with(context).load(NetworkService.httpUrl + Constants.DOWNLOAD_FILE_BY_ID + "?fileId=" + projects.get(holder.getAdapterPosition()).getPhoto())
                .error(R.color.light_gray).into(holder.mImage);

    }

    @Override
    public int getItemCount() {
        if (projects.size() > 3) {
            return 3;
        }else {
            return projects.size();
        }
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.m_image)
        ImageView mImage;

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
    }

    public OnItemClickListener listener;

    public interface OnItemClickListener {
        void onClick(int position);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.listener = listener;
    }
}
