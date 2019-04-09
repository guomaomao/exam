package com.seatrend.exam.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.seatrend.exam.R;
import com.seatrend.exam.entity.SuperviseEntity;
import com.seatrend.exam.response.CatalogueResponse;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SuperviseAdapter extends RecyclerView.Adapter<SuperviseAdapter.ViewHolder> {

    private Context context;
    private List<CatalogueResponse.DataBean.Catalogue2Bean> list;

    public SuperviseAdapter(Context context, List<CatalogueResponse.DataBean.Catalogue2Bean> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_supervise, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        CatalogueResponse.DataBean.Catalogue2Bean catalogue2Bean = list.get(holder.getAdapterPosition());
        holder.mText.setText(catalogue2Bean.getName());
        if ("考前准备".equals(catalogue2Bean.getName())){
            holder.mImage.setImageResource(R.mipmap.kqzb);

        }else if ("考场检查".equals(catalogue2Bean.getName())) {
            holder.mImage.setImageResource(R.mipmap.kcjc);

        }else if ("远程巡考".equals(catalogue2Bean.getName())) {
            holder.mImage.setImageResource(R.mipmap.ycxk);

        }else if ("考生回访".equals(catalogue2Bean.getName())) {
            holder.mImage.setImageResource(R.mipmap.hfks);

        }else if ("工作报告".equals(catalogue2Bean.getName())) {
            holder.mImage.setImageResource(R.mipmap.gzbg);

        }else {
            holder.mImage.setImageResource(R.mipmap.avatar);
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.m_image)
        ImageView mImage;
        @BindView(R.id.m_text)
        TextView mText;

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

    public OnClickListener listener;

    public interface OnClickListener{
        void onClick(int position);
    }

    public void setOnClickListener(OnClickListener listener) {
        this.listener = listener;
    }

}
