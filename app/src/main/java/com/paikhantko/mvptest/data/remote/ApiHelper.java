package com.paikhantko.mvptest.data.remote;

public interface ApiHelper {
    void getAllCovidCountries(long page,OnFinishListener onFinishListener);

    void disposeRequests();

    interface OnFinishListener{
        void onSuccess(Object...objects);
        void onError(String message);
    }
}
