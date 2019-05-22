package com.gemall.library.bean;

import java.io.Serializable;

public class PayMethodsBean implements Serializable {


    /**
     * type : 1
     * name : 余额
     * min : 0
     * max : 0
     * amount : 0
     */

    private int type;
    private String name;
    private double min;
    private double max;
    private double amount;

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getMin() {
        return min;
    }

    public void setMin(double min) {
        this.min = min;
    }

    public double getMax() {
        return max;
    }

    public void setMax(double max) {
        this.max = max;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
