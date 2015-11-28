package com.cogxio.android.test.utils;

import android.content.Context;
import android.location.Location;
import android.location.LocationManager;
import android.util.Log;

import com.google.android.gms.maps.model.LatLng;

/**
 * Created by Abhishek on 28/11/15.
 */
public class LocationUtils {

    private static final double BANGALORE_LATITUDE = 12.9715987;
    private static final double BANGALORE_LONGITUDE = 77.5945627;

    public static LatLng getUserLocation(Context context){

        LocationManager locationManager = (LocationManager) context.getSystemService(Context.LOCATION_SERVICE);

        if(locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER)){
            return getLocation(locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER));

        }else if(locationManager.isProviderEnabled(LocationManager.NETWORK_PROVIDER)){
            return getLocation(locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER));

        }else {
            return getLocation(null);
        }
    }

    private static LatLng getLocation(Location location){

        if(location != null){
            Log.e(String.valueOf(location.getLatitude()),String.valueOf(location.getLongitude()));
            return new LatLng(location.getLatitude(),location.getLongitude());
        }else{
            return new LatLng(BANGALORE_LATITUDE,BANGALORE_LONGITUDE);
        }
    }
}
