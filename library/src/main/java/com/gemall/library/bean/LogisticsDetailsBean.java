package com.gemall.library.bean;

import java.util.List;

public class LogisticsDetailsBean {

    /**
     * expressInfo : [{"time":"sample string 1","ftime":"sample string 2","context":"sample string 3"},{"time":"sample string 1","ftime":"sample string 2","context":"sample string 3"}]
     * shippingCode : sample string 1
     * expressCompanyName : sample string 2
     * logisiticsOrderInfos : [{"type":1,"description":"sample string 2","time":"2019-04-23T17:49:36.3051105+08:00"},{"type":1,"description":"sample string 2","time":"2019-04-23T17:49:36.3051105+08:00"}]
     */

    private String shippingCode;
    private String expressCompanyName;
    private List<ExpressInfoBean> expressInfo;
    private List<LogisiticsOrderInfosBean> logisiticsOrderInfos;

    public String getShippingCode() {
        return shippingCode;
    }

    public void setShippingCode(String shippingCode) {
        this.shippingCode = shippingCode;
    }

    public String getExpressCompanyName() {
        return expressCompanyName;
    }

    public void setExpressCompanyName(String expressCompanyName) {
        this.expressCompanyName = expressCompanyName;
    }

    public List<ExpressInfoBean> getExpressInfo() {
        return expressInfo;
    }

    public void setExpressInfo(List<ExpressInfoBean> expressInfo) {
        this.expressInfo = expressInfo;
    }

    public List<LogisiticsOrderInfosBean> getLogisiticsOrderInfos() {
        return logisiticsOrderInfos;
    }

    public void setLogisiticsOrderInfos(List<LogisiticsOrderInfosBean> logisiticsOrderInfos) {
        this.logisiticsOrderInfos = logisiticsOrderInfos;
    }

    public static class ExpressInfoBean {
        /**
         * time : sample string 1
         * ftime : sample string 2
         * context : sample string 3
         */

        private String time;
        private String ftime;
        private String context;

        public String getTime() {
            return time;
        }

        public void setTime(String time) {
            this.time = time;
        }

        public String getFtime() {
            return ftime;
        }

        public void setFtime(String ftime) {
            this.ftime = ftime;
        }

        public String getContext() {
            return context;
        }

        public void setContext(String context) {
            this.context = context;
        }
    }

    public static class LogisiticsOrderInfosBean {
        /**
         * type : 1
         * description : sample string 2
         * time : 2019-04-23T17:49:36.3051105+08:00
         */

        private int type;
        private String description;
        private String time;

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getTime() {
            return time;
        }

        public void setTime(String time) {
            this.time = time;
        }
    }
}
