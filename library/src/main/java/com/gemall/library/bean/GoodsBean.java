package com.gemall.library.bean;

import java.io.Serializable;

public class GoodsBean implements Serializable {


    /**
     * storeUID : 86fcf82c-4e2e-4c7f-8e1b-ec964bc242b7
     * cartUID : 624dd100-667a-4348-81d1-8ecf38908030
     * productUID : 2d9c0f68-523e-4185-8f1e-8516493c3d77
     * productName : sample string 4
     * quantity : 5
     * productPictureURL : sample string 6
     * productSpecUID : 8931a62c-48f3-4d7a-b74d-becfa71021d0
     */


    private double price;
    private String[] productSpec;

    private String storeUID;
    private String cartUID;
    private String productUID;
    private String productName;
    private int quantity;//数量
    private String productPictureURL;
    private String productSpecUID;
    private long stock;//库存

    public long getStock() {
        return stock;
    }

    public void setStock(long stock) {
        this.stock = stock;
    }

    public String[] getProductSpec() {
        return productSpec;
    }

    public void setProductSpec(String[] productSpec) {
        this.productSpec = productSpec;
    }

    public String getStoreUID() {
        return storeUID;
    }

    public void setStoreUID(String storeUID) {
        this.storeUID = storeUID;
    }

    public String getCartUID() {
        return cartUID;
    }

    public void setCartUID(String cartUID) {
        this.cartUID = cartUID;
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

    public String getProductPictureURL() {
        return productPictureURL;
    }

    public void setProductPictureURL(String productPictureURL) {
        this.productPictureURL = productPictureURL;
    }

    public String getProductSpecUID() {
        return productSpecUID;
    }

    public void setProductSpecUID(String productSpecUID) {
        this.productSpecUID = productSpecUID;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
