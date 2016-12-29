package com.example.pfw.projectframework.utils;

import android.app.Activity;
import android.content.Context;
import android.util.DisplayMetrics;

/**
 * 尺寸换算工具
 */
public class DensityUtil {

    public static int dip2px(Context c, float dpValue) {
        final float scale = c.getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }

    public static int px2dip(Context c, float pxValue) {
        final float scale = c.getResources().getDisplayMetrics().density;
        return (int) (pxValue / scale + 0.5f);
    }


    public static int px2sp(Context c, float pxValue) {
        float fontScale = c.getResources().getDisplayMetrics().scaledDensity;
        return (int) (pxValue / fontScale + 0.5f);
    }


    public static int sp2px(Context c, float spValue) {
        float fontScale = c.getResources().getDisplayMetrics().scaledDensity;
        return (int) (spValue * fontScale + 0.5f);
    }

    /**
     * 获取状态栏高度
     * @param c 上下文
     * @return  态栏高度
     */
    public static int getStatusBarHeight(Context c) {
        int resourceId = c.getResources().getIdentifier("status_bar_height", "dimen", "android");
        return resourceId > 0 ?
                c.getResources().getDimensionPixelSize(resourceId) :
                0;
    }

    /**
     * 获取导航条高度
     * @param c 上下文
     * @return  如果不含虚拟按键返回 0，否则返回高度
     */
    public static int getNavigationBarHeight(Context c) {
        int resourceId = c.getResources().getIdentifier("navigation_bar_height", "dimen", "android");
        return resourceId > 0 ?
                c.getResources().getDimensionPixelSize(resourceId) :
                0;
    }

    /**
     * 获取屏幕高度
     * @param c
     * @return
     */
    public static int getScreenHight(Activity c) {
        DisplayMetrics dm = new DisplayMetrics();
        c.getWindowManager().getDefaultDisplay().getMetrics(dm);
        return  dm.heightPixels;
    }
}
