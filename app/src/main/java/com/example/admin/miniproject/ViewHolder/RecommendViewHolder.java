package com.example.admin.miniproject.ViewHolder;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.TextView;

import com.example.admin.miniproject.R;
import com.example.admin.miniproject.activity.ArticleContentActivity;

/**
 * Created by hanking on 2018/9/4.
 * Copyright (c) 2018 Xunlei. All rights reserved.
 *
 * @author hanking
 */
public class RecommendViewHolder extends BaseViewHolder{
    private TextView articleTitle;
    private TextView articleContent;
    private TextView agree;
    private Context context;
    public RecommendViewHolder(View view, Context context) {
        super(view);
        this.context=context;
        initView(view);
        initEvent();
    }
    private void initEvent()
    {
        articleContent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(context, ArticleContentActivity.class);
                intent.putExtra("articleTitle",articleTitle.getText());
                context.startActivity(intent);
            }
        });
    }
    private void initView(View view)
    {
        articleTitle=view.findViewById(R.id.article_title);
        articleContent=view.findViewById(R.id.article_content);
        agree=view.findViewById(R.id.agree);
    }
    @Override
    public void bindData(Object data) {

    }
}
