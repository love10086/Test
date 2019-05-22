package com.gemall.library.http;

import android.app.Activity;

import com.gemall.library.base.BaseResponse;
import com.gemall.library.bean.LoginInfo;
import com.gemall.library.config.Constant;
import com.gemall.library.crypt.RSACoder;
import com.gemall.library.interface_list.ICancelOrderListener;
import com.gemall.library.interface_list.ICheckIdentityCodeListener;
import com.gemall.library.interface_list.ICommonCallbackListener;
import com.gemall.library.interface_list.IConfirmReceiveGoodsListener;
import com.gemall.library.interface_list.ISendIdentityCodeListener;
import com.gemall.library.util.BeanUtils;
import com.gemall.library.util.SkuUtils;

import java.util.HashMap;
import java.util.Map;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Response;

/**
 * @auther g-emall
 * @date 2019/4/16 14:11
 * @desc 通用接口访问
 */
public class CommonHttpUtils {
    /**
     * @param phone
     * @param type  1：注册 2：重置密码 3：绑定银行卡 4：绑定手机 5：手机验证码快捷登录
     * @desc 发送验证码
     */
    public static void sendIdentityCode(Activity context, String phone, int type, final ISendIdentityCodeListener iSendIdentityCodeListener) {
        Map<String, String> map = new HashMap<>();
        map.put("mobile", phone);
        map.put("type", type + "");
        Call<BaseResponse<Boolean>> call = RetrofitManage.getInstance().getHttpServiceConnection().sendIdentityCode(map);
        RetrofitManage.sendRequest(context, call, new RetrofitManage.RequestCallback<Boolean>() {
            @Override
            public void onResponse(Call<BaseResponse<Boolean>> call, Response<BaseResponse<Boolean>> response) {
                if (response.body().getResData()) { // 成功
                    if (iSendIdentityCodeListener != null) {
                        iSendIdentityCodeListener.onSuccess();
                    }
                } else { // 失败
                    if (iSendIdentityCodeListener != null) {
                        iSendIdentityCodeListener.onFailure(response.body().description);
                    }
                }
            }

            @Override
            public void onFailure(Call<BaseResponse<Boolean>> call, Throwable t) {
                if (iSendIdentityCodeListener != null) {
                    iSendIdentityCodeListener.onFailure("网络异常，请稍后重试");
                }
            }
        });
    }

    /**
     * @param phone
     * @type 注册=1 重置密码=2 绑定银行卡=3 绑定手机=4
     * @desc 验证验证码
     */
    public static void checkIdentityCode(Activity context, String phone, String code, int type, final ICheckIdentityCodeListener iCheckIdentityCodeListener) {
        Map<String, String> map = new HashMap<>();
        map.put("mobile", phone);//java.lang.IllegalArgumentException: Field map contained null value for key 'mobile'.
        map.put("code", code);//java.lang.IllegalArgumentException: Field map contained null value for key 'mobile'.
        map.put("type", type + "");
        Call<BaseResponse<Boolean>> call = RetrofitManage.getInstance().getHttpServiceConnection().checkIdentityCode(map);
        RetrofitManage.sendRequest(context, call, new RetrofitManage.RequestCallback<Boolean>() {
            @Override
            public void onResponse(Call<BaseResponse<Boolean>> call, Response<BaseResponse<Boolean>> response) {
                if (response.body().getResData()) { // 成功
                    if (iCheckIdentityCodeListener != null) {
                        iCheckIdentityCodeListener.onSuccess();
                    }
                } else { // 失败
                    if (iCheckIdentityCodeListener != null) {
                        iCheckIdentityCodeListener.onFailure(response.body().description);
                    }
                }
            }

            @Override
            public void onFailure(Call<BaseResponse<Boolean>> call, Throwable t) {
                if (iCheckIdentityCodeListener != null) {
                    iCheckIdentityCodeListener.onFailure("网络异常，请稍后重试~");
                }
            }
        });
    }

    /**
     * 取消订单
     * 操作类型，0默认，1超时未支付取消
     */
    public static void cancelOrder(Activity context, String salesOrderUID, String salesOrderCode, String cancelReason, int type, final ICancelOrderListener iCancelOrderListener) {
        Map<String, String> map = new HashMap<>();
        map.put("salesOrderUID", salesOrderUID);
        map.put("salesOrderCode", salesOrderCode);
        map.put("cancelReason", cancelReason);
        map.put("type", type + "");
        RequestBody body = RequestBody.create(okhttp3.MediaType.parse("application/json; charset=utf-8"), SkuUtils.gson.toJson(map));
        Call<BaseResponse<Boolean>> call = RetrofitManage.getInstance().getHttpServiceConnection().cancelOrder(body);
        RetrofitManage.sendRequest(context, call, new RetrofitManage.RequestCallback<Boolean>() {
            @Override
            public void onResponse(Call<BaseResponse<Boolean>> call, Response<BaseResponse<Boolean>> response) {
                if (response.body().getResData()) { // 成功
                    if (iCancelOrderListener != null) {
                        iCancelOrderListener.onCancelOrderSuccess();
                    }
                } else { // 失败
                    if (iCancelOrderListener != null) {
                        iCancelOrderListener.onCancelOrderFailure(response.body().description);
                    }
                }
            }

            @Override
            public void onFailure(Call<BaseResponse<Boolean>> call, Throwable t) {
                if (iCancelOrderListener != null) {
                    iCancelOrderListener.onCancelOrderFailure("网络异常，请稍后重试~");
                }
            }
        });
    }

    /**
     * 确认收货
     * 操作类型，0默认，1超时未支付取消
     */
    public static void confirmReceiveGoods(Activity context, String salesOrderUID, String pwd, final IConfirmReceiveGoodsListener iConfirmReceiveGoodsListener) {
        iConfirmReceiveGoodsListener.onConfirmReceiveGoodsBefore();
        Map<String, String> map = new HashMap<>();
        map.put("salesOrderUID", salesOrderUID);
        map.put("password", pwd);
        RequestBody body = RequestBody.create(okhttp3.MediaType.parse("application/json; charset=utf-8"), SkuUtils.gson.toJson(map));
        Call<BaseResponse<Boolean>> call = RetrofitManage.getInstance().getHttpServiceConnection().confirmReceiveGoods(body);
        RetrofitManage.sendRequest(context, call, new RetrofitManage.RequestCallback<Boolean>() {
            @Override
            public void onResponse(Call<BaseResponse<Boolean>> call, Response<BaseResponse<Boolean>> response) {
                if (response.body().getResData()) { // 成功
                    if (iConfirmReceiveGoodsListener != null) {
                        iConfirmReceiveGoodsListener.onConfirmReceiveGoodsSuccess();
                    }
                } else { // 失败
                    if (iConfirmReceiveGoodsListener != null) {
                        iConfirmReceiveGoodsListener.onConfirmReceiveGoodsFailure(response.body().description);
                    }
                }
            }

            @Override
            public void onFailure(Call<BaseResponse<Boolean>> call, Throwable t) {
                if (iConfirmReceiveGoodsListener != null) {
                    iConfirmReceiveGoodsListener.onConfirmReceiveGoodsFailure("网络异常，请稍后重试~");
                }
            }
        });
    }


    /**
     * @desc 账号密码登录
     */
    public static void accountAndPwdLogin(final Activity context, String accountInput, String pwdStr, int type, final ICommonCallbackListener iCommonCallbackListener) {
        String pwdRSA = RSACoder.encryptBySkuPubkeyToBase64(Constant.key, pwdStr);
        Map<String, String> map = new HashMap<>();
        map.put("loginType", type + "");
        map.put("loginName", accountInput);
        map.put("loginPwd", pwdRSA);
        Call<BaseResponse<LoginInfo>> call = RetrofitManage.getInstance().getHttpServiceConnection().accountLogin(map);
        RetrofitManage.sendRequest(context, call,new RetrofitManage.RequestCallback<LoginInfo>(){

            @Override
            public void onResponse(Call<BaseResponse<LoginInfo>> call, Response<BaseResponse<LoginInfo>> response) {
                if ("1000".equals(response.body().code)) {
                    BeanUtils.saveLoginSuccessData(context, response.body().resData);
                    iCommonCallbackListener.onSuccess("");

                } else {
                    iCommonCallbackListener.onFailure("",response.body().description);
                }
            }

            @Override
            public void onFailure(Call<BaseResponse<LoginInfo>> call, Throwable t) {
                iCommonCallbackListener.onFailure("","网络异常，请稍后再试~");
            }
        });
    }

}
