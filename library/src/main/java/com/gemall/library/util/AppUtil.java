package com.gemall.library.util;

import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.drawable.Drawable;

import java.util.List;

public class AppUtil {


    public static String getPackageName(Context context) {
        //当前应用pid
        int pid = android.os.Process.myPid();
        //任务管理类
        ActivityManager manager = (ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE);
        //遍历所有应用
        List<ActivityManager.RunningAppProcessInfo> infos = manager.getRunningAppProcesses();
        for (ActivityManager.RunningAppProcessInfo info : infos) {
            if (info.pid == pid)//得到当前应用
                return info.processName;//返回包名
        }
        return "";
    }



    /**
     * 获取程序 图标
     * @param context
     * @return
     */
    public static Drawable getAppIcon(Context context){
        try {
            //包管理操作管理类
            PackageManager pm = context.getPackageManager();
            //获取到应用信息
            ApplicationInfo info = pm.getApplicationInfo(getPackageName(context), 0);
            return info.loadIcon(pm);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
    /**
     * 获取程序的版本号
     * @param context
     * @return
     */
    public static String getAppVersion(Context context){
        //包管理操作管理类
        PackageManager pm = context.getPackageManager();
        try {
            PackageInfo packinfo = pm.getPackageInfo(getPackageName(context), 0);
            return packinfo.versionName;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return "";
    }
    /**
     * 获取程序的名字
     * @param context
     * @param packname
     * @return
     */
    public static String getAppName(Context context,String packname){
        //包管理操作管理类
        PackageManager pm = context.getPackageManager();
        try {
            ApplicationInfo info = pm.getApplicationInfo(packname, 0);
            return info.loadLabel(pm).toString();
        } catch (PackageManager.NameNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return packname;
    }


}
