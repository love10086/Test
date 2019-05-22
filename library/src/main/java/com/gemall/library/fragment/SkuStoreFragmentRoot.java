package com.gemall.library.fragment;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import java.io.Serializable;

/**
 * Created by Gemall on 2017/7/12.
 */
public abstract class SkuStoreFragmentRoot<T> extends Fragment implements Serializable {


    public String TAG_Simple = getClass().getSimpleName();
    public T mylistener;
    public Application mGwtKeyApp;
    public Activity mActivity;


    @Override
    public void onAttach(Activity activity) {
        this.mActivity = activity;
        mylistener = (T) activity;
        super.onAttach(activity);
    }

    public Object callbackData(String action, Object... objectData){return null;};


}
