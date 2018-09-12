package com.example.admin.miniproject.ViewHolder;

import android.support.annotation.NonNull;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.admin.miniproject.R;
import com.example.admin.miniproject.entity.ContractItem;

/**
 * Created by hanking on 2018/9/9.
 * Copyright (c) 2018 Xunlei. All rights reserved.
 *
 * @author hanking
 */
public class OtherContractHolder extends BaseViewHolder {
    private ImageView icon;
    private TextView contractContent;
    private TextView contractTitle;
    private LinearLayout learnMore;
    public OtherContractHolder(@NonNull View view) {
        super(view);
        initView(view);
    }

    private void initView(View view) {
        icon=view.findViewById(R.id.contract_icon);
        contractContent =view.findViewById(R.id.contract_content);
        contractTitle=view.findViewById(R.id.contract_title);
        learnMore=view.findViewById(R.id.learn_more);

    }

    @Override
    public void bindData(Object data) {
        ContractItem contractItem=(ContractItem)data;
        icon.setBackgroundResource(contractItem.getIcon());
        contractTitle.setText(contractItem.getContractTitle());
        contractContent.setText(contractItem.getContent());

    }
}
