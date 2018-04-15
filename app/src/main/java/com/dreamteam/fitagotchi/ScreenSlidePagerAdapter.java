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
    ProfileFragment pf = null;
    ExcerciseFragment ef = null;
    @Override
    public Fragment getItem(int position) {
        if(position == 0)
        {
            if(pf == null) {
                pf = new ProfileFragment();
                pf.setProfileFragment(email);
            }
            return pf;
        }
        else if(position == 1)
        {
            return new PetFragment();
        }
        else if (position ==2)
        {
            if(ef == null)
                ef = new ExcerciseFragment();
            return ef;
        }
        else {
            return new PetFragment();
        }

    }

    @Override
    public int getCount() {
        return NUM_PAGES;
    }
}