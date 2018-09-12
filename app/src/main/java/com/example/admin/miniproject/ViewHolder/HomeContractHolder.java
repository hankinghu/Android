package com.example.admin.miniproject.ViewHolder;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.admin.miniproject.R;
import com.example.admin.miniproject.activity.ContractContentActivity;
import com.example.admin.miniproject.entity.ContractItem;

/**
 * Created by hanking on 2018/9/9.
 * Copyright (c) 2018 Xunlei. All rights reserved.
 *
 * @author hanking
 */
public class HomeContractHolder extends BaseViewHolder {
    private ImageView icon;
    private TextView contractContent;
    private TextView contractTitle;
    private LinearLayout learnMore;
    private Context context;
    private  int type;
    public HomeContractHolder(@NonNull View view, Context context) {
        super(view);
        this.context=context;
        initView(view);
        initEvent();
    }

    private void initView(View view) {
        icon=view.findViewById(R.id.contract_icon);
        contractContent =view.findViewById(R.id.contract_content);
        contractTitle=view.findViewById(R.id.contract_title);
        learnMore=view.findViewById(R.id.learn_more);

    }
    private void initEvent()
    {
        learnMore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(context, ContractContentActivity.class);
                intent.putExtra("more",type);
                context.startActivity(intent);
            }
        });

    }
    @Override
    public void bindData(Object data) {
        ContractItem contractItem=(ContractItem)data;
        this.type=contractItem.getType();
        icon.setBackgroundResource(contractItem.getIcon());
        contractTitle.setText(contractItem.getContractTitle());
        contractContent.setText(contractItem.getContent());

    }
}
