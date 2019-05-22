package com.gemall.library.bean;

import java.util.List;

/**
 * @auther g-emall
 * @date 2019/4/15
 * @desc
 */
public class LoginInfo {

    /**
     * uid : 7f9f2da5-6e01-4d55-a380-8689d5bbd0bd
     * id : 189275
     * code : GW00189275
     * userName : GW00189275
     * email : null
     * mobile : 15625266464
     * accountUid : e341a154-ef16-4eb5-bcdf-73513c2a5a00
     * userType : 1
     * userTypes : [1]
     * tempID : 196b8191-4f42-4cd9-9e5a-09f1141f492b
     * token : e4wDM/RfQFwC4PpkM6SW983yXL3ol8NpINH5qq1qKbY5a1GZ++KABbBulRPgvOF7nyiT15ZjqfrNJ35OjgyEZODm3yPbtPXqum8hUodehF9esklavLvO/bHgk1yhzx0hgZvowxHFjiKLKBU3EF3uh2v9L9Qm941BpNYRGcuqm5cFEpswlXitdCd2kxE1NGrtRb58Ehvd8mJOdl2UXO6ALbPvkhp9Sxu7n2PE2bfGeyaeqiBjGNoXYbolR034UTf99YwWtE2Kxxd9VpUnA5+Z6fdvTDHqkkQjdhoZIQLApbq7Im3SHM8MPoxgLTuaQ1rj9QKW4SNQPBYNNQpaK2mtHQ==
     * currencySymbol : ¥
     * merchantUniqueID : 00000000-0000-0000-0000-000000000000
     * countryRegionName : CN
     * isSeller : false
     */

    private String uid;
    private int id;
    private String code;
    private String userName;
    private Object email;
    private String mobile;
    private String accountUid;
    private int userType;
    private String tempID="";
    private String token;
    private String currencySymbol ="￥";
    private String merchantUniqueID;
    private String countryRegionName;
    private boolean isSeller;
    private List<Integer> userTypes;

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public Object getEmail() {
        return email;
    }

    public void setEmail(Object email) {
        this.email = email;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getAccountUid() {
        return accountUid;
    }

    public void setAccountUid(String accountUid) {
        this.accountUid = accountUid;
    }

    public int getUserType() {
        return userType;
    }

    public void setUserType(int userType) {
        this.userType = userType;
    }

    public String getTempID() {
        return tempID;
    }

    public void setTempID(String tempID) {
        this.tempID = tempID;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getCurrencySymbol() {
        return currencySymbol;
    }

    public void setCurrencySymbol(String currencySymbol) {
        this.currencySymbol = currencySymbol;
    }

    public String getMerchantUniqueID() {
        return merchantUniqueID;
    }

    public void setMerchantUniqueID(String merchantUniqueID) {
        this.merchantUniqueID = merchantUniqueID;
    }

    public String getCountryRegionName() {
        return countryRegionName;
    }

    public void setCountryRegionName(String countryRegionName) {
        this.countryRegionName = countryRegionName;
    }

    public boolean isIsSeller() {
        return isSeller;
    }

    public void setIsSeller(boolean isSeller) {
        this.isSeller = isSeller;
    }

    public List<Integer> getUserTypes() {
        return userTypes;
    }

    public void setUserTypes(List<Integer> userTypes) {
        this.userTypes = userTypes;
    }

    @Override
    public String toString() {
        return "LoginInfo{" +
                "uid='" + uid + '\'' +
                ", id=" + id +
                ", code='" + code + '\'' +
                ", userName='" + userName + '\'' +
                ", email=" + email +
                ", mobile='" + mobile + '\'' +
                ", accountUid='" + accountUid + '\'' +
                ", userType=" + userType +
                ", tempID='" + tempID + '\'' +
                ", token='" + token + '\'' +
                ", currencySymbol='" + currencySymbol + '\'' +
                ", merchantUniqueID='" + merchantUniqueID + '\'' +
                ", countryRegionName='" + countryRegionName + '\'' +
                ", isSeller=" + isSeller +
                ", userTypes=" + userTypes +
                '}';
    }
}
