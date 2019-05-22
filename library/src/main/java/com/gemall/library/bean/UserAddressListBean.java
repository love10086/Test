package com.gemall.library.bean;

import java.io.Serializable;
import java.util.List;

public class UserAddressListBean implements Serializable {
    private PageInfoBean pageInfo;
    private List<ItemBean> list;

    public PageInfoBean getPageInfo() {
        return pageInfo;
    }

    public void setPageInfo(PageInfoBean pageInfo) {
        this.pageInfo = pageInfo;
    }

    public List<ItemBean> getList() {
        return list;
    }

    public void setList(List<ItemBean> list) {
        this.list = list;
    }

    private class PageInfoBean{
        private int totalCount;
        private int pageCount;

        public int getTotalCount() {
            return totalCount;
        }

        public void setTotalCount(int totalCount) {
            this.totalCount = totalCount;
        }

        public int getPageCount() {
            return pageCount;
        }

        public void setPageCount(int pageCount) {
            this.pageCount = pageCount;
        }
    }

    public class ItemBean implements Serializable{
        /**
         * id : 1
         * uniqueId : 0a77c9f7-616d-4d69-92aa-06e1faa8c162
         * userUniqueId : e71c4616-1d09-4098-b7a0-1fe16037ef44
         * userCode : sample string 3
         * realName : sample string 4
         * mobile : sample string 5
         * telephone : sample string 6
         * zipCode : sample string 7
         * isDefault : 1
         * country : 1
         * province : 1
         * city : 1
         * district : 1
         * address_ : sample string 8
         * createTime : 2019-04-17T18:05:33.4523205+08:00
         * updateTime : 2019-04-17T18:05:33.4523205+08:00
         */

        private int id;
        private String uniqueId;
        private String userUniqueId;
//        private String userCode;
        private String realName;
        private String mobile;
        private String telephone;
        private String zipCode;
        private int isDefault;
        private int country;
        private int province;
        private int city;
        private int district;
        private String address_;
        private String createTime;
        private String updateTime;
        private String myAreaValues;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getUniqueId() {
            return uniqueId;
        }

        public void setUniqueId(String uniqueId) {
            this.uniqueId = uniqueId;
        }

        public String getUserUniqueId() {
            return userUniqueId;
        }

        public void setUserUniqueId(String userUniqueId) {
            this.userUniqueId = userUniqueId;
        }

//        public String getUserCode() {
//            return userCode;
//        }
//
//        public void setUserCode(String userCode) {
//            this.userCode = userCode;
//        }

        public String getRealName() {
            return realName;
        }

        public void setRealName(String realName) {
            this.realName = realName;
        }

        public String getMobile() {
            return mobile;
        }

        public void setMobile(String mobile) {
            this.mobile = mobile;
        }

        public String getTelephone() {
            return telephone;
        }

        public void setTelephone(String telephone) {
            this.telephone = telephone;
        }

        public String getZipCode() {
            return zipCode;
        }

        public void setZipCode(String zipCode) {
            this.zipCode = zipCode;
        }

        public int getIsDefault() {
            return isDefault;
        }

        public void setIsDefault(int isDefault) {
            this.isDefault = isDefault;
        }

        public int getCountry() {
            return country;
        }

        public void setCountry(int country) {
            this.country = country;
        }

        public int getProvince() {
            return province;
        }

        public void setProvince(int province) {
            this.province = province;
        }

        public int getCity() {
            return city;
        }

        public void setCity(int city) {
            this.city = city;
        }

        public int getDistrict() {
            return district;
        }

        public void setDistrict(int district) {
            this.district = district;
        }

        public String getAddress_() {
            return address_;
        }

        public void setAddress_(String address_) {
            this.address_ = address_;
        }

        public String getCreateTime() {
            return createTime;
        }

        public void setCreateTime(String createTime) {
            this.createTime = createTime;
        }

        public String getUpdateTime() {
            return updateTime;
        }

        public void setUpdateTime(String updateTime) {
            this.updateTime = updateTime;
        }

        public String getMyAreaValues() {
            return myAreaValues;
        }

        public void setMyAreaValues(String myAreaValues) {
            this.myAreaValues = myAreaValues;
        }
    }
}
