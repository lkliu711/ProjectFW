package com.example.pfw.projectframework.utils;

import com.example.pfw.projectframework.App;
import com.example.pfw.projectframework.BuildConfig;
import com.example.pfw.projectframework.helper.HttpCacheInterceptor;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;

import java.io.File;
import java.lang.reflect.Type;
import java.util.concurrent.TimeUnit;

import okhttp3.Cache;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * retrofit单例工具类
 */
public class RetrofitUtil {

    private volatile static Retrofit singleton;
    private static OkHttpClient okHttpClient;
    private static Gson gson;

    public static <T> T createApi(Class<T> clazz) {
        return createApi(BuildConfig.API_URL, clazz);
    }

    public static <T> T createApi(String baseUrl, Class<T> clazz) {
        if (singleton == null || !singleton.baseUrl().equals(HttpUrl.parse(baseUrl))) {
            synchronized (RetrofitUtil.class) {
                if (singleton == null || !singleton.baseUrl().equals(HttpUrl.parse(baseUrl))) {
                    Retrofit.Builder builder = new Retrofit.Builder();
                    builder.client(initOkHttp())
                            .baseUrl(baseUrl)
                            .addConverterFactory(GsonConverterFactory.create())
//                            .addConverterFactory(GsonConverterFactory.create(initGson()))
                            .addCallAdapterFactory(RxJavaCallAdapterFactory.create());
                    singleton = builder.build();
                }
            }
        }
        return singleton.create(clazz);
    }

    /**
     * 初始化OkHttpClient
     */
    private static OkHttpClient initOkHttp() {
        if (okHttpClient == null) {
            HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
            interceptor.setLevel(BuildConfig.DEBUG ? HttpLoggingInterceptor.Level.BODY :
                    HttpLoggingInterceptor.Level.NONE);

            File cacheFile = new File(App.getContext().getCacheDir(), "cache");
            Cache cache = new Cache(cacheFile, 1024 * 1024 * 100); //100Mb

            okHttpClient = new OkHttpClient.Builder()
                    .readTimeout(20, TimeUnit.SECONDS)
                    .connectTimeout(20, TimeUnit.SECONDS)
                    .addInterceptor(interceptor)
                    .addNetworkInterceptor(new HttpCacheInterceptor(App.getContext()))
                    .cache(cache)
                    .build();
        }
        return okHttpClient;
    }

//    private static Gson initGson() {
//        if (gson == null) {
//            gson = new GsonBuilder()
//                    .registerTypeHierarchyAdapter(Agency.class, (JsonDeserializer<Agency>) (json, typeOfT, context) -> fromJson(json, typeOfT))
//                    .registerTypeHierarchyAdapter(WareHouse.class, (JsonDeserializer<WareHouse>) (json, typeOfT, context) -> fromJson(json, typeOfT))
//                    .registerTypeHierarchyAdapter(Role.class, (JsonDeserializer<Role>) (json, typeOfT, context) -> fromJson(json, typeOfT))
//                    .create();
//        }
//        return gson;
//    }

    private static <T> T fromJson(JsonElement json, Type typeOfT) {
        if (json.isJsonObject()) {
            return new Gson().fromJson(json, typeOfT);
        } else {
            return null;
        }
    }
}
