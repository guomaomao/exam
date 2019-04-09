package com.seatrend.exam.common.view;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;

import com.seatrend.exam.R;

public class Loading extends Dialog {
    protected Loading(Context context, boolean cancelable, OnCancelListener cancelListener) {
        super(context, cancelable, cancelListener);
    }

    public Loading(Context context, int theme) {
        super(context, theme);
    }

    public Loading(Context context) {
        super(context, R.style.loading);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.loading);
    }
}
