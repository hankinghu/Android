package com.example.admin.miniproject.helper;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Color;
import android.os.Handler;
import android.support.v4.widget.SwipeRefreshLayout;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ForegroundColorSpan;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;

import com.example.admin.miniproject.utils.DipPixelUtil;

/**
 * Created by hanking on 2018/9/3.
 * Copyright (c) 2018 Xunlei. All rights reserved.
 *
 * @author hanking
 */
public class RefreshPromptView extends android.support.v7.widget.AppCompatTextView {
    public static final int PROMPT_HEIGHT_IN_DP = 37;

    private static final int ANIMATION_DURATION = 400;
    private Handler mHandler = new Handler();
    private ObjectAnimator mAnimator;
    public RefreshPromptView(Context context) {
        super(context);
    }

    public RefreshPromptView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public RefreshPromptView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public void show(int refreshSize) {
        mHandler.removeCallbacks(mHideRunnable);
        String promptText = refreshSize + " 条内容更新";
        String refreshSizeText = String.valueOf(refreshSize);
        int index = promptText.indexOf(refreshSizeText);
        if (index < 0) {
            return;
        }
        SpannableStringBuilder style = new SpannableStringBuilder(promptText);
        style.setSpan(new ForegroundColorSpan(Color.parseColor("#1294f6")), index, index + refreshSizeText.length(), Spannable.SPAN_EXCLUSIVE_INCLUSIVE);
        style.setSpan(new AbsoluteSizeSpan(DipPixelUtil.sp2pix(14)), index, index + refreshSizeText.length(), Spannable.SPAN_EXCLUSIVE_INCLUSIVE);
        setText(style);
        doShowAnimator();
        mHandler.postDelayed(mHideRunnable, 1600);
    }

    public void show(String s) {
        mHandler.removeCallbacks(mHideRunnable);
        setText(s);
        doShowAnimator();
        mHandler.postDelayed(mHideRunnable, 1600);
    }

    public void hide() {
        mHandler.removeCallbacks(mHideRunnable);
        doHideAnimation();
    }

    private void doShowAnimator() {
        if (mAnimator != null && mAnimator.isRunning()) {
            mAnimator.cancel();
        }
        mAnimator = ObjectAnimator.ofFloat(this, View.TRANSLATION_Y, getTranslationY(), 0);
        mAnimator.setDuration(ANIMATION_DURATION);
        mAnimator.start();
    }

    private void doHideAnimation() {
        if (mAnimator != null && mAnimator.isRunning()) {
            mAnimator.cancel();
        }
        mAnimator = ObjectAnimator.ofFloat(this, View.TRANSLATION_Y, getTranslationY(), -getHeight());
        mAnimator.setDuration(ANIMATION_DURATION);
        mAnimator.start();
    }

    private Runnable mHideRunnable = new Runnable() {
        @Override
        public void run() {
            hide();
        }
    };
}
