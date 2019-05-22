package com.gemall.library.bean;

import java.util.List;

/**
 * @auther g-emall
 * @date 2019/5/14 17:50
 * @desc
 */
public class CreateOrderListOrListBottomBean {
    private String salesorderuid;
    private String salesOrderCode;
    private double payAmount;
    private List<OrderInfo.ListBean.SalesItemBean> salesItem;

    public double getPayAmount() {
        return payAmount;
    }

    public void setPayAmount(double payAmount) {
        this.payAmount = payAmount;
    }

    public String getSalesorderuid() {
        return salesorderuid;
    }

    public void setSalesorderuid(String salesorderuid) {
        this.salesorderuid = salesorderuid;
    }

    public String getSalesOrderCode() {
        return salesOrderCode;
    }

    public void setSalesOrderCode(String salesOrderCode) {
        this.salesOrderCode = salesOrderCode;
    }

    public List<OrderInfo.ListBean.SalesItemBean> getSalesItem() {
        return salesItem;
    }

    public void setSalesItem(List<OrderInfo.ListBean.SalesItemBean> salesItem) {
        this.salesItem = salesItem;
    }
}
