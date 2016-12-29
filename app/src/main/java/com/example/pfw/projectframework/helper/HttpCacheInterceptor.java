package com.example.pfw.projectframework.helper;

import android.content.Context;
import android.util.Log;


import com.example.pfw.apimodel.utils.NetWorkUtil;
import com.example.pfw.projectframework.App;

import java.io.IOException;

import okhttp3.CacheControl;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 *
 */
public class HttpCacheInterceptor implements Interceptor {

    Context mContext;

    public HttpCacheInterceptor(Context context) {
        mContext = context;
    }

    @Override
    public Response intercept(Chain chain) throws IOException {
//        String authToken = App.getContext().getLoginInfo() == null ? "" : App.getContext().getLoginInfo().getToken();
        String authToken = "";
        Request request = chain.request();
        if (!NetWorkUtil.isNetConnected(mContext)) {
            request = request.newBuilder()
                    .cacheControl(CacheControl.FORCE_CACHE)
                    .build();
            Log.d("Okhttp", "no network");
        } else {
            request = request.newBuilder()
                    .header("Authorization", "Bearer " + authToken)
                    .cacheControl(CacheControl.FORCE_CACHE)
                    .build();
        }

        Response originalResponse = chain.proceed(request);
        if (NetWorkUtil.isNetConnected(mContext)) {
            //有网的时候读接口上的@Headers里的配置，你可以在这里进行统一的设置
            String cacheControl = request.cacheControl().toString();
            return originalResponse.newBuilder()
                    .header("Cache-Control", cacheControl)
                    .removeHeader("Pragma")
                    .build();
        } else {
            return originalResponse.newBuilder()
                    .header("Cache-Control", "public, only-if-cached, max-stale=2419200")
                    .removeHeader("Pragma")
                    .build();
        }
    }
}
