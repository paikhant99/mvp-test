package com.paikhantko.mvptest.ui.main.presenter;

import com.paikhantko.mvptest.ui.base.BasePresenter;

public interface MainPresenter extends BasePresenter {
    void loadCovidCountriesList(long page);
}
