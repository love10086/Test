package com.gemall.library.widget;

/**
 * Created by g-emall on 2018/8/23.
 */

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;

public class CustomScrollViewPager extends ViewPager {
    // false 禁止ViewPager左右滑动。
    private boolean scrollable = false;

    public CustomScrollViewPager(@NonNull Context context) {
        super(context);
    }

    public CustomScrollViewPager(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public void setScrollable(boolean scrollable) {
        this.scrollable = scrollable;
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        if(scrollable){
            return super.onInterceptTouchEvent(ev);
        }
        return scrollable;
    }

    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        if(scrollable){
            return super.onTouchEvent(ev);
        }
        return scrollable;
    }
}
