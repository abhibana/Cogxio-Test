package com.cogxio.android.test.activity;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import com.cogxio.android.test.R;
import com.cogxio.android.test.adapter.SnowyPagerAdapter;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class MainActivity extends SnowyBaseActivity{

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
        snowyVp.setOffscreenPageLimit(2);
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

//    private void setUpFloatingActionMenu() {

//        ImageView icon = new ImageView(this);
//        icon.setImageDrawable(getResources().getDrawable(R.drawable.ic_add));
//        actionButton = new FloatingActionButton.Builder(this).setContentView(icon).build();
//
//        SubActionButton.Builder itemBuilder = new SubActionButton.Builder(this);
//
////                .setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.colorPrimary)));
//
//        ImageView addIcon = new ImageView(this);
//        addIcon.setImageDrawable(getResources().getDrawable(R.drawable.ic_create));
//        SubActionButton createButton = itemBuilder.setContentView(addIcon).build();
//
//        ImageView deleteIcon = new ImageView(this);
//        deleteIcon.setImageDrawable(getResources().getDrawable(R.drawable.ic_delete));
//        SubActionButton deleteButton = itemBuilder.setContentView(deleteIcon).build();
//
//        ImageView sendIcon = new ImageView(this);
//        sendIcon.setImageDrawable(getResources().getDrawable(R.drawable.ic_send));
//        SubActionButton sendButton = itemBuilder.setContentView(sendIcon).build();
//
//        FloatingActionMenu actionMenu = new FloatingActionMenu.Builder(this)
//                .addSubActionView(createButton)
//                .addSubActionView(deleteButton)
//                .addSubActionView(sendButton)
//                .attachTo(actionButton)
//                .build();
//        actionButton.setVisibility(View.GONE);
////        actionButton.setBackgroundResource(R.color.colorPrimary);
//    }
//
//    public void hideOrShowFloatingActionButton(){
//
//        if (position == 1) {
//            actionButton.setVisibility(View.VISIBLE);
//        } else {
//            actionButton.setVisibility(View.GONE);
//        }
//    }

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }

}
