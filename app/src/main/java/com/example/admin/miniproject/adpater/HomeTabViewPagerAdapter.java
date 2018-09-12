package com.example.admin.miniproject.adpater;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by hanking on 2018/8/27.
 * Copyright (c) 2018 Xunlei. All rights reserved.
 *
 * @author hanking
 */
public class HomeTabViewPagerAdapter extends FragmentPagerAdapter {
    private List<String> mTabTitles;
    private List<Fragment> mFragmentList;
    public HomeTabViewPagerAdapter(FragmentManager fm,List<Fragment> mFragmentList,List<String> mTabTitles) {
        super(fm);
        this.mFragmentList=mFragmentList;
        this.mTabTitles=mTabTitles;
    }

    @Override
    public Fragment getItem(int i) {
        return mFragmentList.get(i);
    }

    @Override
    public int getCount() {
        return mFragmentList.size();
    }
    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return mTabTitles.get(position);

    }
}
