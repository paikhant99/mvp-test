package com.paikhantko.mvptest.di.component;

import android.app.Application;

import com.paikhantko.mvptest.MVPTestApp;
import com.paikhantko.mvptest.di.builder.ActivityBuilder;
import com.paikhantko.mvptest.di.module.AppModule;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjectionModule;

@Singleton
@Component(modules = {AndroidInjectionModule.class,AppModule.class, ActivityBuilder.class})
public interface AppComponent {

    void inject(MVPTestApp app);

    @Component.Builder
    interface Builder{

        @BindsInstance
        Builder application(Application application);

        AppComponent build();
    }

}
