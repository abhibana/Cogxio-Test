package com.cogxio.android.test.utils;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by Abhishek on 28/11/15.
 */
public class SharedPreferencesUtils {

    private static final String RESULTS_PREF_KEY = "results";

    public static void storeResultsString(Context context,String results){

        getSnowySharedPreference(context).edit().putString(RESULTS_PREF_KEY,results).apply();
    }

    public static String getStoredResults(Context context){

        return getSnowySharedPreference(context).getString(RESULTS_PREF_KEY,"");
    }

    private static SharedPreferences getSnowySharedPreference(Context context){

        String preferenceName = "SnowyPreference";
        return context.getSharedPreferences(preferenceName,Context.MODE_PRIVATE);
    }
}
