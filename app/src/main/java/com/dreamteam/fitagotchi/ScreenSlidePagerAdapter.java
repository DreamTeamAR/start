package com.dreamteam.fitagotchi;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

class ScreenSlidePagerAdapter extends FragmentStatePagerAdapter {
    private static final int NUM_PAGES = 4;
    private String email;
    public ScreenSlidePagerAdapter(FragmentManager fm, String email) {
        super(fm);
        this.email = email;
    }

    @Override
    public Fragment getItem(int position) {
        ProfileFragment temp = new ProfileFragment();
        temp.setProfileFragment(email);
        return temp;
    }

    @Override
    public int getCount() {
        return NUM_PAGES;
    }
}