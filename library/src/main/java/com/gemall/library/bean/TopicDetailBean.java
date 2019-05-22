package com.gemall.library.bean;

import java.util.List;

/**
 * author : g-emall
 * time   : 2019/4/23
 * desc   : 专题详情合并评论列表 自己合并商品列表
 */
public class TopicDetailBean {

    /**
     * info : {"uniqueId":"627c1361-25cb-442f-8c4a-72ee50978d80","title":"sample string 2","subtitle":"sample string 3","image":"sample string 4","topicContent":"sample string 5","browseNum":1,"isLike":6,"startTime":"2019-04-23T09:57:32.1655334+08:00","endTime":"2019-04-23T09:57:32.1655334+08:00"}
     * commentList : {"pageInfo":{"totalCount":1,"pageCount":2},"list":[{"uniqueId":"003b7ba0-9aac-4596-a8be-929b9c249523","topicUniqueId":"3d7c1570-31fe-4b87-8bd1-900723aed092","userUniqueId":"cf09f61f-06cf-4872-9d47-6784b165e335","userCode":"sample string 2","content":"sample string 3","status":1,"isAnonymous":1,"createTime":"2019-04-23T09:57:32.1755371+08:00"},{"uniqueId":"003b7ba0-9aac-4596-a8be-929b9c249523","topicUniqueId":"3d7c1570-31fe-4b87-8bd1-900723aed092","userUniqueId":"cf09f61f-06cf-4872-9d47-6784b165e335","userCode":"sample string 2","content":"sample string 3","status":1,"isAnonymous":1,"createTime":"2019-04-23T09:57:32.1755371+08:00"}]}
     */

    private InfoBean info; // 详情信息
    private CommentListBean commentList; //评论列表
    private TopicGoodsBean goodList; // 商品列表

    public InfoBean getInfo() {
        return info;
    }

    public void setInfo(InfoBean info) {
        this.info = info;
    }

    public TopicGoodsBean getGoodList() {
        return goodList;
    }

    public void setGoodList(TopicGoodsBean goodList) {
        this.goodList = goodList;
    }

    public CommentListBean getCommentList() {
        return commentList;
    }

    public void setCommentList(CommentListBean commentList) {
        this.commentList = commentList;
    }


    public static class InfoBean {
        /**
         * uniqueId : 627c1361-25cb-442f-8c4a-72ee50978d80
         * title : sample string 2
         * subtitle : sample string 3
         * image : sample string 4
         * topicContent : sample string 5
         * browseNum : 1
         * isLike : 6
         * startTime : 2019-04-23T09:57:32.1655334+08:00
         * endTime : 2019-04-23T09:57:32.1655334+08:00
         */

        private String uniqueId;
        private String title;
        private String subtitle;
        private String image;
        private String topicContent;
        private int browseNum;
        private int isLike;
        private String startTime;
        private String endTime;

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

        public String getSubtitle() {
            return subtitle;
        }

        public void setSubtitle(String subtitle) {
            this.subtitle = subtitle;
        }

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }

        public String getTopicContent() {
            return topicContent;
        }

        public void setTopicContent(String topicContent) {
            this.topicContent = topicContent;
        }

        public int getBrowseNum() {
            return browseNum;
        }

        public void setBrowseNum(int browseNum) {
            this.browseNum = browseNum;
        }

        public int getIsLike() {
            return isLike;
        }

        public void setIsLike(int isLike) {
            this.isLike = isLike;
        }

        public String getStartTime() {
            return startTime;
        }

        public void setStartTime(String startTime) {
            this.startTime = startTime;
        }

        public String getEndTime() {
            return endTime;
        }

        public void setEndTime(String endTime) {
            this.endTime = endTime;
        }
    }

    public static class TopicGoodsBean {


        /**
         * uniqueId : 00d46a43-78cd-43a8-940b-b0a1b3323524
         * defaultPrice : 1.0
         * name : sample string 2
         * sellingPoints : sample string 3
         * productPictures : sample string 4
         * salesVolume : 1
         */

        private String uniqueId;
        private double defaultPrice;
        private String name;
        private String sellingPoints;
        private String productPictures;
        private int salesVolume;
        private int totalStock;

        public int getTotalStock() {
            return totalStock;
        }

        public void setTotalStock(int totalStock) {
            this.totalStock = totalStock;
        }

        public String getUniqueId() {
            return uniqueId;
        }

        public void setUniqueId(String uniqueId) {
            this.uniqueId = uniqueId;
        }

        public double getDefaultPrice() {
            return defaultPrice;
        }

        public void setDefaultPrice(double defaultPrice) {
            this.defaultPrice = defaultPrice;
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

        public String getProductPictures() {
            return productPictures;
        }

        public void setProductPictures(String productPictures) {
            this.productPictures = productPictures;
        }

        public int getSalesVolume() {
            return salesVolume;
        }

        public void setSalesVolume(int salesVolume) {
            this.salesVolume = salesVolume;
        }
    }

    public static class CommentListBean {
        /**
         * pageInfo : {"totalCount":1,"pageCount":2}
         * list : [{"uniqueId":"003b7ba0-9aac-4596-a8be-929b9c249523","topicUniqueId":"3d7c1570-31fe-4b87-8bd1-900723aed092","userUniqueId":"cf09f61f-06cf-4872-9d47-6784b165e335","userCode":"sample string 2","content":"sample string 3","status":1,"isAnonymous":1,"createTime":"2019-04-23T09:57:32.1755371+08:00"},{"uniqueId":"003b7ba0-9aac-4596-a8be-929b9c249523","topicUniqueId":"3d7c1570-31fe-4b87-8bd1-900723aed092","userUniqueId":"cf09f61f-06cf-4872-9d47-6784b165e335","userCode":"sample string 2","content":"sample string 3","status":1,"isAnonymous":1,"createTime":"2019-04-23T09:57:32.1755371+08:00"}]
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
             * uniqueId : 003b7ba0-9aac-4596-a8be-929b9c249523
             * topicUniqueId : 3d7c1570-31fe-4b87-8bd1-900723aed092
             * userUniqueId : cf09f61f-06cf-4872-9d47-6784b165e335
             * userCode : sample string 2
             * content : sample string 3
             * status : 1
             * isAnonymous : 1
             * createTime : 2019-04-23T09:57:32.1755371+08:00
             */

            private String uniqueId;
            private String topicUniqueId;
            private String userUniqueId;
            private String userCode;
            private String content;
            private int status;
            private int isAnonymous;
            private String createTime;
            /**
             * headPortraitURL : sample string 4
             */

            private String headPortraitURL;

            public String getUniqueId() {
                return uniqueId;
            }

            public void setUniqueId(String uniqueId) {
                this.uniqueId = uniqueId;
            }

            public String getTopicUniqueId() {
                return topicUniqueId;
            }

            public void setTopicUniqueId(String topicUniqueId) {
                this.topicUniqueId = topicUniqueId;
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

            public String getContent() {
                return content;
            }

            public void setContent(String content) {
                this.content = content;
            }

            public int getStatus() {
                return status;
            }

            public void setStatus(int status) {
                this.status = status;
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

            public String getHeadPortraitURL() {
                return headPortraitURL;
            }

            public void setHeadPortraitURL(String headPortraitURL) {
                this.headPortraitURL = headPortraitURL;
            }
        }
    }
}
