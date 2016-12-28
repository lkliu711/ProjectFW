package com.example.pfw.projectframework.utils;

import android.content.Context;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.pfw.projectframework.App;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import okhttp3.MediaType;
import okhttp3.RequestBody;


/**
 * Created by wangfangqi on 16/7/21.
 */
public class Utils {

    private static Toast toast;
    private static long lastClickTime;

    /**
     * 隐藏软键盘
     *
     * @param view 获取焦点的view
     */
    public static void hideSoftKeyboard(View view) {
        if (view == null)
            return;
        ((InputMethodManager) App.getContext().getSystemService(
                Context.INPUT_METHOD_SERVICE)).hideSoftInputFromWindow(
                view.getWindowToken(), 0);
    }

    /**
     * 显示软键盘
     * @param view
     */
    public static void showSoftKeyboard(View view) {
        if (view == null)
            return;
        ((InputMethodManager) App.getContext().getSystemService(
                Context.INPUT_METHOD_SERVICE)).showSoftInput(view,
                InputMethodManager.SHOW_FORCED);
    }

    /**
     * Toast
     */
    public static void showToast(Context context, String str) {
        if (toast == null) {
            toast = Toast.makeText(context, str, Toast.LENGTH_SHORT);
        } else {
            toast.setText(str);
        }
        toast.show();
    }

    /**
     * 限制一秒内连续点击
     */
    public static boolean isFastDoubleClick() {
        long time = System.currentTimeMillis();
        long timeD = time - lastClickTime;
        if (timeD >= 0 && timeD <= 800) {
            return true;
        } else {
            lastClickTime = time;
            return false;
        }
    }

    /**
     * 加载本地图片
     *
     * @param context   上下文
     * @param imageView imageView
     * @param path      图片路径
     */
    public static void setLocalImage(Context context, ImageView imageView, String path) {
        Glide.with(context).load(path).into(imageView);
    }

    public static List<String> getDate(int num) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            list.add(i + "");
        }
        return list;
    }

    /**
     * 创建上传文本RequestBody.
     *
     * @param value
     * @return
     */
    public static RequestBody toRequestBody(String value) {
        return RequestBody.create(MediaType.parse("text/plain"), value);
//        return RequestBody.create(MediaType.parse("text/x-markdown; charset=utf-8"), value);
    }

    /**
     * 创建上传文件RequestBody.
     *
     * @param value
     * @return
     */
    public static RequestBody toRequestBody(File value) {
        RequestBody body = RequestBody.create(MediaType.parse("multipart/form-data"), value);
        return body;
    }

    public static void editFocus(View view, boolean isFocus) {
        if (isFocus) {
            view.setFocusableInTouchMode(true);
            view.setFocusable(true);
            view.requestFocus();
        } else {
            view.setFocusable(false);
            view.setFocusableInTouchMode(false);
        }
    }
}
