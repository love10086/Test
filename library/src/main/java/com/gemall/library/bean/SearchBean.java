package com.gemall.library.bean;

import java.util.List;

/**
 * author : g-emall
 * time   : 2019/4/20
 * desc   : 商品搜索
 */
public class SearchBean {

    /**
     * pageInfo : {"totalCount":1,"pageCount":2}
     * list : [{"uniqueId":"84386c82-61cd-4be7-a1e1-caac95aa5a65","name":"sample string 2","sellingPoints":"sample string 3","productPictures":"sample string 4","salesVolume":1,"defaultPrice":1,"createTime":"2019-04-20T17:11:46.2198596+08:00","updateTime":"2019-04-20T17:11:46.2198596+08:00","sort":5},{"uniqueId":"84386c82-61cd-4be7-a1e1-caac95aa5a65","name":"sample string 2","sellingPoints":"sample string 3","productPictures":"sample string 4","salesVolume":1,"defaultPrice":1,"createTime":"2019-04-20T17:11:46.2198596+08:00","updateTime":"2019-04-20T17:11:46.2198596+08:00","sort":5}]
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

    public static class PageInfoBean {
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

    public static class ListBean {
        /**
         * uniqueId : 84386c82-61cd-4be7-a1e1-caac95aa5a65
         * name : sample string 2
         * sellingPoints : sample string 3
         * productPictures : sample string 4
         * salesVolume : 1
         * defaultPrice : 1.0
         * createTime : 2019-04-20T17:11:46.2198596+08:00
         * updateTime : 2019-04-20T17:11:46.2198596+08:00
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
