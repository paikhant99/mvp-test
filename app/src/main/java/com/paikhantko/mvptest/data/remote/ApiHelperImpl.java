package com.paikhantko.mvptest.data.remote;

import com.paikhantko.mvptest.utils.rx.SchedulerProvider;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;

public class ApiHelperImpl implements ApiHelper {

    private final ApiService apiService;
    private final SchedulerProvider mSchedulerProvider;
    private CompositeDisposable mCompositeDisposable;

    @Inject
    public ApiHelperImpl(ApiService apiService, SchedulerProvider schedulerProvider) {
        this.apiService = apiService;
        this.mSchedulerProvider = schedulerProvider;
        this.mCompositeDisposable = new CompositeDisposable();
    }

    @Override
    public void getAllCovidCountries(long page,OnFinishListener listener) {
        mCompositeDisposable.add(apiService.getAllCovidApiResponses(page)
                .subscribeOn(mSchedulerProvider.io())
                .observeOn(mSchedulerProvider.ui())
                .subscribe(listener::onSuccess, throwable -> listener.onError(throwable.getMessage())));
    }

    @Override
    public void disposeRequests() {
        mCompositeDisposable.dispose();
        if (mCompositeDisposable != null) {
            mCompositeDisposable = null;
        }
    }
}
