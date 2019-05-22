package com.gemall.library.bean;

import java.util.List;

/**
 * author : g-emall
 * time   : 2019/4/19
 * desc   : 品牌商品列表
 */
public class BrandProductListBean {

    /**
     * pageInfo : {"totalCount":1,"pageCount":2}
     * list : [{"productUniqueID":"7c56da7c-ccb0-4a7e-bea9-18f84a648022","sellingPoints":"sample string 2","name":"sample string 3","productImage":"sample string 4","salesVolume":5,"defaultPrice":6},{"productUniqueID":"7c56da7c-ccb0-4a7e-bea9-18f84a648022","sellingPoints":"sample string 2","name":"sample string 3","productImage":"sample string 4","salesVolume":5,"defaultPrice":6}]
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
         * productUniqueID : 7c56da7c-ccb0-4a7e-bea9-18f84a648022
         * sellingPoints : sample string 2
         * name : sample string 3
         * productImage : sample string 4
         * salesVolume : 5
         * defaultPrice : 6.0
         */

        private String productUniqueID;
        private String sellingPoints;
        private String name;
        private String productImage;
        private int salesVolume;
        private double defaultPrice;
        private int totalStock;

        public String getProductUniqueID() {
            return productUniqueID;
        }

        public void setProductUniqueID(String productUniqueID) {
            this.productUniqueID = productUniqueID;
        }

        public String getSellingPoints() {
            return sellingPoints;
        }

        public void setSellingPoints(String sellingPoints) {
            this.sellingPoints = sellingPoints;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getProductImage() {
            return productImage;
        }

        public void setProductImage(String productImage) {
            this.productImage = productImage;
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

        public int getTotalStock() {
            return totalStock;
        }

        public void setTotalStock(int totalStock) {
            totalStock = totalStock;
        }
    }
}
