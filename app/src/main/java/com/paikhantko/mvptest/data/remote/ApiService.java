package com.paikhantko.mvptest.data.remote;

import com.paikhantko.mvptest.data.model.api.CovidApiResponse;

import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiService {
    @GET("countries-search")
    Single<CovidApiResponse> getAllCovidApiResponses(@Query("page")long page);
}
