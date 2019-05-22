package com.gemall.library.bean.requestbean;

import java.io.Serializable;
import java.util.List;

public class NewProductSell implements Serializable {


    /**
     * pageInfo : {"totalCount":1,"pageCount":2}
     * list : [{"id":1,"uniqueId":"00ceaf6b-1a7a-4a67-996e-15f2e9ecafbd","name":"sample string 3","sellingPoints":"sample string 4","categoryUniqueID":"00345f81-9131-4e1a-b39c-57ed079b2d5e","isPublish":1,"status":1,"totalStock":1,"defaultPrice":1,"supplyPrice":1,"productPictures":"sample string 5","description":"sample string 6","keywords":"sample string 7","salesVolume":1,"isFeeFree":1,"weight":1.1,"volume":1.1,"sort":1,"storeUniqueID":"1b89a711-c5d8-4284-9631-55abf914d5c9","brandsUniqueId":"9dda5467-28a1-4f93-bacf-2e3776350567","createTime":"2019-04-17T10:48:25.4656836+08:00","updateTime":"2019-04-17T10:48:25.4656836+08:00","logisticsTemplateUID":"e3ec3c7b-325b-4dcd-b3c8-7b4b5e7259c1"},{"id":1,"uniqueId":"00ceaf6b-1a7a-4a67-996e-15f2e9ecafbd","name":"sample string 3","sellingPoints":"sample string 4","categoryUniqueID":"00345f81-9131-4e1a-b39c-57ed079b2d5e","isPublish":1,"status":1,"totalStock":1,"defaultPrice":1,"supplyPrice":1,"productPictures":"sample string 5","description":"sample string 6","keywords":"sample string 7","salesVolume":1,"isFeeFree":1,"weight":1.1,"volume":1.1,"sort":1,"storeUniqueID":"1b89a711-c5d8-4284-9631-55abf914d5c9","brandsUniqueId":"9dda5467-28a1-4f93-bacf-2e3776350567","createTime":"2019-04-17T10:48:25.4656836+08:00","updateTime":"2019-04-17T10:48:25.4656836+08:00","logisticsTemplateUID":"e3ec3c7b-325b-4dcd-b3c8-7b4b5e7259c1"}]
     */

    private PageInfoBean pageInfo;
    private List<ListBean> list;

    public PageInfoBean getPageInfo() {
        return pageInfo;
    }

    public void setPageInfo(PageInfoBean pageInfo) {
        this.pageInfo = pageInfo;
    }

    public List<ListBean> getList() {
        return list;
    }

    public void setList(List<ListBean> list) {
        this.list = list;
    }

    public static class PageInfoBean  implements Serializable{
        /**
         * totalCount : 1
         * pageCount : 2
         */

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

    public static class ListBean implements Serializable{
        /**
         * id : 1
         * uniqueId : 00ceaf6b-1a7a-4a67-996e-15f2e9ecafbd
         * name : sample string 3
         * sellingPoints : sample string 4
         * categoryUniqueID : 00345f81-9131-4e1a-b39c-57ed079b2d5e
         * isPublish : 1
         * status : 1
         * totalStock : 1
         * defaultPrice : 1.0
         * supplyPrice : 1.0
         * productPictures : sample string 5
         * description : sample string 6
         * keywords : sample string 7
         * salesVolume : 1
         * isFeeFree : 1
         * weight : 1.1
         * volume : 1.1
         * sort : 1
         * storeUniqueID : 1b89a711-c5d8-4284-9631-55abf914d5c9
         * brandsUniqueId : 9dda5467-28a1-4f93-bacf-2e3776350567
         * createTime : 2019-04-17T10:48:25.4656836+08:00
         * updateTime : 2019-04-17T10:48:25.4656836+08:00
         * logisticsTemplateUID : e3ec3c7b-325b-4dcd-b3c8-7b4b5e7259c1
         */

        private int id;
        private String uniqueId;
        private String name;
        private String sellingPoints;
        private String categoryUniqueID;
        private int isPublish;
        private int status;
        private int totalStock;
        private double defaultPrice;
        private double supplyPrice;
        private String productPictures;
        private String description;
        private String keywords;
        private int salesVolume;
        private int isFeeFree;
        private double weight;
        private double volume;
        private int sort;
        private String storeUniqueID;
        private String brandsUniqueId;
        private String createTime;
        private String updateTime;
        private String logisticsTemplateUID;

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

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getSellingPoints() {
            return sellingPoints;
        }

        public void setSellingPoints(String sellingPoints) {
            this.sellingPoints = sellingPoints;
        }

        public String getCategoryUniqueID() {
            return categoryUniqueID;
        }

        public void setCategoryUniqueID(String categoryUniqueID) {
            this.categoryUniqueID = categoryUniqueID;
        }

        public int getIsPublish() {
            return isPublish;
        }

        public void setIsPublish(int isPublish) {
            this.isPublish = isPublish;
        }

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }

        public int getTotalStock() {
            return totalStock;
        }

        public void setTotalStock(int totalStock) {
            this.totalStock = totalStock;
        }

        public double getDefaultPrice() {
            return defaultPrice;
        }

        public void setDefaultPrice(double defaultPrice) {
            this.defaultPrice = defaultPrice;
        }

        public double getSupplyPrice() {
            return supplyPrice;
        }

        public void setSupplyPrice(double supplyPrice) {
            this.supplyPrice = supplyPrice;
        }

        public String getProductPictures() {
            return productPictures;
        }

        public void setProductPictures(String productPictures) {
            this.productPictures = productPictures;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getKeywords() {
            return keywords;
        }

        public void setKeywords(String keywords) {
            this.keywords = keywords;
        }

        public int getSalesVolume() {
            return salesVolume;
        }

        public void setSalesVolume(int salesVolume) {
            this.salesVolume = salesVolume;
        }

        public int getIsFeeFree() {
            return isFeeFree;
        }

        public void setIsFeeFree(int isFeeFree) {
            this.isFeeFree = isFeeFree;
        }

        public double getWeight() {
            return weight;
        }

        public void setWeight(double weight) {
            this.weight = weight;
        }

        public double getVolume() {
            return volume;
        }

        public void setVolume(double volume) {
            this.volume = volume;
        }

        public int getSort() {
            return sort;
        }

        public void setSort(int sort) {
            this.sort = sort;
        }

        public String getStoreUniqueID() {
            return storeUniqueID;
        }

        public void setStoreUniqueID(String storeUniqueID) {
            this.storeUniqueID = storeUniqueID;
        }

        public String getBrandsUniqueId() {
            return brandsUniqueId;
        }

        public void setBrandsUniqueId(String brandsUniqueId) {
            this.brandsUniqueId = brandsUniqueId;
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

        public String getLogisticsTemplateUID() {
            return logisticsTemplateUID;
        }

        public void setLogisticsTemplateUID(String logisticsTemplateUID) {
            this.logisticsTemplateUID = logisticsTemplateUID;
        }
    }
}
