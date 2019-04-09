package com.seatrend.exam.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;

import com.seatrend.exam.R;
import com.seatrend.exam.response.SelectVehicleResponse;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SelectVehicleAdapter extends RecyclerView.Adapter<SelectVehicleAdapter.ViewHolder> {

    private Context context;
    private List<SelectVehicleResponse.DataBean> data;
    private String isComplete;

    public SelectVehicleAdapter(Context context, List<SelectVehicleResponse.DataBean> data, String isComplete) {
        this.context = context;
        this.data = data;
        this.isComplete = isComplete;
    }

    public void refresh(List<SelectVehicleResponse.DataBean> data) {
        this.data.addAll(data);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_select_vehicle, parent, false);
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

        @BindView(R.id.m_cb_vehicle)
        CheckBox mCbVehicle;

        ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }

        public void init() {
            SelectVehicleResponse.DataBean dataBean = data.get(getAdapterPosition());
            mCbVehicle.setText(dataBean.getName() + "(" + (TextUtils.isEmpty(dataBean.getNumber()) ? "无" : dataBean.getNumber()) + ")");

            mCbVehicle.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                    onListener.onClick(getAdapterPosition(), data.get(getAdapterPosition()), mCbVehicle.isChecked());
                }
            });

            mCbVehicle.setChecked(dataBean.isChecked());

            if ("1".equals(isComplete)) {
                mCbVehicle.setEnabled(false);
            }else {
                mCbVehicle.setEnabled(true);
            }
        }
    }

    public OnItemClickListener onListener;

    public interface OnItemClickListener {
        void onClick(int position, SelectVehicleResponse.DataBean dataBean, boolean isChecked);
    }

    public void setOnItemClickListener(OnItemClickListener onListener) {
        this.onListener = onListener;
    }

}
