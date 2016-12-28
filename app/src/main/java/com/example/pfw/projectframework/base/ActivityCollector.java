package com.example.pfw.projectframework.base;

import android.app.Activity;

import java.util.ArrayList;
import java.util.List;

public class ActivityCollector {
    // 类的管理集合
    public static List<Activity> activities = new ArrayList<>();

    // 想List中添加一个活动
    public static void addActivity(Activity activity) {
        activities.add(activity);
    }

    // 从List中移除活动
    public static void removeActivity(Activity activity) {
        activities.remove(activity);
    }

    public static Activity getLastActivity() {
        if (activities.size() > 0) {
            return activities.get(activities.size() - 1);
        }
        return null;
    }

    // 将List中储存的活动全部销毁
    public static void finishAll() {
        for (Activity activity : activities) {
            if (!activity.isFinishing()) {
                activity.finish();
            }
        }
    }
}
