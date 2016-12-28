package com.example.pfw.projectframework.helper;

import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.widget.CompoundButton;
import android.widget.EditText;

/**
 * Created by wangfangqi on 16/8/25.
 * 显示隐藏密码状态
 */
public class PasswordShowHide implements CompoundButton.OnCheckedChangeListener {

    private EditText editText;

    public PasswordShowHide(EditText editText) {
        this.editText = editText;
    }

    @Override
    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
        if (b)
            editText.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
        else
            editText.setTransformationMethod(PasswordTransformationMethod.getInstance());
        editText.setSelection(editText.getText().toString().length());
    }
}
