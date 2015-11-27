package com.cogxio.android.test;

import android.app.Application;

import uk.co.chrisjenx.calligraphy.CalligraphyConfig;

/**
 * Created by Abhishek on 28/11/15.
 */
public class SnowyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        CalligraphyConfig.initDefault(new CalligraphyConfig.Builder()
                        .setDefaultFontPath("font/CaviarDreams.ttf")
                        .setFontAttrId(R.attr.fontPath)
                        .build()
        );
    }
}
