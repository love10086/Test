package com.gemall.library.bean.requestbean;

import java.util.List;

public class AfterSaleParam {

    /**
     * needReturnGoods : 0
     * productNameOrCode : sample string 1
     * status : [1,2]
     * pageIndex : 2
     * pageSize : 3
     */

    private int needReturnGoods;
    private String productNameOrCode;
    private int pageIndex;
    private int pageSize;
    private List<Integer> status;

    public int getNeedReturnGoods() {
        return needReturnGoods;
    }

    public void setNeedReturnGoods(int needReturnGoods) {
        this.needReturnGoods = needReturnGoods;
    }

    public String getProductNameOrCode() {
        return productNameOrCode;
    }

    public void setProductNameOrCode(String productNameOrCode) {
        this.productNameOrCode = productNameOrCode;
    }

    public int getPageIndex() {
        return pageIndex;
    }

    public void setPageIndex(int pageIndex) {
        this.pageIndex = pageIndex;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public List<Integer> getStatus() {
        return status;
    }

    public void setStatus(List<Integer> status) {
        this.status = status;
    }
}
