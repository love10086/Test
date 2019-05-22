package com.gemall.library.bean;

import java.io.Serializable;
import java.util.List;

public class FavoritesBeanList implements Serializable {


    /**
     * pageInfo : {"totalCount":1,"pageCount":2}
     * list : [{"uniqueId":"6fcadaea-3542-488e-9c7d-c81e38f23117","name":"sample string 2","sellingPoints":"sample string 3","productPictures":"sample string 4","description":"sample string 5","defaultPrice":1,"supplyPrice":1,"isStockout":true,"createTime":"2019-05-09T13:33:38.9711685+08:00"},{"uniqueId":"6fcadaea-3542-488e-9c7d-c81e38f23117","name":"sample string 2","sellingPoints":"sample string 3","productPictures":"sample string 4","description":"sample string 5","defaultPrice":1,"supplyPrice":1,"isStockout":true,"createTime":"2019-05-09T13:33:38.9711685+08:00"}]
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

    public static class ListBean  implements Serializable{
        /**
         * uniqueId : 6fcadaea-3542-488e-9c7d-c81e38f23117
         * name : sample string 2
         * sellingPoints : sample string 3
         * productPictures : sample string 4
         * description : sample string 5
         * defaultPrice : 1
         * supplyPrice : 1
         * isStockout : true
         * createTime : 2019-05-09T13:33:38.9711685+08:00
         */


        private boolean isShowSelectedBut;

        private String uniqueId;
        private String name;
        private String sellingPoints;
        private String productPictures;
        private String description;
        private double defaultPrice;
        private int supplyPrice;
        private boolean isStockout;
        private String createTime;


        public boolean isShowSelectedBut() {
            return isShowSelectedBut;
        }

        public void setShowSelectedBut(boolean showSelectedBut) {
            isShowSelectedBut = showSelectedBut;
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

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public double getDefaultPrice() {
            return defaultPrice;
        }

        public void setDefaultPrice(double defaultPrice) {
            this.defaultPrice = defaultPrice;
        }

        public int getSupplyPrice() {
            return supplyPrice;
        }

        public void setSupplyPrice(int supplyPrice) {
            this.supplyPrice = supplyPrice;
        }

        public boolean isIsStockout() {
            return isStockout;
        }

        public void setIsStockout(boolean isStockout) {
            this.isStockout = isStockout;
        }

        public String getCreateTime() {
            return createTime;
        }

        public void setCreateTime(String createTime) {
            this.createTime = createTime;
        }
    }
}
