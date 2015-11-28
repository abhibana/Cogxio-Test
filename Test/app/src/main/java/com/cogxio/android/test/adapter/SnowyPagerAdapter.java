package com.cogxio.android.test.adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.cogxio.android.test.fragment.LocateInMapFragment;
import com.cogxio.android.test.fragment.WelcomeFragment;

/**
 * Created by Abhishek on 28/11/15.
 */
public class SnowyPagerAdapter extends FragmentPagerAdapter {

    private Context context;
    private int pagerSize;

    public SnowyPagerAdapter(Context context,FragmentManager fragmentManager,int pagerSize){
        super(fragmentManager);
        this.context = context;
        this.pagerSize = pagerSize;
    }

    @Override
    public Fragment getItem(int position) {
        if(position == 0){
            return new WelcomeFragment();
        }
        return new LocateInMapFragment();
    }

    @Override
    public int getCount() {
        return pagerSize;
    }
}
