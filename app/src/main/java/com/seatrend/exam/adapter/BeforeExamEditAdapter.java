package com.seatrend.exam.adapter;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.seatrend.exam.R;
import com.seatrend.exam.activity.BigImageActivity;
import com.seatrend.exam.common.Constants;
import com.seatrend.exam.common.view.SpacingItemDecoration;
import com.seatrend.exam.entity.PicEntity;
import com.seatrend.exam.network.NetworkService;
import com.seatrend.exam.response.RoomExamResponse;
import com.seatrend.exam.response.SelectVehicleResponse;
import com.seatrend.exam.utils.Utils;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 考前检查
 */
public class BeforeExamEditAdapter extends RecyclerView.Adapter<BeforeExamEditAdapter.ViewHolder> {

    public static final int PHOTO_REQUEST_CAMERA = 10;

    private Context context;
    private List<RoomExamResponse.DataBean.ListBean.ProjectsBean> list;
    private String isComplete;
    private List<SelectVehicleResponse.DataBean> data;

    public BeforeExamEditAdapter(Context context, List<RoomExamResponse.DataBean.ListBean.ProjectsBean> list, String isComplete, List<SelectVehicleResponse.DataBean> data) {
        this.context = context;
        this.list = list;
        this.isComplete = isComplete;
        this.data = data;

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_before_exam_edit, parent, false);
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

    public void refreshImage(List<RoomExamResponse.DataBean.ListBean.ProjectsBean> list, int position) {
        this.list = list;
        notifyItemChanged(position);
    }

    public void refresh(List<RoomExamResponse.DataBean.ListBean.ProjectsBean> list) {
        this.list = list;
        notifyDataSetChanged();
    }

    public void refreshVehicle(List<SelectVehicleResponse.DataBean> data) {
        this.data = data;
        notifyDataSetChanged();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.m_tv_title)
        TextView mTvTitle;
        @BindView(R.id.m_rb_normal)
        RadioButton mRbNormal;
        @BindView(R.id.m_rb_abnormal)
        RadioButton mRbAbnormal;
        @BindView(R.id.m_radio_group)
        RadioGroup mRadioGroup;
        @BindView(R.id.m_iv_upload_img)
        ImageView mIvUploadImg;
        @BindView(R.id.m_iv_delete)
        ImageView mIvDelete;
        @BindView(R.id.m_ll_success)
        LinearLayout mLlSuccess;
        @BindView(R.id.m_ll_uploading)
        LinearLayout mLlUploading;
        @BindView(R.id.m_btn_re_upload)
        Button mBtnReUpload;
        @BindView(R.id.m_ll_failed)
        LinearLayout mLlFailed;
        @BindView(R.id.m_et_exception)
        EditText mEtException;
        @BindView(R.id.m_tv_text_num)
        TextView mTvTextNum;
        @BindView(R.id.m_tv_save)
        TextView mTvSave;
        @BindView(R.id.m_ll_exception_deal)
        LinearLayout mLlExceptionDeal;
        @BindView(R.id.m_ll_top)
        LinearLayout mLlTop;
        @BindView(R.id.m_recycler_vehicle)
        RecyclerView mRecyclerVehicle;

        ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }

        public void init() {
            final RoomExamResponse.DataBean.ListBean.ProjectsBean projectsBean = list.get(getAdapterPosition());

            mTvTitle.setText(projectsBean.getResultOrder() + "." + projectsBean.getCheckpoint());

            if (projectsBean.getPhoto() != null) {
                Glide.with(context).load(NetworkService.httpUrl + Constants.DOWNLOAD_FILE_BY_ID + "?fileId=" + projectsBean.getPhoto()).error(R.color.light_gray).centerCrop().into(mIvUploadImg);

                mIvDelete.setVisibility(View.VISIBLE);
                mIvUploadImg.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        ArrayList<PicEntity> picEntities = new ArrayList<>();
                        PicEntity entity = new PicEntity();
                        entity.setUrl(projectsBean.getPhoto());
                        entity.setNetwork(true);
                        picEntities.add(entity);

                        context.startActivity(new Intent(context, BigImageActivity.class).putExtra("picEntity", picEntities));
                    }
                });

            } else {
                mIvDelete.setVisibility(View.GONE);

                Glide.with(context).load(R.mipmap.upload_img).into(mIvUploadImg);
                mIvUploadImg.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        //上传照片
                        listener.onClick(getAdapterPosition(), projectsBean.getListId());
                    }
                });

                mLlUploading.setVisibility(View.GONE);
                mLlFailed.setVisibility(View.GONE);
                mLlSuccess.setVisibility(View.GONE);
            }

            if (projectsBean.getUploadImageStatus() == 1) {
                mLlUploading.setVisibility(View.VISIBLE);
                mLlFailed.setVisibility(View.GONE);
                mLlSuccess.setVisibility(View.GONE);

            } else if (projectsBean.getUploadImageStatus() == 2) {
                mLlUploading.setVisibility(View.GONE);
                mLlFailed.setVisibility(View.VISIBLE);
                mLlSuccess.setVisibility(View.GONE);

            } else if (projectsBean.getUploadImageStatus() == 3) {
                mLlUploading.setVisibility(View.GONE);
                mLlFailed.setVisibility(View.GONE);
                mLlSuccess.setVisibility(View.VISIBLE);

            } else {
                mLlUploading.setVisibility(View.GONE);
                mLlFailed.setVisibility(View.GONE);
                mLlSuccess.setVisibility(View.GONE);
            }

            mBtnReUpload.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    reUploadListener.onClick(getAdapterPosition(), projectsBean.getListId());
                }
            });

            mIvDelete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    imageDeleteListener.onClick(getAdapterPosition(), projectsBean.getListId());

                }
            });

            mRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(RadioGroup radioGroup, int i) {
                    switch (i) {
                        case R.id.m_rb_normal:
                            mLlExceptionDeal.setVisibility(View.GONE);
                            projectsBean.setResult("0");
                            projectsBean.setRemark("");
                            break;

                        case R.id.m_rb_abnormal:
                            projectsBean.setResult("1");
                            mLlExceptionDeal.setVisibility(View.VISIBLE);
                            break;
                    }
                }
            });

            if ("0".equals(projectsBean.getResult())) {
                mRbNormal.setChecked(true);
            } else {
                mRbAbnormal.setChecked(true);
            }

            if (!TextUtils.isEmpty(projectsBean.getRemark())) {
                mEtException.setText(projectsBean.getRemark());
                mTvTextNum.setText(String.valueOf(50 - projectsBean.getRemark().length()));
            } else {
                mEtException.setText("");
                mTvTextNum.setText(String.valueOf(50));
            }

            mEtException.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                }

                @Override
                public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                    String string = mEtException.getText().toString().trim();
                    mTvTextNum.setText(String.valueOf(50 - string.length()));

                    if (!TextUtils.isEmpty(string) && string.length() > 0) {
                        mTvSave.setVisibility(View.VISIBLE);
                    }
                }

                @Override
                public void afterTextChanged(Editable editable) {

                }
            });

            mTvSave.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String string = mEtException.getText().toString().trim();
                    exceptionListener.onClick(getAdapterPosition(), projectsBean.getListId(), string);
                    mTvSave.setVisibility(View.GONE);
                }
            });

            if ("1".equals(isComplete)) {
                mRbNormal.setEnabled(false);
                mRbAbnormal.setEnabled(false);
                mIvUploadImg.setEnabled(false);
                mEtException.setEnabled(false);
                mIvDelete.setVisibility(View.GONE);
                mTvSave.setVisibility(View.GONE);

            } else {
                mRbNormal.setEnabled(true);
                mRbAbnormal.setEnabled(true);
                mIvUploadImg.setEnabled(true);
                mEtException.setEnabled(true);
            }


            if ("今日考试车辆".equals(projectsBean.getCheckpoint())) {
                mRecyclerVehicle.setVisibility(View.VISIBLE);
                mLlTop.setVisibility(View.GONE);

                String remark = projectsBean.getRemark();
                if (remark != null) {
                    String[] split = remark.split(",");
                    for (int i = 0; i < split.length; i ++) {
                        for (int j = 0 ; j < data.size(); j ++) {
                            if (split[i].equals(data.get(j).getName())){
                                data.get(j).setChecked(true);
                            }
                        }
                    }
                }

                //给recyclerView设置manager
                mRecyclerVehicle.setNestedScrollingEnabled(false);
                mRecyclerVehicle.setLayoutManager(new GridLayoutManager(context, 3));
                mRecyclerVehicle.addItemDecoration(new SpacingItemDecoration(3, Utils.dip2px(context, 2), false));
                SelectVehicleAdapter selectVehicleAdapter = new SelectVehicleAdapter(context, data, isComplete);
                mRecyclerVehicle.setAdapter(selectVehicleAdapter);

                selectVehicleAdapter.setOnItemClickListener(new SelectVehicleAdapter.OnItemClickListener() {
                    @Override
                    public void onClick(int position, SelectVehicleResponse.DataBean dataBean, boolean isChecked) {
                        vehicleSelectListener.onClick(position, dataBean, isChecked, getAdapterPosition(), projectsBean.getListId());
                    }
                });

            }else {
                mRecyclerVehicle.setVisibility(View.GONE);
                mLlTop.setVisibility(View.VISIBLE);
            }
        }
    }

    public OnUploadImageListener listener;

    public interface OnUploadImageListener {
        void onClick(int position, int id);
    }

    public void setOnUploadImageListener(OnUploadImageListener listener) {
        this.listener = listener;
    }

    public OnReUploadImageListener reUploadListener;

    public interface OnReUploadImageListener {
        void onClick(int position, int id);
    }

    public void setOnReUploadImageListener(OnReUploadImageListener reUploadListener) {
        this.reUploadListener = reUploadListener;
    }

    public OnExceptionListener exceptionListener;

    public interface OnExceptionListener {
        void onClick(int position, int id, String text);
    }

    public void setOnExceptionListener(OnExceptionListener exceptionListener) {
        this.exceptionListener = exceptionListener;
    }

    public OnImageDeleteListener imageDeleteListener;

    public interface OnImageDeleteListener {
        void onClick(int position, int id);
    }

    public void setOnImageDeleteListener(OnImageDeleteListener imageDeleteListener) {
        this.imageDeleteListener = imageDeleteListener;
    }

    public OnVehicleSelectListener vehicleSelectListener;

    public interface OnVehicleSelectListener {
        void onClick(int position, SelectVehicleResponse.DataBean dataBean, boolean isChecked, int basePosition, int id);
    }

    public void setOnVehicleSelectListener(OnVehicleSelectListener vehicleSelectListener) {
        this.vehicleSelectListener = vehicleSelectListener;
    }

}
