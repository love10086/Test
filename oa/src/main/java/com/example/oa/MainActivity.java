package com.example.oa;

import android.app.Activity;
import android.os.Bundle;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.amap.api.maps.AMap;
import com.amap.api.maps.MapView;


@Route(path = "/oa/MainActivity")
public class MainActivity extends Activity {


    MapView mMapView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.oa_activity_main);

        mMapView = findViewById(R.id.map);
        mMapView.onCreate(savedInstanceState);// 此方法必须重写
        AMap aMap = mMapView.getMap();

    }
}
