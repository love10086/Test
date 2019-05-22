package com.gemall.library.hepler;

import android.view.View;

/**
 * author : g-emall
 * time   : 2019/4/10
 * desc   : 用于监听没有双击事件
 */
public abstract class OnNoDoubleClickListener implements View.OnClickListener {
    private int mThrottleFirstTime = 1000;
    private long mLastClickTime = 0;

    public OnNoDoubleClickListener() {
    }

    public OnNoDoubleClickListener(int throttleFirstTime) {
        mThrottleFirstTime = throttleFirstTime;
    }

    @Override
    public void onClick(View v) {
        long currentTime = System.currentTimeMillis();
        if (currentTime - mLastClickTime > mThrottleFirstTime) {
            mLastClickTime = currentTime;
            onNoDoubleClick(v);
        }
    }

    public abstract void onNoDoubleClick(View v);
}
