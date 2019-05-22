package com.gemall.library.bean.requestbean;

/**
 * @auther g-emall
 * @date 2019/4/16 14:52
 * @desc
 */
public class LoginParam {
    private String loginType;
    private String loginName;
    private String loginPwd;
    private String equipmentId;
    private String deviceIdentity;
    private int clientSource;

    public String getLoginType() {
        return loginType;
    }

    public void setLoginType(String loginType) {
        this.loginType = loginType;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getLoginPwd() {
        return loginPwd;
    }

    public void setLoginPwd(String loginPwd) {
        this.loginPwd = loginPwd;
    }

    public String getEquipmentId() {
        return equipmentId;
    }

    public void setEquipmentId(String equipmentId) {
        this.equipmentId = equipmentId;
    }

    public String getDeviceIdentity() {
        return deviceIdentity;
    }

    public void setDeviceIdentity(String deviceIdentity) {
        this.deviceIdentity = deviceIdentity;
    }

    public int getClientSource() {
        return clientSource;
    }

    public void setClientSource(int clientSource) {
        this.clientSource = clientSource;
    }
}
