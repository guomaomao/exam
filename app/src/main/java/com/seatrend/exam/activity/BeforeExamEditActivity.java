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
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;

import com.google.gson.JsonSyntaxException;
import com.seatrend.exam.R;
import com.seatrend.exam.adapter.BeforeExamEditAdapter;
import com.seatrend.exam.adapter.ItemTitleAdapter;
import com.seatrend.exam.common.Constants;
import com.seatrend.exam.entity.BeforeExamEditRequest;
import com.seatrend.exam.presenter.GetPresenter;
import com.seatrend.exam.presenter.JsonTypePresenter;
import com.seatrend.exam.presenter.UploadImagePresenter;
import com.seatrend.exam.response.BaseResponse;
import com.seatrend.exam.response.CommonResponse;
import com.seatrend.exam.response.RoomExamResponse;
import com.seatrend.exam.response.SelectVehicleResponse;
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

public class BeforeExamEditActivity extends BaseActivity implements UploadImageView, GetView, JsonView {

    @BindView(R.id.m_recycler_title)
    RecyclerView mRecyclerTitle;
    @BindView(R.id.m_recycler)
    RecyclerView mRecycler;

    private Uri imageUri;
    private File tempFile;

    private UploadImagePresenter imagePresenter;
    private GetPresenter getPresenter;
    private String checktype;
    private BeforeExamEditAdapter adapter;
    private List<RoomExamResponse.DataBean.ListBean.ProjectsBean> projects;
    private ItemTitleAdapter mTitleAdapter;
    private ArrayList<String> titleList = new ArrayList<>();
    private RoomExamResponse.DataBean.ListBean listBean;

    private List<RoomExamResponse.DataBean.ListBean.ProjectsBean> newProjects = new ArrayList<>();
    private int titlePosition;
    private int clickPosition;
    private String type;
    private int mId;
    private JsonTypePresenter jsonPresenter;
    private String isComplete;
    private List<SelectVehicleResponse.DataBean> data = new ArrayList<>();

    @Override
    public int getLayout() {
        return R.layout.activity_before_exam_edit;
    }

    @Override
    public void initView(Bundle savedInstanceState) {
        setButton("保存");
        getPresenter = new GetPresenter(this);
        imagePresenter = new UploadImagePresenter(this);
        jsonPresenter = new JsonTypePresenter(this);

        isComplete = intent.getStringExtra("isComplete");
        type = intent.getStringExtra("type");
        if ("before".equals(type)) {
            setTitle("考前检查");
            checktype = "1";

        } else if ("between".equals(type)) {
            setTitle("考中检查");
            mRecyclerTitle.setVisibility(View.GONE);
            checktype = "2";

        }

        if ("1".equals(isComplete)) {
            mButton.setVisibility(View.GONE);
        }

        mRecyclerTitle.setNestedScrollingEnabled(false);
        LinearLayoutManager manager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false) {
            @Override
            public boolean canScrollVertically() {
                return false;
            }
        };
        mRecyclerTitle.setLayoutManager(manager);

        mTitleAdapter = new ItemTitleAdapter(this, titleList);
        mRecyclerTitle.setAdapter(mTitleAdapter);

        if (mTitleAdapter != null) {
            mTitleAdapter.setOnItemClickListener(new ItemTitleAdapter.OnItemClickListener() {
                @Override
                public void onClick(int position) {
                    titlePosition = position;

                    mTitleAdapter.setThisPosition(position);
                    newProjects.clear();
                    for (int i = 0; i < projects.size(); i++) {
                        if (titleList.get(position).equals(projects.get(i).getPointtype())) {
                            newProjects.add(projects.get(i));
                        }
                    }

                    if (adapter != null) {
                        adapter.refresh(newProjects);
                    }
                }
            });
        }

        mRecycler.setLayoutManager(new LinearLayoutManager(this));
        adapter = new BeforeExamEditAdapter(this, newProjects, isComplete, data);
        mRecycler.setAdapter(adapter);

        if (adapter != null) {
            adapter.setOnUploadImageListener(new BeforeExamEditAdapter.OnUploadImageListener() {
                @Override
                public void onClick(int position, int id) {
                    clickPosition = position;
                    mId = id;
                    openCamera();
                }
            });

            adapter.setOnReUploadImageListener(new BeforeExamEditAdapter.OnReUploadImageListener() {
                @Override
                public void onClick(int position, int id) {
                    clickPosition = position;
                    mId = id;
                    uploading();
                }
            });

            adapter.setOnExceptionListener(new BeforeExamEditAdapter.OnExceptionListener() {
                @Override
                public void onClick(int position, int id, String text) {
                    clickPosition = position;
                    mId = id;

                    newProjects.clear();
                    for (int i = 0; i < projects.size(); i++) {
                        if (projects.get(i).getListId() == mId) {
                            projects.get(i).setRemark(text);
                        }

                        if (titleList.get(titlePosition).equals(projects.get(i).getPointtype())) {
                            newProjects.add(projects.get(i));
                        }
                    }
                    adapter.refreshImage(newProjects, clickPosition);
                }
            });

            adapter.setOnImageDeleteListener(new BeforeExamEditAdapter.OnImageDeleteListener() {
                @Override
                public void onClick(int position, int id) {
                    clickPosition = position;
                    mId = id;

                    newProjects.clear();
                    for (int i = 0; i < projects.size(); i++) {
                        if (projects.get(i).getListId() == mId) {
                            projects.get(i).setPhoto(null);
                            projects.get(i).setUploadImageStatus(-1);
                        }
                        if (titleList.get(titlePosition).equals(projects.get(i).getPointtype())) {
                            newProjects.add(projects.get(i));
                        }
                    }
                    adapter.refreshImage(newProjects, clickPosition);
                }
            });

            adapter.setOnVehicleSelectListener(new BeforeExamEditAdapter.OnVehicleSelectListener() {
                @Override
                public void onClick(int position, SelectVehicleResponse.DataBean dataBean, boolean isChecked, int basePosition, int id) {
                    mId = id;
                    data.get(position).setChecked(isChecked);

                   if("今日考试车辆".equals(newProjects.get(basePosition).getCheckpoint())){
                       StringBuilder sb = new StringBuilder();

                       for (int i = 0; i < data.size(); i++) {
                           if (data.get(i).isChecked()) {
                               sb.append(data.get(i).getName()).append(",");
                           }
                       }

                       Log.i("成功", sb.toString());

                        newProjects.clear();
                        for (int i = 0; i < projects.size(); i++) {
                            if (projects.get(i).getListId() == mId) {
                                projects.get(i).setRemark(sb.toString());
                            }
                            if (titleList.get(titlePosition).equals(projects.get(i).getPointtype())) {
                                newProjects.add(projects.get(i));
                            }
                        }
                   }
                }
            });
        }

        HashMap<String, String> map = new HashMap<>();
        map.put("kcxh", Constants.kcxh);
        getPresenter.doNetworkTask(map, Constants.SELECT_VEHICLE_BY_KCXH);

    }

    private void getData() {
        mLoading.show();
        Map<String, String> map = new HashMap<>();
        map.put("checktime", Constants.ksrq);
        map.put("checktype", checktype);
        map.put("checkerId", Constants.sfzmhm);
        map.put("curPage", "1");
        map.put("pageSize", "10");

        getPresenter.doNetworkTask(map, Constants.EXAM_CHECK_PAGES);
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

    private void uploading() {
        //上传照片
        imagePresenter.uploadFile(Constants.UPLOAD_IMAGE, Utils.uriToFile(imageUri, BeforeExamEditActivity.this), "31");
        //正在上传
        if (adapter != null) {
            newProjects.clear();
            for (int i = 0; i < projects.size(); i++) {
                if (projects.get(i).getListId() == mId) {
                    projects.get(i).setUploadImageStatus(1);
                }
                if (titleList.get(titlePosition).equals(projects.get(i).getPointtype())) {
                    newProjects.add(projects.get(i));
                }
            }
            adapter.refreshImage(newProjects, clickPosition);
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

    @Override
    public int setBarColor() {
        return R.color.blue;
    }

    @OnClick(R.id.m_button)
    public void onViewClicked() {
        for (int i = 0; i < newProjects.size(); i++) {
            RoomExamResponse.DataBean.ListBean.ProjectsBean projectsBean = newProjects.get(i);
            if (!"今日考试车辆".equals(projectsBean.getCheckpoint())){
                if (projectsBean.getPhoto() == null) {
                    showToast("还有照片未上传");
                    return;
                }

                if (!"0".equals(projectsBean.getResult())) {
                    if (TextUtils.isEmpty(projectsBean.getRemark())) {
                        showToast("处置办法未填写");
                        return;
                    }
                }
            }
        }

        BeforeExamEditRequest mExamAfterResultEntity = new BeforeExamEditRequest();
        mExamAfterResultEntity.setCheckerId(Constants.sfzmhm);
        mExamAfterResultEntity.setChecker(Constants.xm);
        mExamAfterResultEntity.setCheckstate(listBean.getCheckstate());
        mExamAfterResultEntity.setExamsubject(listBean.getExamsubject());
        mExamAfterResultEntity.setId(listBean.getId());
        mExamAfterResultEntity.setChecktype(listBean.getChecktype());
        mExamAfterResultEntity.setCheckstate(listBean.getCheckstate());
        String s = gson.toJson(projects);


        Log.i("成功", s);

        List list = gson.fromJson(s, List.class);
        mExamAfterResultEntity.setProjects(list);
        String jsonParameter = gson.toJson(mExamAfterResultEntity);

        mLoading.show();
        jsonPresenter.doNetWorkTaskJson(jsonParameter, Constants.INSERT_AFTER);

    }

    @Override
    public void uploadImageSuccess(BaseResponse response) {
        try {
            UploadImageResponse entity = gson.fromJson(response.getResponseString(), UploadImageResponse.class);
            if (adapter != null) {
                newProjects.clear();
                for (int i = 0; i < projects.size(); i++) {
                    if (projects.get(i).getListId() == mId) {
                        projects.get(i).setPhoto(entity.getData());

                        if (entity.getCode() == 0) {
                            projects.get(i).setUploadImageStatus(3); //上传成功
                            projects.get(i).setPhoto(entity.getData());

                        } else {
                            projects.get(i).setUploadImageStatus(2); //上传失败
                        }
                    }
                    if (titleList.get(titlePosition).equals(projects.get(i).getPointtype())) {
                        newProjects.add(projects.get(i));
                    }
                }
                adapter.refreshImage(newProjects, clickPosition);
            }

        } catch (JsonSyntaxException e) {
            showErrorDialog("JsonSyntaxException  " + e.getMessage());
        }
    }

    @Override
    public void uploadImageFailed(BaseResponse response) {
        if (adapter != null) {
            newProjects.clear();
            for (int i = 0; i < projects.size(); i++) {
                if (projects.get(i).getListId() == mId) {
                    projects.get(i).setUploadImageStatus(2); //上传失败
                }
                if (titleList.get(titlePosition).equals(projects.get(i).getPointtype())) {
                    newProjects.add(projects.get(i));
                }
            }
            adapter.refreshImage(newProjects, clickPosition);
        }
    }

    @Override
    public void getSuccess(BaseResponse response) {
        try {
            if (Constants.SELECT_VEHICLE_BY_KCXH.equals(response.getUrl())) {
                SelectVehicleResponse vehicleResponse = gson.fromJson(response.getResponseString(), SelectVehicleResponse.class);
                if (vehicleResponse.getCode() == 0) {
                    data = vehicleResponse.getData();
                    adapter.refreshVehicle(data);

                    getData();

                }

            } else {
                mLoading.dismiss();
                RoomExamResponse examEntity = gson.fromJson(response.getResponseString(), RoomExamResponse.class);
                List<RoomExamResponse.DataBean.ListBean> list = examEntity.getData().getList();
                if (list != null && list.size() > 0) {
                    listBean = list.get(0);
                    projects = listBean.getProjects();
                    if (projects != null && projects.size() > 0) {
                        notShowEmpty();

                        for (int i = 0; i < projects.size(); i++) {
                            projects.get(i).setListId(i);
                            if (!titleList.contains(projects.get(i).getPointtype())) {
                                titleList.add(projects.get(i).getPointtype());
                            }
                        }
                        mTitleAdapter.refresh(titleList);

                        newProjects.clear();
                        for (int i = 0; i < projects.size(); i++) {
                            if (titleList.get(titlePosition).equals(projects.get(i).getPointtype())) {
                                newProjects.add(projects.get(i));
                            }
                        }
                        adapter.refresh(newProjects);

                    } else {
                        showEmpty();
                    }

                } else {
                    showEmpty();
                }
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
            titlePosition = titlePosition + 1;

            if (mResponse.getCode() == 0) {
                if (titlePosition == titleList.size()) {
                    finish();

                } else {
                    mTitleAdapter.setThisPosition(titlePosition);
                    newProjects.clear();

                    for (int i = 0; i < projects.size(); i++) {
                        if (titleList.get(titlePosition).equals(projects.get(i).getPointtype())) {
                            newProjects.add(projects.get(i));
                        }
                    }

                    if (adapter != null) {
                        adapter.refresh(newProjects);
                    }
                }
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
}
