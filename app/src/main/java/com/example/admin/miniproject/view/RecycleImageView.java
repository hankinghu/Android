package com.example.admin.miniproject.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.widget.ImageView;

/**
 * Created by hanking on 2018/9/4.
 * Copyright (c) 2018 Xunlei. All rights reserved.
 *
 * @author hanking
 */
@SuppressLint("AppCompatCustomView")
public class RecycleImageView extends ImageView {
    public RecycleImageView(Context context) {
        super(context);
    }

    public RecycleImageView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public RecycleImageView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
    @Override
    protected void onDetachedFromWindow() {
        //暂时注释,因为在多个framengt切换的时候,切换回来会导致图片被销毁,导致空白的问题
        //setImageDrawable(null);

        super.onDetachedFromWindow();
    }

    @Override
    public void setImageDrawable(Drawable drawable) {
        final Drawable previousDrawable = getDrawable();
        super.setImageDrawable(drawable);
        notifyDrawable(drawable, true);
        notifyDrawable(previousDrawable, false);
    }

    @SuppressWarnings("deprecation")
    @Override
    public void setBackgroundDrawable(Drawable background) {
        final Drawable previousDrawable = getBackground();
        super.setBackgroundDrawable(background);
        notifyDrawable(background, true);
        notifyDrawable(previousDrawable, false);
    }

    @Override
    public void setBackground(Drawable background) {
        final Drawable previousDrawable = getBackground();
        super.setBackground(background);
        notifyDrawable(background, true);
        notifyDrawable(previousDrawable, false);
    }

    private static void notifyDrawable(Drawable drawable, final boolean isDisplayed) {
        if (drawable instanceof RecycleBitmapDrawable) {
            ((RecycleBitmapDrawable) drawable).setIsDisplayed(isDisplayed);
        } else if (drawable instanceof LayerDrawable) {
            LayerDrawable layerDrawable = (LayerDrawable) drawable;
            for (int i = 0, z = layerDrawable.getNumberOfLayers(); i < z; i++) {
                notifyDrawable(layerDrawable.getDrawable(i), isDisplayed);
            }
        } else if (drawable instanceof RecycleDrawable) {
            ((RecycleDrawable) drawable).setIsDisplayed(isDisplayed);
        }
    }

    @Override
    protected void onDraw(Canvas canvas) {
        try {
            super.onDraw(canvas);
        } catch (Exception e) {

        }
    }
}
