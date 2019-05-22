package com.gemall.library.bean;

public class UserBasicInfoBean {

    /**
     * uid : sample string 1
     * code : sample string 2
     * userName : sample string 3
     * headPortraitURL : sample string 4
     * gender : 5
     * email : sample string 6
     * mobile : sample string 7
     * birthday : 2019-04-19T10:38:42.1862357+08:00
     * storeName : sample string 8
     */

    private String uid;
    private String code;
    private String userName;
    private String headPortraitURL;
    private int gender;
    private String email;
    private String mobile;
    private String birthday;
    private String storeName;

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getHeadPortraitURL() {
        return headPortraitURL;
    }

    public void setHeadPortraitURL(String headPortraitURL) {
        this.headPortraitURL = headPortraitURL;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }
}
