package com.example.pfw.projectframework.module.launch.ui.activity;

import android.os.Bundle;

import com.example.pfw.projectframework.R;
import com.example.pfw.projectframework.base.BaseActivity;
import com.example.pfw.projectframework.module.launch.contract.LoginContract;
import com.example.pfw.projectframework.module.launch.model.LoginModel;
import com.example.pfw.projectframework.module.launch.presenter.LoginPresenter;
import com.example.pfw.projectframework.utils.StateBarTranslucentUtils;

/**
 * 登录
 */
public class LoginActivity extends BaseActivity<LoginPresenter, LoginModel> implements LoginContract.View {

    @Override
    protected void setStatusColor() {
        //该方法用来去除主页的状态栏，可不做任何处理
        StateBarTranslucentUtils.setStateBarColor(this, R.color.ksw_md_solid_checked_disable);
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void onSavedState(Bundle savedInstanceState) {
//        boolean isLogin = (boolean) SPUtil.get(this, Constant.LOGIN, false);
//        if (isLogin) {
////            startActivity(new Intent(this, MainActivity.class));
//            finish();
//        }
    }

    @Override
    public void initView() {

    }

    @Override
    public void loginSuccess() {

    }

    @Override
    public void loginFail(String error) {

    }

//    @OnClick({R.id.btn_login, R.id.btn_recover_password})
//    public void onClick(View view) {
//        switch (view.getId()) {
//            case R.id.btn_login:
//                if (Utils.isFastDoubleClick())
//                    return;
//                Utils.hideSoftKeyboard(getCurrentFocus());
//                login();
//                break;
//            case R.id.btn_recover_password:
//                startActivity(new Intent(this, RecoverPasswordActivity.class));
//                break;
//        }
//    }
//
//    private void login() {
//        String mobile = etAccount.getText().toString();
//        String password = etPassWord.getText().toString();
////        if (RegUtils.isMobileNumber(mobile)) {
//            mPresenter.login(mobile, DES.md5(password));
////        } else {
////            Utils.showToast(this, "号码格式错误");
////        }
//    }
//
//    @Override
//    public void loginSuccess() {
//        startActivity(new Intent(LoginActivity.this, MainActivity.class));
//        finish();
//    }
//
//    @Override
//    public void loginFail(String error) {
//        Utils.showToast(this, error);
//    }
//
//    class TextChange implements TextWatcher {
//        @Override
//        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
//        }
//
//        @Override
//        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
//        }
//
//        @Override
//        public void afterTextChanged(Editable s) {
//            String mobile = etAccount.getText().toString();
//            String password = etPassWord.getText().toString();
//            if (mobile.length() == 11 && password.length() >= 6) {
//                btnLogin.setEnabled(true);
//            } else {
//                btnLogin.setEnabled(false);
//            }
//        }
//    }
}
