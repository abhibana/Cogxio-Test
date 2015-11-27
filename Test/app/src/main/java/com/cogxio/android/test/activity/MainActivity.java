package com.cogxio.android.test.activity;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;

import com.cogxio.android.test.R;

import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class MainActivity extends AppCompatActivity {

    private TabLayout snowyTabs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setLayoutElements();
    }

    private void setLayoutElements(){
        snowyTabs = (TabLayout) findViewById(R.id.snowy_tl);
        setUpTabs();
    }

    private void setUpTabs(){
        String tabs[] = getResources().getStringArray(R.array.tab_names);
        for(String tab:tabs){
            snowyTabs.addTab(snowyTabs.newTab().setText(tab));
        }
    }

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }
}
