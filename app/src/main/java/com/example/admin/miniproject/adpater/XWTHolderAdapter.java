package com.example.admin.miniproject.adpater;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.admin.miniproject.R;
import com.example.admin.miniproject.ViewHolder.BaseViewHolder;
import com.example.admin.miniproject.ViewHolder.HomeContractHolder;
import com.example.admin.miniproject.entity.ContractItem;

import java.util.List;

/**
 * Created by hanking on 2018/9/9.
 * Copyright (c) 2018 Xunlei. All rights reserved.
 *
 * @author hanking
 */
public class XWTHolderAdapter extends RecyclerView.Adapter<BaseViewHolder> {
    List<ContractItem> contractItems;
    private Context context;
    public XWTHolderAdapter(List<ContractItem> contractItems, Context context) {
        this.contractItems = contractItems;
        this.context=context;
    }

    @NonNull
    @Override
    public BaseViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        BaseViewHolder viewHolder = null;
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.xwt_item, viewGroup, false);
/*        switch (viewType) {
            case ContractItem.ARTICLE_VALUES_CONTRACT_TYPE:
                viewHolder = new ArticleValuesContractViewHolder(view);
                break;
            case ContractItem.HOME_CONTRACT_TYPE:
                viewHolder = new HomeContractHolder(view);break;
            case ContractItem.OTHER_CONTRACT_TYPE:
                viewHolder = new OtherContractHolder(view);break;

        }*/
        viewHolder = new HomeContractHolder(view,context);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull BaseViewHolder viewHolder, int i) {
        viewHolder.bindData(contractItems.get(i));
    }

    @Override
    public int getItemCount() {
        return contractItems.size();
    }

    @Override
    public int getItemViewType(int position) {
        return contractItems.get(position).getType();
    }

    public void setValues(List<ContractItem> contractItems) {
        this.contractItems = contractItems;
        notifyDataSetChanged();
    }

    public void clearData() {
        contractItems.clear();
        notifyDataSetChanged();
    }
}
