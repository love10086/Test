package com.example.emall.wpq;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.example.emall.wpq.application.MyApplication;
import com.gemall.library.application.LibraryApplication;

public class BaseActivity extends AppCompatActivity {


//    public MyApplication mLibraryApplication;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        mLibraryApplication = (MyApplication) getApplication();
    }

}
