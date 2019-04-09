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

import com.seatrend.exam.R;
import com.seatrend.exam.response.VisitExamineResponse;
import com.seatrend.exam.utils.Utils;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class VisitExamineChildAdapter extends RecyclerView.Adapter<VisitExamineChildAdapter.ViewHolder> {

    private Context context;
    private List<VisitExamineResponse.DataBean.ListBean.VisitRecordMessagesBean> visitRecordMessages;

    public VisitExamineChildAdapter(Context context, List<VisitExamineResponse.DataBean.ListBean.VisitRecordMessagesBean> visitRecordMessages) {
        this.context = context;
        this.visitRecordMessages = visitRecordMessages;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_visit_examine_child, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, int position) {
        holder.init();

    }

    @Override
    public int getItemCount() {
        return visitRecordMessages.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.m_iv_avatar)
        ImageView mIvAvatar;
        @BindView(R.id.m_tv_username)
        TextView mTvUsername;
        @BindView(R.id.m_tv_time)
        TextView mTvTime;
        @BindView(R.id.m_tv_content)
        TextView mTvContent;
        @BindView(R.id.m_ll_content)
        LinearLayout mLlContent;
        @BindView(R.id.m_iv_voice)
        ImageView mIvVoice;
        @BindView(R.id.m_ll_voice)
        LinearLayout mLlVoice;

        ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }

        public void init(){
            VisitExamineResponse.DataBean.ListBean.VisitRecordMessagesBean messagesBean = visitRecordMessages.get(getAdapterPosition());
            mTvUsername.setText(messagesBean.getVisitor());
            mTvContent.setText(messagesBean.getVisitMessage());
            mTvTime.setText(Utils.formatTime(messagesBean.getVisitTime()));

            mIvVoice.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onClick(getAdapterPosition(), mIvVoice);
                }
            });
        }
    }

    public OnPlayListener listener;

    public interface OnPlayListener {
        void onClick(int position, ImageView mIvVoice);
    }

    public void setOnPlayListener(OnPlayListener listener) {
        this.listener = listener;
    }

}
