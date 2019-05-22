package com.gemall.library.application;

import android.app.Application;

import com.alibaba.android.arouter.launcher.ARouter;
import com.gemall.library.bean.LoginInfo;
import com.gemall.library.config.UserConfigure;
import com.gemall.library.crypt.DesUtil;
import com.gemall.library.interface_list.IComponentApplication;
import com.gemall.library.util.SkuUtils;
import com.raizlabs.android.dbflow.config.FlowManager;
import cn.jpush.android.api.JPushInterface;

public class LibraryApplication extends Application implements IComponentApplication {


    private static LibraryApplication mLibraryApplication;

    private LibraryApplication(){}

    public static LibraryApplication getLibraryApplication(){
            if(mLibraryApplication == null){
                mLibraryApplication = new LibraryApplication();
            }
        return mLibraryApplication;
    }


    public void initLibraryApplication(Application application){
        onCreate(application);
    }

    @Override
    public void onCreate(Application application) {

        ARouter.openLog();     // 打印日志
        ARouter.openDebug();   // 开启调试模式(如果在InstantRun模式下运行，必须开启调试模式！线上版本需要关闭,否则有安全风险)
        ARouter.init(application); // 尽可能早，推荐在Application中初始化

        JPushInterface.setDebugMode(true);
        JPushInterface.init(application);

        //初始化DBFLOW
        FlowManager.init(application);

        //        if (isDebug()) {           // 这两行必须写在init之前，否则这些配置在init过程中将无效
        //            ARouter.openLog();     // 打印日志
        //            ARouter.openDebug();   // 开启调试模式(如果在InstantRun模式下运行，必须开启调试模式！线上版本需要关闭,否则有安全风险)
        //        }


    }


}
