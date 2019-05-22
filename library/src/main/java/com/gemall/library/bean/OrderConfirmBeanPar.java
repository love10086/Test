package com.gemall.library.bean;

import java.util.List;

public class OrderConfirmBeanPar {


    /**
     * clientSource : 1
     * addressUID : 1fc97a77-9230-4994-ac26-c4c8dcbce3eb
     * salesStoreItems : [{"storeUID":"cb18ca0a-184d-4905-b816-c7c4bea6f8d7","cartUID":"8a1a4cd9-7e5f-4d7b-a16c-39489281fa66","productUID":"b9bfd7e8-ec19-4388-af6d-38a189e46cdb","productName":"sample string 4","quantity":5,"productPictureURL":"sample string 6","productSpecUID":"01b33d48-f4bf-475b-aab4-df1a57a3755d"},{"storeUID":"cb18ca0a-184d-4905-b816-c7c4bea6f8d7","cartUID":"8a1a4cd9-7e5f-4d7b-a16c-39489281fa66","productUID":"b9bfd7e8-ec19-4388-af6d-38a189e46cdb","productName":"sample string 4","quantity":5,"productPictureURL":"sample string 6","productSpecUID":"01b33d48-f4bf-475b-aab4-df1a57a3755d"}]
     * remark : sample string 3
     * isCart : 4
     */

    private int clientSource;
    private String addressUID;
    private String remark;
    private int isCart;
    private List<SalesStoreItemsBean> salesStoreItems;

    public int getClientSource() {
        return clientSource;
    }

    public void setClientSource(int clientSource) {
        this.clientSource = clientSource;
    }

    public String getAddressUID() {
        return addressUID;
    }

    public void setAddressUID(String addressUID) {
        this.addressUID = addressUID;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public int getIsCart() {
        return isCart;
    }

    public void setIsCart(int isCart) {
        this.isCart = isCart;
    }

    public List<SalesStoreItemsBean> getSalesStoreItems() {
        return salesStoreItems;
    }

    public void setSalesStoreItems(List<SalesStoreItemsBean> salesStoreItems) {
        this.salesStoreItems = salesStoreItems;
    }

    public static class SalesStoreItemsBean {
        /**
         * storeUID : cb18ca0a-184d-4905-b816-c7c4bea6f8d7
         * cartUID : 8a1a4cd9-7e5f-4d7b-a16c-39489281fa66
         * productUID : b9bfd7e8-ec19-4388-af6d-38a189e46cdb
         * productName : sample string 4
         * quantity : 5
         * productPictureURL : sample string 6
         * productSpecUID : 01b33d48-f4bf-475b-aab4-df1a57a3755d
         */

        private String storeUID;
        private String cartUID;
        private String productUID;
        private String productName;
        private int quantity;
        private String productPictureURL;
        private String productSpecUID;

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
    }
}
