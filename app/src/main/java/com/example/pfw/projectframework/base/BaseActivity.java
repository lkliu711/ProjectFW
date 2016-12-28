package com.example.pfw.projectframework.base;

import android.os.Bundle;

import com.example.pfw.projectframework.R;
import com.example.pfw.projectframework.utils.StateBarTranslucentUtils;
import com.example.pfw.projectframework.utils.TUtil;

import butterknife.ButterKnife;
import me.yokeyword.fragmentation.SwipeBackLayout;
import me.yokeyword.fragmentation.anim.DefaultNoAnimator;
import me.yokeyword.fragmentation.anim.FragmentAnimator;
import me.yokeyword.fragmentation_swipeback.SwipeBackActivity;

/**
 * Created by Administrator on 2016/4/5.
 */
public abstract class BaseActivity<T extends BasePresenter, E extends BaseModel> extends SwipeBackActivity {
    public T mPresenter;
    public E mModel;

    @Override
    @SuppressWarnings("unchecked")
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        StateBarTranslucentUtils.setStateBarTranslucent(this);
        setContentView(this.getLayoutId());
        setStatusColor();
        onSavedState(savedInstanceState);
        ButterKnife.bind(this);
        if (this instanceof BaseView) {
            mPresenter = TUtil.getT(this, 0);
            mModel = TUtil.getT(this, 1);
            mPresenter.setVM(this, mModel);
        }
        this.initView();
        getSwipeBackLayout().setEdgeOrientation(SwipeBackLayout.EDGE_LEFT);
        ActivityCollector.addActivity(this);
    }

    //    @Override
//    protected void attachBaseContext(Context newBase) {
//        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
//    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mPresenter != null) mPresenter.onDestroy();
        ActivityCollector.removeActivity(this);
    }

    @Override
    protected FragmentAnimator onCreateFragmentAnimator() {
        return new DefaultNoAnimator();
    }

    protected void setStatusColor() {
        StateBarTranslucentUtils.setStateBarColor(this, R.color.ksw_md_solid_checked_disable);
    }

    public abstract int getLayoutId();

    public abstract void onSavedState(Bundle savedInstanceState);

    public abstract void initView();
}
