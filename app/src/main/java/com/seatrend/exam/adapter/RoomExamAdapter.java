package com.seatrend.exam.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.seatrend.exam.R;
import com.seatrend.exam.activity.BigImageActivity;
import com.seatrend.exam.activity.CheckDetailActivity;
import com.seatrend.exam.common.view.SpacingItemDecoration;
import com.seatrend.exam.entity.PicEntity;
import com.seatrend.exam.response.RoomExamResponse;
import com.seatrend.exam.utils.Utils;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RoomExamAdapter extends RecyclerView.Adapter<RoomExamAdapter.ViewHolder> {

    private Context context;
    private List<RoomExamResponse.DataBean.ListBean> list;

    public RoomExamAdapter(Context context, List<RoomExamResponse.DataBean.ListBean> list) {
        this.context = context;
        this.list = list;
    }

    public void refresh(List<RoomExamResponse.DataBean.ListBean> list) {
        this.list = list;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_room_exam, parent, false);
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
        @BindView(R.id.m_avatar)
        ImageView mAvatar;
        @BindView(R.id.m_tv_username)
        TextView mTvUsername;
        @BindView(R.id.m_tv_exam_room)
        TextView mTvExamRoom;
        @BindView(R.id.m_recycler)
        RecyclerView mRecycler;
        @BindView(R.id.m_tv_result)
        TextView mTvResult;
        @BindView(R.id.m_tv_time)
        TextView mTvTime;

        ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    context.startActivity(new Intent(context, CheckDetailActivity.class).putExtra("checkId", list.get(getAdapterPosition()).getId()));
                }
            });
        }

        public void init(){
            RoomExamResponse.DataBean.ListBean listBean = list.get(getAdapterPosition());
            mTvUsername.setText(listBean.getChecker());
            mTvExamRoom.setText(listBean.getExamroom());

            if ("0".equals(listBean.getCheckstate())){
                mTvResult.setText("正常");
                mTvResult.setBackgroundResource(R.drawable.my_bg_green_20);

            }else {
                mTvResult.setText("异常");
                mTvResult.setBackgroundResource(R.drawable.my_bg_dark_orange_20);
            }

            mTvTime.setText(Utils.formatTime(listBean.getExamtime()));

            //给recyclerView设置manager
            mRecycler.setLayoutManager(new GridLayoutManager(context, 3));
            mRecycler.addItemDecoration(new SpacingItemDecoration(3, Utils.dip2px(context, 2), false));

            final List<RoomExamResponse.DataBean.ListBean.ProjectsBean> projects = list.get(getAdapterPosition()).getProjects();
            if (projects != null && projects.size() > 0) {
                mRecycler.setVisibility(View.VISIBLE);
                ImageAdapter mAdapter = new ImageAdapter(context, projects);
                mRecycler.setAdapter(mAdapter);
                mAdapter.setOnItemClickListener(new ImageAdapter.OnItemClickListener() {
                    @Override
                    public void onClick(int position) {
                        ArrayList<PicEntity> picEntities = new ArrayList<>();
                        for (int i = 0 ; i < projects.size(); i++) {
                            PicEntity entity = new PicEntity();
                            entity.setUrl(projects.get(i).getPhoto());
                            entity.setNetwork(true);
                            picEntities.add(entity);
                        }
                        context.startActivity(new Intent(context, BigImageActivity.class).putExtra("picEntity", picEntities));
                    }
                });

            }else {
                mRecycler.setVisibility(View.GONE);
            }
        }
    }
}
