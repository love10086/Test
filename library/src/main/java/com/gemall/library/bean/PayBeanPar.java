package com.gemall.library.bean;

import java.util.List;

public class PayBeanPar {


    /**
     * salesOrderUIDList : ["d9c1e9af-2be0-42b7-b863-783c2c5b2576","a97fd190-fdfe-4c50-8347-4f67310b5b5b"]
     * payMethodsDetails : {"point":1}
     * remark : sample string 1
     */

    private PayMethodsDetailsBean payMethodsDetails;
    private String remark;
    private List<String> salesOrderUIDList;

    public PayMethodsDetailsBean getPayMethodsDetails() {
        return payMethodsDetails;
    }

    public void setPayMethodsDetails(PayMethodsDetailsBean payMethodsDetails) {
        this.payMethodsDetails = payMethodsDetails;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public List<String> getSalesOrderUIDList() {
        return salesOrderUIDList;
    }

    public void setSalesOrderUIDList(List<String> salesOrderUIDList) {
        this.salesOrderUIDList = salesOrderUIDList;
    }

    public static class PayMethodsDetailsBean {
        /**
         * point : 1
         */

        private double point;

        public double getPoint() {
            return point;
        }

        public void setPoint(double point) {
            this.point = point;
        }
    }
}
