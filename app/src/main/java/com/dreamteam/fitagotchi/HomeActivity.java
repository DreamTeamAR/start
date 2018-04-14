package com.dreamteam.fitagotchi;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;


public class HomeActivity extends AppCompatActivity {

    private String email;
    private ViewPager mPager;
    private PagerAdapter pagerAdapter;
    int[] bottomNavElements = new int[4];
    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment fragment;
            switch (item.getItemId()) {
                case R.id.nav_profile:

                    mPager.setCurrentItem(0);
                    return true;
                case R.id.nav_msg:

                    mPager.setCurrentItem(1);
                    return true;
                case R.id.nav_quest:

                    mPager.setCurrentItem(2);
                    return true;
                case R.id.nav_settings:

                    mPager.setCurrentItem(3);
                    return true;
            }
            return false;
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_activity);
        email = getIntent().getStringExtra("email");
        bottomNavElements[0] = R.id.nav_profile;
        bottomNavElements[1] = R.id.nav_msg;
        bottomNavElements[2] = R.id.nav_quest;
        bottomNavElements[3] = R.id.nav_settings;
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        mPager = findViewById(R.id.pager);
        pagerAdapter = new ScreenSlidePagerAdapter(getSupportFragmentManager(), email);
        mPager.setAdapter(pagerAdapter);
        mPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            public void onPageScrollStateChanged(int state) {
            }

            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }

            public void onPageSelected(int position) {
                navigation.setSelectedItemId(bottomNavElements[position]);
                navigation.performClick();
            }
        });

        // Write a message to the database

    }



}

