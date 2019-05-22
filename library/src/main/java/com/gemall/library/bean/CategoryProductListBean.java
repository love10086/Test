package com.gemall.library.bean;

import java.io.Serializable;
import java.util.List;

public class CategoryProductListBean implements Serializable{


    /**
     * pageInfo : {"totalCount":1,"pageCount":2}
     * list : [{"uniqueId":"ffd6127d-79d6-4d8b-b21a-fc8e42e63fd3","name":"sample string 2","sellingPoints":"sample string 3","productPictures":"sample string 4","salesVolume":1,"defaultPrice":1,"createTime":"2019-04-19T15:31:26.4707699+08:00","updateTime":"2019-04-19T15:31:26.4707699+08:00","sort":5},{"uniqueId":"ffd6127d-79d6-4d8b-b21a-fc8e42e63fd3","name":"sample string 2","sellingPoints":"sample string 3","productPictures":"sample string 4","salesVolume":1,"defaultPrice":1,"createTime":"2019-04-19T15:31:26.4707699+08:00","updateTime":"2019-04-19T15:31:26.4707699+08:00","sort":5}]
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

    public static class PageInfoBean implements Serializable{
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

    public static class ListBean implements Serializable {
        /**
         * uniqueId : ffd6127d-79d6-4d8b-b21a-fc8e42e63fd3
         * name : sample string 2
         * sellingPoints : sample string 3
         * productPictures : sample string 4
         * salesVolume : 1
         * defaultPrice : 1
         * createTime : 2019-04-19T15:31:26.4707699+08:00
         * updateTime : 2019-04-19T15:31:26.4707699+08:00
         * sort : 5
         */

        private String uniqueId;
        private String name;
        private String sellingPoints;
        private String productPictures;
        private int salesVolume;
        private double defaultPrice;
        private String createTime;
        private String updateTime;
        private int sort;
        private int totalStock;

        public int getTotalStock() {
            return totalStock;
        }

        public void setTotalStock(int totalStock) {
            this.totalStock = totalStock;
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

        public String getProductPictures() {
            return productPictures;
        }

        public void setProductPictures(String productPictures) {
            this.productPictures = productPictures;
        }

        public int getSalesVolume() {
            return salesVolume;
        }

        public void setSalesVolume(int salesVolume) {
            this.salesVolume = salesVolume;
        }

        public double getDefaultPrice() {
            return defaultPrice;
        }

        public void setDefaultPrice(double defaultPrice) {
            this.defaultPrice = defaultPrice;
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

        public int getSort() {
            return sort;
        }

        public void setSort(int sort) {
            this.sort = sort;
        }
    }
}
