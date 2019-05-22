package com.gemall.library.util;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.support.v4.content.FileProvider;
import android.telephony.TelephonyManager;

import java.io.File;
import java.util.UUID;

/**
 * 手机信息工具类
 *
 * @author GB.chen
 */
public class PhoneUtil {

    /**
     * 判断sim卡是否可用
     *
     * @param context
     * @return
     */
    public static boolean simIsAvailable(Context context) {
        boolean available = false;
        TelephonyManager telephonyManager = (TelephonyManager) context
                .getSystemService(Context.TELEPHONY_SERVICE);
        int simState = telephonyManager.getSimState();
        if (simState == TelephonyManager.SIM_STATE_READY) {
            available = true;
        }

        return available;
    }

    // 获取设备uuid
    public static String getUniqueID() {
        //获得独一无二的Psuedo ID
        String serial = null;

        String m_szDevIDShort = "35" +
                Build.BOARD.length() % 10 + Build.BRAND.length() % 10 +

                Build.CPU_ABI.length() % 10 + Build.DEVICE.length() % 10 +

                Build.DISPLAY.length() % 10 + Build.HOST.length() % 10 +

                Build.ID.length() % 10 + Build.MANUFACTURER.length() % 10 +

                Build.MODEL.length() % 10 + Build.PRODUCT.length() % 10 +

                Build.TAGS.length() % 10 + Build.TYPE.length() % 10 +

                Build.USER.length() % 10; //13 位

        try {
            serial = Build.class.getField("SERIAL").get(null).toString();
            //API>=9 使用serial号
            return new UUID(m_szDevIDShort.hashCode(), serial.hashCode()).toString();
        } catch (Exception exception) {
            //serial需要一个初始化
            serial = "serial"; // 随便一个初始化
        }
        //使用硬件信息拼凑出来的15位号码
        return new UUID(m_szDevIDShort.hashCode(), serial.hashCode()).toString();
    }

    /**
     *  手机隐藏显示
     */
    public static String getMachiningPhone(String phone){
        try{
            if (StringUtils.isUsefulString(phone)){
                if (10 < phone.length()){
                    return phone.substring(0,3) + "****" + phone.substring(7, 11);
                }else {
                    return phone;
                }
            }else {
                return "";
            }
        }catch (Exception e){
            return "";
        }
    }


    public static void install(Context context,String filePath) {

        try {
//            SkuUtils.printf(TAG, "开始执行安装: " + filePath);
            File apkFile = new File(filePath);
            SkuUtils.printf("安装包大小" + apkFile.length());
            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
//                SkuUtils.printf(TAG, "版本大于 N ，开始使用 fileProvider 进行安装");
                intent.setFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
                Uri contentUri = FileProvider.getUriForFile(
                        context
                        , "com.gemall.yjzy.fileprovider"
                        , apkFile);
                intent.setDataAndType(contentUri, "application/vnd.android.package-archive");
            } else {
//                SkuUtils.printf(TAG, "正常进行安装");
                intent.setDataAndType(Uri.fromFile(apkFile), "application/vnd.android.package-archive");
            }
            context.startActivity(intent);
        }catch (Exception e){
            e.printStackTrace();
        }

    }


}
