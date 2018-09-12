package com.example.admin.miniproject.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.admin.miniproject.R;
import com.example.admin.miniproject.adpater.RecommendFragmentViewPagerAdapter;
import com.example.admin.miniproject.entity.NewsTitle;
import com.example.admin.miniproject.entity.UserInfo;

import java.util.ArrayList;

/**
 * Created by hanking on 2018/9/2.
 * Copyright (c) 2018 Xunlei. All rights reserved.
 *
 * @author hanking
 */
public class RecommendFragment extends Fragment {
    private RecyclerView mRecyclerView;
    private RecommendFragmentViewPagerAdapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private SwipeRefreshLayout swipeLayout;
    private ArrayList<UserInfo> userInfos;
    private ArrayList<NewsTitle> newsTitles;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate(R.layout.recommend_fragment_layout, container, false);
        userInfos = new ArrayList<>();
        newsTitles = new ArrayList<>();
        initData();
        initView(view);
        return view;

    }
    public void initData()
    {
        for (int i = 0; i < 5; ++i) {
            newsTitles.add(new NewsTitle());
        }
    }
    public void initView(View view) {
        mRecyclerView = view.findViewById(R.id.recommend_recycler);
        swipeLayout = view.findViewById(R.id.my_recommend_swipe);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(getContext());
        mRecyclerView.setLayoutManager(mLayoutManager);
        mAdapter = new RecommendFragmentViewPagerAdapter(newsTitles,getContext());
        mRecyclerView.setAdapter(mAdapter);
        swipeLayout.setOnRefreshListener(new myOnRefreshListener());
    }

    class myOnRefreshListener implements SwipeRefreshLayout.OnRefreshListener {
        @Override
        public void onRefresh() {
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    swipeLayout.setRefreshing(false);
                }
            }, 1000);
        }
    }

}