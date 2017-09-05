package com.example.katecatlin.womenrisingandroid.services;

/**
 * Created by katecatlin on 9/4/17.
 */

import retrofit2.Retrofit;

public class ServiceFactory {

    /**
     * Creates a retrofit service from an arbitrary class (clazz)
     * @param clazz Java interface of the retrofit service
     * @param endPoint REST endpoint url
     * @return retrofit service with defined endpoint
     */

    public static <T> T createRetrofitService(final Class<T> clazz, final String endPoint) {
        final Retrofit restAdapter = new Retrofit().Builder()
                .setEndpoint(endPoint)
                .build();
        T service = restAdapter.create(clazz);

        return service;
    }
}