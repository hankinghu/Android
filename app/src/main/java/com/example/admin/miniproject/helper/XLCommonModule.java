package com.example.admin.miniproject.helper;

import android.annotation.SuppressLint;
import android.app.Application;
import android.content.Context;
import android.support.annotation.NonNull;

/**
 * Created by hanking on 2018/9/3.
 * Copyright (c) 2018 Xunlei. All rights reserved.
 *
 * @author hanking
 */
public class XLCommonModule {
    @SuppressLint("StaticFieldLeak")
    private static volatile XLCommonModule sInstance;
    private Application mApplication;

    private XLCommonModule() {
    }

    public static XLCommonModule getInstance() {
        if (sInstance == null) {
            synchronized (XLCommonModule.class) {
                if (sInstance == null) {
                    sInstance = new XLCommonModule();
                }
            }
        }
        return sInstance;
    }

    /**
     * 在Application的onCreate中调用初始化，保存Application
     */
    public static void init(@NonNull Application application) {
        getInstance().mApplication = application;
    }

    public Application getApplication() {
        return mApplication;
    }

    public Context getContext() {
        return mApplication;
    }
}
