package com.example.admin.miniproject.fragment;

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
import com.example.admin.miniproject.adpater.PopularHolderAdapter;
import com.example.admin.miniproject.entity.PopularItem;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hanking on 2018/9/2.
 * Copyright (c) 2018 Xunlei. All rights reserved.
 *
 * @author hanking
 */
public class PopularFragment extends Fragment{
    private SwipeRefreshLayout mSwipeRefresh;
    private RecyclerView mRecyclerView;
    private RecyclerView.LayoutManager mLayoutManager;
    private PopularHolderAdapter holderAdapter;
    private List<PopularItem> popularItems;
    private static final String TAG=PopularFragment.class.getClass().getSimpleName();
    private String titleString="身为程序员碰到最奇葩的需求是怎样的？";
    private String titleContentString="做了10多年的BIOS和FW。某一天一亲戚打电话给我，说他有个朋友公司做了块板子，固件一直又问题，让我帮他重写一套，改天请我吃饭。我一听就觉得不妙，婉拒了，跟他说我已经两年多没写过代码了，可以介绍一个朋友给他，专门做外包的。后来做外包的朋友跟我吐槽，亲戚的朋友带了一块工控板，让他重写个BIOS。我朋友看了之后，给了个友情价，8万，对方一脸懵逼的问，写个程序还要钱？\n" +
            "\n" +
            "作者：Rossi\n" +
            "链接：https://www.zhihu.com/question/270783764/answer/470191989\n" +
            "来源：知乎\n" +
            "著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。";
    private double coins=136.0;
    private int titleImage=R.drawable.zbz;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate(R.layout.popular_fragment_layout, container, false);
        initData();
        initView(view);
        return view;
    }
    class myOnRefreshListener implements SwipeRefreshLayout.OnRefreshListener {
        @Override
        public void onRefresh() {
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    mSwipeRefresh.setRefreshing(false);
                }
            }, 1000);
        }
    }
    private void initData()
    {
        popularItems=new ArrayList<>();
        for(int i=0;i<6;++i)
        {
            popularItems.add(new PopularItem(0,titleString,titleContentString,titleImage,coins));
        }

    }
    private void initView(View view)
    {
        mRecyclerView=view.findViewById(R.id.pop_recycler);
        mSwipeRefresh=view.findViewById(R.id.my_pop_swipe);
        mSwipeRefresh.setOnRefreshListener(new myOnRefreshListener());
        mLayoutManager = new LinearLayoutManager(getContext());
        mRecyclerView.setLayoutManager(mLayoutManager);
        holderAdapter=new PopularHolderAdapter(popularItems,getContext());
        mRecyclerView.setAdapter(holderAdapter);
    }
}
