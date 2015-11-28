package com.cogxio.android.test.network.request.listener;

import android.content.Intent;
import android.widget.Toast;

import com.cogxio.android.test.R;
import com.cogxio.android.test.activity.MainActivity;
import com.cogxio.android.test.activity.SplashScreenActivity;
import com.cogxio.android.test.utils.SharedPreferencesUtils;
import com.google.gson.JsonObject;
import com.octo.android.robospice.persistence.exception.SpiceException;
import com.octo.android.robospice.request.listener.RequestListener;

/**
 * Created by Abhishek on 28/11/15.
 */
public class GetSnowyResultsRequestListener implements RequestListener<JsonObject> {

    private SplashScreenActivity activity;

    public GetSnowyResultsRequestListener(SplashScreenActivity activity){
        this.activity = activity;
    }

    @Override
    public void onRequestFailure(SpiceException spiceException) {
        Toast.makeText(activity,activity.getString(R.string.api_error),Toast.LENGTH_SHORT).show();
        activity.finish();
    }

    @Override
    public void onRequestSuccess(JsonObject jsonObject) {

        SharedPreferencesUtils.storeResultsString(activity,jsonObject.toString());
        activity.startActivity(new Intent(activity, MainActivity.class));
        activity.finish();
        activity.overridePendingTransition(R.anim.fab_out, R.anim.fab_in);
    }
}
