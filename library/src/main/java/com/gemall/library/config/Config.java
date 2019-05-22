package com.gemall.library.config;

import android.os.Environment;
import android.util.Log;

import java.io.File;

public class Config {

    /**
     * 程序的文件所放置的目錄
     */
    public static String ROOT_PATH;

    static {
        if (Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)) {
            ROOT_PATH = Environment.getExternalStorageDirectory() + "/ZYSC/";
        } else {
            ROOT_PATH = Environment.getDataDirectory().getAbsolutePath() + "/ZYSC/";
        }
    }

    /**
     * 创建app缓存文件夹
     */
    public static void createFile(){
        try {
            File file = new File(ROOT_PATH);
            if (!file.exists()) {
                file.mkdir();
            }
        } catch (Exception e) {
            Log.e("error", e.toString());
        }
    }

    /**
     *  清除缓存空间
     */
    public static boolean clearCache(){
       try{
           File file = new File(ROOT_PATH);
           if (file.exists()) {
               deleteFile(file);
           }

           return true;
       }catch (Exception e){
           return  false;
       }
    }

    /**
     *  清除图片缓存
     */
    public static boolean clearImageCache(){
        try{
            File file = new File(getBitmapPath());
            if (file.exists()) {
                deleteFile(file);
            }
            return true;
        }catch (Exception e){
            return false;
        }
    }

    /**
     * 递归删除文件
     */
    private static void deleteFile(File file) {
        if (file.isDirectory()) {
            File[] files = file.listFiles();
            for (int i = 0; i < files.length; i++) {
                File f = files[i];
                deleteFile(f);
            }
        } else if (file.exists()) {
            file.delete();
        }
    }

    /**
     * 版本更新文件存放的目录
     *
     * @return
     */
    public static String getAppUpdate() {
        return ROOT_PATH + "Backup/";
    }

    /**
     * 日志文件存放目录
     *
     * @return
     */
    public static String getLogPath() {
        return ROOT_PATH + "Log/";
    }

    /**
     * 压缩图片存放目录
     *
     * @return
     */
    public static String getBitmapPath() {
        return ROOT_PATH + "Image/";
    }

    public static String getAvatarPath() {
        return ROOT_PATH + "Avatar/";
    }

    public static String getCachePath() {
        return ROOT_PATH + "Cache/";
    }
}
