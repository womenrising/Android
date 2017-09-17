package com.example.katecatlin.womenrisingandroid.services;

import com.example.katecatlin.womenrisingandroid.interfaces.WomenRisingService;
import com.example.katecatlin.womenrisingandroid.models.Profile;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

/**
 * Created by katecatlin on 9/4/17.
 */

public class RetrofitHelper {

    /**
     * Communicate with the json api.
     */
    public WomenRisingService getWomenRisingService() {
        final Retrofit retrofit = createRetrofit();
        return retrofit.create(WomenRisingService.class);
    }

    /**
     * Creates a pre configured Retrofit instance
     */
    private Retrofit createRetrofit() {
        return new Retrofit.Builder()
                .baseUrl("http://www.womenrising.co//api/v1/users/")
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create()) // <- add this
                .build();
    }
}