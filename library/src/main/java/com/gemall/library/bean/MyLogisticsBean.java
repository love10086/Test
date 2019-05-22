package com.gemall.library.bean;

public class MyLogisticsBean {
    private int status;//1：订单已提交 2：支付成功 3：订单已发货 4：订单交易成功 5：物流信息
    private String title;
    private String date;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
