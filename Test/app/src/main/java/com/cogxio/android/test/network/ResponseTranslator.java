package com.cogxio.android.test.network;

import com.cogxio.android.test.network.response.SnowyResult;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import java.util.ArrayList;

/**
 * Created by Abhishek on 28/11/15.
 */
public class ResponseTranslator {

    private static Gson gson = new Gson();

    public static ArrayList<SnowyResult> getSnowyResultList(JsonObject snowyResultJson){

        ArrayList<SnowyResult> snowyResultsList = new ArrayList<>();
        JsonArray snowyResultsArray = snowyResultJson.getAsJsonArray(ResponseKeys.RESULTS);

        for(JsonElement snowyResult:snowyResultsArray){
            snowyResultsList.add(getSnowyResult(snowyResult.getAsJsonObject()));
        }

        return snowyResultsList;
    }

    private static SnowyResult getSnowyResult(JsonObject snowyResult){

        return gson.fromJson(snowyResult,SnowyResult.class);
    }

    public interface ResponseKeys {
        String RESULTS = "results";
    }
}
