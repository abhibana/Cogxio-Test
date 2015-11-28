package com.cogxio.android.test.network;

import com.google.gson.JsonObject;

import retrofit.http.GET;

/**
 * Created by Abhishek on 28/11/15.
 */
public interface SnowyRetrofitInterface {

    String API_KEY = "/7mIYy0a6meoIXt5MGQHQUFJxRBSORj8SnAWvoelhctw==";
    @GET(API_KEY)
    JsonObject getSnowyResults();
}
