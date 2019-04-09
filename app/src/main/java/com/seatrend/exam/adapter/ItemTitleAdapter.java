package com.seatrend.exam.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.seatrend.exam.R;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ItemTitleAdapter extends RecyclerView.Adapter<ItemTitleAdapter.ViewHolder> {
    private Context context;
    private ArrayList<String> list;

    private int thisPosition;

    public int getThisPosition() {
        return thisPosition;
    }

    public void setThisPosition(int thisPosition) {
        this.thisPosition = thisPosition;

        notifyDataSetChanged();
    }

    public void refresh(ArrayList<String> list){
        this.list = list;
        notifyDataSetChanged();
    }

    public ItemTitleAdapter(Context context, ArrayList<String> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_title, parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.mText.setText(list.get(position));
        holder.mBg.setBackgroundColor(context.getResources().getColor(R.color.blue));

        if (position == getThisPosition()) {
            holder.mText.setTextColor(context.getResources().getColor(R.color.blue));
            holder.mBg.setBackgroundColor(context.getResources().getColor(R.color.blue));

        } else {
            holder.mText.setTextColor(context.getResources().getColor(R.color.dark_gray));
            holder.mBg.setBackgroundColor(context.getResources().getColor(R.color.light_gray));
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        @BindView(R.id.m_tv_text)
        TextView mText;
        @BindView(R.id.m_bg)
        TextView mBg;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onClick(getAdapterPosition());
                }
            });
        }
    }

    public OnItemClickListener listener;

    public interface OnItemClickListener{
        void onClick(int position);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.listener = listener;
    }

}
