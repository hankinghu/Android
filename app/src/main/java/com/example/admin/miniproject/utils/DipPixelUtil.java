package com.example.admin.miniproject.utils;

import android.annotation.SuppressLint;
import android.content.res.Resources;

import com.example.admin.miniproject.helper.XLCommonModule;

/**
 * Created by hanking on 2018/9/3.
 * Copyright (c) 2018 Xunlei. All rights reserved.
 *
 * @author hanking
 */
public class DipPixelUtil {
    @SuppressLint("DefaultLocale")
    public static int dip2px(float dpValue) {
        final float scale = getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }

    /**
     * @param spValue
     * @param spValue (DisplayMetrics类中的scaledDensity属性)
     * @return
     */
    public static int sp2pix(float spValue) {
        final float fontScale = getResources().getDisplayMetrics().scaledDensity;
        return (int) (spValue * fontScale + 0.5f);
    }

    public static int px2dip(int px) {
        final float fontScale = getResources().getDisplayMetrics().scaledDensity;
        return (int) (px / fontScale + 0.5f);
    }

    private static Resources getResources() {
        try {
            return XLCommonModule.getInstance().getContext().getResources();
        } catch (Throwable e) {
            return Resources.getSystem();
        }
    }
}
