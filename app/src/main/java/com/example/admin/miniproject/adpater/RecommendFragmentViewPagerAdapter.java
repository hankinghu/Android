package com.example.admin.miniproject.adpater;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.admin.miniproject.R;
import com.example.admin.miniproject.ViewHolder.RecommendViewHolder;
import com.example.admin.miniproject.entity.NewsTitle;
import com.example.admin.miniproject.entity.UserInfo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hanking on 2018/9/3.
 * Copyright (c) 2018 Xunlei. All rights reserved.
 *
 * @author hanking
 */
public class RecommendFragmentViewPagerAdapter extends RecyclerView.Adapter<RecommendViewHolder> {

    private List<NewsTitle> newsTitles;
    private Context context;
    public RecommendFragmentViewPagerAdapter() {
    }

    public RecommendFragmentViewPagerAdapter(List<NewsTitle> newsTitles, Context context) {
        this.context=context;
        this.newsTitles = newsTitles;
    }

    @NonNull
    @Override
    public RecommendViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        // create a new view
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.choiceness_photo_article_item, viewGroup, false);
        RecommendViewHolder holder = new RecommendViewHolder(view,context);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecommendViewHolder recommendViewHolder, int i) {
        recommendViewHolder.bindData(newsTitles);
    }


    @Override
    public int getItemCount() {
        return newsTitles.size();
    }

    public void clear() {

        newsTitles.clear();
        notifyDataSetChanged();
    }

    public void addAll(List<UserInfo> userInfos, List<NewsTitle> newsTitles) {

        this.newsTitles.addAll(newsTitles);
        notifyDataSetChanged();
    }
}
