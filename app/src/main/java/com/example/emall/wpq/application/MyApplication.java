package com.example.emall.wpq.application;

import android.app.Application;

import com.alibaba.android.arouter.launcher.ARouter;
import com.gemall.library.application.LibraryApplication;
import com.gemall.library.bean.LoginInfo;
import com.gemall.library.config.UserConfigure;
import com.gemall.library.crypt.DesUtil;
import com.gemall.library.interface_list.IComponentApplication;
import com.gemall.library.util.SkuUtils;
import com.raizlabs.android.dbflow.config.FlowManager;

import cn.jpush.android.api.JPushInterface;

public class MyApplication extends Application implements IComponentApplication {


    @Override
    public void onCreate() {
        super.onCreate();
        LibraryApplication.getLibraryApplication().initLibraryApplication(this);
    }

    @Override
    public void onCreate(Application application) {

    }
}
