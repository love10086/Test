package com.gemall.library.bean;

public class OrderCountsBean {

    /**
     * ordertotal : {"submit":1,"payed":2,"sended":3,"receivedFood":4,"evaluationed":5,"closed":6,"refund":7}
     * favoriteProductCount : 1
     * newDetail : {"time":"sample string 1","ftime":"sample string 2","context":"sample string 3","orderCode":"sample string 4"}
     */

    private OrdertotalBean ordertotal;
    private int favoriteProductCount;
    private NewDetailBean newDetail;

    public OrdertotalBean getOrdertotal() {
        return ordertotal;
    }

    public void setOrdertotal(OrdertotalBean ordertotal) {
        this.ordertotal = ordertotal;
    }

    public int getFavoriteProductCount() {
        return favoriteProductCount;
    }

    public void setFavoriteProductCount(int favoriteProductCount) {
        this.favoriteProductCount = favoriteProductCount;
    }

    public NewDetailBean getNewDetail() {
        return newDetail;
    }

    public void setNewDetail(NewDetailBean newDetail) {
        this.newDetail = newDetail;
    }

    public static class OrdertotalBean {
        /**
         * submit : 1
         * payed : 2
         * sended : 3
         * receivedFood : 4
         * evaluationed : 5
         * closed : 6
         * refund : 7
         */

        private int submit;
        private int payed;
        private int sended;
        private int receivedFood;
        private int evaluationed;
        private int closed;
        private int refund;

        public int getSubmit() {
            return submit;
        }

        public void setSubmit(int submit) {
            this.submit = submit;
        }

        public int getPayed() {
            return payed;
        }

        public void setPayed(int payed) {
            this.payed = payed;
        }

        public int getSended() {
            return sended;
        }

        public void setSended(int sended) {
            this.sended = sended;
        }

        public int getReceivedFood() {
            return receivedFood;
        }

        public void setReceivedFood(int receivedFood) {
            this.receivedFood = receivedFood;
        }

        public int getEvaluationed() {
            return evaluationed;
        }

        public void setEvaluationed(int evaluationed) {
            this.evaluationed = evaluationed;
        }

        public int getClosed() {
            return closed;
        }

        public void setClosed(int closed) {
            this.closed = closed;
        }

        public int getRefund() {
            return refund;
        }

        public void setRefund(int refund) {
            this.refund = refund;
        }
    }

    public static class NewDetailBean {
        /**
         * time : sample string 1
         * ftime : sample string 2
         * context : sample string 3
         * orderCode : sample string 4
         */

        private String time;
        private String ftime;
        private String context;
        private String orderCode;
        private String productPic;

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

        public String getOrderCode() {
            return orderCode;
        }

        public void setOrderCode(String orderCode) {
            this.orderCode = orderCode;
        }

        public String getProductPic() {
            return productPic;
        }

        public void setProductPic(String productPic) {
            this.productPic = productPic;
        }
    }
}
