package com.cogxio.android.test.network.request.listener;

import android.content.Context;

import com.cogxio.android.test.utils.SharedPreferencesUtils;
import com.google.gson.JsonObject;
import com.octo.android.robospice.persistence.exception.SpiceException;
import com.octo.android.robospice.request.listener.RequestListener;

/**
 * Created by Abhishek on 28/11/15.
 */
public class GetSnowyResultsRequestListener implements RequestListener<JsonObject> {

    private Context context;

    public GetSnowyResultsRequestListener(Context context){
        this.context = context;
    }

    @Override
    public void onRequestFailure(SpiceException spiceException) {

    }

    @Override
    public void onRequestSuccess(JsonObject jsonObject) {

        SharedPreferencesUtils.storeResultsString(context,jsonObject.toString());
    }
}
