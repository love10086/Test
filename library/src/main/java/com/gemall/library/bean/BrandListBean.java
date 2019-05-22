package com.gemall.library.bean;

import java.io.Serializable;
import java.util.List;

public class BrandListBean implements Serializable {


    /**
     * pageInfo : {"totalCount":1,"pageCount":2}
     * list : [{"uniqueId":"244075d8-f1b5-4fe2-ab2f-2962741e7ac2","title":"sample string 2","image":"sample string 3","description":"sample string 4","brandsProducts":[{"productUniqueID":"6f8ad157-770e-4efb-b638-ea77a72126c8","sellingPoints":"sample string 2","name":"sample string 3","productImage":"sample string 4","salesVolume":5,"defaultPrice":6},{"productUniqueID":"6f8ad157-770e-4efb-b638-ea77a72126c8","sellingPoints":"sample string 2","name":"sample string 3","productImage":"sample string 4","salesVolume":5,"defaultPrice":6}]},{"uniqueId":"244075d8-f1b5-4fe2-ab2f-2962741e7ac2","title":"sample string 2","image":"sample string 3","description":"sample string 4","brandsProducts":[{"productUniqueID":"6f8ad157-770e-4efb-b638-ea77a72126c8","sellingPoints":"sample string 2","name":"sample string 3","productImage":"sample string 4","salesVolume":5,"defaultPrice":6},{"productUniqueID":"6f8ad157-770e-4efb-b638-ea77a72126c8","sellingPoints":"sample string 2","name":"sample string 3","productImage":"sample string 4","salesVolume":5,"defaultPrice":6}]}]
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
         * totalCount : 1
         * pageCount : 2
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

    public static class ListBean {
        /**
         * uniqueId : 244075d8-f1b5-4fe2-ab2f-2962741e7ac2
         * title : sample string 2
         * image : sample string 3
         * description : sample string 4
         * brandsProducts : [{"productUniqueID":"6f8ad157-770e-4efb-b638-ea77a72126c8","sellingPoints":"sample string 2","name":"sample string 3","productImage":"sample string 4","salesVolume":5,"defaultPrice":6},{"productUniqueID":"6f8ad157-770e-4efb-b638-ea77a72126c8","sellingPoints":"sample string 2","name":"sample string 3","productImage":"sample string 4","salesVolume":5,"defaultPrice":6}]
         */

        private String uniqueId;
        private String title;
        private String image;
        private String description;
        private List<BrandsProductsBean> brandsProducts;

        public String getUniqueId() {
            return uniqueId;
        }

        public void setUniqueId(String uniqueId) {
            this.uniqueId = uniqueId;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public List<BrandsProductsBean> getBrandsProducts() {
            return brandsProducts;
        }

        public void setBrandsProducts(List<BrandsProductsBean> brandsProducts) {
            this.brandsProducts = brandsProducts;
        }

        public static class BrandsProductsBean {
            /**
             * productUniqueID : 6f8ad157-770e-4efb-b638-ea77a72126c8
             * sellingPoints : sample string 2
             * name : sample string 3
             * productImage : sample string 4
             * salesVolume : 5
             * defaultPrice : 6
             */

            private String productUniqueID;
            private String sellingPoints;
            private String name;
            private String productImage;
            private double salesVolume;
            private double defaultPrice;
            private int totalStock;

            public int getTotalStock() {
                return totalStock;
            }

            public void setTotalStock(int totalStock) {
                this.totalStock = totalStock;
            }

            public String getProductUniqueID() {
                return productUniqueID;
            }

            public void setProductUniqueID(String productUniqueID) {
                this.productUniqueID = productUniqueID;
            }

            public String getSellingPoints() {
                return sellingPoints;
            }

            public void setSellingPoints(String sellingPoints) {
                this.sellingPoints = sellingPoints;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getProductImage() {
                return productImage;
            }

            public void setProductImage(String productImage) {
                this.productImage = productImage;
            }

            public double getSalesVolume() {
                return salesVolume;
            }

            public void setSalesVolume(double salesVolume) {
                this.salesVolume = salesVolume;
            }

            public double getDefaultPrice() {
                return defaultPrice;
            }

            public void setDefaultPrice(double defaultPrice) {
                this.defaultPrice = defaultPrice;
            }
        }
    }
}
