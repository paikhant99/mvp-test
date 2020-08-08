package com.paikhantko.mvptest.di.module;

import android.app.Application;
import android.content.Context;

import com.paikhantko.mvptest.BuildConfig;
import com.paikhantko.mvptest.data.remote.ApiHelper;
import com.paikhantko.mvptest.data.remote.ApiHelperImpl;
import com.paikhantko.mvptest.data.remote.ApiService;
import com.paikhantko.mvptest.utils.rx.AppSchedulerProvider;
import com.paikhantko.mvptest.utils.rx.SchedulerProvider;

import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class AppModule {

    @Provides
    @Singleton
    Context provideContext(Application application){
        return application;
    }

    @Provides
    @Singleton
    OkHttpClient provideHttpClient(){
        return new OkHttpClient.Builder()
                .readTimeout(150, TimeUnit.SECONDS)
                .connectTimeout(150,TimeUnit.SECONDS)
                .build();
    }

    @Provides
    @Singleton
    Retrofit provideRetrofit(OkHttpClient okHttpClient){
        return new Retrofit.Builder().client(okHttpClient)
                .baseUrl(BuildConfig.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
    }

    @Provides
    @Singleton
    ApiService provideApiService(Retrofit retrofit){
        return retrofit.create(ApiService.class);
    }

    @Provides
    SchedulerProvider provideSchedulerProvider() {
        return new AppSchedulerProvider();
    }

    @Provides
    ApiHelper provideApiHelperImpl(ApiService apiService, SchedulerProvider schedulerProvider){
        return new ApiHelperImpl(apiService,schedulerProvider);
    }

}
