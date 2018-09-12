package com.example.admin.miniproject.ViewHolder;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.admin.miniproject.R;
import com.example.admin.miniproject.activity.ArticleContentActivity;
import com.example.admin.miniproject.entity.PopularItem;

/**
 * Created by hanking on 2018/9/9.
 * Copyright (c) 2018 Xunlei. All rights reserved.
 *
 * @author hanking
 */
public class PopularViewHolder extends BaseViewHolder {
    private TextView title;
    private TextView number;
    private TextView titleContent;
    private TextView coin;
    private ImageView titleImage;
    private LinearLayout linear;
    public PopularViewHolder(@NonNull View view,Context context) {
        super(view);
        initView(view);
        initEvent(context);
    }

    private void initView(View view) {
        title=view.findViewById(R.id.title);
        number=view.findViewById(R.id.number);
        coin=view.findViewById(R.id.coin);
        titleContent=view.findViewById(R.id.title_content);
        titleImage=view.findViewById(R.id.title_image);
        linear=view.findViewById(R.id.linear);
    }
    private void initEvent(final Context context)
    {
        linear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(context, ArticleContentActivity.class);
                intent.putExtra("articleTitle",title.getText());
                context.startActivity(intent);
            }
        });

    }
    @Override
    public void bindData(Object data) {
        PopularItem popularItem=(PopularItem)data;
        number.setText(popularItem.getNumber()+"");
        title.setText(popularItem.getTitle());
        titleContent.setText(popularItem.getTitleContent());
        titleImage.setImageResource(popularItem.getTitleImage());
        coin.setText(popularItem.getCoin()+"");
    }
}
