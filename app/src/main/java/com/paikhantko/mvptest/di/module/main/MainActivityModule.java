package com.paikhantko.mvptest.di.module.main;

import com.paikhantko.mvptest.data.remote.ApiHelper;
import com.paikhantko.mvptest.ui.main.MainCovidResponseAdapter;
import com.paikhantko.mvptest.ui.main.presenter.MainPresenter;
import com.paikhantko.mvptest.ui.main.presenter.MainPresenterImpl;
import com.paikhantko.mvptest.ui.main.MainView;

import java.util.ArrayList;

import dagger.Module;
import dagger.Provides;

@Module
public class MainActivityModule {

    @Provides
    public MainPresenter provideMainPresenter(MainView view, ApiHelper apiHelper){
        return new MainPresenterImpl(view,apiHelper);
    }

    @Provides
    public MainCovidResponseAdapter provideMainCovidResponseAdapter(){
        return new MainCovidResponseAdapter(new ArrayList<>());
    }
}
