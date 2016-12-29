package com.example.pfw.projectframework.base;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;

import com.kaopiz.kprogresshud.KProgressHUD;

/**
 *
 */
public abstract class BasePresenter<E, T> {
    public Context context;
    public E mModel;
    public T mView;
    public RxManager mRxManager = new RxManager();
    public KProgressHUD hud;

    public void setVM(T v, E m) {
        if (v instanceof AppCompatActivity) {
            context = (AppCompatActivity) v;
        } else if (v instanceof Fragment) {
            context = ((Fragment) v).getContext();
        }
        this.mView = v;
        this.mModel = m;
        this.onStart();
    }

    public abstract void onStart();

    public void onDestroy() {
        mRxManager.clear();
        loadDismiss();
    }

    public void showLoading() {
        if (hud != null && hud.isShowing()) {
            hud.dismiss();
        }
        hud = KProgressHUD.create(context)
                .setStyle(KProgressHUD.Style.SPIN_INDETERMINATE)
                .show();
    }

    public void loadDismiss() {
        if (hud != null && hud.isShowing()) {
            hud.dismiss();
        }
    }
}
