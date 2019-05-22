package com.gemall.library.widget;

import android.content.Context;
import android.util.AttributeSet;

/**
 * Created by g-emall on 2018/9/17.
 */

public class YJGTextView extends android.support.v7.widget.AppCompatTextView {

    public YJGTextView(Context context) {
        super(context);
    }

    public YJGTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public YJGTextView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    @Override
    public boolean isFocused() {
        return true;
    }

}