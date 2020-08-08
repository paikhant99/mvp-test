package com.paikhantko.mvptest.di.builder;

import com.paikhantko.mvptest.di.module.main.MainActivityModule;
import com.paikhantko.mvptest.di.module.main.MainViewModule;
import com.paikhantko.mvptest.ui.main.MainActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ActivityBuilder {
    @ContributesAndroidInjector(modules = {
            MainActivityModule.class, MainViewModule.class
    })
    abstract MainActivity bindMainActivity();
}
