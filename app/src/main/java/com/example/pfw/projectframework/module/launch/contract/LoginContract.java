package com.example.pfw.projectframework.module.launch.contract;


import com.example.pfw.apimodel.entity.LoginInfo;
import com.example.pfw.projectframework.base.BaseModel;
import com.example.pfw.projectframework.base.BasePresenter;
import com.example.pfw.projectframework.base.BaseView;

import rx.Observable;

/**
 * Created by wangfangqi on 16/8/25.
 */
public interface LoginContract {
    interface Model extends BaseModel {
        Observable<LoginInfo> login(String mobile, String password);
    }

    interface View extends BaseView {
        void loginSuccess();

        void loginFail(String error);
    }

    abstract class Presenter extends BasePresenter<Model, View> {

        public abstract void login(String mobile, String password);

        @Override
        public void onStart() {

        }
    }
}