package com.seatrend.exam.entity;

import java.io.Serializable;

public class PicEntity implements Serializable {

    private String url;
    private boolean isNetwork;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public boolean isNetwork() {
        return isNetwork;
    }

    public void setNetwork(boolean network) {
        isNetwork = network;
    }
}
