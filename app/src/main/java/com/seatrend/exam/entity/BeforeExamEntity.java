package com.seatrend.exam.entity;

import android.net.Uri;

public class BeforeExamEntity {

    private int id;
    private String title;
    private Uri imageUri;
    private int uploadImageStatus; //1正在上传 2上传失败 3上传成功

    public int getUploadImageStatus() {
        return uploadImageStatus;
    }

    public void setUploadImageStatus(int uploadImageStatus) {
        this.uploadImageStatus = uploadImageStatus;
    }

    public Uri getImageUri() {
        return imageUri;
    }

    public void setImageUri(Uri imageUri) {
        this.imageUri = imageUri;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
