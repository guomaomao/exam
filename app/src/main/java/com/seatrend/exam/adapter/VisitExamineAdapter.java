package com.seatrend.exam.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.seatrend.exam.R;
import com.seatrend.exam.common.MediaManager;
import com.seatrend.exam.response.VisitExamineResponse;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 回访考生
 */
public class VisitExamineAdapter extends RecyclerView.Adapter<VisitExamineAdapter.ViewHolder> {

    private Context context;
    private List<VisitExamineResponse.DataBean.ListBean> beanList;

    public VisitExamineAdapter(Context context, List<VisitExamineResponse.DataBean.ListBean> beanList) {
        this.context = context;
        this.beanList = beanList;
    }

    public void refresh(List<VisitExamineResponse.DataBean.ListBean> beanList) {
        this.beanList = beanList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_visit_examine, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.init();
    }

    @Override
    public int getItemCount() {
        return beanList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.m_iv_avatar)
        ImageView mIvAvatar;
        @BindView(R.id.m_tv_username)
        TextView mTvUsername;
        @BindView(R.id.m_tv_satisfaction)
        TextView mTvSatisfaction;
        @BindView(R.id.m_tv_content)
        TextView mTvContent;
        @BindView(R.id.m_iv_visit)
        ImageView mIvVisit;
        @BindView(R.id.m_recycler)
        RecyclerView mRecycler;
        PopupWindow mWindow;

        ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }

        @SuppressLint("ClickableViewAccessibility")
        public void init() {
            final VisitExamineResponse.DataBean.ListBean listBean = beanList.get(getAdapterPosition());
            mTvUsername.setText(listBean.getXm());
            mTvSatisfaction.setText(listBean.getMyd());
            mTvContent.setText(listBean.getYjjy());


            mRecycler.setLayoutManager(new LinearLayoutManager(context));
            VisitExamineChildAdapter childAdapter = new VisitExamineChildAdapter(context, listBean.getVisitRecordMessages());
            mRecycler.setAdapter(childAdapter);

            childAdapter.setOnPlayListener(new VisitExamineChildAdapter.OnPlayListener() {
                @Override
                public void onClick(int position, final ImageView mIvVoice) {
                    mIvVoice.setImageResource(R.drawable.voice_to_icon);

                    final AnimationDrawable voiceAnimation = (AnimationDrawable) mIvVoice.getDrawable();
                    voiceAnimation.start();

                    //播放音频
                    MediaManager.playSound("路径", new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mp) {
                            voiceAnimation.stop();
                            mIvVoice.setImageResource(R.mipmap.ease_chatto_voice_playing);
                        }
                    });
                }
            });

            mIvVisit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (mWindow != null) {
                        if (mWindow.isShowing()) {
                            mWindow.dismiss();
                        } else {
                            showWindow(listBean.getHfzt(), listBean.getId(), listBean.getLxdh());
                        }
                    } else {
                        showWindow(listBean.getHfzt(), listBean.getId(), listBean.getLxdh());
                    }
                }
            });

            mRecycler.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    if (mWindow != null) {
                        if (mWindow.isShowing()) {
                            mWindow.dismiss();
                        }
                    }
                    return false;
                }
            });
        }

        private void showWindow(final String hfzt, final String id, final String phone) {
            final View view = LayoutInflater.from(context).inflate(R.layout.item_popup_visit, null);
            view.measure(View.MeasureSpec.UNSPECIFIED, View.MeasureSpec.UNSPECIFIED);
            int mShowMorePopupWindowWidth = -view.getMeasuredWidth();
            int mShowMorePopupWindowHeight = -view.getMeasuredHeight();

            mWindow = new PopupWindow(view, ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            mWindow.showAsDropDown(mIvVisit, mShowMorePopupWindowWidth, mShowMorePopupWindowHeight);

            view.findViewById(R.id.m_ll_visit_phone).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(Intent.ACTION_DIAL);
                    Uri data = Uri.parse("tel:" + phone);
                    intent.setData(data);
                    context.startActivity(intent);

                    mWindow.dismiss();
                }
            });

            view.findViewById(R.id.m_ll_visit_record).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    listener.onClick(hfzt, id);
                    mWindow.dismiss();

                }
            });
        }
    }

    public OnItemClickListener listener;

    public interface OnItemClickListener {
        void onClick(String str1, String str2);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.listener = listener;
    }

}
