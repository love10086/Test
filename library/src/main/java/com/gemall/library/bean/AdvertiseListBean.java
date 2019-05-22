package com.gemall.library.bean;

public class AdvertiseListBean {


    /**
     * code : sample string 1
     * id : 2
     * content : {"target":"sample string 1","targetType":2,"pictures":"sample string 3"}
     * startTime : 2019-04-19T17:03:35.8184902+08:00
     * endTime : 2019-04-19T17:03:35.8184902+08:00
     * sort : sample string 3
     * status : 1
     * provinceId : 1
     * cityId : 1
     * isExistPermission : true
     * title : sample string 5
     */

    private String code;
    private int id;
    private ContentBean content; // Json格式的广告内容,字段包括：TargetType：目标类型Target：目标Text：文字内容 Pictures：图片
    private String startTime;
    private String endTime;
    private String sort;
    private int status;
    private int provinceId;
    private int cityId;
    private boolean isExistPermission;
    private String title;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ContentBean getContent() {
        return content;
    }

    public void setContent(ContentBean content) {
        this.content = content;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(int provinceId) {
        this.provinceId = provinceId;
    }

    public int getCityId() {
        return cityId;
    }

    public void setCityId(int cityId) {
        this.cityId = cityId;
    }

    public boolean isIsExistPermission() {
        return isExistPermission;
    }

    public void setIsExistPermission(boolean isExistPermission) {
        this.isExistPermission = isExistPermission;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public static class ContentBean {
        /**
         * target : sample string 1
         * targetType : 2
         * pictures : sample string 3
         */

        private String target;
        private int targetType; // 目标类型：1：网址；2：商品；3：商品分类
        private String pictures;

        public String getTarget() {
            return target;
        }

        public void setTarget(String target) {
            this.target = target;
        }

        public int getTargetType() {
            return targetType;
        }

        public void setTargetType(int targetType) {
            this.targetType = targetType;
        }

        public String getPictures() {
            return pictures;
        }

        public void setPictures(String pictures) {
            this.pictures = pictures;
        }
    }
}
