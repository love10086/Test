package com.gemall.library.http;

import com.gemall.library.base.BaseResponse;
import com.gemall.library.bean.AdvertiseListBean;
import com.gemall.library.bean.AfterSaleListBean;
import com.gemall.library.bean.AppVersionInfoBean;
import com.gemall.library.bean.BrandListBean;
import com.gemall.library.bean.BrandProductListBean;
import com.gemall.library.bean.CategoryListBean;
import com.gemall.library.bean.CategoryProductListBean;
import com.gemall.library.bean.ConfigBean;
import com.gemall.library.bean.FavoritesBeanList;
import com.gemall.library.bean.FundsBean;
import com.gemall.library.bean.LoginInfo;
import com.gemall.library.bean.LogisticsDetailsBean;
import com.gemall.library.bean.MyAssetsListBean;
import com.gemall.library.bean.OrderCountsBean;
import com.gemall.library.bean.OrderDetailsInfo;
import com.gemall.library.bean.OrderEvaluateListBean;
import com.gemall.library.bean.OrderInfo;
import com.gemall.library.bean.PayMethodsBean;
import com.gemall.library.bean.ProductDetailBean;
import com.gemall.library.bean.RegisterInfo;
import com.gemall.library.bean.ShoppingCartBean;
import com.gemall.library.bean.TopicBean;
import com.gemall.library.bean.TopicDetailBean;
import com.gemall.library.bean.UserAddressListBean;
import com.gemall.library.bean.UserBasicInfoBean;
import com.gemall.library.bean.requestbean.NewProductSell;

import java.util.List;
import java.util.Map;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Headers;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;

/**
 *
 */
public interface HttpService {
    // 获取配置信息
    @Headers({"Content-Type: application/json", "Accept: application/json"})
    @POST("OwnOpenApi/common/getConfigValue")
    Call<BaseResponse<ConfigBean>> getConfigValue(@Body RequestBody body);


    // 账户密码登陆
    @FormUrlEncoded
    @POST("OwnMall/user/login")
    Call<BaseResponse<LoginInfo>> accountLogin(@FieldMap() Map<String, String> maps);
    //Call<BaseResponse<LoginInfo>> accountLogin(@Body RequestBody body);

    // 短信登陆
    @FormUrlEncoded
    @POST("OwnMall/user/quickLogin")
    Call<BaseResponse<LoginInfo>> messageLogin(@FieldMap() Map<String, String> maps);

    // 注册
    @FormUrlEncoded
    @POST("OwnMall/user/register")
    Call<BaseResponse<RegisterInfo>> register(@FieldMap() Map<String, String> maps);

    // 发送验证码
    @FormUrlEncoded
    @POST("OwnMall/user/getMobileValidCode")
    Call<BaseResponse<Boolean>> sendIdentityCode(@FieldMap() Map<String, String> maps);

    // 验证验证码
    @FormUrlEncoded
    @POST("OwnMall/common/CheckCaptchaMobile")
    Call<BaseResponse<Boolean>> checkIdentityCode(@FieldMap() Map<String, String> maps);

    // 重置密码
    @FormUrlEncoded
    @POST("OwnMall/user/resetPassword")
    Call<BaseResponse<Boolean>> forgetPwd(@FieldMap() Map<String, String> maps);

    //购物车列表
    @Headers({"Content-Type: application/json", "Accept: application/json"})
    @POST("OwnOpenApi/Cart/CartList")
    Call<BaseResponse<ShoppingCartBean>> getShoppingCartList(@Body RequestBody body);

    //购物车item增减数量,身份验证：需要
    @Headers({"Content-Type: application/json", "Accept: application/json"})
    @POST("OwnOpenApi/Cart/EditCart")
    Call<BaseResponse<Boolean>> shoppingCartProductEdit(@Body RequestBody body);

    //订单列表,身份验证：需要
    @Headers({"Content-Type: application/json", "Accept: application/json"})
    @POST("OwnOpenApi/salesOrder/getList")
    Call<BaseResponse<OrderInfo>> getOrderList(@Body RequestBody body);

    //取消订单,身份验证：需要
    @Headers({"Content-Type: application/json", "Accept: application/json"})
    @POST("OwnOpenApi/salesOrder/CancelOrder")
    Call<BaseResponse<Boolean>> cancelOrder(@Body RequestBody body);

    //确认收货,身份验证：需要
    @Headers({"Content-Type: application/json", "Accept: application/json"})
    @POST("OwnOpenApi/salesOrder/confirmDelivery")
    Call<BaseResponse<Boolean>> confirmReceiveGoods(@Body RequestBody body);

    //订单详情,身份验证：需要
    @Headers({"Content-Type: application/json", "Accept: application/json"})
    @POST("OwnOpenApi/salesOrder/getDetail")
    Call<BaseResponse<OrderDetailsInfo>> getOrderDetails(@Body RequestBody body);

    //添加购物车,身份验证：需要
    @Headers({"Content-Type: application/json", "Accept: application/json"})
    @POST("OwnOpenApi/Cart/AddCart")
    Call<BaseResponse<Boolean>> addCart(@Body RequestBody body);

    //添加收藏商品,身份验证：需要
    @Headers({"Content-Type: application/json", "Accept: application/json"})
    @POST("OwnOpenApi/product/addFavoriteProduct")
    Call<BaseResponse<Boolean>> addFavoriteProduct(@Body RequestBody body);

    //获取公钥
    @Headers({"Content-Type: application/json", "Accept: application/json"})
    @POST("OwnMall/common/getPublicKey")
    Call<BaseResponse<Map<String, String>>> getPublicKey();


    // 新品活动商品列表
    @Headers({"Content-Type: application/json", "Accept: application/json"})
    @POST("OwnOpenApi/product/getNewProductSell")
    Call<BaseResponse<NewProductSell>> getNewProductSell(@Body RequestBody body);

    // 获取收藏商品列表,身份验证：需要
    @Headers({"Content-Type: application/json", "Accept: application/json"})
    @POST("OwnOpenApi/Cart/DeteleCart")
    Call<BaseResponse<Boolean>> shoppingCartProductDel(@Body RequestBody body);

    // 获取收藏商品列表,身份验证：需要
    @Headers({"Content-Type: application/json", "Accept: application/json"})
    @POST("OwnOpenApi/product/getFavoriteProductList")
    Call<BaseResponse<FavoritesBeanList>> getFavoriteProductList(@Body RequestBody body);

    // 删除收藏商品,身份验证：需要
    @Headers({"Content-Type: application/json", "Accept: application/json"})
    @POST("OwnOpenApi/product/deleteFavoriteProduct")
    Call<BaseResponse<Boolean>> deleteFavoriteProduct(@Body RequestBody body);

    // 物流信息
    @Headers({"Content-Type: application/json", "Accept: application/json"})
    @POST("OwnOpenApi/logistics/logisticsDetails")
    Call<BaseResponse<LogisticsDetailsBean>> logisticsDetails(@Body RequestBody route);

    // 品牌列表是否需要身份认证：不需要
    @Headers({"Content-Type: application/json", "Accept: application/json"})
    @POST("OwnOpenApi/brand/getBrandList")
    Call<BaseResponse<BrandListBean>> getBrandList(@Body RequestBody body);


    // 专题列表请求方式：POST 是否需要身份认证：不需要
    @Headers({"Content-Type: application/json", "Accept: application/json"})
    @POST("OwnOpenApi/topic/list")
    Call<BaseResponse<TopicBean>> getTopicList(@Body RequestBody body);


    // 获取分类商品列表接口
    @Headers({"Content-Type: application/json", "Accept: application/json"})
    @POST("OwnOpenApi/product/getCategoryProductList")
    Call<BaseResponse<CategoryProductListBean>> getCategoryProductList(@Body RequestBody body);


    // (通过广告位编号)查询首页的广告接口
    @Headers({"Content-Type: application/json", "Accept: application/json"})
    @POST("OwnOpenApi/advertise/getList")
    Call<BaseResponse<List<AdvertiseListBean>>> getAdvertiseList(@Body RequestBody body);
    // -------------------------------------专题--------------------------------------------------------

    // 专题详情 请求方式：POST 是否需要身份认证：不需要
    @FormUrlEncoded
    @POST("OwnOpenApi/topic/detail")
    Call<BaseResponse<TopicBean.ListBean>> getTopicDetail(@FieldMap() Map<String, String> maps);

    // 专题商品列表 请求方式：POST 是否需要身份认证：不需要
    @FormUrlEncoded
    @POST("OwnOpenApi/topic/goodsList")
    Call<BaseResponse<List<TopicDetailBean.TopicGoodsBean>>> getTopicGoodsList(@FieldMap() Map<String, String> maps);

    // 专题详情合并评论列表 请求方式：POST 是否需要身份认证：不需要
    @FormUrlEncoded
    @POST("OwnOpenApi/topic/info")
    Call<BaseResponse<TopicDetailBean>> getTopicDetailComment(@FieldMap() Map<String, String> maps);

    // 品牌商品列表 是否需要身份认证：不需要
    @FormUrlEncoded
    @POST("OwnOpenApi/brand/getBrandsProduct")
    Call<BaseResponse<BrandProductListBean>> getBrandsProduct(@FieldMap() Map<String, String> maps);


    // 专题点赞/取消点赞 请求方式：POST 是否需要身份认证：需要
    @FormUrlEncoded
    @POST("OwnOpenApi/topic/like")
    Call<BaseResponse<Boolean>> setListTopic(@FieldMap() Map<String, String> maps);

    // 专题评论 请求方式：POST 是否需要身份认证：需要
    @FormUrlEncoded
    @POST("OwnOpenApi/topic/comment")
    Call<BaseResponse<Boolean>> writeTopicComment(@FieldMap() Map<String, String> maps);

    // -------------------------------------专题--------------------------------------------------------


    // 获取商品父分类列表接口(即：一级分类)
    @Headers({"Content-Type: application/json", "Accept: application/json"})
    @POST("OwnOpenApi/product/getFatherCategoryList")
    Call<BaseResponse<List<CategoryListBean>>> getFatherCategoryList();

    // 根据父分类ID获取商品子分类接口 （二级、三级子分类一并返回）
    @FormUrlEncoded
    @POST("OwnOpenApi/product/getChildCategorysByID")
    Call<BaseResponse<List<CategoryListBean>>> getChildCategorysByID(@FieldMap() Map<String, Integer> maps);


    // 商品搜索，身份验证：不需要
    @FormUrlEncoded
    @POST("OwnOpenApi/product/search")
    Call<BaseResponse<CategoryProductListBean>> getSearchProductList(@FieldMap() Map<String, String> maps);

    // 获取商品详情、商品规格接口
    @FormUrlEncoded
    @POST("OwnOpenApi/product/getProductDetail")
    Call<BaseResponse<ProductDetailBean>> getProductDetail(@FieldMap() Map<String, String> maps);

    //------------------    地址管理接口   ------------------
    // 地址列表
    @Headers({"Content-Type: application/json", "Accept: application/json"})
    @POST("OwnOpenApi/address/getUserAddressList")
    Call<BaseResponse<UserAddressListBean>> getUserAddressList(@Body RequestBody route);

    // 设为默认地址
    @FormUrlEncoded
    @POST("OwnOpenApi/address/setIsDefault")
    Call<BaseResponse<Boolean>> setIsDefault(@FieldMap() Map<String, String> maps);

    // 删除地址
    @FormUrlEncoded
    @POST("OwnOpenApi/address/deleteAddress")
    Call<BaseResponse<Boolean>> deleteAddress(@FieldMap() Map<String, String> maps);

    // 添加地址
    @FormUrlEncoded
    @POST("OwnOpenApi/address/addAddress")
    Call<BaseResponse<Boolean>> addAddress(@FieldMap() Map<String, String> maps);

    // 更新地址
    @FormUrlEncoded
    @POST("OwnOpenApi/address/updateAddress")
    Call<BaseResponse<Boolean>> updateAddress(@FieldMap() Map<String, String> maps);

    // 获取所有区域
    @FormUrlEncoded
    @POST("OwnMall/common/getRegionAll")
    Call<BaseResponse<String>> getRegionAll(@FieldMap() Map<String, String> maps);
    //------------------    地址管理接口   ------------------

    //------------------    我的接口   ------------------
    // 获取用户基本资料
    @FormUrlEncoded
    @POST("OwnMall/user/getUserInfo")
    Call<BaseResponse<UserBasicInfoBean>> getUserBasicInfo(@FieldMap() Map<String, String> maps);

    // 修改用户信息
    @Headers({"Content-Type: application/json", "Accept: application/json"})
    @POST("OwnMall/user/modify")
    Call<BaseResponse<Boolean>> updateUserBasicInfo(@Body RequestBody route);

    // 上传图片
    @Multipart
    @POST("OwnMall/common/uploadImage")
    Call<ResponseBody> uploadImage(@Part("description") RequestBody description, @Part MultipartBody.Part file);

    // 修改登录密码(根据旧密码)
    @Headers({"Content-Type: application/json", "Accept: application/json"})
    @POST("OwnMall/user/ModifyByOldLoginPassword")
    Call<BaseResponse<Boolean>> ModifyByOldLoginPassword(@Body RequestBody route);

    //订单数量统计（获取我的页面收藏数量，各状态订单数量和最新物流情况）
    @FormUrlEncoded
    @POST("OwnOpenApi/salesOrder/orderCountsByStatus")
    Call<BaseResponse<OrderCountsBean>> orderCountsByStatus(@FieldMap() Map<String, String> maps);

    //用户注销
    @FormUrlEncoded
    @POST("OwnMall/user/logout")
    Call<BaseResponse<Boolean>> logout(@FieldMap() Map<String, String> maps);

    //协议信息
    @FormUrlEncoded
    @POST("OwnOpenApi/common/getProtocolConfig")
    Call<BaseResponse<String>> getProtocolConfig(@FieldMap() Map<String, String> maps);

    //用户资金
    @FormUrlEncoded
    @POST("OwnOpenApi/account/getBalance")
    Call<BaseResponse<FundsBean>> getBalance(@FieldMap() Map<String, String> maps);

    //用户资金交易明细
    @FormUrlEncoded
    @POST("OwnOpenApi/account/getBalanceTransactionRecord")
    Call<BaseResponse<MyAssetsListBean>> getBalanceTransactionRecord(@FieldMap() Map<String, String> maps);
    //------------------    我的接口   ------------------

    // 获取APP更新信息
    @Headers({"Content-Type: application/json", "Accept: application/json"})
    @POST("OwnMall/common/getAppUpdateInfo")
    Call<BaseResponse<AppVersionInfoBean>> getAppUpdateInfo(@Body RequestBody route);


    //------------------    订单接口   ------------------
    //申请退款
    @FormUrlEncoded
    @POST("OwnOpenApi/salesOrder/RefundCancel")
    Call<BaseResponse<Boolean>> refundCancel(@FieldMap() Map<String, String> maps);

    //退款/售后列表
    @Headers({"Content-Type: application/json", "Accept: application/json"})
    @POST("OwnOpenApi/salesOrder/RefundList")
    Call<BaseResponse<AfterSaleListBean>> getRefundList(@Body RequestBody route);

    //
    // 添加评论
    @Headers({"Content-Type: application/json", "Accept: application/json"})
    @POST("OwnOpenApi/orderEvaluate/add")
    Call<BaseResponse<Boolean>> addComment(@Body RequestBody route);
    //------------------    订单接口   ------------------

    //重置绑定手机 请求方式：POST+HTTPS 是否需要身份认证：需要
    @FormUrlEncoded
    @POST("OwnMall/common/resetMobile")
    Call<BaseResponse<Boolean>> resetMobile(@FieldMap() Map<String, String> maps);

    //设置支付密码 请求方式：POST+HTTPS 是否需要身份认证：需要
    @FormUrlEncoded
    @POST("OwnMall/user/setPaymentPassword")
    Call<BaseResponse<Boolean>> setPaymentPassword(@FieldMap() Map<String, String> maps);



    //根据手机验证码设置支付密码 请求方式：POST+HTTPS 是否需要身份认证：需要
    @FormUrlEncoded
    @POST("OwnMall/user/setPaymentPasswordByCaptche")
    Call<BaseResponse<Boolean>> setPaymentPasswordByCaptche(@FieldMap() Map<String, String> maps);

    //检查用户是否有手机支付密码 是否需要身份认证：需要
    @Headers({"Content-Type: application/json", "Accept: application/json"})
    @POST("OwnMall/user/IsExistMobilePassWord")
    Call<BaseResponse<Boolean>> IsExistMobilePassWord();


    //评论列表 请求方式：POST 是否需要身份认证：不需要
    @FormUrlEncoded
    @POST("OwnOpenApi/orderEvaluate/list")
    Call<BaseResponse<OrderEvaluateListBean>> getOrderEvaluateList(@FieldMap() Map<String, String> maps);

    //添加订单
    @Headers({"Content-Type: application/json", "Accept: application/json"})
    @POST("OwnOpenApi/salesOrder/AddOrder")
    Call<BaseResponse<List<String>>> AddOrder(@Body RequestBody route);



    //获取订单可用支付方式
    @Headers({"Content-Type: application/json", "Accept: application/json"})
    @POST("OwnOpenApi/paymentPlatform/getPayMethods")
    Call<BaseResponse<List<PayMethodsBean>>> getPayMethods(@Body RequestBody route);


    //添加支付(无第三方支付功能) 请求方式：POST 是否需要身份认证：需要 [王小君]
    @Headers({"Content-Type: application/json", "Accept: application/json"})
    @POST("OwnOpenApi/paymentPlatform/add")
    Call<BaseResponse<Boolean>> paymentPlatform(@Body RequestBody route);


    //获取首页关键词 是否需要身份认证：不需要
    @Headers({"Content-Type: application/json", "Accept: application/json"})
    @POST("OwnOpenApi/common/getIndexKeywords")
    Call<BaseResponse<List<String>>> getIndexKeywords();


    //验证支付密码请求方式：POST+HTTPS 是否需要身份认证：需要
    @Headers({"Content-Type: application/json", "Accept: application/json"})
    @POST("OwnMall/user/authByMobilePaymentPassword")
    Call<BaseResponse<Boolean>> authByMobilePaymentPassword(@Body RequestBody route);

}
