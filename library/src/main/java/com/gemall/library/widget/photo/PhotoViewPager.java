package com.gemall.library.widget.photo;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;

/**
 * author : g-emall
 * time   : 2019/5/15
 * desc   :
 */
public class PhotoViewPager extends ViewPager {
    public PhotoViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
    }
    public PhotoViewPager(Context context) {
        super(context);
    }
    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        try {
            return super.onInterceptTouchEvent(ev);
        } catch (IllegalArgumentException e) {
            return false;
        }
    }
}