package com.gemall.library.bean;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * @auther g-emall
 * @date 2019/4/19 13:46
 * @desc
 */

public class OrderInfo implements Serializable {

    /**
     * pageInfo : {"totalCount":3,"pageCount":1}
     * list : [{"salesOrderCode":"010201905142573657","salesOrderUID":"6e12a2f1-6288-4bff-a931-9f711193c3ef","createTime":"2019-05-14T17:33:53.32","logisticsSignedTime":null,"logisticsDeliveredTime":null,"deliverMethodType":0,"totalAmount":10,"payAmount":10,"salesOrderStatus":1,"salesOrderStatusDesc":"待付款","salesOrderCloseType":null,"salesItem":[{"productUID":"25bc5e56-a449-49b0-a08b-8edf1a1e1d5a","productName":"321","quantity":1,"unitPrice":10,"totalAmount":10,"productPictureURL":"gemall_20190514094828_68a234b3-f1d4-48c3-981e-01b167e0d908.png","variantName":"颜色:红色"}],"remark":null,"logisticsContactName":"mmmm","province":null,"city":null,"district":null,"address":null,"mobile":"1562723555","salesItemCount":1,"productCount":1,"isRefunding":false,"refundAmount":0,"paymentTime":null,"closedTime":null},{"salesOrderCode":"010201905142573656","salesOrderUID":"b8473408-6ff3-418a-b4ed-678eb21d080f","createTime":"2019-05-14T17:12:48.36","logisticsSignedTime":null,"logisticsDeliveredTime":null,"deliverMethodType":0,"totalAmount":8,"payAmount":8,"salesOrderStatus":1,"salesOrderStatusDesc":"待付款","salesOrderCloseType":null,"salesItem":[{"productUID":"47ad5945-2f9c-448a-8f99-b7561440dee5","productName":"yyy01","quantity":1,"unitPrice":2,"totalAmount":2,"productPictureURL":"gemall_20190513182229_9f5b5193-87cf-4176-b5d7-bbf42c2ad50c.png","variantName":"尺寸:S码"},{"productUID":"47ad5945-2f9c-448a-8f99-b7561440dee5","productName":"yyy01","quantity":1,"unitPrice":2,"totalAmount":2,"productPictureURL":"gemall_20190513182229_9f5b5193-87cf-4176-b5d7-bbf42c2ad50c.png","variantName":"尺寸:S码"},{"productUID":"47ad5945-2f9c-448a-8f99-b7561440dee5","productName":"yyy01","quantity":1,"unitPrice":2,"totalAmount":2,"productPictureURL":"gemall_20190513182229_9f5b5193-87cf-4176-b5d7-bbf42c2ad50c.png","variantName":"尺寸:S码"},{"productUID":"47ad5945-2f9c-448a-8f99-b7561440dee5","productName":"yyy01","quantity":1,"unitPrice":2,"totalAmount":2,"productPictureURL":"gemall_20190513182229_9f5b5193-87cf-4176-b5d7-bbf42c2ad50c.png","variantName":"尺寸:S码"}],"remark":null,"logisticsContactName":"mmmm","province":null,"city":null,"district":null,"address":null,"mobile":"1562723555","salesItemCount":4,"productCount":4,"isRefunding":false,"refundAmount":0,"paymentTime":null,"closedTime":null},{"salesOrderCode":"010201905142573655","salesOrderUID":"7c8db34e-40c7-4844-b375-0a7736261dfb","createTime":"2019-05-14T16:55:19.173","logisticsSignedTime":null,"logisticsDeliveredTime":null,"deliverMethodType":0,"totalAmount":2,"payAmount":2,"salesOrderStatus":1,"salesOrderStatusDesc":"待付款","salesOrderCloseType":null,"salesItem":[{"productUID":"a8a91881-5647-4000-a56f-576f09a9f6ee","productName":"名称050905","quantity":1,"unitPrice":2,"totalAmount":2,"productPictureURL":"gemall_20190509183401_56baa0a6-3093-4065-b166-8aebd84da1fa.jpg","variantName":"商品重量:800g,尺寸:XL码"}],"remark":null,"logisticsContactName":"mmmm","province":null,"city":null,"district":null,"address":null,"mobile":"1562723555","salesItemCount":1,"productCount":1,"isRefunding":false,"refundAmount":0,"paymentTime":null,"closedTime":null}]
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
         * totalCount : 3
         * pageCount : 1
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
         * salesOrderCode : 010201905142573657
         * salesOrderUID : 6e12a2f1-6288-4bff-a931-9f711193c3ef
         * createTime : 2019-05-14T17:33:53.32
         * logisticsSignedTime : null
         * logisticsDeliveredTime : null
         * deliverMethodType : 0
         * totalAmount : 10.0
         * payAmount : 10.0
         * salesOrderStatus : 1
         * salesOrderStatusDesc : 待付款
         * salesOrderCloseType : null
         * salesItem : [{"productUID":"25bc5e56-a449-49b0-a08b-8edf1a1e1d5a","productName":"321","quantity":1,"unitPrice":10,"totalAmount":10,"productPictureURL":"gemall_20190514094828_68a234b3-f1d4-48c3-981e-01b167e0d908.png","variantName":"颜色:红色"}]
         * remark : null
         * logisticsContactName : mmmm
         * province : null
         * city : null
         * district : null
         * address : null
         * mobile : 1562723555
         * salesItemCount : 1
         * productCount : 1
         * isRefunding : false
         * refundAmount : 0.0
         * paymentTime : null
         * closedTime : null
         */

        private String salesOrderCode;
        private String salesOrderUID;
        private String createTime;
        private Object logisticsSignedTime;
        private Object logisticsDeliveredTime;
        private int deliverMethodType;
        private double totalAmount;
        private double payAmount;
        private int salesOrderStatus;
        private String salesOrderStatusDesc;
        private Object salesOrderCloseType;
        private Object remark;
        private String logisticsContactName;
        private Object province;
        private Object city;
        private Object district;
        private Object address;
        private String mobile;
        private int salesItemCount;
        private int productCount;
        private boolean isRefunding;
        private double refundAmount;
        private Object paymentTime;
        private Object closedTime;
        private List<SalesItemBean> salesItem;

        public String getSalesOrderCode() {
            return salesOrderCode;
        }

        public void setSalesOrderCode(String salesOrderCode) {
            this.salesOrderCode = salesOrderCode;
        }

        public String getSalesOrderUID() {
            return salesOrderUID;
        }

        public void setSalesOrderUID(String salesOrderUID) {
            this.salesOrderUID = salesOrderUID;
        }

        public String getCreateTime() {
            return createTime;
        }

        public void setCreateTime(String createTime) {
            this.createTime = createTime;
        }

        public Object getLogisticsSignedTime() {
            return logisticsSignedTime;
        }

        public void setLogisticsSignedTime(Object logisticsSignedTime) {
            this.logisticsSignedTime = logisticsSignedTime;
        }

        public Object getLogisticsDeliveredTime() {
            return logisticsDeliveredTime;
        }

        public void setLogisticsDeliveredTime(Object logisticsDeliveredTime) {
            this.logisticsDeliveredTime = logisticsDeliveredTime;
        }

        public int getDeliverMethodType() {
            return deliverMethodType;
        }

        public void setDeliverMethodType(int deliverMethodType) {
            this.deliverMethodType = deliverMethodType;
        }

        public double getTotalAmount() {
            return totalAmount;
        }

        public void setTotalAmount(double totalAmount) {
            this.totalAmount = totalAmount;
        }

        public double getPayAmount() {
            return payAmount;
        }

        public void setPayAmount(double payAmount) {
            this.payAmount = payAmount;
        }

        public int getSalesOrderStatus() {
            return salesOrderStatus;
        }

        public void setSalesOrderStatus(int salesOrderStatus) {
            this.salesOrderStatus = salesOrderStatus;
        }

        public String getSalesOrderStatusDesc() {
            return salesOrderStatusDesc;
        }

        public void setSalesOrderStatusDesc(String salesOrderStatusDesc) {
            this.salesOrderStatusDesc = salesOrderStatusDesc;
        }

        public Object getSalesOrderCloseType() {
            return salesOrderCloseType;
        }

        public void setSalesOrderCloseType(Object salesOrderCloseType) {
            this.salesOrderCloseType = salesOrderCloseType;
        }

        public Object getRemark() {
            return remark;
        }

        public void setRemark(Object remark) {
            this.remark = remark;
        }

        public String getLogisticsContactName() {
            return logisticsContactName;
        }

        public void setLogisticsContactName(String logisticsContactName) {
            this.logisticsContactName = logisticsContactName;
        }

        public Object getProvince() {
            return province;
        }

        public void setProvince(Object province) {
            this.province = province;
        }

        public Object getCity() {
            return city;
        }

        public void setCity(Object city) {
            this.city = city;
        }

        public Object getDistrict() {
            return district;
        }

        public void setDistrict(Object district) {
            this.district = district;
        }

        public Object getAddress() {
            return address;
        }

        public void setAddress(Object address) {
            this.address = address;
        }

        public String getMobile() {
            return mobile;
        }

        public void setMobile(String mobile) {
            this.mobile = mobile;
        }

        public int getSalesItemCount() {
            return salesItemCount;
        }

        public void setSalesItemCount(int salesItemCount) {
            this.salesItemCount = salesItemCount;
        }

        public int getProductCount() {
            return productCount;
        }

        public void setProductCount(int productCount) {
            this.productCount = productCount;
        }

        public boolean isIsRefunding() {
            return isRefunding;
        }

        public void setIsRefunding(boolean isRefunding) {
            this.isRefunding = isRefunding;
        }

        public double getRefundAmount() {
            return refundAmount;
        }

        public void setRefundAmount(double refundAmount) {
            this.refundAmount = refundAmount;
        }

        public Object getPaymentTime() {
            return paymentTime;
        }

        public void setPaymentTime(Object paymentTime) {
            this.paymentTime = paymentTime;
        }

        public Object getClosedTime() {
            return closedTime;
        }

        public void setClosedTime(Object closedTime) {
            this.closedTime = closedTime;
        }

        public List<SalesItemBean> getSalesItem() {
            return salesItem;
        }

        public void setSalesItem(List<SalesItemBean> salesItem) {
            this.salesItem = salesItem;
        }

        public static class SalesItemBean implements Serializable {
            /**
             * productUID : 25bc5e56-a449-49b0-a08b-8edf1a1e1d5a
             * productName : 321
             * quantity : 1
             * unitPrice : 10.0
             * totalAmount : 10.0
             * productPictureURL : gemall_20190514094828_68a234b3-f1d4-48c3-981e-01b167e0d908.png
             * variantName : 颜色:红色
             */

            private String productUID;
            private String productName;
            private int quantity;
            private double unitPrice;
            private double totalAmount;
            private String productPictureURL;
            private String variantName;

            private int orderStatus;//这是自己在这里添加的非,方便列表展示
            private String orderUid;//这是自己在这里添加的非,方便列表展示
            private List<Map<String, String>> commentPhotoList;//商品评价图片列表
            private String evaluation;//商品评价

            public String getVariantName() {
                return variantName;
            }

            public void setVariantName(String variantName) {
                this.variantName = variantName;
            }

            public String getOrderUid() {
                return orderUid;
            }

            public void setOrderUid(String orderUid) {
                this.orderUid = orderUid;
            }

            public int getOrderStatus() {
                return orderStatus;
            }

            public void setOrderStatus(int salesOrderStatus) {
                this.orderStatus = salesOrderStatus;
            }

            public String getProductUID() {
                return productUID;
            }

            public void setProductUID(String productUID) {
                this.productUID = productUID;
            }

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

            public String getProductPictureURL() {
                return productPictureURL;
            }

            public void setProductPictureURL(String productPictureURL) {
                this.productPictureURL = productPictureURL;
            }

            public List<Map<String, String>> getCommentPhotoList() {
                return commentPhotoList;
            }

            public void setCommentPhotoList(List<Map<String, String>> commentPhotoList) {
                this.commentPhotoList = commentPhotoList;
            }

            public String getEvaluation() {
                return evaluation;
            }

            public void setEvaluation(String evaluation) {
                this.evaluation = evaluation;
            }
        }
    }

}
