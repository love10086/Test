package com.gemall.library.bean;

import java.io.Serializable;

public class AppVersionInfoBean implements Serializable {


    /**
     * version : sample string 1
     * mobileClientUpdateLog : sample string 2
     * isShow : 3
     * isPublished : 4
     * isAutoDownload : 5
     * downLoadUrl : sample string 6
     * appSize : 7.1
     */

    private String version;
    private String mobileClientUpdateLog;
    private int isShow;
    private int isPublished;
    private int isAutoDownload;
    private String downLoadUrl;
    private long appSize;
    private String fileAbsolutePath;//本地赋值

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getMobileClientUpdateLog() {
        return mobileClientUpdateLog;
    }

    public void setMobileClientUpdateLog(String mobileClientUpdateLog) {
        this.mobileClientUpdateLog = mobileClientUpdateLog;
    }

    public int getIsShow() {
        return isShow;
    }

    public void setIsShow(int isShow) {
        this.isShow = isShow;
    }

    public int getIsPublished() {
        return isPublished;
    }

    public void setIsPublished(int isPublished) {
        this.isPublished = isPublished;
    }

    public int getIsAutoDownload() {
        return isAutoDownload;
    }

    public void setIsAutoDownload(int isAutoDownload) {
        this.isAutoDownload = isAutoDownload;
    }

    public String getDownLoadUrl() {
        return downLoadUrl;
    }

    public void setDownLoadUrl(String downLoadUrl) {
        this.downLoadUrl = downLoadUrl;
    }

    public long getAppSize() {
        return appSize;
    }

    public void setAppSize(long appSize) {
        this.appSize = appSize;
    }

    public String getFileAbsolutePath() {
        return fileAbsolutePath;
    }

    public void setFileAbsolutePath(String fileAbsolutePath) {
        this.fileAbsolutePath = fileAbsolutePath;
    }
}
