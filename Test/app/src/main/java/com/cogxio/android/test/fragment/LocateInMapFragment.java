package com.cogxio.android.test.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.cogxio.android.test.R;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

/**
 * Created by Abhishek on 28/11/15.
 */
public class LocateInMapFragment extends Fragment {

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_maps, container, false);
        FragmentManager fManager= getChildFragmentManager();
        SupportMapFragment mapFragment = (SupportMapFragment) fManager.findFragmentById(R.id.map);
        mapFragment.getMapAsync(new OnMapReadyCallback()
        {
            public void onMapReady(GoogleMap map)
            {
                if (map == null)
                {
                    // showToast(getActivity(),
//                    "Sorry! unable to create maps");
                } else
                {
//                    googleMap = map;
//                    googleMap.getUiSettings().setCompassEnabled(true);
//                    googleMap.getUiSettings().setZoomControlsEnabled(true);
//                    googleMap.getUiSettings().setMyLocationButtonEnabled(false);
//                    googleMap.getUiSettings().setRotateGesturesEnabled(true);
                    LatLng sydney = new LatLng(-34, 151);
//                    GoogleMap map = getMap();
                    map.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
                    map.moveCamera(CameraUpdateFactory.newLatLng(sydney));
                }
            }
        });
        return rootView;
    }

//    @Override
//    public void onMapReady(GoogleMap googleMap) {
//        // Add a marker in Sydney, Australia, and move the camera.
//        LatLng sydney = new LatLng(-34, 151);
//        GoogleMap map = getMap();
//        map.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
//        map.moveCamera(CameraUpdateFactory.newLatLng(sydney));
//    }
}
