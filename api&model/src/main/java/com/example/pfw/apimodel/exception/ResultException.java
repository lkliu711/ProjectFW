package com.example.pfw.apimodel.exception;

/**
 * 错误消息体
 */
public class ResultException {

    /**
     * code : user_not_found
     * type : bussiness_error
     * message : user not found
     * param :
     */

    private String code;
    private String type;
    private String message;
    private String param;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getParam() {
        return param;
    }

    public void setParam(String param) {
        this.param = param;
    }
}
