package com.gemall.library.widget;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.MotionEvent;

public class RecyclerviewNoTouch extends RecyclerView {


    private boolean TouchEnable = false;

    public RecyclerviewNoTouch(@NonNull Context context) {
        super(context);
    }

    public RecyclerviewNoTouch(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public RecyclerviewNoTouch(@NonNull Context context, @Nullable AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }


    public boolean isTouchEnable() {
        return TouchEnable;
    }

    public void setTouchEnable(boolean touchEnable) {
        TouchEnable = touchEnable;
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        if(TouchEnable){
            return super.dispatchTouchEvent(ev);
        }else {
            return false;
        }

    }




}
