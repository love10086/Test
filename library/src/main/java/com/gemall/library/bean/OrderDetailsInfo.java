package com.gemall.library.bean;

import java.io.Serializable;
import java.util.List;

/**
 * @auther g-emall
 * @date 2019/4/19 19:26
 * @desc
 */
public class OrderDetailsInfo implements Serializable {


    /**
     * userUID : 77f3eaf2-8b82-4e60-a6ef-f6fe474d0c2f
     * userCode : 
     * lastLogisticsContext : 订单已提交
     * lastLogisticsTime : 2019-05-14T17:33:53
     * clientSource : 1
     * logisticsContactAddress : 北京市北京市西城区北京市 北京市 西城区 w
     * deliverMethodType : 0
     * logisticsDeliveredTime : null
     * logisticsSignedTime : null
     * remark : null
     * salesItem : [{"productUID":"25bc5e56-a449-49b0-a08b-8edf1a1e1d5a","productName":"321","quantity":1,"unitPrice":10,"totalAmount":10,"productPictureURL":"gemall_20190514094828_68a234b3-f1d4-48c3-981e-01b167e0d908.png","variantName":"颜色:红色"}]
     * totalAmount : 10.0
     * totalAmountIncludeDeliveryFee : 10.0
     * payAmount : 10.0
     * salesOrderCode : 010201905142573657
     * salesOrderStatus : 1
     * salesOrderStatusDesc : 待付款
     * salesOrderCloseType : null
     * logisticsFee : 0.0
     * logisticsContactName : nnmk
     * logisticsContactMobileNO : 1562723555
     * payMethods : {"point":0,"cash":10}
     * paymentDetailInfo : null
     * createTime : 2019-05-14T17:33:53
     * deliveryCode : 
     * uid : 6e12a2f1-6288-4bff-a931-9f711193c3ef
     * paymentTime : null
     * completeTime : null
     * salesOrderType : 8
     * closeReason : 
     * refundTime : null
     * userMobile : 15627236873
     * refundAmount : 0.0
     * refundReason : null
     * isRefunding : false
     * refundApplyTime : null
     * refundRefuseReason : null
     * paymentDetail : [{"name":null,"amount":0},{"name":"赠送账户","amount":0},{"name":"消费账户","amount":0},{"name":"兑换账户","amount":0},{"name":"抵扣金额","amount":0}]
     * closedTime : null
     * orderCompleteTimeTips : null
     * ordersRefundStatus : null
     * isOpenConsumerAccount : false
     * isOpenPoint : false
     */

    private String userUID;
    private String userCode;
    private String lastLogisticsContext;
    private String lastLogisticsTime;
    private int clientSource;
    private String logisticsContactAddress;
    private int deliverMethodType;
    private String logisticsDeliveredTime;
    private String logisticsSignedTime;
    private String remark;
    private double totalAmount;
    private double totalAmountIncludeDeliveryFee;
    private double payAmount;
    private String salesOrderCode;
    private int salesOrderStatus;
    private String salesOrderStatusDesc;
    private String salesOrderCloseType;
    private double logisticsFee;
    private String logisticsContactName;
    private String logisticsContactMobileNO;
    private PayMethodsBean payMethods;
    private String paymentDetailInfo;
    private String createTime;
    private String deliveryCode;
    private String uid;
    private String paymentTime;
    private String completeTime;
    private int salesOrderType;
    private String closeReason;
    private String refundTime;
    private String userMobile;
    private double refundAmount;
    private String refundReason;
    private boolean isRefunding;
    private String refundApplyTime;
    private String refundRefuseReason;
    private String closedTime;
    private String orderCompleteTimeTips;
    private String ordersRefundStatus;
    private boolean isOpenConsumerAccount;
    private boolean isOpenPoint;
    private List<OrderInfo.ListBean.SalesItemBean> salesItem;
    private List<PaymentDetailBean> paymentDetail;

    public String getUserUID() {
        return userUID;
    }

    public void setUserUID(String userUID) {
        this.userUID = userUID;
    }

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }

    public String getLastLogisticsContext() {
        return lastLogisticsContext;
    }

    public void setLastLogisticsContext(String lastLogisticsContext) {
        this.lastLogisticsContext = lastLogisticsContext;
    }

    public String getLastLogisticsTime() {
        return lastLogisticsTime;
    }

    public void setLastLogisticsTime(String lastLogisticsTime) {
        this.lastLogisticsTime = lastLogisticsTime;
    }

    public int getClientSource() {
        return clientSource;
    }

    public void setClientSource(int clientSource) {
        this.clientSource = clientSource;
    }

    public String getLogisticsContactAddress() {
        return logisticsContactAddress;
    }

    public void setLogisticsContactAddress(String logisticsContactAddress) {
        this.logisticsContactAddress = logisticsContactAddress;
    }

    public int getDeliverMethodType() {
        return deliverMethodType;
    }

    public void setDeliverMethodType(int deliverMethodType) {
        this.deliverMethodType = deliverMethodType;
    }

    public String getLogisticsDeliveredTime() {
        return logisticsDeliveredTime;
    }

    public void setLogisticsDeliveredTime(String logisticsDeliveredTime) {
        this.logisticsDeliveredTime = logisticsDeliveredTime;
    }

    public String getLogisticsSignedTime() {
        return logisticsSignedTime;
    }

    public void setLogisticsSignedTime(String logisticsSignedTime) {
        this.logisticsSignedTime = logisticsSignedTime;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public double getTotalAmountIncludeDeliveryFee() {
        return totalAmountIncludeDeliveryFee;
    }

    public void setTotalAmountIncludeDeliveryFee(double totalAmountIncludeDeliveryFee) {
        this.totalAmountIncludeDeliveryFee = totalAmountIncludeDeliveryFee;
    }

    public double getPayAmount() {
        return payAmount;
    }

    public void setPayAmount(double payAmount) {
        this.payAmount = payAmount;
    }

    public String getSalesOrderCode() {
        return salesOrderCode;
    }

    public void setSalesOrderCode(String salesOrderCode) {
        this.salesOrderCode = salesOrderCode;
    }

    public int getSalesOrderStatus() {
        return salesOrderStatus;
    }

    public void setSalesOrderStatus(int salesOrderStatus) {
        this.salesOrderStatus = salesOrderStatus;
    }

    public String getSalesOrderStatusDesc() {
        return salesOrderStatusDesc;
    }

    public void setSalesOrderStatusDesc(String salesOrderStatusDesc) {
        this.salesOrderStatusDesc = salesOrderStatusDesc;
    }

    public String getSalesOrderCloseType() {
        return salesOrderCloseType;
    }

    public void setSalesOrderCloseType(String salesOrderCloseType) {
        this.salesOrderCloseType = salesOrderCloseType;
    }

    public double getLogisticsFee() {
        return logisticsFee;
    }

    public void setLogisticsFee(double logisticsFee) {
        this.logisticsFee = logisticsFee;
    }

    public String getLogisticsContactName() {
        return logisticsContactName;
    }

    public void setLogisticsContactName(String logisticsContactName) {
        this.logisticsContactName = logisticsContactName;
    }

    public String getLogisticsContactMobileNO() {
        return logisticsContactMobileNO;
    }

    public void setLogisticsContactMobileNO(String logisticsContactMobileNO) {
        this.logisticsContactMobileNO = logisticsContactMobileNO;
    }

    public PayMethodsBean getPayMethods() {
        return payMethods;
    }

    public void setPayMethods(PayMethodsBean payMethods) {
        this.payMethods = payMethods;
    }

    public String getPaymentDetailInfo() {
        return paymentDetailInfo;
    }

    public void setPaymentDetailInfo(String paymentDetailInfo) {
        this.paymentDetailInfo = paymentDetailInfo;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getDeliveryCode() {
        return deliveryCode;
    }

    public void setDeliveryCode(String deliveryCode) {
        this.deliveryCode = deliveryCode;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getPaymentTime() {
        return paymentTime;
    }

    public void setPaymentTime(String paymentTime) {
        this.paymentTime = paymentTime;
    }

    public String getCompleteTime() {
        return completeTime;
    }

    public void setCompleteTime(String completeTime) {
        this.completeTime = completeTime;
    }

    public int getSalesOrderType() {
        return salesOrderType;
    }

    public void setSalesOrderType(int salesOrderType) {
        this.salesOrderType = salesOrderType;
    }

    public String getCloseReason() {
        return closeReason;
    }

    public void setCloseReason(String closeReason) {
        this.closeReason = closeReason;
    }

    public String getRefundTime() {
        return refundTime;
    }

    public void setRefundTime(String refundTime) {
        this.refundTime = refundTime;
    }

    public String getUserMobile() {
        return userMobile;
    }

    public void setUserMobile(String userMobile) {
        this.userMobile = userMobile;
    }

    public double getRefundAmount() {
        return refundAmount;
    }

    public void setRefundAmount(double refundAmount) {
        this.refundAmount = refundAmount;
    }

    public String getRefundReason() {
        return refundReason;
    }

    public void setRefundReason(String refundReason) {
        this.refundReason = refundReason;
    }

    public boolean isIsRefunding() {
        return isRefunding;
    }

    public void setIsRefunding(boolean isRefunding) {
        this.isRefunding = isRefunding;
    }

    public String getRefundApplyTime() {
        return refundApplyTime;
    }

    public void setRefundApplyTime(String refundApplyTime) {
        this.refundApplyTime = refundApplyTime;
    }

    public String getRefundRefuseReason() {
        return refundRefuseReason;
    }

    public void setRefundRefuseReason(String refundRefuseReason) {
        this.refundRefuseReason = refundRefuseReason;
    }

    public String getClosedTime() {
        return closedTime;
    }

    public void setClosedTime(String closedTime) {
        this.closedTime = closedTime;
    }

    public String getOrderCompleteTimeTips() {
        return orderCompleteTimeTips;
    }

    public void setOrderCompleteTimeTips(String orderCompleteTimeTips) {
        this.orderCompleteTimeTips = orderCompleteTimeTips;
    }

    public String getOrdersRefundStatus() {
        return ordersRefundStatus;
    }

    public void setOrdersRefundStatus(String ordersRefundStatus) {
        this.ordersRefundStatus = ordersRefundStatus;
    }

    public boolean isIsOpenConsumerAccount() {
        return isOpenConsumerAccount;
    }

    public void setIsOpenConsumerAccount(boolean isOpenConsumerAccount) {
        this.isOpenConsumerAccount = isOpenConsumerAccount;
    }

    public boolean isIsOpenPoint() {
        return isOpenPoint;
    }

    public void setIsOpenPoint(boolean isOpenPoint) {
        this.isOpenPoint = isOpenPoint;
    }

    public List<OrderInfo.ListBean.SalesItemBean> getSalesItem() {
        return salesItem;
    }

    public void setSalesItem(List<OrderInfo.ListBean.SalesItemBean> salesItem) {
        this.salesItem = salesItem;
    }

    public List<PaymentDetailBean> getPaymentDetail() {
        return paymentDetail;
    }

    public void setPaymentDetail(List<PaymentDetailBean> paymentDetail) {
        this.paymentDetail = paymentDetail;
    }

    public static class PayMethodsBean {
        /**
         * point : 0.0
         * cash : 10.0
         */

        private double point;
        private double cash;

        public double getPoint() {
            return point;
        }

        public void setPoint(double point) {
            this.point = point;
        }

        public double getCash() {
            return cash;
        }

        public void setCash(double cash) {
            this.cash = cash;
        }
    }
    
    public static class PaymentDetailBean {
        /**
         * name : null
         * amount : 0.0
         */

        private String name;
        private double amount;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public double getAmount() {
            return amount;
        }

        public void setAmount(double amount) {
            this.amount = amount;
        }
    }
}
