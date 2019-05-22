package com.gemall.library.bean;

import java.io.Serializable;
import java.util.List;

public class PayBean implements Serializable {

    private double payMoney;
    private List<String> OrderUids;


    public double getPayMoney() {
        return payMoney;
    }

    public void setPayMoney(double payMoney) {
        this.payMoney = payMoney;
    }

    public List<String> getOrderUids() {
        return OrderUids;
    }

    public void setOrderUids(List<String> orderUids) {
        OrderUids = orderUids;
    }
}
