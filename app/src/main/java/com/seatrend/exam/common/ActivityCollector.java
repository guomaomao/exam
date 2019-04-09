package com.seatrend.exam.common;

import android.app.Activity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/12/22.
 */

public class ActivityCollector {

    public static List<Activity> activities = new ArrayList<>();

    public static void addActivity(Activity activity) {
        activities.add(activity);
    }

    public static void removeActivity(Activity activity) {
        activities.remove(activity);
    }

    public static void finishAll() {
        for (int i = 0; i < activities.size(); i++) {
            Activity activity = activities.get(i);
            if (activity != null && !activity.isFinishing()) {
                activity.finish();
            }
        }
    }

    public static Activity getCurrentActivity() {
        if (activities.size() > 0) {
            return activities.get(activities.size() - 1);
        }
        return null;
    }

    //除了指定一个activity 其他都关闭
    public static void finishToOne(Class cls) {
        for (int i = 0; i < activities.size(); i++) {
            Activity activity = activities.get(i);
            if (activity != null && !activity.isFinishing()) {

                if (activity.getClass() == cls) {
                    continue;
                } else {
                    activity.finish();
                }

            }
        }
    }

    //关闭当前activity
    public static void finishCurrentActivity() {
        if (activities.size() > 0) {
            Activity activity = activities.get(activities.size() - 1);
            if (activity != null && !activity.isFinishing()) {
                activity.finish();
            }
        }
    }
}
