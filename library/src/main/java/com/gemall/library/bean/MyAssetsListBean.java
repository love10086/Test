package com.gemall.library.bean;

import java.util.List;

/**
 *
 */

public class MyAssetsListBean {

    /**
     * pageInfo : {"totalCount":1,"pageCount":2}
     * list : [{"isBorrow":true,"amount":2,"createTime":"2019-05-05T13:48:16.4082409+08:00","description":"sample string 4"},{"isBorrow":true,"amount":2,"createTime":"2019-05-05T13:48:16.4082409+08:00","description":"sample string 4"}]
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
         * isBorrow : true
         * amount : 2.0
         * createTime : 2019-05-05T13:48:16.4082409+08:00
         * description : sample string 4
         */

        private boolean isBorrow;
        private double amount;
        private String createTime;
        private String description;

        public boolean isIsBorrow() {
            return isBorrow;
        }

        public void setIsBorrow(boolean isBorrow) {
            this.isBorrow = isBorrow;
        }

        public double getAmount() {
            return amount;
        }

        public void setAmount(double amount) {
            this.amount = amount;
        }

        public String getCreateTime() {
            return createTime;
        }

        public void setCreateTime(String createTime) {
            this.createTime = createTime;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }
    }
}
