package com.gemall.library.bean;

import java.io.Serializable;
import java.util.List;

/**
 * @auther g-emall
 * @date 2019/4/17 17:27
 * @desc
 */
public class ShoppingCartBean implements Serializable {


    /**
     * list : [{"cartProductImage":"gemall_20190425195539_7ec63a70-29d3-4932-a307-721e680e4772.jpg","cartStatus":1,"cartUID":"5af22dc7-87b2-4837-9eb8-feba553d5b65","createTime":"2019-04-28T17:22:32.227","price":1,"productName":"萨达萨达","productSpec":[{"productSpecImage":"gemall_20190425195539_7ec63a70-29d3-4932-a307-721e680e4772.jpg","productSpecName":"","productSpecPrice":1,"productSpecStock":1,"productSpecUniqueId":"3e99e851-fa8f-4f72-ba8b-63966c930053","productSpecValueInfo":"","productSpecValueName":"商品规格01:规格属性01,颜色:蓝","stock":1},{"productSpecImage":"gemall_20190425195539_7ec63a70-29d3-4932-a307-721e680e4772.jpg","productSpecName":"","productSpecPrice":1,"productSpecStock":1,"productSpecUniqueId":"4e6f5d8c-6bec-4d83-b8bb-055c8d1ede84","productSpecValueInfo":"","productSpecValueName":"商品规格01:规格属性01,颜色:蓝","stock":1}],"productSpecItem":[["规格属性01","蓝","红","3e99e851-fa8f-4f72-ba8b-63966c930053"],["规格属性01","蓝","红","4e6f5d8c-6bec-4d83-b8bb-055c8d1ede84"]],"productSpecKeyValue":[{"specName":"商品规格01","specValues":["规格属性01"]},{"specName":"颜色","specValues":["蓝"]}],"productSpecName":"","productSpecStatus":1,"productSpecStock":1,"productSpecUniqueId":"3e99e851-fa8f-4f72-ba8b-63966c930053","productSpecValueName":"商品规格01:规格属性01,颜色:蓝","productStatus":1,"productUID":"13cb39c1-1189-4578-aa82-0b925362c512","quantity":1,"storeUID":"00000000-0000-0000-0000-000000000000"}]
     * pageInfo : {"pageCount":1,"totalCount":1}
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

    public static class PageInfoBean implements Serializable {
        /**
         * pageCount : 1
         * totalCount : 1
         */

        private int pageCount;
        private int totalCount;

        public int getPageCount() {
            return pageCount;
        }

        public void setPageCount(int pageCount) {
            this.pageCount = pageCount;
        }

        public int getTotalCount() {
            return totalCount;
        }

        public void setTotalCount(int totalCount) {
            this.totalCount = totalCount;
        }
    }

    public static class ListBean implements Serializable {
        /**
         * cartProductImage : gemall_20190425195539_7ec63a70-29d3-4932-a307-721e680e4772.jpg
         * cartStatus : 1
         * cartUID : 5af22dc7-87b2-4837-9eb8-feba553d5b65
         * createTime : 2019-04-28T17:22:32.227
         * price : 1.0
         * productName : 萨达萨达
         * productSpec : [{"productSpecImage":"gemall_20190425195539_7ec63a70-29d3-4932-a307-721e680e4772.jpg","productSpecName":"","productSpecPrice":1,"productSpecStock":1,"productSpecUniqueId":"3e99e851-fa8f-4f72-ba8b-63966c930053","productSpecValueInfo":"","productSpecValueName":"商品规格01:规格属性01,颜色:蓝","stock":1},{"productSpecImage":"gemall_20190425195539_7ec63a70-29d3-4932-a307-721e680e4772.jpg","productSpecName":"","productSpecPrice":1,"productSpecStock":1,"productSpecUniqueId":"4e6f5d8c-6bec-4d83-b8bb-055c8d1ede84","productSpecValueInfo":"","productSpecValueName":"商品规格01:规格属性01,颜色:蓝","stock":1}]
         * productSpecItem : [["规格属性01","蓝","红","3e99e851-fa8f-4f72-ba8b-63966c930053"],["规格属性01","蓝","红","4e6f5d8c-6bec-4d83-b8bb-055c8d1ede84"]]
         * productSpecKeyValue : [{"specName":"商品规格01","specValues":["规格属性01"]},{"specName":"颜色","specValues":["蓝"]}]
         * productSpecName :
         * productSpecStatus : 1
         * productSpecStock : 1
         * productSpecUniqueId : 3e99e851-fa8f-4f72-ba8b-63966c930053
         * productSpecValueName : 商品规格01:规格属性01,颜色:蓝
         * productStatus : 1
         * productUID : 13cb39c1-1189-4578-aa82-0b925362c512
         * quantity : 1
         * storeUID : 00000000-0000-0000-0000-000000000000
         */
/*ProductStatus商品状态（0删除，1上架，2下架）
ProductSpecStatus商品规格状态（0删除，1正常）
CartStatus购物车状态（0失效，1正常）*/
        private String cartProductImage;
        private int cartStatus;
        private String cartUID;
        private String createTime;
        private double price;
        private String productName;
        private String productSpecName;
        private int productSpecStatus;
        private int productSpecStock;
        private String productSpecUniqueId;
        private String productSpecValueName;
        private int productStatus;
        private String productUID;
        private int quantity;
        private String storeUID;
        private boolean isSelected;
        private int type = 0;
        private List<ProductSpecBean> productSpec;
        private List<List<String>> productSpecItem;
        private List<ProductSpecKeyValueBean> productSpecKeyValue;

        public boolean isSelected() {
            return isSelected;
        }

        public void setSelected(boolean selected) {
            isSelected = selected;
        }

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public String getCartProductImage() {
            return cartProductImage;
        }

        public void setCartProductImage(String cartProductImage) {
            this.cartProductImage = cartProductImage;
        }

        public int getCartStatus() {
            return cartStatus;
        }

        public void setCartStatus(int cartStatus) {
            this.cartStatus = cartStatus;
        }

        public String getCartUID() {
            return cartUID;
        }

        public void setCartUID(String cartUID) {
            this.cartUID = cartUID;
        }

        public String getCreateTime() {
            return createTime;
        }

        public void setCreateTime(String createTime) {
            this.createTime = createTime;
        }

        public double getPrice() {
            return price;
        }

        public void setPrice(double price) {
            this.price = price;
        }

        public String getProductName() {
            return productName;
        }

        public void setProductName(String productName) {
            this.productName = productName;
        }

        public String getProductSpecName() {
            return productSpecName;
        }

        public void setProductSpecName(String productSpecName) {
            this.productSpecName = productSpecName;
        }

        public int getProductSpecStatus() {
            return productSpecStatus;
        }

        public void setProductSpecStatus(int productSpecStatus) {
            this.productSpecStatus = productSpecStatus;
        }

        public int getProductSpecStock() {
            return productSpecStock;
        }

        public void setProductSpecStock(int productSpecStock) {
            this.productSpecStock = productSpecStock;
        }

        public String getProductSpecUniqueId() {
            return productSpecUniqueId;
        }

        public void setProductSpecUniqueId(String productSpecUniqueId) {
            this.productSpecUniqueId = productSpecUniqueId;
        }

        public String getProductSpecValueName() {
            return productSpecValueName;
        }

        public void setProductSpecValueName(String productSpecValueName) {
            this.productSpecValueName = productSpecValueName;
        }

        public int getProductStatus() {
            return productStatus;
        }

        public void setProductStatus(int productStatus) {
            this.productStatus = productStatus;
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

        public String getStoreUID() {
            return storeUID;
        }

        public void setStoreUID(String storeUID) {
            this.storeUID = storeUID;
        }

        public List<ProductSpecBean> getProductSpec() {
            return productSpec;
        }

        public void setProductSpec(List<ProductSpecBean> productSpec) {
            this.productSpec = productSpec;
        }

        public List<List<String>> getProductSpecItem() {
            return productSpecItem;
        }

        public void setProductSpecItem(List<List<String>> productSpecItem) {
            this.productSpecItem = productSpecItem;
        }

        public List<ProductSpecKeyValueBean> getProductSpecKeyValue() {
            return productSpecKeyValue;
        }

        public void setProductSpecKeyValue(List<ProductSpecKeyValueBean> productSpecKeyValue) {
            this.productSpecKeyValue = productSpecKeyValue;
        }

        @Override
        public String toString() {
            return "ListBean{" +
                    "cartProductImage='" + cartProductImage + '\'' +
                    ", cartStatus=" + cartStatus +
                    ", cartUID='" + cartUID + '\'' +
                    ", createTime='" + createTime + '\'' +
                    ", price=" + price +
                    ", productName='" + productName + '\'' +
                    ", productSpecName='" + productSpecName + '\'' +
                    ", productSpecStatus=" + productSpecStatus +
                    ", productSpecStock=" + productSpecStock +
                    ", productSpecUniqueId='" + productSpecUniqueId + '\'' +
                    ", productSpecValueName='" + productSpecValueName + '\'' +
                    ", productStatus=" + productStatus +
                    ", productUID='" + productUID + '\'' +
                    ", quantity=" + quantity +
                    ", storeUID='" + storeUID + '\'' +
                    ", isSelected=" + isSelected +
                    ", type=" + type +
                    ", productSpec=" + productSpec +
                    ", productSpecItem=" + productSpecItem +
                    ", productSpecKeyValue=" + productSpecKeyValue +
                    '}';
        }

        public static class ProductSpecBean implements Serializable {
            /**
             * productSpecImage : gemall_20190425195539_7ec63a70-29d3-4932-a307-721e680e4772.jpg
             * productSpecName :
             * productSpecPrice : 1.0
             * productSpecStock : 1
             * productSpecUniqueId : 3e99e851-fa8f-4f72-ba8b-63966c930053
             * productSpecValueInfo :
             * productSpecValueName : 商品规格01:规格属性01,颜色:蓝
             * stock : 1
             */

            private String productSpecImage;
            private String productSpecName;
            private double productSpecPrice;
            private int productSpecStock;
            private String productSpecUniqueId;
            private String productSpecValueInfo;
            private String productSpecValueName;
            private int stock;

            public String getProductSpecImage() {
                return productSpecImage;
            }

            public void setProductSpecImage(String productSpecImage) {
                this.productSpecImage = productSpecImage;
            }

            public String getProductSpecName() {
                return productSpecName;
            }

            public void setProductSpecName(String productSpecName) {
                this.productSpecName = productSpecName;
            }

            public double getProductSpecPrice() {
                return productSpecPrice;
            }

            public void setProductSpecPrice(double productSpecPrice) {
                this.productSpecPrice = productSpecPrice;
            }

            public int getProductSpecStock() {
                return productSpecStock;
            }

            public void setProductSpecStock(int productSpecStock) {
                this.productSpecStock = productSpecStock;
            }

            public String getProductSpecUniqueId() {
                return productSpecUniqueId;
            }

            public void setProductSpecUniqueId(String productSpecUniqueId) {
                this.productSpecUniqueId = productSpecUniqueId;
            }

            public String getProductSpecValueInfo() {
                return productSpecValueInfo;
            }

            public void setProductSpecValueInfo(String productSpecValueInfo) {
                this.productSpecValueInfo = productSpecValueInfo;
            }

            public String getProductSpecValueName() {
                return productSpecValueName;
            }

            public void setProductSpecValueName(String productSpecValueName) {
                this.productSpecValueName = productSpecValueName;
            }

            public int getStock() {
                return stock;
            }

            public void setStock(int stock) {
                this.stock = stock;
            }

            @Override
            public String toString() {
                return "ProductSpecBean{" +
                        "productSpecImage='" + productSpecImage + '\'' +
                        ", productSpecName='" + productSpecName + '\'' +
                        ", productSpecPrice=" + productSpecPrice +
                        ", productSpecStock=" + productSpecStock +
                        ", productSpecUniqueId='" + productSpecUniqueId + '\'' +
                        ", productSpecValueInfo='" + productSpecValueInfo + '\'' +
                        ", productSpecValueName='" + productSpecValueName + '\'' +
                        ", stock=" + stock +
                        '}';
            }
        }

        public static class ProductSpecKeyValueBean implements Serializable {
            /**
             * specName : 商品规格01
             * specValues : ["规格属性01"]
             */

            private String specName;
            private List<String> specValues;

            public String getSpecName() {
                return specName;
            }

            public void setSpecName(String specName) {
                this.specName = specName;
            }

            public List<String> getSpecValues() {
                return specValues;
            }

            public void setSpecValues(List<String> specValues) {
                this.specValues = specValues;
            }

            @Override
            public String toString() {
                return "ProductSpecKeyValueBean{" +
                        "specName='" + specName + '\'' +
                        ", specValues=" + specValues +
                        '}';
            }
        }
    }
}
