package com.example.ebookportal.Adapters;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.example.ebookportal.Fragments.EverythingFragment;
import com.example.ebookportal.Fragments.SuggestedFragment;

public class PagerAdapter extends FragmentStatePagerAdapter {

    int tabsCount;
    public PagerAdapter(@NonNull FragmentManager fm, int count) {
        super(fm, count);
        this.tabsCount = count;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new SuggestedFragment();
            case 1:
                return new EverythingFragment();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return tabsCount;
    }
}
