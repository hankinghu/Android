package com.example.admin.miniproject.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.admin.miniproject.R;
import com.example.admin.miniproject.adpater.HomeTabViewPagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hanking on 2018/8/27.
 * Copyright (c) 2018 Xunlei. All rights reserved.
 *
 * @author hanking
 */
public class HomeTabFragment extends Fragment {
    private TabLayout homeTabLayout;
    private ViewPager homeViewPager;
    private List<Fragment> fragmentList;
    private List<String> tabTitles;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate(R.layout.home_tab_fragment_layout, container, false);
        initView(view);
        return view;
    }
    public void initView(View view)
    {
        fragmentList=new ArrayList<>();
        tabTitles=new ArrayList<>();
        fragmentList.add(new RecommendFragment());
        fragmentList.add(new PopularFragment());
        fragmentList.add(new XWTDynamicFragment());
        tabTitles.add("推荐");
        tabTitles.add("热门榜");
        tabTitles.add("XWT动态");

        homeTabLayout=view.findViewById(R.id.home_tabLayout);
        homeViewPager=view.findViewById(R.id.home_viewPager);
        FragmentManager fragmentManager=getChildFragmentManager();
        homeViewPager.setAdapter(new HomeTabViewPagerAdapter(fragmentManager,fragmentList,tabTitles));
        homeViewPager.setOffscreenPageLimit(2);
        homeTabLayout.setupWithViewPager(homeViewPager);



    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Nullable
    @Override
    public View getView() {
        return super.getView();
    }

    @Override
    public void onStart() {
        super.onStart();
    }

    @Override
    public void onResume() {
        super.onResume();
    }

}
