package com.gemall.library.http;

import android.app.Activity;

import com.gemall.library.application.LibraryApplication;
import com.gemall.library.base.BaseResponse;
import com.gemall.library.bean.AdvertiseListBean;
import com.gemall.library.bean.AppVersionInfoBean;
import com.gemall.library.bean.BrandListBean;
import com.gemall.library.bean.CategoryProductListBean;
import com.gemall.library.bean.ConfigBean;
import com.gemall.library.bean.FavoritesBeanList;
import com.gemall.library.bean.OrderDetailsInfo;
import com.gemall.library.bean.PayMethodsBean;
import com.gemall.library.bean.TopicBean;
import com.gemall.library.bean.UserAddressListBean;
import com.gemall.library.bean.requestbean.NewProductSell;
import com.gemall.library.config.Constant;
import com.gemall.library.crypt.RSACoder;
import com.gemall.library.util.SkuUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import okhttp3.MediaType;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Response;

public class HttpManager {

    public static final String SUCCESS = "1000";
    public static final String Error = "-1";

    public interface CustomHttpCallBack<T> {
        void onRequestComplete(BaseResponse<T> skuBaseResponse);
    }

    private static HttpManager httpManager;

    public static HttpManager getInstance() {
        if(httpManager == null){
            httpManager = new HttpManager();
        }
        return httpManager;
    }

    private <T> BaseResponse <T> getErrorSkuBaseResponse(){

        BaseResponse<T> skuBaseResponse = new BaseResponse();
        skuBaseResponse.setIsSuccess(0);
        skuBaseResponse.setCode("-1");
        skuBaseResponse.setDescription("网络异常");
        return skuBaseResponse;
    }


    //获取公钥
    public void getPublicKey(final CustomHttpCallBack<Map<String,String>> customHttpCallBack) {


        Call<BaseResponse<Map<String,String>>> call = RetrofitManage.getInstance().getHttpServiceConnection().getPublicKey();


        RetrofitManage.sendRequest(call, new RetrofitManage.RequestCallback<Map<String,String>>() {
            @Override
            public void onResponse(Call<BaseResponse<Map<String,String>>> call, Response<BaseResponse<Map<String,String>>> response) {

//                SkuUtils.printf("****"+SkuUtils.gson.toJson(response.body().getResData().get("publicKey")));
                customHttpCallBack.onRequestComplete(response.body());

            }

            @Override
            public void onFailure(Call<BaseResponse<Map<String,String>>> call, Throwable t) {

                customHttpCallBack.onRequestComplete(getInstance().<Map<String,String>>getErrorSkuBaseResponse());
            }
        });

    }




    //新品活动商品列表
    public void getNewProductSell(final CustomHttpCallBack<NewProductSell> customHttpCallBack, int pageSize) {

        HashMap<String,String> hashMap = new HashMap<>();
        hashMap.put("PageIndex","1");
        hashMap.put("PageSize",pageSize+"");
        RequestBody body = RequestBody.create(MediaType.parse("application/json; charset=utf-8"), SkuUtils.gson.toJson(hashMap));
        Call<BaseResponse<NewProductSell>> call = RetrofitManage.getInstance().getHttpServiceConnection().getNewProductSell(body);


        RetrofitManage.sendRequest(call, new RetrofitManage.RequestCallback<NewProductSell>() {
            @Override
            public void onResponse(Call<BaseResponse<NewProductSell>> call, Response<BaseResponse<NewProductSell>> response) {

//                SkuUtils.printf("****"+SkuUtils.gson.toJson(response.body().getResData().get("publicKey")));
                customHttpCallBack.onRequestComplete(response.body());

            }

            @Override
            public void onFailure(Call<BaseResponse<NewProductSell>> call, Throwable t) {

                customHttpCallBack.onRequestComplete(getInstance().<NewProductSell>getErrorSkuBaseResponse());
            }
        });

    }










    //品牌列表是否需要身份认证：不需要
    public void getBrandList(int pageSize, final CustomHttpCallBack<BrandListBean> customHttpCallBack) {

        HashMap<String,String> hashMap = new HashMap<>();
        hashMap.put("pageIndex","1");
        hashMap.put("pageSize",pageSize+"");
        RequestBody body = RequestBody.create(MediaType.parse("application/json; charset=utf-8"), SkuUtils.gson.toJson(hashMap));
        Call<BaseResponse<BrandListBean>> call = RetrofitManage.getInstance().getHttpServiceConnection().getBrandList(body);


        RetrofitManage.sendRequest(call, new RetrofitManage.RequestCallback<BrandListBean>() {
            @Override
            public void onResponse(Call<BaseResponse<BrandListBean>> call, Response<BaseResponse<BrandListBean>> response) {

//                SkuUtils.printf("****"+SkuUtils.gson.toJson(response.body().getResData().get("publicKey")));
                customHttpCallBack.onRequestComplete(response.body());

            }

            @Override
            public void onFailure(Call<BaseResponse<BrandListBean>> call, Throwable t) {

                customHttpCallBack.onRequestComplete(getInstance().<BrandListBean>getErrorSkuBaseResponse());
            }
        });

    }








    //专题列表请求方式：POST 是否需要身份认证：不需要
    public void getTopicList(int pageIndex,int pageSize,final CustomHttpCallBack<TopicBean> customHttpCallBack) {

        HashMap<String,String> hashMap = new HashMap<>();
        hashMap.put("pageIndex",String.valueOf(pageIndex));
        hashMap.put("pageSize",String.valueOf(pageSize));
        RequestBody body = RequestBody.create(MediaType.parse("application/json; charset=utf-8"), SkuUtils.gson.toJson(hashMap));
        Call<BaseResponse<TopicBean>> call = RetrofitManage.getInstance().getHttpServiceConnection().getTopicList(body);


        RetrofitManage.sendRequest(call, new RetrofitManage.RequestCallback<TopicBean>() {
            @Override
            public void onResponse(Call<BaseResponse<TopicBean>> call, Response<BaseResponse<TopicBean>> response) {

//                SkuUtils.printf("****"+SkuUtils.gson.toJson(response.body().getResData().get("publicKey")));
                customHttpCallBack.onRequestComplete(response.body());

            }

            @Override
            public void onFailure(Call<BaseResponse<TopicBean>> call, Throwable t) {

                customHttpCallBack.onRequestComplete(getInstance().<TopicBean>getErrorSkuBaseResponse());
            }
        });

    }







    /**
     * 获取分类商品列表接口
     * @param pageIndex
     * @param pageSize
     * @param cateGoryUniqueID 分类UID
     * @param srotType 1综合默认排序 2最新排序 3销量排序 4价格升序排序 5价格降序排序
     * @param customHttpCallBack
     */
    public void getCategoryProductList(int pageIndex,int pageSize, String cateGoryUniqueID, int srotType, final CustomHttpCallBack<CategoryProductListBean> customHttpCallBack) {

        HashMap<String,String> hashMap = new HashMap<>();
        hashMap.put("cateGoryUniqueID",cateGoryUniqueID);
        hashMap.put("srotType",String.valueOf(srotType));//1综合默认排序 2最新排序 3销量排序 4价格升序排序 5价格降序排序
        hashMap.put("pageIndex",String.valueOf(pageIndex));
        hashMap.put("pageSize",String.valueOf(pageSize));
        RequestBody body = RequestBody.create(MediaType.parse("application/json; charset=utf-8"), SkuUtils.gson.toJson(hashMap));
        Call<BaseResponse<CategoryProductListBean>> call = RetrofitManage.getInstance().getHttpServiceConnection().getCategoryProductList(body);


        RetrofitManage.sendRequest(call, new RetrofitManage.RequestCallback<CategoryProductListBean>() {
            @Override
            public void onResponse(Call<BaseResponse<CategoryProductListBean>> call, Response<BaseResponse<CategoryProductListBean>> response) {

//                SkuUtils.printf("****"+SkuUtils.gson.toJson(response.body().getResData().get("publicKey")));
                customHttpCallBack.onRequestComplete(response.body());

            }

            @Override
            public void onFailure(Call<BaseResponse<CategoryProductListBean>> call, Throwable t) {

                customHttpCallBack.onRequestComplete(getInstance().<CategoryProductListBean>getErrorSkuBaseResponse());
            }
        });

    }



    //(通过广告位编号)查询首页的广告接口
    public void getAdvertiseList(String code, final CustomHttpCallBack<List<AdvertiseListBean>> customHttpCallBack) {

        HashMap<String,String> hashMap = new HashMap<>();
        hashMap.put("code",code);
        RequestBody body = RequestBody.create(MediaType.parse("application/json; charset=utf-8"), SkuUtils.gson.toJson(hashMap));
        Call<BaseResponse<List<AdvertiseListBean>>> call = RetrofitManage.getInstance().getHttpServiceConnection().getAdvertiseList(body);


        RetrofitManage.sendRequest(call, new RetrofitManage.RequestCallback<List<AdvertiseListBean>>() {
            @Override
            public void onResponse(Call<BaseResponse<List<AdvertiseListBean>>> call, Response<BaseResponse<List<AdvertiseListBean>>> response) {

//                SkuUtils.printf("****"+SkuUtils.gson.toJson(response.body().getResData().get("publicKey")));
                customHttpCallBack.onRequestComplete(response.body());

            }

            @Override
            public void onFailure(Call<BaseResponse<List<AdvertiseListBean>>> call, Throwable t) {

                customHttpCallBack.onRequestComplete(getInstance().<List<AdvertiseListBean>>getErrorSkuBaseResponse());
            }
        });

    }

    //获取配置
    public void getConfigValue(final CustomHttpCallBack<ConfigBean> customHttpCallBack, String configKey) {

        HashMap<String,String> hashMap = new HashMap<>();
        hashMap.put("configKey", configKey);
        RequestBody body = RequestBody.create(MediaType.parse("application/json; charset=utf-8"), SkuUtils.gson.toJson(hashMap));
        Call<BaseResponse<ConfigBean>> call = RetrofitManage.getInstance().getHttpServiceConnection().getConfigValue(body);


        RetrofitManage.sendRequest(call, new RetrofitManage.RequestCallback<ConfigBean>() {
            @Override
            public void onResponse(Call<BaseResponse<ConfigBean>> call, Response<BaseResponse<ConfigBean>> response) {
                customHttpCallBack.onRequestComplete(response.body());

            }

            @Override
            public void onFailure(Call<BaseResponse<ConfigBean>> call, Throwable t) {

                customHttpCallBack.onRequestComplete(getInstance().<ConfigBean>getErrorSkuBaseResponse());
            }
        });

    }






    //获取配置
    public void getAppUpdateInfo(String packageNumber,final CustomHttpCallBack<AppVersionInfoBean> customHttpCallBack) {

        HashMap<String,String> hashMap = new HashMap<>();
        hashMap.put("packageNumber", packageNumber);
        RequestBody body = RequestBody.create(MediaType.parse("application/json; charset=utf-8"), SkuUtils.gson.toJson(hashMap));
        Call<BaseResponse<AppVersionInfoBean>> call = RetrofitManage.getInstance().getHttpServiceConnection().getAppUpdateInfo(body);


        RetrofitManage.sendRequest(call, new RetrofitManage.RequestCallback<AppVersionInfoBean>() {
            @Override
            public void onResponse(Call<BaseResponse<AppVersionInfoBean>> call, Response<BaseResponse<AppVersionInfoBean>> response) {
                customHttpCallBack.onRequestComplete(response.body());

            }

            @Override
            public void onFailure(Call<BaseResponse<AppVersionInfoBean>> call, Throwable t) {

                customHttpCallBack.onRequestComplete(getInstance().<AppVersionInfoBean>getErrorSkuBaseResponse());
            }
        });

    }

    /**
     * 添加收藏商品,身份验证：需要
     * @param userUniqueId      用户UID
     * @param productUniqueId   商品UID
     * @param productUniqueId   类型，1：收藏，2：取消收藏
     * @param customHttpCallBack
     */
    public void addFavoriteProduct(String userUniqueId,String productUniqueId, int type, final CustomHttpCallBack<Boolean> customHttpCallBack) {

        HashMap<String,String> hashMap = new HashMap<>();
        hashMap.put("userUniqueId", userUniqueId);
        hashMap.put("productUniqueId", productUniqueId);
        hashMap.put("type", type+"");
        RequestBody body = RequestBody.create(MediaType.parse("application/json; charset=utf-8"), SkuUtils.gson.toJson(hashMap));
        Call<BaseResponse<Boolean>> call = RetrofitManage.getInstance().getHttpServiceConnection().addFavoriteProduct(body);


        RetrofitManage.sendRequest(call, new RetrofitManage.RequestCallback<Boolean>() {
            @Override
            public void onResponse(Call<BaseResponse<Boolean>> call, Response<BaseResponse<Boolean>> response) {
                customHttpCallBack.onRequestComplete(response.body());

            }

            @Override
            public void onFailure(Call<BaseResponse<Boolean>> call, Throwable t) {

                customHttpCallBack.onRequestComplete(getInstance().<Boolean>getErrorSkuBaseResponse());
            }
        });

    }

    //获取配置
    public void addCart(final CustomHttpCallBack<Boolean> customHttpCallBack, String productUID, String productSpecUID, String storeUID, int quantity) {

        HashMap<String,String> hashMap = new HashMap<>();
        hashMap.put("productUID", productUID);
        hashMap.put("productSpecUID", productSpecUID);
        hashMap.put("storeUID", storeUID);
        hashMap.put("quantity", quantity+"");
        RequestBody body = RequestBody.create(MediaType.parse("application/json; charset=utf-8"), SkuUtils.gson.toJson(hashMap));
        Call<BaseResponse<Boolean>> call = RetrofitManage.getInstance().getHttpServiceConnection().addCart(body);


        RetrofitManage.sendRequest(call, new RetrofitManage.RequestCallback<Boolean>() {
            @Override
            public void onResponse(Call<BaseResponse<Boolean>> call, Response<BaseResponse<Boolean>> response) {
                customHttpCallBack.onRequestComplete(response.body());

            }

            @Override
            public void onFailure(Call<BaseResponse<Boolean>> call, Throwable t) {

                customHttpCallBack.onRequestComplete(getInstance().<Boolean>getErrorSkuBaseResponse());
            }
        });

    }



    //添加订单
    public void addOrder(String data,final CustomHttpCallBack<List<String>> customHttpCallBack) {

        RequestBody body = RequestBody.create(MediaType.parse("application/json; charset=utf-8"), data);
        Call<BaseResponse<List<String>>> call = RetrofitManage.getInstance().getHttpServiceConnection().AddOrder(body);


        RetrofitManage.sendRequest(call, new RetrofitManage.RequestCallback<List<String>>() {
            @Override
            public void onResponse(Call<BaseResponse<List<String>>> call, Response<BaseResponse<List<String>>> response) {
                customHttpCallBack.onRequestComplete(response.body());
            }

            @Override
            public void onFailure(Call<BaseResponse<List<String>>> call, Throwable t) {

                customHttpCallBack.onRequestComplete(getInstance().<List<String>>getErrorSkuBaseResponse());
            }
        });


    }



    //获取订单可用支付方式
    public void getPayMethods(String data,final CustomHttpCallBack<List<PayMethodsBean>> customHttpCallBack) {

        RequestBody body = RequestBody.create(MediaType.parse("application/json; charset=utf-8"), data);
        Call<BaseResponse<List<PayMethodsBean>>> call = RetrofitManage.getInstance().getHttpServiceConnection().getPayMethods(body);


        RetrofitManage.sendRequest(call, new RetrofitManage.RequestCallback<List<PayMethodsBean>>() {
            @Override
            public void onResponse(Call<BaseResponse<List<PayMethodsBean>>> call, Response<BaseResponse<List<PayMethodsBean>>> response) {
                customHttpCallBack.onRequestComplete(response.body());
            }

            @Override
            public void onFailure(Call<BaseResponse<List<PayMethodsBean>>> call, Throwable t) {

                customHttpCallBack.onRequestComplete(getInstance().<List<PayMethodsBean>>getErrorSkuBaseResponse());
            }
        });


    }


    //获取订单详情
    public void getDetail(String data,final CustomHttpCallBack<OrderDetailsInfo> customHttpCallBack) {

        RequestBody body = RequestBody.create(MediaType.parse("application/json; charset=utf-8"), data);
        Call<BaseResponse<OrderDetailsInfo>> call = RetrofitManage.getInstance().getHttpServiceConnection().getOrderDetails(body);


        RetrofitManage.sendRequest(call, new RetrofitManage.RequestCallback<OrderDetailsInfo>() {
            @Override
            public void onResponse(Call<BaseResponse<OrderDetailsInfo>> call, Response<BaseResponse<OrderDetailsInfo>> response) {
                customHttpCallBack.onRequestComplete(response.body());
            }

            @Override
            public void onFailure(Call<BaseResponse<OrderDetailsInfo>> call, Throwable t) {

                customHttpCallBack.onRequestComplete(getInstance().<OrderDetailsInfo>getErrorSkuBaseResponse());
            }
        });


    }



    //添加支付(无第三方支付功能) 请求方式：POST 是否需要身份认证：需要 [王小君]
    public void paymentPlatform(String data,final CustomHttpCallBack<Boolean> customHttpCallBack) {

        RequestBody body = RequestBody.create(MediaType.parse("application/json; charset=utf-8"), data);
        Call<BaseResponse<Boolean>> call = RetrofitManage.getInstance().getHttpServiceConnection().paymentPlatform(body);


        RetrofitManage.sendRequest(call, new RetrofitManage.RequestCallback<Boolean>() {
            @Override
            public void onResponse(Call<BaseResponse<Boolean>> call, Response<BaseResponse<Boolean>> response) {
                customHttpCallBack.onRequestComplete(response.body());
            }

            @Override
            public void onFailure(Call<BaseResponse<Boolean>> call, Throwable t) {

                customHttpCallBack.onRequestComplete(getInstance().<Boolean>getErrorSkuBaseResponse());
            }
        });


    }

    //获取首页关键词 是否需要身份认证：不需要
    public void getIndexKeywords(final CustomHttpCallBack<List<String>> customHttpCallBack) {

        Call<BaseResponse<List<String>>> call = RetrofitManage.getInstance().getHttpServiceConnection().getIndexKeywords();


        RetrofitManage.sendRequest(call, new RetrofitManage.RequestCallback<List<String>>() {
            @Override
            public void onResponse(Call<BaseResponse<List<String>>> call, Response<BaseResponse<List<String>>> response) {
                customHttpCallBack.onRequestComplete(response.body());
            }

            @Override
            public void onFailure(Call<BaseResponse<List<String>>> call, Throwable t) {

                customHttpCallBack.onRequestComplete(getInstance().<List<String>>getErrorSkuBaseResponse());
            }
        });


    }


    //地址列表
    public void getUserAddressList(final Activity activity, final CustomHttpCallBack<UserAddressListBean> customHttpCallBack) {

        Map<String, String> map = new HashMap<>();
        map.put("pageIndex",  "1");
        map.put("pageSize",  "100");
        RequestBody body = RequestBody.create(MediaType.parse("application/json; charset=utf-8"), SkuUtils.gson.toJson(map));
        Call<BaseResponse<UserAddressListBean>> call = RetrofitManage.getInstance().getHttpServiceConnection().getUserAddressList(body);


        RetrofitManage.sendRequest(call, new RetrofitManage.RequestCallback<UserAddressListBean>() {
            @Override
            public void onResponse(Call<BaseResponse<UserAddressListBean>> call, Response<BaseResponse<UserAddressListBean>> response) {
               if(activity == null || activity.isFinishing()){
                    return;
               }
                customHttpCallBack.onRequestComplete(response.body());
            }

            @Override
            public void onFailure(Call<BaseResponse<UserAddressListBean>> call, Throwable t) {
                if(activity == null || activity.isFinishing()){
                    return;
                }
                customHttpCallBack.onRequestComplete(getInstance().<UserAddressListBean>getErrorSkuBaseResponse());
            }
        });


    }





    //检查用户是否有手机支付密码 是否需要身份认证：需要
    public void IsExistMobilePassWord(final Activity activity, final CustomHttpCallBack<Boolean> customHttpCallBack) {

        Call<BaseResponse<Boolean>> call = RetrofitManage.getInstance().getHttpServiceConnection().IsExistMobilePassWord();

        RetrofitManage.sendRequest(call, new RetrofitManage.RequestCallback<Boolean>() {
            @Override
            public void onResponse(Call<BaseResponse<Boolean>> call, Response<BaseResponse<Boolean>> response) {
                if(activity == null || activity.isFinishing()){
                    return;
                }
                customHttpCallBack.onRequestComplete(response.body());
            }

            @Override
            public void onFailure(Call<BaseResponse<Boolean>> call, Throwable t) {
                if(activity == null || activity.isFinishing()){
                    return;
                }
                customHttpCallBack.onRequestComplete(getInstance().<Boolean>getErrorSkuBaseResponse());
            }
        });


    }




    //验证支付密码请求方式：POST+HTTPS 是否需要身份认证：需要
    public void authByMobilePaymentPassword(final Activity activity, String payPassword,final CustomHttpCallBack<Boolean> customHttpCallBack) {

        String pwdRSA = RSACoder.encryptBySkuPubkeyToBase64(Constant.key, payPassword);

        Map<String, String> map = new HashMap<>();
        map.put("payPassword",  pwdRSA);
        RequestBody body = RequestBody.create(MediaType.parse("application/json; charset=utf-8"), SkuUtils.gson.toJson(map));
        Call<BaseResponse<Boolean>> call = RetrofitManage.getInstance().getHttpServiceConnection().authByMobilePaymentPassword(body);


        RetrofitManage.sendRequest(call, new RetrofitManage.RequestCallback<Boolean>() {
            @Override
            public void onResponse(Call<BaseResponse<Boolean>> call, Response<BaseResponse<Boolean>> response) {
                if(activity == null || activity.isFinishing()){
                    return;
                }
                customHttpCallBack.onRequestComplete(response.body());
            }

            @Override
            public void onFailure(Call<BaseResponse<Boolean>> call, Throwable t) {
                if(activity == null || activity.isFinishing()){
                    return;
                }
                customHttpCallBack.onRequestComplete(getInstance().<Boolean>getErrorSkuBaseResponse());
            }
        });


    }








}
