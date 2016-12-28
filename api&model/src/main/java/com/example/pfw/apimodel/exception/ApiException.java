package com.example.pfw.apimodel.exception;

/**
 * Created by zhangxiangyu on 16/5/9.
 * <p>
 * 自定义ApiException，携带了异常代码和信息，以及根源Throwable
 */
public class ApiException extends Exception {

    public static final int UNKNOWN = 1000;
    public static final int PARSE_ERROR = 1001;
    private final int code;
    private String displayMessage;

    public ApiException(Throwable throwable, int code) {
        super(throwable);
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public String getDisplayMessage() {
        return displayMessage;
    }

    public void setDisplayMessage(String msg) {
        this.displayMessage = msg;
    }
}
