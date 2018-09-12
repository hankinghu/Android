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
import com.example.admin.miniproject.adpater.XWTHolderAdapter;
import com.example.admin.miniproject.entity.ContractItem;
import com.example.admin.miniproject.entity.UserInfo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hanking on 2018/9/2.
 * Copyright (c) 2018 Xunlei. All rights reserved.
 *
 * @author hanking
 */
public class XWTDynamicFragment extends Fragment {
    private XWTHolderAdapter xwtHolderAdapter;
    private RecyclerView recyclerView;
    private SwipeRefreshLayout refreshLayout;
    private RecyclerView.LayoutManager mLayoutManager;
    private List<ContractItem> contractItems;
    private String content="各个国家、部门、人员之间的一个共同遵守的约定，一般是大家就有关国家、部门、人员之间的利益问题进行公开讨论达成一致的意见，并且同意遵守的一个规定。 公约是参与制定的单位和个人共同信守的行为规范，它对于维护社会秩序、促进安定团结、加强社会主义精神文明建设有着不可低估的作用。";
    private String homeTitle="家园公约";
    private String valuesTitle="文章价值公约";
    private String otherTitle="其他公约";
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate(R.layout.xwt_dynamic_fragment_layout, container, false);
        initView(view);
        return view;
    }
    private void initView(View view){
        recyclerView=view.findViewById(R.id.xwt_recycler);
        refreshLayout=view.findViewById(R.id.my_xwt_swipe);
        mLayoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(mLayoutManager);
        initData();
        xwtHolderAdapter=new XWTHolderAdapter(contractItems,getContext());
        recyclerView.setAdapter(xwtHolderAdapter);
        refreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {

                        refreshLayout.setRefreshing(false);
                    }
                }, 1000);
            }
        });
    }

    private  void initData()
    {
        contractItems=new ArrayList<>();
        contractItems.add(new ContractItem(1,R.drawable.home_tab_layout_icon,content,"",homeTitle));
        contractItems.add(new ContractItem(2,R.drawable.home_tab_layout_icon,content,"",valuesTitle));
        contractItems.add(new ContractItem(3,R.drawable.home_tab_layout_icon,content,"",otherTitle));
    }
}
