package com.example.pfw.apimodel.utils;

/**
 * 请求错误描述帮助类
 */
public class ConverterUtil {

    /**
     * 设置错误码描述
     *
     * @param code
     * @return
     */
    public static String getErrorMessage(String code) {
        switch (code) {
            case "user_not_found":
                return "找不到用户";
            case "password_not_correct":
                return "密码错误";
            case "invalid_access":
                return "该账号无权限登录！";
            default:
                return "";
        }
    }
}
