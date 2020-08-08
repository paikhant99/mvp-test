package com.paikhantko.mvptest.ui.base;

import com.paikhantko.mvptest.data.remote.ApiHelper;

public class BasePresenterImpl implements ApiHelper.OnFinishListener {

    @Override
    public void onSuccess(Object... objects) {

    }

    @Override
    public void onError(String message) {

    }
}
