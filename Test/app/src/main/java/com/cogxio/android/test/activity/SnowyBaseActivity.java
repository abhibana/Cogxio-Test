package com.cogxio.android.test.activity;

import android.support.v7.app.AppCompatActivity;

import com.cogxio.android.test.service.SnowySpiceService;
import com.octo.android.robospice.SpiceManager;

/**
 * Created by Abhishek on 28/11/15.
 */
public class SnowyBaseActivity extends AppCompatActivity {

    private SpiceManager snowySpiceManager = new SpiceManager(SnowySpiceService.class);

    @Override
    protected void onStart() {
        super.onStart();
        snowySpiceManager.start(this);
    }

    @Override
    protected void onStop() {
        super.onStop();
        snowySpiceManager.shouldStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        snowySpiceManager.removeAllDataFromCache();
    }

    public SpiceManager getSnowySpiceManager(){ return  snowySpiceManager; }
}
