package com.seatrend.exam.service;

import android.app.DownloadManager;
import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.support.v4.content.FileProvider;
import android.util.Log;

import com.seatrend.exam.R;
import com.seatrend.exam.common.Constants;
import com.seatrend.exam.network.NetworkService;

import java.io.File;
import java.io.IOException;

/**
 * 版本更新
 * Created by Administrator on 2017/5/12.
 */

public class UpdateService extends Service {
    private BroadcastReceiver receiver;

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        try {
            receiver = new BroadcastReceiver() {
                @Override
                public void onReceive(Context context, Intent intent) {
                    File file = new File(Environment.getExternalStorageDirectory() + "/download/exam.apk");
                    intent = new Intent(Intent.ACTION_VIEW);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    Uri data;
                    // 判断版本大于等于7.0
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                        data = FileProvider.getUriForFile(context, "com.seatrend.exam.provider", file);
                    } else {
                        data = Uri.fromFile(file);
                    }
                    // 给目标应用一个临时授权
                    intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
                    intent.setDataAndType(data, "application/vnd.android.package-archive");
                    startActivity(intent);
                    stopSelf();
                }
            };
            registerReceiver(receiver, new IntentFilter(DownloadManager.ACTION_DOWNLOAD_COMPLETE));
            startDownload(intent.getStringExtra("pda"));

        } catch (Exception e) {
            e.printStackTrace();
        }
        return Service.START_STICKY;
    }

    @Override
    public void onDestroy() {
        unregisterReceiver(receiver);
        super.onDestroy();
    }

    private void startDownload(String pda) {
        DownloadManager dm = (DownloadManager) getSystemService(DOWNLOAD_SERVICE);
        String url = NetworkService.httpUrl + Constants.DOWNLOAD_FILE_BY_ID + "?fileId=" + pda;

        DownloadManager.Request request = new DownloadManager.Request(Uri.parse(url));
        request.setMimeType("application/vnd.android.package-archive");
        File file = new File(Environment.getExternalStorageDirectory(), "/download/exam.apk");
        if (file.exists()) {
            file.deleteOnExit();
        }
        request.setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS, "exam.apk");
        request.setTitle(getString(R.string.app_name));
        request.setDescription(getString(R.string.version_update));
        request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
        dm.enqueue(request);
    }
}
