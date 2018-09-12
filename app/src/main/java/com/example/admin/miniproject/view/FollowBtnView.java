package com.example.admin.miniproject.view;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.support.annotation.AttrRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.LocalBroadcastManager;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.example.admin.miniproject.R;
import com.example.admin.miniproject.entity.UserInfo;

/**
 * Created by SunYuan on 2017/8/1.
 * Copyright (c) 2017 Xunlei. All rights reserved.
 *
 * @author SunYuan
 * @since 2017/8/1
 */
public class FollowBtnView extends FrameLayout {
    public static final String ACTION_START_FOLLOW_GUIDE_ANIMATION = "action_start_follow_guide_animation";
    private UserInfo mVideoUserInfo;
    private ImageView mFollowBtn;
    private OnFollowBtnListener mListener;

    public FollowBtnView(@NonNull Context context) {
        super(context);
        initView();
    }

    public FollowBtnView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initView();
    }

    public FollowBtnView(@NonNull Context context, @Nullable AttributeSet attrs, @AttrRes int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView();
    }

    private void initView() {
        LayoutInflater.from(getContext()).inflate(R.layout.short_video_card_follow_btn_view, this);
        mFollowBtn = (ImageView) findViewById(R.id.follow_btn);
    }

    public void setDrawableId(int drawableId) {
        mFollowBtn.setBackgroundResource(drawableId);
    }

    public void doStartFollowTipsAnimation() {
        if (!mFollowBtn.isEnabled()) {
            return;
        }
        if (mFollowBtn.getBackground() instanceof AnimationDrawable) {
            AnimationDrawable animationDrawable = (AnimationDrawable) mFollowBtn.getBackground();
            animationDrawable.stop();
            animationDrawable.start();
        }
    }

    public void tryStartFollowTipsAnimation() {
        if (getVisibility() == VISIBLE) {
            doStartFollowTipsAnimation();
        } else {
            Intent intent = new Intent(FollowBtnView.ACTION_START_FOLLOW_GUIDE_ANIMATION);
            LocalBroadcastManager.getInstance(getContext()).sendBroadcast(intent);
        }
    }

    @Override
    public void setEnabled(boolean enabled) {
        super.setEnabled(enabled);
        mFollowBtn.setEnabled(enabled);
    }

    public void setFollowListener(OnFollowBtnListener listener) {
        mListener = listener;
        mFollowBtn.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mVideoUserInfo == null) {
                    return;
                }
              /*  boolean isLogined = LoginHelper.getInstance().isLogined();
                if (isLogined) {
                    doFollow(mVideoUserInfo);
                } else {
                    doFollowAfterLogin(mVideoUserInfo);
                }
                if (mListener != null) {
                    mListener.onClickFollowButton(isLogined);
                }*/
            }
        });
    }

    public void setUserInfo(UserInfo userInfo) {
        /*mVideoUserInfo = userInfo;
        String publisherId = userInfo.getUid();
        boolean isPublishedIdEmpty = TextUtils.isEmpty(publisherId);
        if (!isPublishedIdEmpty && publisherId.equals(LoginHelper.getInstance().getUserId() + "")) {
            setVisibility(GONE);
            return;
        }
        boolean isFollowed = isPublishedIdEmpty ? false : FollowManager.getInstance().isFollowing(Long.valueOf(publisherId));
        setEnabled(!isFollowed);*/
    }

    private void doFollow(UserInfo userInfo) {
        setEnabled(false);
/*        long followUid = Long.parseLong(userInfo.getUid());
        FollowManager.getInstance().follow(followUid, true, new FollowNetworkHelper.ResponseListener0() {
            @Override
            public void onSuccess() {
                setEnabled(false);
                if (mListener != null) {
                    mListener.onFollowSuccess();
                }
            }

            @Override
            public void onFail(String error) {
                setEnabled(true);
                if (mListener != null) {
                    mListener.onFollowFailed(error);
                }
            }
        });*/
    }

    private void doFollowAfterLogin(final UserInfo userInfo) {
       /* final String publisherId = userInfo.getUid();
        LoginHelper.getInstance().startActivity(getContext(), new LoginCompletedListener() {
            @Override
            public void onLoginCompleted(boolean isSuccess, int errCode, Object userData) {
                if (errCode == 0 && !TextUtils.isEmpty(publisherId)) {
                    if (FollowManager.getInstance().isFollowing(Long.valueOf(publisherId))) {
                        setEnabled(false);
                    } else {
                        doFollow(userInfo);
                    }
                } else {
                    setEnabled(true);
                }
            }
        }, mListener.getLoginFrom(), null);*/
    }

    /*private FollowPresenterCallBack mFollowCallBack = new FollowPresenterCallBack() {
        @Override
        public void doRefresh(boolean isCancelFollow, List<String> followedIds) {
            if (mVideoUserInfo == null) {
                return;
            }
            if (followedIds == null || followedIds.isEmpty()) {
                return;
            }
            if (followedIds.contains(mVideoUserInfo.getUid())) {
                if (isCancelFollow) {
                    setEnabled(true);
                } else {
                    setEnabled(false);
                }
            }
        }
    };
*/
    @Override
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
//        FollowPresenterImpl.getInstance().unBinderFollow(mFollowCallBack);
    }

    @Override
    protected void onWindowVisibilityChanged(int visibility) {
        super.onWindowVisibilityChanged(visibility);
        if (visibility == VISIBLE) {
//            FollowPresenterImpl.getInstance().bindFollow(mFollowCallBack);
        }
        /*if (mVideoUserInfo != null && mVideoUserInfo.isFollowed()) {
            mFollowBtn.setEnabled(false);
        } else {
            mFollowBtn.setEnabled(true);
        }*/
    }

    public interface OnFollowBtnListener {
        /**
         * 关注成功回调
         */
        void onFollowSuccess();

        /**
         * 关注失败回调
         *
         * @param error 失败原因
         */
        void onFollowFailed(String error);

        /**
         * 点击关注按钮
         *
         * @param isLogined 当前是否已登录
         */
        void onClickFollowButton(boolean isLogined);

        /**
         * 未登录时，弹出登录界面，提供登录来源
         */
//        LoginFrom getLoginFrom();
    }
}
