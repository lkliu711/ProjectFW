package com.example.pfw.projectframework.module.launch.model;

import com.example.pfw.apimodel.api.UserApi;
import com.example.pfw.apimodel.entity.LoginInfo;
import com.example.pfw.projectframework.module.launch.contract.LoginContract;
import com.example.pfw.projectframework.utils.RetrofitUtil;
import com.example.pfw.projectframework.utils.RxSchedulers;

import rx.Observable;

/**
 * Created by wangfangqi on 16/8/26.
 */
public class LoginModel implements LoginContract.Model {
    @Override
    public Observable<LoginInfo> login(String mobile, String password) {
        return RetrofitUtil.createApi(UserApi.class).login(mobile, password)
                .compose(RxSchedulers.io_main());
    }
}
