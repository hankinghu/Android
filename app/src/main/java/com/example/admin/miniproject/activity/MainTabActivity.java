package com.example.admin.miniproject.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;

import com.example.admin.miniproject.R;
import com.example.admin.miniproject.adpater.MainTabHolderAdapter;
import com.example.admin.miniproject.fragment.HomeTabFragment;
import com.example.admin.miniproject.fragment.PersonalTabFragment;
import com.example.admin.miniproject.fragment.PublishTabFragment;
import com.example.admin.miniproject.helper.NoScrollViewPager;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hanking on 2018/9/2.
 * Copyright (c) 2018 Xunlei. All rights reserved.
 *
 * @author hanking
 */
public class MainTabActivity extends AppCompatActivity {
    private TabLayout mTabLayout;
    private List<Fragment> fragmentList;
    private NoScrollViewPager noScrollViewPager;
    private String[] titles = new String[]
            {
                    "首页", "发布", "我的"
            };
    private int[] icons = new int[]{
            R.drawable.home_tab_layout, R.drawable.publish_tab_layout_icon, R.drawable.personal_tab_layout
    };
    private int[] iconsPress = new int[]{
            R.drawable.home_tab_press, R.drawable.publish_tab_layout_icon, R.drawable.personal_tab_press
    };
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_tab_layout);
        initView();
    }

    private void initView() {
        mTabLayout = findViewById(R.id.bottom_tab_layout);
        noScrollViewPager = findViewById(R.id.main_noScroll_viewPager);
        fragmentList = new ArrayList<>();
        fragmentList.add(new HomeTabFragment());
        fragmentList.add(new PublishTabFragment());
        fragmentList.add(new PersonalTabFragment());
        noScrollViewPager.setAdapter(new MainTabHolderAdapter(getSupportFragmentManager(), fragmentList, titles));
        mTabLayout.setupWithViewPager(noScrollViewPager);
        mTabLayout.removeAllTabs();
        for (int i = 0; i < titles.length; ++i) {
            TabLayout.Tab mTab = mTabLayout.newTab();
            mTab.setText(titles[i]);
            mTab.setIcon(icons[i]);
            if(i==0)
            {
                mTab.setIcon(iconsPress[i]);
            }
            mTabLayout.addTab(mTab);
        }
        mTabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                tab.setIcon(iconsPress[tab.getPosition()]);
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                tab.setIcon(icons[tab.getPosition()]);
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(Intent.ACTION_MAIN);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.addCategory(Intent.CATEGORY_HOME);
        startActivity(intent);
    }
}
