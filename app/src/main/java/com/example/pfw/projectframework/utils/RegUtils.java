package com.example.pfw.projectframework.utils;

/**
 * Created by wangfangqi on 16/7/22.
 * 数据校验
 */
public class RegUtils {

    /**
     * 手机号码验证
     *
     * @param data 可能是手机号码字符串
     * @return 是否是手机号码
     */
    public static boolean isMobileNumber(String data) {
        String expr = "^((13[0-9])|(14[5,7,9])|(15[^4,\\D])|(17[^0,^2,^4,^9,\\D])|(18[0-9]))\\d{8}$";
        return data.matches(expr);
    }

    /**
     * 只含数字
     *
     * @param data 可能只包含数字的字符串
     * @return 是否只包含数字
     */
    public static boolean isNumber(String data) {
        String expr = "^[0-9]+$";
        return data.matches(expr);
    }
}
