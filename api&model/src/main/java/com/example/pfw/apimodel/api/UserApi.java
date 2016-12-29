package com.example.pfw.apimodel.api;



import com.example.pfw.apimodel.entity.LoginInfo;

import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import rx.Observable;

/**
 * Created by wangfangqi on 16/8/25.
 * 用户相关
 */
public interface UserApi {

    @FormUrlEncoded
    @POST("user/login")
    Observable<LoginInfo> login(@Field("mobile") String mobile, @Field("password") String password);

}
