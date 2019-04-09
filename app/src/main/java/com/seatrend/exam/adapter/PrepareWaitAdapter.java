package com.seatrend.exam.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.seatrend.exam.R;
import com.seatrend.exam.common.Constants;
import com.seatrend.exam.network.NetworkService;
import com.seatrend.exam.response.PrepareDetailResponse;
import com.seatrend.exam.response.RoomExamResponse;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 考前准备--》检查详情--》候考区
 */
public class PrepareWaitAdapter extends RecyclerView.Adapter<PrepareWaitAdapter.ViewHolder> {

    private Context context;
    private List<PrepareDetailResponse.DataBean.ProjectsBean> projects;

    public PrepareWaitAdapter(Context context, List<PrepareDetailResponse.DataBean.ProjectsBean> projects) {
        this.context = context;
        this.projects = projects;
    }

    public void refresh(List<PrepareDetailResponse.DataBean.ProjectsBean> projects) {
        this.projects = projects;
        notifyDataSetChanged();
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_prepare_wait, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.init();
    }

    @Override
    public int getItemCount() {
        return projects.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.m_tv_title)
        TextView mTvTitle;
        @BindView(R.id.m_tv_state)
        TextView mTvState;
        @BindView(R.id.m_iv_photo)
        ImageView mIvPhoto;
        @BindView(R.id.m_tv_disposal)
        TextView mTvDisposal;
        @BindView(R.id.m_ll_exception)
        LinearLayout mLlException;

        ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }

        public void init() {
            PrepareDetailResponse.DataBean.ProjectsBean projectsBean = projects.get(getAdapterPosition());

            mTvTitle.setText(projectsBean.getResultOrder() + "." + projectsBean.getCheckpoint());

            if ("0".equals(projectsBean.getResult())){
                mTvState.setText("正常");
                mLlException.setVisibility(View.GONE);

            }else {
                mTvState.setText("异常");
                mLlException.setVisibility(View.VISIBLE);
                mTvDisposal.setText(projectsBean.getRemark());

            }

            Glide.with(context).load(NetworkService.httpUrl + Constants.DOWNLOAD_FILE_BY_ID + "?fileId=" + projectsBean.getPhoto()).error(R.mipmap.avatar).into(mIvPhoto);

        }
    }
}
