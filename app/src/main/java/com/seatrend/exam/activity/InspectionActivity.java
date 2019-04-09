package com.seatrend.exam.activity;

import android.annotation.SuppressLint;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.View;
import android.view.WindowManager;
import android.widget.LinearLayout;

import com.hikvision.sdk.VMSNetSDK;
import com.hikvision.sdk.consts.SDKConstant;
import com.hikvision.sdk.net.business.OnVMSNetSDKBusiness;
import com.seatrend.exam.R;
import com.seatrend.exam.common.view.CustomSurfaceView;
import com.seatrend.exam.utils.Utils;

import java.lang.ref.WeakReference;

import butterknife.BindView;

public class InspectionActivity extends BaseActivity implements SurfaceHolder.Callback {

    @BindView(R.id.m_surface_view)
    CustomSurfaceView mSurfaceView;
    @BindView(R.id.m_ll_header)
    LinearLayout mLlHeader;
//    @BindView(R.id.m_ll_bottom)
//    LinearLayout mLlBottom;
//    @BindView(R.id.m_tv_point_record)
//    TextView mTvPointRecord;
//    @BindView(R.id.m_tv_choose)
//    TextView mTvChoose;

    private boolean isShowing = false;
//    private CameraSubjectTwoResponse.DataBean mSubjectTwoData;
//    private CameraSubjectOneResponse.DataBean mSubjectOneData;

    /**
     * 获取监控点信息成功
     */
    private static final int GET_CAMERA_INFO_SUCCESS = 1;
    /**
     * 获取监控点信息失败
     */
    private static final int GET_CAMERA_INFO_FAILURE = 2;
    /**
     * 播放窗口1
     */
    private int PLAY_WINDOW_ONE = 1;

    /**
     * 码流类型
     */
    private int mStreamType = SDKConstant.LiveSDKConstant.MAIN_HIGH_STREAM;

    private MyHandler mHandler;
//    private String kskm;
//    private List<KTUsageResponse.DataBean> mListKTUsage;
//    private List<VehicleUsageResponse.DataBean.ListBean> mListVehicleUsage;

    @Override
    public int getLayout() {
        return R.layout.activity_inspection;
    }

    @SuppressLint("ClickableViewAccessibility")
    @Override
    public void initView(Bundle savedInstanceState) {
        setTitle("正在巡考");
//        GetPresenter getPresenter = new GetPresenter(this);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        mSurfaceView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (isShowing) {
                    isShowing = false;
                    mLlHeader.setVisibility(View.VISIBLE);
//                    mLlBottom.setVisibility(View.VISIBLE);

                } else {
                    isShowing = true;
                    mLlHeader.setVisibility(View.GONE);
//                    mLlBottom.setVisibility(View.GONE);
                }
                return false;
            }
        });

//        kskm = Constants.mKskm;
//
//        if ("1".equals(kskm) || "4".equals(kskm)) {
//            mListKTUsage = Constants.mListKTUsage;
//
//            mTvPointRecord.setVisibility(View.GONE);
//            mTvChoose.setText("选考台");
//
//            HashMap<String, String> map = new HashMap<>();
//            map.put("kcdm", Constants.mKcdm);
//            map.put("ksjh", Constants.mksjh);
//            getPresenter.doNetworkTask(map, Constants.CAMERA_SUBJECT_ONE);
//
//        } else {
//            mListVehicleUsage = Constants.mListVehicleUsage;
//
//            mTvPointRecord.setVisibility(View.VISIBLE);
//            mTvChoose.setText("选考车");
//
//            HashMap<String, String> map = new HashMap<>();
//            map.put("kcxh ", Constants.mKcxh);
//            map.put("kchp", Constants.mKchp);
//            getPresenter.doNetworkTask(map, Constants.CAMERA_SUBJECT_TWO);
//
//        }
        mLoading.show();

        mSurfaceView.getHolder().addCallback(this);
        mHandler = new MyHandler(this);

        setCamera(intent.getStringExtra("cameraNumber"));

    }

    private void setCamera(final String camera) {
        if (!TextUtils.isEmpty(camera)) {
            new Thread() {
                @Override
                public void run() {
                    Looper.prepare();
                    VMSNetSDK.getInstance().startLiveOpt(PLAY_WINDOW_ONE, camera, mSurfaceView, mStreamType, new OnVMSNetSDKBusiness() {
                        @Override
                        public void onFailure() {
                            mLoading.dismiss();
                            mHandler.sendEmptyMessage(GET_CAMERA_INFO_FAILURE);
                        }

                        @Override
                        public void onSuccess(Object obj) {
                            mLoading.dismiss();
                            mHandler.sendEmptyMessage(GET_CAMERA_INFO_SUCCESS);
                        }
                    });
                    Looper.loop();
                }
            }.start();
        }
    }

    /**
     * 视图更新处理器
     */
    private class MyHandler extends Handler {

        WeakReference<InspectionActivity> mActivityReference;

        MyHandler(InspectionActivity activity) {
            mActivityReference = new WeakReference<>(activity);
        }

        @Override
        public void handleMessage(Message msg) {
            InspectionActivity activity = mActivityReference.get();
            if (activity != null) {
                switch (msg.what) {
                    case GET_CAMERA_INFO_SUCCESS:
                        Utils.showToast(activity, getString(R.string.rtsp_success));
                        break;
                    case GET_CAMERA_INFO_FAILURE:
                        Utils.showToast(activity, getString(R.string.rtsp_fail));
                        break;
                    default:
                        break;
                }
            }
        }
    }

    @Override
    public int setBarColor() {
        return R.color.blue;
    }

//    @OnClick({R.id.m_tv_choose, R.id.m_tv_examine_info, R.id.m_tv_process_snapping, R.id.m_tv_point_record})
//    public void onViewClicked(View view) {
//        switch (view.getId()) {
//            case R.id.m_tv_choose:
//                showWindowChoose();
//                break;
//            case R.id.m_tv_examine_info:
//                showWindowExamineInfo();
//                break;
//            case R.id.m_tv_process_snapping:
//                showWindowProcessSnapping();
//                break;
//            case R.id.m_tv_point_record:
//                showWindowPointRecord();
//                break;
//        }
//    }
//
//    //选考台
//    private void showWindowChoose() {
//        View view = LayoutInflater.from(this).inflate(R.layout.item_popup_choose, null);
//        final PopupWindow mWindow = new PopupWindow(view, 1000, ViewGroup.LayoutParams.MATCH_PARENT);
//        mWindow.setFocusable(true);
//        mWindow.setOutsideTouchable(true);
//        mWindow.showAtLocation(getLayoutInflater().inflate(R.layout.activity_inspection, null), Gravity.END, 0, 0);
//
//        TextView mTvChoose = view.findViewById(R.id.m_tv_choose);
//        RecyclerView mRecycler = view.findViewById(R.id.m_recycler);
//        mRecycler.setLayoutManager(new GridLayoutManager(this, 5));
//        mRecycler.addItemDecoration(new SpacingItemDecoration(5, Utils.dip2px(this, 5), false));
//        RemoteInspection2Adapter inspectAdapter = new RemoteInspection2Adapter(this);
//        mRecycler.setAdapter(inspectAdapter);
//        inspectAdapter.setOnItemClickListener(new RemoteInspection2Adapter.OnItemClickListener() {
//            @Override
//            public void onClick(int position) {
//                mWindow.dismiss();
//
//                //跳转资源列表页面
//                Intent intent = new Intent(InspectionActivity.this, InspectionActivity.class);
//                if (Constants.mListKTUsage != null) {
//                    Constants.mKcdm = Constants.mListKTUsage.get(position).getKcdm();
//                    Constants.mksjh = Constants.mListKTUsage.get(position).getKsjh();
//                }
//
//                if (Constants.mListVehicleUsage != null) {
//                    Constants.mKcxh = Constants.mListVehicleUsage.get(position).getKcbaxh();
//                    Constants.mKchp = Constants.mListVehicleUsage.get(position).getHphm();
//                }
//                Constants.mKskm = kskm;
//                startActivity(intent);
//                finish();
//
////                if (mSubjectOneData != null) {
////                    CameraSubjectOneResponse.DataBean.CameraBean camera = mSubjectOneData.getCamera();
////                    if (camera != null) {
////                        setCamera(camera.getCameraNumber());
////                    }
////
////                }else if (mSubjectTwoData != null) {
////                    CameraSubjectTwoResponse.DataBean.CameraBean camera = mSubjectTwoData.getCamera();
////                    if (camera != null) {
////                        setCamera(camera.getCameraNumber());
////                    }
////                }
//            }
//        });
//
//        if (("1".equals(kskm) || "4".equals(kskm)) && mListKTUsage != null) {
//            inspectAdapter.setKTData(mListKTUsage);
//            mTvChoose.setText("选考台");
//        } else {
//            mTvChoose.setText("选考车");
//            if (mListVehicleUsage != null) {
//                inspectAdapter.setVehicleData(mListVehicleUsage);
//            }
//        }
//    }
//
//    //考生信息
//    private void showWindowExamineInfo() {
//        View view = LayoutInflater.from(this).inflate(R.layout.item_popup_examine_info, null);
//        PopupWindow mWindow = new PopupWindow(view, 1000, ViewGroup.LayoutParams.MATCH_PARENT);
//        mWindow.setFocusable(true);
//        mWindow.setOutsideTouchable(true);
//        mWindow.showAtLocation(getLayoutInflater().inflate(R.layout.activity_inspection, null), Gravity.END, 0, 0);
//
//        TextView mTvUsername = view.findViewById(R.id.m_tv_username);
//        TextView mTvTopAuth = view.findViewById(R.id.m_tv_top_auth);
//        TextView mTvSex = view.findViewById(R.id.m_tv_sex);
//        TextView mTvId = view.findViewById(R.id.m_tv_id);
//        TextView mTvVehicleType = view.findViewById(R.id.m_tv_vehicle_type);
//        TextView mTvAuth = view.findViewById(R.id.m_tv_auth);
//        TextView mTvExamResson = view.findViewById(R.id.m_tv_exam_reason);
//        TextView mTvExamStatus = view.findViewById(R.id.m_tv_exam_status);
//        TextView mTvStartTime = view.findViewById(R.id.m_tv_start_time);
//        TextView mTvEndTiem = view.findViewById(R.id.m_tv_end_time);
//        ImageView mIvId = view.findViewById(R.id.m_iv_id);
//        ImageView mIvScene = view.findViewById(R.id.m_iv_scene);
//
//        if (mSubjectOneData != null) {
//            mTvUsername.setText(mSubjectOneData.getKsy1xm());
//            if ("1".equals(mSubjectOneData.getXb())) {
//                mTvSex.setText("男");
//            } else if ("2".equals(mSubjectOneData.getXb())) {
//                mTvSex.setText("女");
//            }
//            mTvId.setText(mSubjectOneData.getJszh());
//            mTvVehicleType.setText(mSubjectOneData.getSqcx());
//            mTvAuth.setText("人像对比通过");
//            mTvTopAuth.setText("人像对比通过");
//            mTvExamResson.setText(mSubjectOneData.getSqyy());
//
//            if ("1".equals(mSubjectOneData.getKszt())){
//                mTvExamStatus.setText("考试中");
//            }else if ("2".equals(mSubjectOneData.getKszt())){
//                mTvExamStatus.setText("考试结束");
//            }
//
//            mTvStartTime.setText(mSubjectOneData.getScsj());
//            mTvEndTiem.setText(mSubjectOneData.getJssj());
//
//            List<CameraSubjectOneResponse.DataBean.ResExamKszpBean> resExamKszp = mSubjectOneData.getResExamKszp();
//            if (resExamKszp != null) {
//                for (int i = 0; i < resExamKszp.size(); i++) {
//                    if (resExamKszp.size() > 1) {
//                        Glide.with(this).load(Utils.base64ToBitmap(resExamKszp.get(1).getZp())).error(R.color.light_gray).into(mIvScene);
//
//                    } else if (resExamKszp.size() > 0) {
//                        Glide.with(this).load(Utils.base64ToBitmap(resExamKszp.get(0).getZp())).error(R.color.light_gray).into(mIvId);
//                    }
//                }
//            }
//
//        } else if (mSubjectTwoData != null) {
//            mTvUsername.setText(mSubjectTwoData.getKsy1());
//            mTvSex.setText("未知");
//            mTvId.setText(mSubjectTwoData.getKsysfzmhm());
//            mTvVehicleType.setText(mSubjectTwoData.getKscx());
//            if ("1".equals(mSubjectTwoData.getBdjg())) {
//                mTvAuth.setText("人像对比通过");
//                mTvTopAuth.setText("人像对比通过");
//            } else {
//                mTvAuth.setText("人像对比未通过");
//                mTvTopAuth.setText("人像对比未通过");
//            }
//            mTvExamResson.setText(mSubjectTwoData.getKsyy());
//
//            if ("1".equals(mSubjectTwoData.getKszt())){
//                mTvExamStatus.setText("考试中");
//            }else if ("2".equals(mSubjectTwoData.getKszt())){
//                mTvExamStatus.setText("考试结束");
//            }
//
//            mTvStartTime.setText(Utils.formatTime(mSubjectTwoData.getKssj()));
//            mTvEndTiem.setText(Utils.formatTime(mSubjectTwoData.getJssj()));
//
//            List<CameraSubjectTwoResponse.DataBean.ResDrvPhotoBean> resDrvPhoto = mSubjectTwoData.getResDrvPhoto();
//            if (resDrvPhoto != null) {
//                for (int i = 0; i < resDrvPhoto.size(); i++) {
//                    if (resDrvPhoto.size() > 1) {
//                        Glide.with(this).load(Utils.base64ToBitmap(resDrvPhoto.get(1).getZp())).error(R.color.light_gray).into(mIvScene);
//
//                    } else if (resDrvPhoto.size() > 0) {
//                        Glide.with(this).load(Utils.base64ToBitmap(resDrvPhoto.get(0).getZp())).error(R.color.light_gray).into(mIvId);
//                    }
//                }
//            }
//        }
//    }
//
//    //过程抓拍
//    private void showWindowProcessSnapping() {
//        View view = LayoutInflater.from(this).inflate(R.layout.item_popup_process_snapping, null);
//        PopupWindow mWindow = new PopupWindow(view, 1000, ViewGroup.LayoutParams.MATCH_PARENT);
//        mWindow.setFocusable(true);
//        mWindow.setOutsideTouchable(true);
//        mWindow.showAtLocation(getLayoutInflater().inflate(R.layout.activity_inspection, null), Gravity.END, 0, 0);
//
//        RecyclerView mRecycler = view.findViewById(R.id.m_recycler);
//        mRecycler.setLayoutManager(new GridLayoutManager(this, 2));
//        mRecycler.addItemDecoration(new SpacingItemDecoration(2, Utils.dip2px(this, 5), false));
//        ProcessSnappingAdapter snappingAdapter = new ProcessSnappingAdapter(this);
//        mRecycler.setAdapter(snappingAdapter);
//        if (("1".equals(kskm) || "4".equals(kskm)) && mSubjectOneData != null) {
//            List<CameraSubjectOneResponse.DataBean.ResExamKszpTempBean> resExamKszpTemp = mSubjectOneData.getResExamKszpTemp();
//            snappingAdapter.setSubjectOneData(resExamKszpTemp);
//
//        } else if (mSubjectTwoData != null) {
//            List<CameraSubjectTwoResponse.DataBean.ResDrvMonExamPhotosBean> resDrvMonExamPhotos = mSubjectTwoData.getResDrvMonExamPhotos();
//            snappingAdapter.setSubjectTwoData(resDrvMonExamPhotos);
//        }
//    }
//
//    //扣分记录
//    private void showWindowPointRecord() {
//        View view = LayoutInflater.from(this).inflate(R.layout.item_popup_point_record, null);
//        PopupWindow mWindow = new PopupWindow(view, 1000, ViewGroup.LayoutParams.MATCH_PARENT);
//        mWindow.setFocusable(true);
//        mWindow.setOutsideTouchable(true);
//        mWindow.showAtLocation(getLayoutInflater().inflate(R.layout.activity_inspection, null), Gravity.END, 0, 0);
//
//        RecyclerView mRecycler = view.findViewById(R.id.m_recycler);
//        mRecycler.setLayoutManager(new LinearLayoutManager(this));
//
//        if (("2".equals(kskm) || "3".equals(kskm)) && mSubjectTwoData != null) {
//            List<CameraSubjectTwoResponse.DataBean.ResDrvCodeExamsBean> resDrvCodeExams = mSubjectTwoData.getResDrvCodeExams();
//            mRecycler.setAdapter(new PointRecordSubjectTwoAdapter(this, resDrvCodeExams));
//        }
//    }
//
//    @Override
//    public void getSuccess(BaseResponse response) {
//        try {
//            mLoading.dismiss();
//            if (Constants.CAMERA_SUBJECT_ONE.equals(response.getUrl())) {
//                CameraSubjectOneResponse mResponse = gson.fromJson(response.getResponseString(), CameraSubjectOneResponse.class);
//                mSubjectOneData = mResponse.getData();
//
//            } else {
//                CameraSubjectTwoResponse mResponse = gson.fromJson(response.getResponseString(), CameraSubjectTwoResponse.class);
//                mSubjectTwoData = mResponse.getData();
//            }
//
//            if (mSubjectOneData != null) {
//                CameraSubjectOneResponse.DataBean.CameraBean camera = mSubjectOneData.getCamera();
//                if (camera != null) {
//                    setCamera(camera.getCameraNumber());
//                } else {
//                    showToast("获取摄像头信息为空");
//                }
//
//            } else if (mSubjectTwoData != null) {
//                CameraSubjectTwoResponse.DataBean.CameraBean camera = mSubjectTwoData.getCamera();
//                if (camera != null) {
//                    setCamera(camera.getCameraNumber());
//                } else {
//                    showToast("获取摄像头信息为空");
//                }
//
//            } else {
//                showToast("获取考生信息数据为空");
//            }
//
//        } catch (JsonSyntaxException e) {
//            showErrorDialog("JsonSyntaxException  " + e.getMessage());
//        }
//    }
//
//    @Override
//    public void getFailed(BaseResponse response) {
//        mLoading.dismiss();
//        showErrorDialog(response.getResponseString());
//    }

    @Override
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
    }

    @Override
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i1, int i2) {
    }

    @Override
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        //页面销毁时停止预览
        boolean stopLiveResult = VMSNetSDK.getInstance().stopLiveOpt(1);
        if (stopLiveResult) {
            Utils.showToast(this, "停止成功");
        }
    }
}
