package com.seatrend.exam.common.view;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.view.Gravity;
import android.view.Window;
import android.view.WindowManager;

import com.seatrend.exam.R;


/**
 * 通用的dialog
 * Created by Administrator on 2017/5/23.
 */

public class CommonDialog extends Dialog {


    public CommonDialog(Context context) {
        super(context);
    }

    /**
     * dialog 显示在屏幕中间
     *
     * @param context
     * @param mLayout
     * @param mCancel
     * @return
     */
    public static Dialog CenterDialog(Context context, int mLayout, boolean mCancel) {
        Dialog mDialog = new Dialog(context, R.style.MyDialogStyle);
        mDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        mDialog.setCanceledOnTouchOutside(mCancel);
        mDialog.setContentView(mLayout);
        Window window = mDialog.getWindow();
        if (window != null) {
            WindowManager.LayoutParams params = window.getAttributes();
            params.gravity = Gravity.CENTER;
            params.width = WindowManager.LayoutParams.MATCH_PARENT;
            params.height = WindowManager.LayoutParams.MATCH_PARENT;
            window.setAttributes(params);

        }
        return mDialog;

    }

    /**
     * dialog 显示在屏幕下面
     *
     * @param context
     * @param mLayout
     * @param mCancel
     * @return
     */
    public static Dialog BottomDialog(Context context, int mLayout, boolean mCancel) {
        Dialog mDialog = new Dialog(context, R.style.MyDialogStyle);
        mDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        mDialog.setCanceledOnTouchOutside(mCancel);
        mDialog.setContentView(mLayout);
        Window window = mDialog.getWindow();
        if (window != null) {
            WindowManager.LayoutParams params = window.getAttributes();
            params.gravity = Gravity.BOTTOM;
            params.width = WindowManager.LayoutParams.MATCH_PARENT;
            window.setAttributes(params);
        }
        return mDialog;
    }

    /**
     * dialog 显示在屏幕上面
     *
     * @param context
     * @param mLayout
     * @param mCancel
     * @return
     */
    public static Dialog TopDialog(Context context, int mLayout, boolean mCancel) {
        Dialog mDialog = new Dialog(context, R.style.MyDialogStyle);
        mDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        mDialog.setCanceledOnTouchOutside(mCancel);
        mDialog.setContentView(mLayout);
        Window window = mDialog.getWindow();
        if (window != null) {
            WindowManager.LayoutParams params = window.getAttributes();
            params.gravity = Gravity.TOP;
            params.width = WindowManager.LayoutParams.MATCH_PARENT;
            window.setAttributes(params);
        }
        return mDialog;
    }

}
