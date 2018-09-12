package com.example.admin.miniproject.ViewHolder;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by hanking on 2018/9/4.
 * Copyright (c) 2018 Xunlei. All rights reserved.
 *
 * @author hanking
 */
public abstract class BaseViewHolder extends RecyclerView.ViewHolder{
    public BaseViewHolder(@NonNull View itemView) {
        super(itemView);
    }
    public abstract void bindData(Object data);
}
