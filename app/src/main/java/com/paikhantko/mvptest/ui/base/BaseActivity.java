package com.paikhantko.mvptest.ui.base;

import android.os.Bundle;

import androidx.annotation.LayoutRes;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

import dagger.android.AndroidInjection;

public abstract class BaseActivity<T extends ViewDataBinding> extends AppCompatActivity {

    private T mViewDataBinding;

    /**
     * @return layout resource id
     */
    protected abstract
    @LayoutRes
    int getLayoutId();

    protected T getViewDataBinding() {
        return mViewDataBinding;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        performDependencyInjection();
        performDataBinding();
    }

    private void performDataBinding() {
        mViewDataBinding= DataBindingUtil.setContentView(this,getLayoutId());
        mViewDataBinding.executePendingBindings();
    }

    private void performDependencyInjection() {
        AndroidInjection.inject(this);
    }
}
