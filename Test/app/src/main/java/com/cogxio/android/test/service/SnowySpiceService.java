package com.cogxio.android.test.service;

import com.cogxio.android.test.network.SnowyRetrofitInterface;
import com.octo.android.robospice.retrofit.RetrofitGsonSpiceService;

import retrofit.RestAdapter;

/**
 * Created by Abhishek on 28/11/15.
 */
public class SnowySpiceService extends RetrofitGsonSpiceService {

    private final String BASE_URL = "https://api.import.io/store/data/85f69b3f-b0a7-4f14-80e1-682ff325d4f2/_query?input/webpage/url=http%3A%2F%2Fowlkingdom.com%2F&_user=a31791af-10fa-4234-9e23-508d6c7838e7&_" +
            "apikey=EHJSRe1mjAgGkREpxEh4nTK385HVh1apflVdRjtwHW";

    @Override
    public void onCreate() {
        super.onCreate();
        addRetrofitInterface(SnowyRetrofitInterface.class);
    }

    @Override
    protected RestAdapter.Builder createRestAdapterBuilder() {
        return new RestAdapter.Builder()
                .setEndpoint(BASE_URL)
                .setLogLevel(RestAdapter.LogLevel.FULL);
    }

    @Override
    protected String getServerUrl() {
        return BASE_URL;
    }
}
