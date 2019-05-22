package com.gemall.library.http;

import android.app.Activity;

import com.alibaba.android.arouter.launcher.ARouter;
import com.gemall.library.base.BaseResponse;
import com.gemall.library.util.SkuUtils;

import java.net.SocketTimeoutException;
import java.net.UnknownHostException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by g-emall on 2018/8/24.
 */

public class RequestRunnable<T> implements Runnable {

    Activity activity;
    Call<BaseResponse<T>> call;
    RetrofitManage.RequestCallback<T> requestCallback;
    long count;

    RequestRunnable(Activity activity, Call<BaseResponse<T>> call, RetrofitManage.RequestCallback<T> requestCallback, long count) {

        this.activity = activity;
        this.call = call;
        this.requestCallback = requestCallback;
        this.count = count;
    }


    @Override
    public void run() {
        call.enqueue(new Callback<BaseResponse<T>>() {
            @Override
            public void onResponse(Call<BaseResponse<T>> call, Response<BaseResponse<T>> response) {

                if (requestCallback != null) {//有时候并不需要返回结果

                    try {
                        if (RetrofitManage.iSOutLog) {
                            SkuUtils.printf("sendRequest====code======", SkuUtils.gson.toJson(response.body().getCode()));
                            SkuUtils.printf("sendRequest====data======", SkuUtils.gson.toJson(response.body()));
                        }
                    } catch (Exception e) {
                    }
                    try {
                        BaseResponse skuBaseResponse = response.body();
                        /**
                         *errorType=6时访问的接口需要登录
                         */
                        /*  if (skuBaseResponse.getErrorType() == 6) {*/
                        /**
                         * (code == 3000 || code == 3009 || code == 3010 || code == 5072)
                         * //toke失效 或者是账号被挤下线  5072:请求头部信息缺失,访问的接口需要登录
                         */
                        if (skuBaseResponse.getErrorType() == 6) {
                            SkuUtils.delAccountInfo("UserInfo");
                            ARouter.getInstance().build("/LoginActivity/").navigation();
                        } else {
                            requestCallback.onResponse(call, response);
                        }

                    } catch (Exception e) {
                        e.printStackTrace();
                        requestCallback.onFailure(call, e);
                    }

                }

            }

            @Override
            public void onFailure(Call<BaseResponse<T>> call, Throwable t) {
                if (t instanceof SocketTimeoutException) {
                    // 网络请求超时
                } else if (t instanceof UnknownHostException) {
                    // 网络连接失败，请检查网络设置
                } else {
                    // 网络异常，请稍后重试
                }
                if (requestCallback != null) {
                    requestCallback.onFailure(call, t);
                }
            }
        });


    }

}
