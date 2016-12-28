package com.example.pfw.projectframework.module.launch.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;


import com.example.pfw.projectframework.R;
import com.example.pfw.projectframework.base.BaseActivity;
import com.example.pfw.projectframework.config.Constant;
import com.example.pfw.projectframework.module.launch.contract.LoginContract;
import com.example.pfw.projectframework.module.launch.model.LoginModel;
import com.example.pfw.projectframework.module.launch.presenter.LoginPresenter;
import com.example.pfw.projectframework.utils.SPUtil;
import com.example.pfw.projectframework.utils.StateBarTranslucentUtils;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by wangfangqi on 16/8/20.
 * 登录
 */
public class LoginActivity extends BaseActivity<LoginPresenter, LoginModel> implements LoginContract.View {
//    @BindView(R.id.ll)
//    LinearLayout linearLayout;
//    @BindView(R.id.et_account)
//    ClearEditText etAccount;
//    @BindView(R.id.et_pass_word)
//    ClearEditText etPassWord;
//    @BindView(R.id.checkbox)
//    CheckBox checkBox;
//    @BindView(R.id.btn_login)
//    Button btnLogin;

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
        boolean isLogin = (boolean) SPUtil.get(this, Constant.LOGIN, false);
        if (isLogin) {
//            startActivity(new Intent(this, MainActivity.class));
            finish();
        }
    }

    @Override
    public void initView() {
//        LinearLayout.LayoutParams params = (LinearLayout.LayoutParams) linearLayout.getLayoutParams();
//        params.height = DensityUtil.getScreenHight(this) / 2;
//        linearLayout.setLayoutParams(params);
//        //设置文本长度监听
//        etAccount.addTextChangedListener(new TextChange());
//        etPassWord.addTextChangedListener(new TextChange());
//        checkBox.setOnCheckedChangeListener(new PasswordShowHide(etPassWord));
//        String mobile = (String) SPUtil.get(this, Constant.MOBILE, "");
//        etAccount.setText(mobile);
//        etAccount.setSelection(TextUtils.isEmpty(mobile) ? 0 : mobile.length());
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
