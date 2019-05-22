package com.gemall.library.config;

public class UserInfo {


    private static UserInfo mUserInfo;


    private UserInfo(){}

    public static UserInfo getUserInfo(){
        return mUserInfo;
    }
    public static void setUserInfo(UserInfo mUserInfo){
        UserInfo.mUserInfo = mUserInfo;
    }




    private String tempID;
    private String userToken;
    private String userUID;
    private String clientID;


    public String getTempID() {
        return tempID;
    }

    public void setTempID(String tempID) {
        this.tempID = tempID;
    }

    public String getUserToken() {
        return userToken;
    }

    public void setUserToken(String userToken) {
        this.userToken = userToken;
    }

    public String getUserUID() {
        return userUID;
    }

    public void setUserUID(String userUID) {
        this.userUID = userUID;
    }

    public String getClientID() {
        return clientID;
    }

    public void setClientID(String clientID) {
        this.clientID = clientID;
    }
}
