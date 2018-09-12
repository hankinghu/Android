package com.example.admin.miniproject.entity;

/**
 * Created by hanking on 2018/9/9.
 * Copyright (c) 2018 Xunlei. All rights reserved.
 *
 * @author hanking
 */
public class PopularItem {
    private int number;

    public PopularItem(int number, String title, String titleContent, int titleImage, double coin) {
        this.number = number;
        this.title = title;
        this.titleContent = titleContent;
        this.titleImage = titleImage;
        this.coin = coin;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getTitle() {
        return title;
    }

    public PopularItem() {
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitleContent() {
        return titleContent;
    }

    public void setTitleContent(String titleContent) {
        this.titleContent = titleContent;
    }

    public int getTitleImage() {
        return titleImage;
    }

    public void setTitleImage(int titleImage) {
        this.titleImage = titleImage;
    }

    public double getCoin() {
        return coin;
    }

    public void setCoin(double coin) {
        this.coin = coin;
    }

    private String title;
    private String titleContent;
    private int titleImage;
    private double coin;

    public PopularItem(String title, String titleContent, int titleImage, double coin) {
        this.title = title;
        this.titleContent = titleContent;
        this.titleImage = titleImage;
        this.coin = coin;
    }

}
