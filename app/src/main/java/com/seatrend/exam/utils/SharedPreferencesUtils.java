package com.seatrend.exam.utils;

import android.content.Context;

import com.seatrend.exam.common.Constants;
import com.seatrend.exam.common.MyApplication;


/**
 * Created by seatrend on 2018/8/22.
 */

public class SharedPreferencesUtils {
    public static void setIsFirst(boolean isFirst) {
        MyApplication.getMyApplicationContext().getApplicationContext().getSharedPreferences(Constants.SETTING, Context.MODE_PRIVATE)
                .edit().putBoolean(Constants.IS_FIRST, isFirst).apply();
    }

    public static boolean IsFirst() {
        return MyApplication.getMyApplicationContext().getApplicationContext().getSharedPreferences(Constants.SETTING, Context.MODE_PRIVATE)
                .getBoolean(Constants.IS_FIRST, true);
    }

    public static void setIpAddress(String ip) {
        MyApplication.getMyApplicationContext().getApplicationContext().getSharedPreferences(Constants.SETTING, Context.MODE_PRIVATE)
                .edit().putString(Constants.IP_K, ip).apply();
    }

    public static String getIpAddress() {
        return MyApplication.getMyApplicationContext().getApplicationContext().getSharedPreferences(Constants.SETTING, Context.MODE_PRIVATE)
                .getString(Constants.IP_K, "");
    }

    public static void setPort(String port) {
        MyApplication.getMyApplicationContext().getApplicationContext().getSharedPreferences(Constants.SETTING, Context.MODE_PRIVATE)
                .edit().putString(Constants.PORT_K, port).apply();
    }

    public static String getPort() {
        return MyApplication.getMyApplicationContext().getApplicationContext().getSharedPreferences(Constants.SETTING, Context.MODE_PRIVATE)
                .getString(Constants.PORT_K, "");
    }

    public static void setAdmin(String admin) {
        MyApplication.getMyApplicationContext().getApplicationContext().getSharedPreferences(Constants.SETTING, Context.MODE_PRIVATE)
                .edit().putString(Constants.ADMAIN, admin).apply();
    }

    public static String getAdmin() {
        return MyApplication.getMyApplicationContext().getApplicationContext().getSharedPreferences(Constants.SETTING, Context.MODE_PRIVATE)
                .getString(Constants.ADMAIN, "admin");
    }

    public static void setUsername(String username) {
        MyApplication.getMyApplicationContext().getApplicationContext().getSharedPreferences(Constants.SETTING, Context.MODE_PRIVATE)
                .edit().putString(Constants.USERNAME, username).apply();
    }

    public static String getUsername() {
        return MyApplication.getMyApplicationContext().getApplicationContext().getSharedPreferences(Constants.SETTING, Context.MODE_PRIVATE)
                .getString(Constants.USERNAME, "");
    }

    public static void setPassword(String password) {
        MyApplication.getMyApplicationContext().getApplicationContext().getSharedPreferences(Constants.SETTING, Context.MODE_PRIVATE)
                .edit().putString(Constants.PASSWORD, password).apply();
    }

    public static String getPassword() {
        return MyApplication.getMyApplicationContext().getApplicationContext().getSharedPreferences(Constants.SETTING, Context.MODE_PRIVATE)
                .getString(Constants.PASSWORD, "");
    }

    public static void setLoginTime(String time) {
        MyApplication.getMyApplicationContext().getApplicationContext().getSharedPreferences(Constants.SETTING, Context.MODE_PRIVATE)
                .edit().putString(Constants.LOGIN_TIME, time).apply();
    }

    public static String getLoginTime() {
        return MyApplication.getMyApplicationContext().getApplicationContext().getSharedPreferences(Constants.SETTING, Context.MODE_PRIVATE)
                .getString(Constants.LOGIN_TIME, "");
    }

}
