package com.gemall.library.bean.requestbean;

/**
 * @auther g-emall
 * @date 2019/4/18 14:47
 * @desc
 */
public class ChangeProductParam {

    /**
     * cartUID : 69a0644d-1e3f-4af7-aa36-f114bfeb0b88
     * productSpecUID : 528932d2-c9ce-41f6-9e63-42316a2597ac
     * productUID : 72944230-40e2-48c6-b8c3-f01ea3848801
     * quantity : 100
     */

    private String cartUID;
    private String productSpecUID;
    private String productUID;
    private int quantity;

    public String getCartUID() {
        return cartUID;
    }

    public void setCartUID(String cartUID) {
        this.cartUID = cartUID;
    }

    public String getProductSpecUID() {
        return productSpecUID;
    }

    public void setProductSpecUID(String productSpecUID) {
        this.productSpecUID = productSpecUID;
    }

    public String getProductUID() {
        return productUID;
    }

    public void setProductUID(String productUID) {
        this.productUID = productUID;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
