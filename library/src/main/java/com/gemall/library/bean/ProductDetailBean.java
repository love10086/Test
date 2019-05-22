package com.gemall.library.bean;

import java.util.List;

/**
 * author : g-emall
 * time   : 2019/4/20
 * desc   : 获取商品详情、商品规格接口
 */
public class ProductDetailBean {


    /**
     * uniqueId : bf2cc1f4-66e9-4532-96ee-69e975ca5817
     * name : 颜色商品
     * sellingPoints : test
     * categoryUniqueID : bf2cc1f4-66e9-4532-96ee-69e975ca5817
     * isPublish : 1
     * status : 1
     * totalStock : 80
     * defaultPrice : 100
     * supplyPrice : 80
     * lowestPrice : 88
     * tallestPrice : 100
     * productPictures : ["gemall_20170927182704_03654859-60b4-4df3-9964-fecf42f66c30.png","gemall_20170927182713_f7e5865a-9097-4240-9969-55d184bae07b.png","gemall_20170927182726_e1afec9c-323d-44d0-af3d-2ae8ecac6cb2.png","gemall_20170927182742_adca27cb-ead3-46f3-87a2-fa2b76883097.png"]
     * description : test
     * keywords : 手动
     * salesVolume : 10
     * isFeeFree : 1
     * weight : 100
     * volume : 100
     * storeUniqueID : ee3b356c-ee6a-4c56-b31e-a3d419db7572
     * brandsUniqueId : ae951aeb-3717-4581-bce2-e125cae97382
     * spec : [{"uniqueId":"05b30289-fb2b-465b-a361-08997153fcbb","productUniqueId":"bf2cc1f4-66e9-4532-96ee-69e975ca5817","price":100,"stock":34,"saleVolume":5,"specName":"{\"1\":\"颜色\",\"2\":\"码数\"}","specValueName":"{\"1\":\"黑色\",\"2\":\"X码\"}","specUniqueID":"441FC323-9A29-446F-ACF0-D49492D65991;441FC323-9A29-446F-ACF0-D49492D65991","specValueUniqueID":"48637DFB-ACFD-46CD-A422-0B7169CCC701;45637DFB-ACFD-46CD-A422-0B7169CCC701","supplyPrice":80,"image":"gemall_20170927182742_adca27cb-ead3-46f3-87a2-fa2b76883097.png"},{"uniqueId":"333932d2-c9ce-41f6-9e63-42316a2597ac","productUniqueId":"bf2cc1f4-66e9-4532-96ee-69e975ca5817","price":88,"stock":50,"saleVolume":22,"specName":"{\"1\":\"颜色\",\"2\":\"码数\"}","specValueName":"{\"1\":\"白色\",\"2\":\"S码\"}","specUniqueID":"441FC323-9A29-446F-ACF0-D49492D65991;441FC323-9A29-446F-ACF0-D49492D65991","specValueUniqueID":"48637DFB-ACFD-46CD-A422-0B7169CCC701;45637DFB-ACFD-46CD-A422-0B7169CCC701","supplyPrice":80,"image":"gemall_20170927182726_e1afec9c-323d-44d0-af3d-2ae8ecac6cb2.png"}]
     * isFavorite : false
     * evaluate : [{"uniqueId":"e62379fb-95cb-479d-999e-c3c37c2c39c4","userUniqueId":"d989362e-dbf2-43c4-acd6-0fe8cdcc98ff","userCode":"GW99999943","userName":"******9943","evaluateContent":"444444444","evaluateLevel":4,"evaluateStar":4,"evaluateImage":["[\"gemall_20170927182704_03654859-60b4-4df3-9964-fecf42f66c30.png\"","\"gemall_20170927182704_03654859-60b4-4df3-9964-fecf42f66c30.png\"]"]}]
     * evaluateCount : 4
     * productSpecKeyValue : {"颜色":["黑色","白色"],"码数":["X码","S码"]}
     */

    private String uniqueId;
    private String name;
    private String sellingPoints;
    private String categoryUniqueID;
    private int isPublish;
    private int status;
    private int totalStock;
    private String defaultPrice;
    private String supplyPrice;
    private String lowestPrice;
    private String tallestPrice;
    private String description;
    private String keywords;
    private int salesVolume;
    private int isFeeFree;
    private int weight;
    private int volume;
    private String storeUniqueID;
    private String brandsUniqueId;
    private boolean isFavorite;
    private int evaluateCount;
    private List<String> productPictures;
    private List<SpecBean> spec;
    private List<EvaluateBean> evaluate;
    private List<ProductSpecsBean> productSpecs;


    public String getUniqueId() {
        return uniqueId;
    }

    public void setUniqueId(String uniqueId) {
        this.uniqueId = uniqueId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSellingPoints() {
        return sellingPoints;
    }

    public void setSellingPoints(String sellingPoints) {
        this.sellingPoints = sellingPoints;
    }

    public String getCategoryUniqueID() {
        return categoryUniqueID;
    }

    public void setCategoryUniqueID(String categoryUniqueID) {
        this.categoryUniqueID = categoryUniqueID;
    }

    public int getIsPublish() {
        return isPublish;
    }

    public void setIsPublish(int isPublish) {
        this.isPublish = isPublish;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getTotalStock() {
        return totalStock;
    }

    public void setTotalStock(int totalStock) {
        this.totalStock = totalStock;
    }

    public String getDefaultPrice() {
        return defaultPrice;
    }

    public void setDefaultPrice(String defaultPrice) {
        this.defaultPrice = defaultPrice;
    }

    public String getSupplyPrice() {
        return supplyPrice;
    }

    public void setSupplyPrice(String supplyPrice) {
        this.supplyPrice = supplyPrice;
    }

    public String getLowestPrice() {
        return lowestPrice;
    }

    public void setLowestPrice(String lowestPrice) {
        this.lowestPrice = lowestPrice;
    }

    public String getTallestPrice() {
        return tallestPrice;
    }

    public void setTallestPrice(String tallestPrice) {
        this.tallestPrice = tallestPrice;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    public int getSalesVolume() {
        return salesVolume;
    }

    public void setSalesVolume(int salesVolume) {
        this.salesVolume = salesVolume;
    }

    public int getIsFeeFree() {
        return isFeeFree;
    }

    public void setIsFeeFree(int isFeeFree) {
        this.isFeeFree = isFeeFree;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public String getStoreUniqueID() {
        return storeUniqueID;
    }

    public void setStoreUniqueID(String storeUniqueID) {
        this.storeUniqueID = storeUniqueID;
    }

    public String getBrandsUniqueId() {
        return brandsUniqueId;
    }

    public void setBrandsUniqueId(String brandsUniqueId) {
        this.brandsUniqueId = brandsUniqueId;
    }

    public boolean isIsFavorite() {
        return isFavorite;
    }

    public void setIsFavorite(boolean isFavorite) {
        this.isFavorite = isFavorite;
    }

    public int getEvaluateCount() {
        return evaluateCount;
    }

    public void setEvaluateCount(int evaluateCount) {
        this.evaluateCount = evaluateCount;
    }


    public List<String> getProductPictures() {
        return productPictures;
    }

    public void setProductPictures(List<String> productPictures) {
        this.productPictures = productPictures;
    }

    public List<SpecBean> getSpec() {
        return spec;
    }

    public void setSpec(List<SpecBean> spec) {
        this.spec = spec;
    }

    public List<EvaluateBean> getEvaluate() {
        return evaluate;
    }

    public void setEvaluate(List<EvaluateBean> evaluate) {
        this.evaluate = evaluate;
    }

    public List<ProductSpecsBean> getProductSpecs() {
        return productSpecs;
    }

    public void setProductSpecs(List<ProductSpecsBean> productSpecs) {
        this.productSpecs = productSpecs;
    }


    public static class SpecBean {
        /**
         * uniqueId : 05b30289-fb2b-465b-a361-08997153fcbb
         * productUniqueId : bf2cc1f4-66e9-4532-96ee-69e975ca5817
         * price : 100
         * stock : 34
         * saleVolume : 5
         * specName : {"1":"颜色","2":"码数"}
         * specValueName : {"1":"黑色","2":"X码"}
         * specUniqueID : 441FC323-9A29-446F-ACF0-D49492D65991;441FC323-9A29-446F-ACF0-D49492D65991
         * specValueUniqueID : 48637DFB-ACFD-46CD-A422-0B7169CCC701;45637DFB-ACFD-46CD-A422-0B7169CCC701
         * supplyPrice : 80
         * image : gemall_20170927182742_adca27cb-ead3-46f3-87a2-fa2b76883097.png
         */

        private String uniqueId;
        private String productUniqueId;
        private String price;
        private int stock;
        private int saleVolume;
        private String specName;
        private String specValueName;
        private String specUniqueID;
        private String specValueUniqueID;
        private String supplyPrice;
        private String image;
        private int selectQuantity;//自定义的添加商品数量

        public int getSelectQuantity() {
            return selectQuantity;
        }

        public void setSelectQuantity(int selectQuantity) {
            this.selectQuantity = selectQuantity;
        }

        public SpecBean() {
        }

        public SpecBean(String price, int stock) {
            this.price = price;
            this.stock = stock;
        }

        public String getUniqueId() {
            return uniqueId;
        }

        public void setUniqueId(String uniqueId) {
            this.uniqueId = uniqueId;
        }

        public String getProductUniqueId() {
            return productUniqueId;
        }

        public void setProductUniqueId(String productUniqueId) {
            this.productUniqueId = productUniqueId;
        }

        public String getPrice() {
            return price;
        }

        public void setPrice(String price) {
            this.price = price;
        }

        public int getStock() {
            return stock;
        }

        public void setStock(int stock) {
            this.stock = stock;
        }

        public int getSaleVolume() {
            return saleVolume;
        }

        public void setSaleVolume(int saleVolume) {
            this.saleVolume = saleVolume;
        }

        public String getSpecName() {
            return specName;
        }

        public void setSpecName(String specName) {
            this.specName = specName;
        }

        public String getSpecValueName() {
            return specValueName;
        }

        public void setSpecValueName(String specValueName) {
            this.specValueName = specValueName;
        }

        public String getSpecUniqueID() {
            return specUniqueID;
        }

        public void setSpecUniqueID(String specUniqueID) {
            this.specUniqueID = specUniqueID;
        }

        public String getSpecValueUniqueID() {
            return specValueUniqueID;
        }

        public void setSpecValueUniqueID(String specValueUniqueID) {
            this.specValueUniqueID = specValueUniqueID;
        }

        public String getSupplyPrice() {
            return supplyPrice;
        }

        public void setSupplyPrice(String supplyPrice) {
            this.supplyPrice = supplyPrice;
        }

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }
    }

    public static class EvaluateBean {
        /**
         * uniqueId : e62379fb-95cb-479d-999e-c3c37c2c39c4
         * userUniqueId : d989362e-dbf2-43c4-acd6-0fe8cdcc98ff
         * userCode : GW99999943
         * userName : ******9943
         * evaluateContent : 444444444
         * evaluateLevel : 4
         * evaluateStar : 4
         * evaluateImage : ["[\"gemall_20170927182704_03654859-60b4-4df3-9964-fecf42f66c30.png\"","\"gemall_20170927182704_03654859-60b4-4df3-9964-fecf42f66c30.png\"]"]
         */

        private String uniqueId;
        private String userUniqueId;
        private String userCode;
        private String userName;
        private String evaluateContent;
        private int evaluateLevel;
        private int evaluateStar;
        private List<String> evaluateImage;

        public String getUniqueId() {
            return uniqueId;
        }

        public void setUniqueId(String uniqueId) {
            this.uniqueId = uniqueId;
        }

        public String getUserUniqueId() {
            return userUniqueId;
        }

        public void setUserUniqueId(String userUniqueId) {
            this.userUniqueId = userUniqueId;
        }

        public String getUserCode() {
            return userCode;
        }

        public void setUserCode(String userCode) {
            this.userCode = userCode;
        }

        public String getUserName() {
            return userName;
        }

        public void setUserName(String userName) {
            this.userName = userName;
        }

        public String getEvaluateContent() {
            return evaluateContent;
        }

        public void setEvaluateContent(String evaluateContent) {
            this.evaluateContent = evaluateContent;
        }

        public int getEvaluateLevel() {
            return evaluateLevel;
        }

        public void setEvaluateLevel(int evaluateLevel) {
            this.evaluateLevel = evaluateLevel;
        }

        public int getEvaluateStar() {
            return evaluateStar;
        }

        public void setEvaluateStar(int evaluateStar) {
            this.evaluateStar = evaluateStar;
        }

        public List<String> getEvaluateImage() {
            return evaluateImage;
        }

        public void setEvaluateImage(List<String> evaluateImage) {
            this.evaluateImage = evaluateImage;
        }
    }

    public static class ProductSpecsBean {
        /**
         * specName : 颜色
         * specValues : ["黑色","白色"]
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
    }
}
