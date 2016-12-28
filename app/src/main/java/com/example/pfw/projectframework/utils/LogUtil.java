package com.example.pfw.projectframework.utils;

import android.text.TextUtils;
import android.util.Log;


import com.example.pfw.projectframework.BuildConfig;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class LogUtil {
    private static final int JSON_INDENT = 4;
    public static String TAG = "ShoppingGuide";

    /**
     * verbose
     *
     * @param str
     */
    public static void v(String str, Object... args) {
        if (BuildConfig.DEBUG) {
            Log.v(getTag(), buildLogString(str, args));
        }
    }

    /**
     * debug
     *
     * @param str
     */
    public static void d(String str, Object... args) {
        if (BuildConfig.DEBUG) {
            Log.d(getTag(), buildLogString(str, args));
        }
    }

    /**
     * info
     *
     * @param str
     */
    public static void i(String str, Object... args) {
        if (BuildConfig.DEBUG) {
            Log.i(getTag(), buildLogString(str, args));
        }
    }

    /**
     * warning
     *
     * @param str
     */
    public static void w(String str, Object... args) {
        if (BuildConfig.DEBUG) {
            Log.w(getTag(), buildLogString(str, args));
        }
    }

    /**
     * error
     *
     * @param str
     */
    public static void e(String str, Object... args) {
        if (BuildConfig.DEBUG) {
            Log.e(getTag(), buildLogString(str, args));
        }
    }

    /**
     * json with a title
     *
     * @param str
     * @param title
     */
    public static void json(String str, String title) {
        if (BuildConfig.DEBUG) {
            Log.d(getTag(), "|===================================================================");

            if (!TextUtils.isEmpty(title)) {
                Log.d(getTag(), "| " + title);
                Log.d(getTag(), "|-------------------------------------------------------------------");
            }

            String message;
            try {
                if (str.startsWith("{")) {
                    JSONObject jsonObject = new JSONObject(str);
                    message = jsonObject.toString(JSON_INDENT);
                } else if (str.startsWith("[")) {
                    JSONArray jsonArray = new JSONArray(str);
                    message = jsonArray.toString(JSON_INDENT);
                } else {
                    message = str;
                }
            } catch (JSONException e) {
                message = str;
            }

            String[] lines = message.split("\n");
            for (String line : lines) {
                Log.d(getTag(), line);
            }
            Log.d(getTag(), "===================================================================|");
        }
    }

    /**
     * json
     *
     * @param str
     */
    public static void json(String str) {
        json(str, null);
    }

    /**
     * 如果$.sTAG是空则自动从StackTrace中取TAG
     *
     * @return
     */
    private static String getTag() {
        if (!TextUtils.isEmpty(TAG)) {
            return TAG;
        }
        StackTraceElement caller = new Throwable().fillInStackTrace().getStackTrace()[2];
        return caller.getFileName();
    }

    /**
     * 根据StackTrace生成带更多信息的log
     * 文件名,方法名,行数
     *
     * @param str
     * @return
     */
    private static String buildLogString(String str, Object... args) {

        // format string with args
        if (args.length > 0) {
            str = String.format(str, args);
        }

        StackTraceElement caller = new Throwable().fillInStackTrace().getStackTrace()[2];
        StringBuilder stringBuilder = new StringBuilder();
        if (TextUtils.isEmpty(TAG)) {
            stringBuilder.append(caller.getMethodName())
                    .append("():")
                    .append(caller.getLineNumber())
                    .append(":")
                    .append(str);
        } else {
            stringBuilder
                    .append("(")
                    .append(caller.getFileName())
                    .append(":")
                    .append(caller.getLineNumber())
                    .append(").")
                    .append(caller.getMethodName())
                    .append("():")
                    .append(str);
        }
        return stringBuilder.toString();
    }
}
