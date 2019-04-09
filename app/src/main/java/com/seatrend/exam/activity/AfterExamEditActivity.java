package com.seatrend.exam.activity;

import android.Manifest;
import android.content.ContentValues;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v4.content.ContextCompat;
import android.text.TextUtils;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.Spinner;

import com.bumptech.glide.Glide;
import com.google.gson.JsonSyntaxException;
import com.seatrend.exam.R;
import com.seatrend.exam.common.Constants;
import com.seatrend.exam.entity.ExamAfterResultEntity;
import com.seatrend.exam.entity.PicEntity;
import com.seatrend.exam.network.NetworkService;
import com.seatrend.exam.presenter.GetPresenter;
import com.seatrend.exam.presenter.JsonTypePresenter;
import com.seatrend.exam.presenter.UploadImagePresenter;
import com.seatrend.exam.response.BaseResponse;
import com.seatrend.exam.response.CommonResponse;
import com.seatrend.exam.response.RoomExamResponse;
import com.seatrend.exam.response.UploadImageResponse;
import com.seatrend.exam.utils.Utils;
import com.seatrend.exam.view.GetView;
import com.seatrend.exam.view.JsonView;
import com.seatrend.exam.view.UploadImageView;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import butterknife.BindView;
import butterknife.OnClick;

import static com.seatrend.exam.adapter.BeforeExamEditAdapter.PHOTO_REQUEST_CAMERA;

public class AfterExamEditActivity extends BaseActivity implements GetView, JsonView, UploadImageView {

    @BindView(R.id.m_rb_monitor_normal)
    RadioButton mRbMonitorNormal;
    @BindView(R.id.m_rb_monitor_abnormal)
    RadioButton mRbMonitorAbnormal;
    @BindView(R.id.m_iv_monitor_photo)
    ImageView mIvMonitorPhoto;
    @BindView(R.id.m_iv_delete)
    ImageView mIvDelete;
    @BindView(R.id.m_ll_success)
    LinearLayout mLlSuccess;
    @BindView(R.id.m_ll_uploading)
    LinearLayout mLlUploading;
    @BindView(R.id.m_ll_failed)
    LinearLayout mLlFailed;
    @BindView(R.id.m_et_exam_num)
    EditText mEtExamNum;
    @BindView(R.id.m_et_qualified_num)
    EditText mEtQualifiedNum;
    @BindView(R.id.m_et_pass_rate)
    EditText mEtPassRate;
    @BindView(R.id.m_sp_exam_charge)
    Spinner mSpExamCharge;
    @BindView(R.id.m_et_exam_detail)
    EditText mEtExamDetail;
    @BindView(R.id.m_rb_exception_no)
    RadioButton mRbExceptionNo;
    @BindView(R.id.m_rb_exception_yes)
    RadioButton mRbExceptionYes;
    @BindView(R.id.m_sp_check)
    Spinner mSpCheck;
    @BindView(R.id.m_et_check_detail)
    EditText mEtCheckDetail;
    @BindView(R.id.m_rb_situation_no)
    RadioButton mRbSituationNo;
    @BindView(R.id.m_rb_situation_yes)
    RadioButton mRbSituationYes;
    @BindView(R.id.m_et_situation_detail)
    EditText mEtSituationDetail;
    @BindView(R.id.m_rb_fault_equipment_no)
    RadioButton mRbFaultEquipmentNo;
    @BindView(R.id.m_rb_fault_equipment_yes)
    RadioButton mRbFaultEquipmentYes;
    @BindView(R.id.m_et_fault_equipment_detail)
    EditText mEtFaultEquipmentDetail;
    @BindView(R.id.m_sp_video)
    Spinner mSpVideo;
    @BindView(R.id.m_rb_video_normal)
    RadioButton mRbVideoNormal;
    @BindView(R.id.m_rb_video_abnormal)
    RadioButton mRbVideoAbnormal;
    @BindView(R.id.m_et_remark)
    EditText mEtRemark;

    private GetPresenter presenter;
    private JsonTypePresenter jsonPresenter;
    private RoomExamResponse.DataBean.ListBean.ProjectBean project;
    private RoomExamResponse.DataBean.ListBean listBean;
    private int situation;
    private int faultEquipment;
    private int monitor;
    private int exception;
    private int video;

    private Uri imageUri;
    private File tempFile;
    private UploadImagePresenter imagePresenter;
    private String photo;
    private ArrayAdapter adapter;

    @Override
    public int getLayout() {
        return R.layout.activity_after_exam_edit;
    }

    @Override
    public void initView(Bundle savedInstanceState) {
        setTitle("考后检查");
        setButton("保存");
        presenter = new GetPresenter(this);
        imagePresenter = new UploadImagePresenter(this);
        jsonPresenter = new JsonTypePresenter(this);

        String isComplete = intent.getStringExtra("isComplete");
        if ("1".equals(isComplete)) {
            setEnabled();
        }

        ArrayList<String> list = new ArrayList<>();
        list.add(Constants.xm);

        adapter = new ArrayAdapter<>(this, R.layout.spinner_textview, list);
        adapter.setDropDownViewResource(R.layout.spinner_checked_textview);
        mSpCheck.setAdapter(adapter);
        mSpExamCharge.setAdapter(adapter);
        mSpVideo.setAdapter(adapter);

        getData();
    }

    private void getData() {
        mLoading.show();
        Map<String, String> map = new HashMap<>();
        map.put("checktime", Constants.ksrq);
        map.put("checktype", "3");
        map.put("checkerId", Constants.sfzmhm);
        map.put("curPage", "1");
        map.put("pageSize", "10");

        presenter.doNetworkTask(map, Constants.EXAM_CHECK_PAGES);
    }

    @Override
    public int setBarColor() {
        return R.color.blue;
    }

    @Override
    public void getSuccess(BaseResponse response) {
        try {
            mLoading.dismiss();
            RoomExamResponse examEntity = gson.fromJson(response.getResponseString(), RoomExamResponse.class);
            List<RoomExamResponse.DataBean.ListBean> list = examEntity.getData().getList();
            if (list != null && list.size() > 0) {
                listBean = list.get(0);
                project = list.get(0).getProject();

                setViewData();

            } else {
                showEmpty();
            }
        } catch (JsonSyntaxException e) {
            showErrorDialog("JsonSyntaxException  " + e.getMessage());
        }
    }

    @Override
    public void getFailed(BaseResponse response) {
        mLoading.dismiss();
        showErrorDialog(response.getResponseString());
    }

    @Override
    public void jsonSuccess(BaseResponse response) {
        try {
            mLoading.dismiss();
            CommonResponse mResponse = gson.fromJson(response.getResponseString(), CommonResponse.class);
            showToast(mResponse.getMessage());
            if (mResponse.getCode() == 0) {
                finish();
            }

        } catch (JsonSyntaxException e) {
            showErrorDialog("JsonSyntaxException  " + e.getMessage());
        }
    }

    @Override
    public void jsonFailed(BaseResponse response) {
        mLoading.dismiss();
        showErrorDialog(response.getResponseString());
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            if (requestCode == PHOTO_REQUEST_CAMERA) {
                uploading();
            }
        }
    }

    private void setViewData() {
        //考试监管平台
        if ("0".equals(project.getMonitorsituationResult())) {
            mRbMonitorNormal.setChecked(true);

        } else {
            mRbMonitorAbnormal.setChecked(true);
        }

        photo = project.getMonitorsituationPhoto();

        if (photo != null) {
            Glide.with(this).load(NetworkService.httpUrl + Constants.DOWNLOAD_FILE_BY_ID + "?fileId=" + photo).error(R.mipmap.upload_img).into(mIvMonitorPhoto);
            mIvDelete.setVisibility(View.VISIBLE);

        }

        //数据统计
        mEtExamNum.setText(project.getExamnumber());
        mEtQualifiedNum.setText(project.getQualifiednumber());
        mEtPassRate.setText(project.getQualifiedrate());

        //数据复核
        Utils.setSpinnerValue(mSpExamCharge, project.getExamdataPerson());
        mEtExamDetail.setText(project.getExamdata());

        //异常数据
        if ("0".equals(project.getUnusualdataResult())) {
            mRbExceptionNo.setChecked(true);

        } else {
            mRbExceptionYes.setChecked(true);

        }

        //考前设备
        mEtCheckDetail.setText(project.getBeforeexamcheck());

        //突发情况
        if ("0".equals(project.getEmergenciesResult())) {
            mRbSituationNo.setChecked(true);

        } else {
            mRbSituationYes.setChecked(true);
        }
        mEtSituationDetail.setText(project.getEmergencies());

        //故障设备
        if ("0".equals(project.getFaultequipmentResult())) {
            mRbFaultEquipmentNo.setChecked(true);

        } else {
            mRbFaultEquipmentYes.setChecked(true);

        }
        mEtFaultEquipmentDetail.setText(project.getFaultequipment());

        //考试录像
        if ("0".equals(project.getVideosavedResult())) {
            mRbVideoNormal.setChecked(true);

        } else {
            mRbVideoAbnormal.setChecked(true);
        }
        Utils.setSpinnerValue(mSpVideo, project.getVideosavedPerson());

        //其他
        mEtRemark.setText(project.getRemark());

    }

    @OnClick({R.id.m_iv_monitor_photo, R.id.m_iv_delete, R.id.m_button, R.id.m_btn_re_upload})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.m_iv_monitor_photo:
                if (photo != null) {
                    ArrayList<PicEntity> picEntities = new ArrayList<>();
                    PicEntity entity = new PicEntity();
                    entity.setUrl(photo);
                    entity.setNetwork(true);
                    picEntities.add(entity);
                    startActivity(new Intent(AfterExamEditActivity.this, BigImageActivity.class).putExtra("picEntity", picEntities));

                } else {
                    openCamera();
                }
                break;

            case R.id.m_iv_delete:
                imageUri = null;
                photo = null;
                Glide.with(this).load(R.mipmap.upload_img).into(mIvMonitorPhoto);
                mIvMonitorPhoto.setEnabled(true);
                mIvDelete.setVisibility(View.GONE);
                mLlUploading.setVisibility(View.GONE);
                mLlFailed.setVisibility(View.GONE);
                mLlSuccess.setVisibility(View.GONE);
                break;

            case R.id.m_btn_re_upload:
                uploading();
                break;

            case R.id.m_button:
                if (TextUtils.isEmpty(photo)) {
                    showToast("请先上传照片");
                    return;
                }

                if (mRbSituationNo.isChecked()) {
                    situation = 0;
                }

                if (mRbSituationYes.isChecked()) {
                    situation = 1;
                }

                if (mRbFaultEquipmentNo.isChecked()) {
                    faultEquipment = 0;
                }

                if (mRbFaultEquipmentYes.isChecked()) {
                    faultEquipment = 1;
                }

                if (mRbMonitorNormal.isChecked()) {
                    monitor = 0;
                }

                if (mRbMonitorAbnormal.isChecked()) {
                    monitor = 1;
                }

                if (mRbExceptionNo.isChecked()) {
                    exception = 0;
                }

                if (mRbExceptionYes.isChecked()) {
                    exception = 1;
                }

                if (mRbVideoNormal.isChecked()) {
                    video = 0;
                }

                if (mRbVideoAbnormal.isChecked()) {
                    video = 1;
                }

                ExamAfterResultEntity mEntity = new ExamAfterResultEntity();
                mEntity.setCheckerId(Constants.sfzmhm);
                mEntity.setChecker(Constants.xm);
                mEntity.setCheckstate(listBean.getCheckstate());
                mEntity.setExamsubject(listBean.getExamsubject());
                mEntity.setId(listBean.getId());
                mEntity.setChecktype(listBean.getChecktype());
                mEntity.setCheckstate(listBean.getCheckstate());

                ExamAfterResultEntity.ProjectBean projectBean = new ExamAfterResultEntity.ProjectBean();
                projectBean.setBeforeexamcheck(mEtCheckDetail.getText().toString().trim());
                projectBean.setEmergenciesResult(String.valueOf(situation));
                projectBean.setEmergencies(mEtSituationDetail.getText().toString().trim());
                projectBean.setExamdata(mEtExamDetail.getText().toString().trim());
                projectBean.setExamdataPerson(mSpExamCharge.getSelectedItem().toString());
                projectBean.setExamnumber(mEtExamNum.getText().toString().trim());
                projectBean.setQualifiednumber(mEtQualifiedNum.getText().toString());
                projectBean.setQualifiedrate(mEtPassRate.getText().toString());
                projectBean.setFaultequipment(mEtFaultEquipmentDetail.getText().toString());
                projectBean.setFaultequipmentResult(String.valueOf(faultEquipment));
                projectBean.setId(listBean.getId());
                projectBean.setMonitorsituationResult(String.valueOf(monitor));
                projectBean.setMonitorsituationPhoto(photo);
                projectBean.setRemark(mEtRemark.getText().toString());
                projectBean.setUnusualdataResult(String.valueOf(exception));
                projectBean.setVideosavedResult(String.valueOf(video));
                projectBean.setVideosavedPerson(mSpVideo.getSelectedItem().toString());
                mEntity.setProject(projectBean);

                String jsonParameter = gson.toJson(mEntity);

                mLoading.show();
                jsonPresenter.doNetWorkTaskJson(jsonParameter, Constants.INSERT_AFTER);
                break;
        }
    }

    public void openCamera() {
        // 激活相机
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        // 判断存储卡是否可以用，可用进行存储
        if (Utils.hasSdcard()) {
            SimpleDateFormat timeStampFormat = new SimpleDateFormat("" + System.currentTimeMillis(), Locale.CHINA);
            String filename = timeStampFormat.format(new Date());
            tempFile = new File(Environment.getExternalStorageDirectory(), filename + ".jpg");
            if (android.os.Build.VERSION.SDK_INT < Build.VERSION_CODES.N) {
                // 从文件中创建uri
                imageUri = Uri.fromFile(tempFile);
                intent.putExtra(MediaStore.EXTRA_OUTPUT, imageUri);
            } else {
                //兼容android7.0 使用共享文件的形式
                ContentValues contentValues = new ContentValues(1);
                contentValues.put(MediaStore.Images.Media.DATA, tempFile.getAbsolutePath());
                //检查是否有存储权限，以免崩溃
                if (ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
                    //申请WRITE_EXTERNAL_STORAGE权限
                    Utils.showToast(this, "请开启存储权限");
                    return;
                }
                imageUri = getContentResolver().insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, contentValues);
                intent.putExtra(MediaStore.EXTRA_OUTPUT, imageUri);
            }
        }
        startActivityForResult(intent, PHOTO_REQUEST_CAMERA);
    }

    private void uploading() {
        //上传照片
        if (imageUri != null) {
            imagePresenter.uploadFile(Constants.UPLOAD_IMAGE, Utils.uriToFile(imageUri, this), "35");
            mLlUploading.setVisibility(View.VISIBLE);
            mLlFailed.setVisibility(View.GONE);
            mLlSuccess.setVisibility(View.GONE);
        }
    }

    @Override
    public void uploadImageSuccess(BaseResponse response) {
        try {
            mLlUploading.setVisibility(View.GONE);
            mLlFailed.setVisibility(View.GONE);
            mLlSuccess.setVisibility(View.VISIBLE);
            mIvDelete.setVisibility(View.VISIBLE);

            UploadImageResponse entity = gson.fromJson(response.getResponseString(), UploadImageResponse.class);
            mIvMonitorPhoto.setImageURI(imageUri);
            photo = entity.getData();

        } catch (JsonSyntaxException e) {
            e.printStackTrace();
            showErrorDialog("JsonSyntaxException  " + e.getMessage());
        }
    }

    @Override
    public void uploadImageFailed(BaseResponse response) {
        mLlUploading.setVisibility(View.GONE);
        mLlFailed.setVisibility(View.VISIBLE);
        mLlSuccess.setVisibility(View.GONE);
    }


    private void setEnabled() {
        mRbMonitorNormal.setEnabled(false);
        mRbMonitorAbnormal.setEnabled(false);
        mIvMonitorPhoto.setEnabled(false);
        mIvDelete.setEnabled(false);
        mEtExamNum.setEnabled(false);
        mEtQualifiedNum.setEnabled(false);
        mEtPassRate.setEnabled(false);
        mSpExamCharge.setEnabled(false);
        mEtExamDetail.setEnabled(false);
        mRbExceptionNo.setEnabled(false);
        mRbExceptionYes.setEnabled(false);
        mSpCheck.setEnabled(false);
        mEtCheckDetail.setEnabled(false);
        mRbSituationNo.setEnabled(false);
        mRbSituationYes.setEnabled(false);
        mEtSituationDetail.setEnabled(false);
        mRbFaultEquipmentNo.setEnabled(false);
        mRbFaultEquipmentYes.setEnabled(false);
        mEtFaultEquipmentDetail.setEnabled(false);
        mSpVideo.setEnabled(false);
        mRbVideoNormal.setEnabled(false);
        mRbVideoAbnormal.setEnabled(false);
        mEtRemark.setEnabled(false);
    }
}
