package com.example.pfw.projectframework.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.example.pfw.projectframework.utils.TUtil;

import butterknife.ButterKnife;
import butterknife.Unbinder;
import me.yokeyword.fragmentation_swipeback.SwipeBackFragment;

/**
 * Fragment基类
 */
public abstract class BaseFragment<T extends BasePresenter, E extends BaseModel> extends SwipeBackFragment {

    public T mPresenter;
    public E mModel;
    private Unbinder unbinder;

    @Nullable
    @Override
    @SuppressWarnings("unchecked")
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(getLayoutId(), container, false);
        unbinder = ButterKnife.bind(this, view);
        if (this instanceof BaseView) {
            mPresenter = TUtil.getT(this, 0);
            mModel = TUtil.getT(this, 1);
            mPresenter.setVM(this, mModel);
        }
        initView();
        return attachToSwipeBack(view);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
        if (mPresenter != null) mPresenter.onDestroy();
    }

    public abstract int getLayoutId();

    public abstract void initView();
}
