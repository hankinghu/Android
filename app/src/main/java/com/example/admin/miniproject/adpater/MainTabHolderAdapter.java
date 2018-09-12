package com.example.admin.miniproject.adpater;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by hanking on 2018/9/3.
 * Copyright (c) 2018 Xunlei. All rights reserved.
 *
 * @author hanking
 */
public class MainTabHolderAdapter extends FragmentPagerAdapter {
    private List<Fragment> fragmentList;
    private String []tabTitles;
    public MainTabHolderAdapter(FragmentManager fm, List<Fragment> fragments, String []tabTitles) {
        super(fm);
        this.fragmentList=fragments;
        this.tabTitles=tabTitles;
    }

    @Override
    public Fragment getItem(int i) {
        return fragmentList.get(i);
    }

    @Override
    public int getCount() {
        return fragmentList.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return tabTitles[position];
    }

}
