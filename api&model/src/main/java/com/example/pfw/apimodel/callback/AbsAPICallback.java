package com.example.pfw.apimodel.callback;

import android.text.TextUtils;

import com.example.pfw.apimodel.exception.ApiException;
import com.example.pfw.apimodel.exception.ResultException;
import com.example.pfw.apimodel.utils.ConverterUtil;
import com.google.gson.Gson;
import com.google.gson.JsonParseException;

import org.json.JSONException;

import java.io.IOException;
import java.text.ParseException;

import retrofit2.adapter.rxjava.HttpException;
import rx.Subscriber;

/**
 * Created by wangfangqi on 16/8/25.
 */
public abstract class AbsAPICallback<T> extends Subscriber<T> {
    //对应HTTP的状态码
    private static final int UNAUTHORIZED = 401;
    private static final int FORBIDDEN = 403;
    private static final int NOT_FOUND = 404;
    private static final int REQUEST_TIMEOUT = 408;
    private static final int INTERNAL_SERVER_ERROR = 500;
    private static final int BAD_GATEWAY = 502;
    private static final int SERVICE_UNAVAILABLE = 503;
    private static final int GATEWAY_TIMEOUT = 504;
    //出错提示
    private final String networkMsg = "网络错误";
    private final String parseMsg = "数据解析错误";

    protected AbsAPICallback() {
    }

    @Override
    public void onError(Throwable e) {
        Throwable throwable = e;
        //获取最根源的异常
        while (throwable.getCause() != null) {
            e = throwable;
            throwable = throwable.getCause();
        }

        ApiException ex;
        if (e instanceof HttpException) {             //HTTP错误
            HttpException httpException = (HttpException) e;
            ex = new ApiException(e, httpException.code());
            switch (httpException.code()) {
                case UNAUTHORIZED:
                case FORBIDDEN:
                case NOT_FOUND:
                case REQUEST_TIMEOUT:
                case GATEWAY_TIMEOUT:
                case INTERNAL_SERVER_ERROR:
                case BAD_GATEWAY:
                case SERVICE_UNAVAILABLE:
                default:
                    try {
                        String body = httpException.response().errorBody().string();
                        if (TextUtils.isEmpty(body)) {
                            ex.setDisplayMessage(networkMsg);  //均视为网络错误
                        } else {
                            Gson gson = new Gson();
                            ResultException resultException = gson.fromJson(body, ResultException.class);
                            ex.setDisplayMessage(ConverterUtil.getErrorMessage(resultException.getCode()));
                        }
                    } catch (IOException e1) {
                        e1.printStackTrace();
                    }
                    break;
            }
            onError(ex);
        } else if (e instanceof JsonParseException
                || e instanceof JSONException
                || e instanceof ParseException) {
            ex = new ApiException(e, ApiException.PARSE_ERROR);
            ex.setDisplayMessage(parseMsg);            //均视为解析错误
            onError(ex);
        } else {
            ex = new ApiException(e, ApiException.UNKNOWN);
            ex.setDisplayMessage(ex.getMessage());          //未知错误
            onError(ex);
        }
    }


    /**
     * 错误回调
     */
    protected abstract void onError(ApiException ex);

    @Override
    public void onCompleted() {

    }

}
