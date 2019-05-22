package com.gemall.library.bean;

import java.io.Serializable;

/**
 * @auther g-emall
 * @date 2019/4/15 18:18
 */
public class OrderTransforDataBean implements Serializable {
    public final static int TOP_ITEM = 1;//头部：时间，类型
    public final static int PRODUCT_ITEM = 2;//商品信息
    public final static int PRICES_ITEM = 3;//价格信息
    public final static int BOTTOM_WAIT_PAY_ITEM = 4;//待付款
    public final static int BOTTOM_WAIT_SEND_PRODUCT_ITEM = 5;//待发货
    public final static int BOTTOM_WAIT_RECEIVE_PRODUCT_ITEM = 6;//待收货
    public final static int BOTTOM_WAIT_EVALUATE_ITEM = 7;//待评价
    public final static int BOTTOM_EVALUATED_ITEM = 8;//已评价
    public final static int BOTTOM_CLOSED_ITEM = 9;//已关闭
    public final static int EMPTY_ITEM = 10;//空数据
    public final static int BOTTOM_REFUNDING_ITEM = 11;//退款中
    public final static int BOTTOM_REFUNDFAILUE_ITEM = 12;//退款失败
    public final static int BOTTOM_REFUNDSUCCESS_ITEM = 13;//退款成功
    private int type;
    private Object data;

    public OrderTransforDataBean(int type, Object data) {
        this.type = type;
        this.data = data;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public static class OrderTopBean implements Serializable {
        private String createDate;
        private String orderType;

        public OrderTopBean(String createDate, String orderType) {
            this.createDate = createDate;
            this.orderType = orderType;
        }

        public String getCreateDate() {
            return createDate;
        }

        public void setCreateDate(String createDate) {
            this.createDate = createDate;
        }

        public String getOrderType() {
            return orderType;
        }

        public void setOrderType(String orderType) {
            this.orderType = orderType;
        }
    }

    public static class OrderPricesBean implements Serializable {
        private String productTotalCount;
        private String totalPrices;

        public OrderPricesBean(String productCount, String totalPrices) {
            this.productTotalCount = productCount;
            this.totalPrices = totalPrices;
        }

        public String getProductTotalCount() {
            return productTotalCount;
        }

        public void setProductTotalCount(String productTotalCount) {
            this.productTotalCount = productTotalCount;
        }

        public String getTotalPrices() {
            return totalPrices;
        }

        public void setTotalPrices(String totalPrices) {
            this.totalPrices = totalPrices;
        }
    }

    public static class OrderProductBean implements Serializable {
        private String imgUrl;
        private String productName;
        private String productUnitPrice;//单价
        private String sameProductCount;


        public String getImgUrl() {
            return imgUrl;
        }

        public void setImgUrl(String imgUrl) {
            this.imgUrl = imgUrl;
        }

        public String getProductName() {
            return productName;
        }

        public void setProductName(String productName) {
            this.productName = productName;
        }

        public String getProductUnitPrice() {
            return productUnitPrice;
        }

        public void setProductUnitPrice(String productUnitPrice) {
            this.productUnitPrice = productUnitPrice;
        }

        public String getSameProductCount() {
            return sameProductCount;
        }

        public void setSameProductCount(String sameProductCount) {
            this.sameProductCount = sameProductCount;
        }
    }

    public static class OrderOperateBean implements Serializable {
        private String productCount;
        private String totalPrices;

        public OrderOperateBean(String productCount, String totalPrices) {
            this.productCount = productCount;
            this.totalPrices = totalPrices;
        }

        public String getProductCount() {
            return productCount;
        }

        public void setProductCount(String productCount) {
            this.productCount = productCount;
        }

        public String getTotalPrices() {
            return totalPrices;
        }

        public void setTotalPrices(String totalPrices) {
            this.totalPrices = totalPrices;
        }
    }

}
