package com.gemall.library.base;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * 接收服务器返回通用数据的类
 */
public class BaseResponse<T> implements Serializable {

    @SerializedName("isSuccess")
    public int isSuccess;   // 是否请求成功
    @SerializedName("code")
    public String code;     // 返回码
    @SerializedName("description")
    public String description;  //结果描述
    @SerializedName("resData")
    public T resData;       // 数据
    @SerializedName("ErrorType")
    public int errorType; //6需要先登录

    public int getErrorType() {
        return errorType;
    }

    public void setErrorType(int errorType) {
        this.errorType = errorType;
    }

    public int getIsSuccess() {
        return isSuccess;
    }

    public void setIsSuccess(int isSuccess) {
        this.isSuccess = isSuccess;
    }

    public String getCode() {
        if (null == code) {
            code = "";
        }
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public T getResData() {
        return resData;
    }

    public void setResData(T resData) {
        this.resData = resData;
    }
}
