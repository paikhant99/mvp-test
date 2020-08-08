package com.paikhantko.mvptest.ui.main.presenter;

import com.paikhantko.mvptest.data.model.api.CovidApiResponse;
import com.paikhantko.mvptest.data.remote.ApiHelper;
import com.paikhantko.mvptest.ui.base.BasePresenterImpl;
import com.paikhantko.mvptest.ui.main.MainView;

public class MainPresenterImpl extends BasePresenterImpl implements MainPresenter {

    private final ApiHelper mApiHelper;
    private MainView mainView;

    public MainPresenterImpl(MainView view, ApiHelper apiHelper) {
        this.mainView=view;
        this.mApiHelper=apiHelper;
    }

    @Override
    public void loadCovidCountriesList(long page) {
        mApiHelper.getAllCovidCountries(page,this);
    }

    @Override
    public void onSuccess(Object... objects) {
        for (Object object:objects){
            if (object instanceof CovidApiResponse){
                mainView.displayData(((CovidApiResponse) object).getData().getRows());
                mainView.updateTotalPages(((CovidApiResponse) object).getData().getPaginationMeta().getTotalPages());
            }
        }
    }

    @Override
    public void onError(String message) {
        mainView.showToast(message);
    }

    @Override
    public void onDestroy() {
        mApiHelper.disposeRequests();
        if (mainView != null){
            mainView = null;
        }
    }
}
