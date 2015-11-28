package com.cogxio.android.test.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.cogxio.android.test.activity.MainActivity;
import com.cogxio.android.test.fragment.GetSnowyFragment;
import com.cogxio.android.test.fragment.LocateInMapFragment;
import com.cogxio.android.test.fragment.WelcomeFragment;

/**
 * Created by Abhishek on 28/11/15.
 */
public class SnowyPagerAdapter extends FragmentPagerAdapter {

    private int pagerSize;
    private MainActivity mainActivity;

    public SnowyPagerAdapter(MainActivity mainActivity,FragmentManager fragmentManager,int pagerSize){
        super(fragmentManager);
        this.mainActivity = mainActivity;
        this.pagerSize = pagerSize;
    }

    @Override
    public Fragment getItem(int position) {

        if(position == 0){
            return new WelcomeFragment();
        }else if(position == 1){
            return new GetSnowyFragment();
        }else {
            return new LocateInMapFragment();
        }
    }

    @Override
    public int getCount() {
        return pagerSize;
    }
}
