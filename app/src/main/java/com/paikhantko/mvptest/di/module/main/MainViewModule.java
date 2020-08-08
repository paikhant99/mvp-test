package com.paikhantko.mvptest.di.module.main;

import com.paikhantko.mvptest.ui.main.MainActivity;
import com.paikhantko.mvptest.ui.main.MainView;

import dagger.Binds;
import dagger.Module;

@Module
public abstract class MainViewModule {
    @Binds
    abstract MainView provideMainView(MainActivity mainActivity);
}
