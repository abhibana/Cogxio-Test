package com.cogxio.android.test.network.request;

import com.cogxio.android.test.network.SnowyRetrofitInterface;
import com.google.gson.JsonObject;
import com.octo.android.robospice.request.retrofit.RetrofitSpiceRequest;

/**
 * Created by Abhishek on 28/11/15.
 */
public class GetSnowyResultsRequest extends RetrofitSpiceRequest<JsonObject,SnowyRetrofitInterface> {

    public GetSnowyResultsRequest(){
        super(JsonObject.class,SnowyRetrofitInterface.class);
    }

    @Override
    public JsonObject loadDataFromNetwork() throws Exception {
        return getService().getSnowyResults();
    }
}
