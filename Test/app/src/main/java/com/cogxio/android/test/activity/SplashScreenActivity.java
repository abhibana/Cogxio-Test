package com.cogxio.android.test.activity;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.widget.Toast;

import com.cogxio.android.test.R;
import com.cogxio.android.test.network.request.GetSnowyResultsRequest;
import com.cogxio.android.test.network.request.listener.GetSnowyResultsRequestListener;
import com.cogxio.android.test.utils.NetworkUtils;

import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

/**
 * Created by Abhishek on 28/11/15.
 */
public class SplashScreenActivity extends SnowyBaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        final int SPLASH_DURATION = 1000;

        if(NetworkUtils.isConnectedToNet(this)){
            fetchSnowyResults();
        }else{
            Toast.makeText(this,getString(R.string.no_network),Toast.LENGTH_SHORT).show();
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    finish();
                }
            }, SPLASH_DURATION);
        }
    }

    private void fetchSnowyResults(){

        GetSnowyResultsRequest getSnowyResultsRequest = new GetSnowyResultsRequest();
        getSnowySpiceManager().execute(getSnowyResultsRequest,new GetSnowyResultsRequestListener(this));
    }

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }
}
