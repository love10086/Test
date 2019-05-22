package com.gemall.library.bean;

import java.util.List;

public class AfterSaleListBean {
    /**
     * pageInfo : {"totalCount":1,"pageCount":2}
     * list : [{"refundApplyUID":"dd2d64af-f509-485d-8607-99dcffa76424","refundApplyCode":"sample string 2","refundAmount":3,"applyStatus":4,"applyTime":"2019-04-23T15:29:18.2033349+08:00","productInfo":{"productName":"sample string 1","quantity":2,"productPictureURL":"sample string 3","unitPrice":4,"totalAmount":5}},{"refundApplyUID":"dd2d64af-f509-485d-8607-99dcffa76424","refundApplyCode":"sample string 2","refundAmount":3,"applyStatus":4,"applyTime":"2019-04-23T15:29:18.2033349+08:00","productInfo":{"productName":"sample string 1","quantity":2,"productPictureURL":"sample string 3","unitPrice":4,"totalAmount":5}}]
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
         * refundApplyUID : dd2d64af-f509-485d-8607-99dcffa76424
         * refundApplyCode : sample string 2
         * refundAmount : 3.0
         * applyStatus : 4
         * applyTime : 2019-04-23T15:29:18.2033349+08:00
         * productInfo : {"productName":"sample string 1","quantity":2,"productPictureURL":"sample string 3","unitPrice":4,"totalAmount":5}
         */

        private String refundApplyUID;
        private String refundApplyCode;
        private double refundAmount;
        private int applyStatus;
        private String applyTime;
        private ProductInfoBean productInfo;

        public String getRefundApplyUID() {
            return refundApplyUID;
        }

        public void setRefundApplyUID(String refundApplyUID) {
            this.refundApplyUID = refundApplyUID;
        }

        public String getRefundApplyCode() {
            return refundApplyCode;
        }

        public void setRefundApplyCode(String refundApplyCode) {
            this.refundApplyCode = refundApplyCode;
        }

        public double getRefundAmount() {
            return refundAmount;
        }

        public void setRefundAmount(double refundAmount) {
            this.refundAmount = refundAmount;
        }

        public int getApplyStatus() {
            return applyStatus;
        }

        public void setApplyStatus(int applyStatus) {
            this.applyStatus = applyStatus;
        }

        public String getApplyTime() {
            return applyTime;
        }

        public void setApplyTime(String applyTime) {
            this.applyTime = applyTime;
        }

        public ProductInfoBean getProductInfo() {
            return productInfo;
        }

        public void setProductInfo(ProductInfoBean productInfo) {
            this.productInfo = productInfo;
        }

        public static class ProductInfoBean {
            /**
             * productName : sample string 1
             * quantity : 2
             * productPictureURL : sample string 3
             * unitPrice : 4.0
             * totalAmount : 5.0
             */

            private String productName;
            private int quantity;
            private String productPictureURL;
            private double unitPrice;
            private double totalAmount;

            public String getProductName() {
                return productName;
            }

            public void setProductName(String productName) {
                this.productName = productName;
            }

            public int getQuantity() {
                return quantity;
            }

            public void setQuantity(int quantity) {
                this.quantity = quantity;
            }

            public String getProductPictureURL() {
                return productPictureURL;
            }

            public void setProductPictureURL(String productPictureURL) {
                this.productPictureURL = productPictureURL;
            }

            public double getUnitPrice() {
                return unitPrice;
            }

            public void setUnitPrice(double unitPrice) {
                this.unitPrice = unitPrice;
            }

            public double getTotalAmount() {
                return totalAmount;
            }

            public void setTotalAmount(double totalAmount) {
                this.totalAmount = totalAmount;
            }
        }
    }
}
