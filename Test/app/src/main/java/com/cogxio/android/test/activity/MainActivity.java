package com.cogxio.android.test.activity;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.cogxio.android.test.R;
import com.cogxio.android.test.adapter.SnowyPagerAdapter;

import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class MainActivity extends AppCompatActivity {

    private TabLayout snowyTabs;
    private ViewPager snowyVp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setLayoutElements();
    }

    private void setLayoutElements(){
        snowyTabs = (TabLayout) findViewById(R.id.snowy_tl);
        setUpTabs();
        snowyVp = (ViewPager) findViewById(R.id.snowy_vp);
        snowyVp.setAdapter(new SnowyPagerAdapter(this,getSupportFragmentManager(),snowyTabs.getTabCount()));
        snowyVp.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(snowyTabs));
    }

    private void setUpTabs(){
        String tabs[] = getResources().getStringArray(R.array.tab_names);
        for(String tab:tabs){
            snowyTabs.addTab(snowyTabs.newTab().setText(tab));
        }
        snowyTabs.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                snowyVp.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

    ViewPager.OnPageChangeListener snowyPageChangeListener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {
        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }
}
