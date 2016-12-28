package com.example.pfw.projectframework;

import android.app.Application;

import com.example.pfw.apimodel.entity.LoginInfo;
import com.example.pfw.projectframework.config.Constant;
import com.example.pfw.projectframework.utils.SPUtil;
import com.google.gson.Gson;

import java.util.List;

/**
 * Created by wangfangqi on 16/8/4.
 */
public class App extends Application {
    private static App context;

    private LoginInfo mLoginInfo;
    private List<String> permitList;

    public static App getContext() {
        return context;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        context = this;
//        CalligraphyConfig.initDefault(new CalligraphyConfig.Builder()
//                .setDefaultFontPath("fonts/STXihei.ttf")
//                .setFontAttrId(R.attr.fontPath)
//                .build()
//        );
    }

    /**
     * 登录信息
     */
    public LoginInfo getLoginInfo() {
        if (mLoginInfo == null) {
            mLoginInfo = new Gson().fromJson((String) SPUtil.get(context, Constant.LOGIN_INFO, ""), LoginInfo.class);
        }
        return mLoginInfo;
    }

    public void setLoginInfo(LoginInfo loginInfo) {
        this.mLoginInfo = loginInfo;
    }

//    public List<String> getPermitList() {
//        if (permitList == null) {
//            permitList = new ArrayList<>();
//            for (PermitMenu permitMenu : getLoginInfo().getMenus()) {
//                permitList.add(permitMenu.code);
//            }
//        }
//        return permitList;
//    }

    public void setPermitList(List<String> permitList) {
        this.permitList = permitList;
    }
}
