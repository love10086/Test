package com.gemall.library.bean;

import java.util.List;

/**
 * author : g-emall
 * time   : 2019/4/24
 * desc   : 评价列表
 */
public class OrderEvaluateListBean {

    /**
     * pageInfo : {"totalCount":1,"pageCount":2}
     * list : [{"uniqueId":"359edbd2-b1e3-4e2b-985d-3dfc63e9fece","userUniqueId":"3af17ae6-308a-4ad0-ad9b-46cc0794ec96","userCode":"sample string 2","userName":"sample string 3","orderUinqueId":"59133e41-f30c-4358-bf11-91b43766e19a","orderCode":"sample string 4","productUniqueId":"2a3cf925-ac78-4992-9976-646f65883e32","evaluateContent":"sample string 5","evaluateType":1,"evaluateLevel":1,"evaluateStar":1,"evaluateImage":["sample string 1","sample string 2"],"headPortraitURL":"sample string 6","isAnonymous":1,"createTime":"sample string 7"},{"uniqueId":"359edbd2-b1e3-4e2b-985d-3dfc63e9fece","userUniqueId":"3af17ae6-308a-4ad0-ad9b-46cc0794ec96","userCode":"sample string 2","userName":"sample string 3","orderUinqueId":"59133e41-f30c-4358-bf11-91b43766e19a","orderCode":"sample string 4","productUniqueId":"2a3cf925-ac78-4992-9976-646f65883e32","evaluateContent":"sample string 5","evaluateType":1,"evaluateLevel":1,"evaluateStar":1,"evaluateImage":["sample string 1","sample string 2"],"headPortraitURL":"sample string 6","isAnonymous":1,"createTime":"sample string 7"}]
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
         * uniqueId : 359edbd2-b1e3-4e2b-985d-3dfc63e9fece
         * userUniqueId : 3af17ae6-308a-4ad0-ad9b-46cc0794ec96
         * userCode : sample string 2
         * userName : sample string 3
         * orderUinqueId : 59133e41-f30c-4358-bf11-91b43766e19a
         * orderCode : sample string 4
         * productUniqueId : 2a3cf925-ac78-4992-9976-646f65883e32
         * evaluateContent : sample string 5
         * evaluateType : 1
         * evaluateLevel : 1
         * evaluateStar : 1
         * evaluateImage : ["sample string 1","sample string 2"]
         * headPortraitURL : sample string 6
         * isAnonymous : 1
         * createTime : sample string 7
         */

        private String uniqueId;
        private String userUniqueId;
//        private String userCode;
        private String userName;
        private String orderUinqueId;
        private String orderCode;
        private String productUniqueId;
        private String evaluateContent;
        private int evaluateType;
        private int evaluateLevel;
        private int evaluateStar;
        private String headPortraitURL;
        private int isAnonymous;
        private String createTime;
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

//        public String getUserCode() {
//            return userCode;
//        }
//
//        public void setUserCode(String userCode) {
//            this.userCode = userCode;
//        }

        public String getUserName() {
            return userName;
        }

        public void setUserName(String userName) {
            this.userName = userName;
        }

        public String getOrderUinqueId() {
            return orderUinqueId;
        }

        public void setOrderUinqueId(String orderUinqueId) {
            this.orderUinqueId = orderUinqueId;
        }

        public String getOrderCode() {
            return orderCode;
        }

        public void setOrderCode(String orderCode) {
            this.orderCode = orderCode;
        }

        public String getProductUniqueId() {
            return productUniqueId;
        }

        public void setProductUniqueId(String productUniqueId) {
            this.productUniqueId = productUniqueId;
        }

        public String getEvaluateContent() {
            return evaluateContent;
        }

        public void setEvaluateContent(String evaluateContent) {
            this.evaluateContent = evaluateContent;
        }

        public int getEvaluateType() {
            return evaluateType;
        }

        public void setEvaluateType(int evaluateType) {
            this.evaluateType = evaluateType;
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

        public String getHeadPortraitURL() {
            return headPortraitURL;
        }

        public void setHeadPortraitURL(String headPortraitURL) {
            this.headPortraitURL = headPortraitURL;
        }

        public int getIsAnonymous() {
            return isAnonymous;
        }

        public void setIsAnonymous(int isAnonymous) {
            this.isAnonymous = isAnonymous;
        }

        public String getCreateTime() {
            return createTime;
        }

        public void setCreateTime(String createTime) {
            this.createTime = createTime;
        }

        public List<String> getEvaluateImage() {
            return evaluateImage;
        }

        public void setEvaluateImage(List<String> evaluateImage) {
            this.evaluateImage = evaluateImage;
        }
    }
}
