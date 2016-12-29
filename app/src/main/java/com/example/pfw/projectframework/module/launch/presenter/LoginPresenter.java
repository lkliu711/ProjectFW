package com.example.pfw.projectframework.module.launch.presenter;

import com.example.pfw.apimodel.callback.AbsAPICallback;
import com.example.pfw.apimodel.entity.LoginInfo;
import com.example.pfw.apimodel.exception.ApiException;
import com.example.pfw.projectframework.App;
import com.example.pfw.projectframework.config.Constant;
import com.example.pfw.projectframework.module.launch.contract.LoginContract;
import com.example.pfw.projectframework.utils.SPUtil;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wangfangqi on 16/8/26.
 */
public class LoginPresenter extends LoginContract.Presenter {

    @Override
    public void login(String mobile, String password) {
        showLoading();
        mRxManager.add(mModel.login(mobile, password).subscribe(new AbsAPICallback<LoginInfo>() {
            @Override
            protected void onError(ApiException ex) {
                loadDismiss();
                mView.loginFail(ex.getDisplayMessage());
            }

            @Override
            public void onNext(LoginInfo loginInfo) {
                mView.loginSuccess();
                loadDismiss();
            }
        }));
    }
}
