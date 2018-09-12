package com.example.admin.miniproject.entity;

/**
 * Created by hanking on 2018/9/9.
 * Copyright (c) 2018 Xunlei. All rights reserved.
 *
 * @author hanking
 */
public class ContractItem {
    private int type;
    private int  icon;
    private String content;
    private String moreContent;
    private String contractTitle;
    public static final int HOME_CONTRACT_TYPE=1;
    public static final int ARTICLE_VALUES_CONTRACT_TYPE=2;
    public static final int OTHER_CONTRACT_TYPE=3;
    public ContractItem() {
    }

    public String getContractTitle() {
        return contractTitle;
    }

    public void setContractTitle(String contractTitle) {
        this.contractTitle = contractTitle;
    }

    public ContractItem(int type, int icon, String content, String moreContent, String contractTitle) {
        this.type = type;
        this.icon = icon;
        this.content = content;
        this.moreContent = moreContent;
        this.contractTitle = contractTitle;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getIcon() {
        return icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getMoreContent() {
        return moreContent;
    }

    public void setMoreContent(String moreContent) {
        this.moreContent = moreContent;
    }
}
