package com.example.admin.miniproject.adpater;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.admin.miniproject.R;
import com.example.admin.miniproject.ViewHolder.BaseViewHolder;
import com.example.admin.miniproject.ViewHolder.PopularViewHolder;
import com.example.admin.miniproject.ViewHolder.RecommendViewHolder;
import com.example.admin.miniproject.entity.PopularItem;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Created by hanking on 2018/9/9.
 * Copyright (c) 2018 Xunlei. All rights reserved.
 *
 * @author hanking
 */
public class PopularHolderAdapter extends RecyclerView.Adapter<BaseViewHolder> {
    List<PopularItem> popularItems;
    private Context context;
    public PopularHolderAdapter(List<PopularItem> popularItems,Context context) {
        this.popularItems = popularItems;
        this.context=context;
    }

    @NonNull
    @Override
    public BaseViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        BaseViewHolder viewHolder = null;
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.popular_item, viewGroup, false);
        viewHolder=new PopularViewHolder(view,context);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull BaseViewHolder viewHolder, int i) {
        popularItems.get(i).setNumber(i);
        viewHolder.bindData(popularItems.get(i));
    }

    @Override
    public int getItemCount() {
        return popularItems.size();
    }
}
