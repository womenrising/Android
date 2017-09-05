package com.example.katecatlin.womenrisingandroid.interfaces;

import android.database.Observable;

import com.example.katecatlin.womenrisingandroid.models.Profile;

import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by katecatlin on 9/4/17.
 */

public interface WomenRisingService {
    String SERVICE_ENDPOINT = "http://www.womenrising.co/api/v1/users";

    @GET("/#{user.id}")
    Observable<Profile> getUser(@Path("userID") String userID);
}
