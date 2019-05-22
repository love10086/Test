package com.gemall.library.bean;

import java.util.List;

/**
 * author : g-emall
 * time   : 2019/4/18
 * desc   : 专题信息
 */
public class TopicBean {


    /**
     * pageInfo : {"totalCount":1,"pageCount":2}
     * list : [{"uniqueId":"444afeda-84df-4504-b069-e0277a3d8143","title":"sample string 2","subtitle":"sample string 3","image":"sample string 4","topicContent":"sample string 5","browseNum":1,"startTime":"2019-04-18T20:26:19.1848023+08:00","endTime":"2019-04-18T20:26:19.1848023+08:00"},{"uniqueId":"444afeda-84df-4504-b069-e0277a3d8143","title":"sample string 2","subtitle":"sample string 3","image":"sample string 4","topicContent":"sample string 5","browseNum":1,"startTime":"2019-04-18T20:26:19.1848023+08:00","endTime":"2019-04-18T20:26:19.1848023+08:00"}]
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
         * uniqueId : 9fd32286-3f29-4f72-b903-4a48299ec077
         * title : sample string 2
         * subtitle : sample string 3
         * image : sample string 4
         * topicContent : sample string 5
         * browseNum : 1
         * isLike : 6
         * startTime : 2019-04-20T16:15:05.4451354+08:00
         * endTime : 2019-04-20T16:15:05.4451354+08:00
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
}
