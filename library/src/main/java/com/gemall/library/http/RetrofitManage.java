package com.gemall.library.http;

import android.app.Activity;
import android.os.Build;
import android.text.TextUtils;

import com.gemall.library.BuildConfig;
import com.gemall.library.application.LibraryApplication;
import com.gemall.library.base.BaseResponse;
import com.gemall.library.bean.LoginInfo;
import com.gemall.library.config.UserInfo;
import com.gemall.library.util.PhoneUtil;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.intercepter.HttpLoggingInterceptor;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

/****
 * @Project_Name: GFT
 * @Copyright: Copyright © 2012-2017 G-emall Technology Co.,Ltd
 * @Version: 1.0.0.1
 * @Created by:     g-emall on 2017/6/5 16:57.
 * @Desc:
 * @ModifyHistory:
 ****/


public class RetrofitManage {

    public static boolean iSOutLog = false;

    public static String BASE_URL = BuildConfig.SERVER_URL;
    private static RetrofitManage mInstance;
    private static Retrofit mRetrofit;
    private static HttpService mHttpService;

    public static RetrofitManage getInstance() {
        if (mInstance == null) {
            synchronized (RetrofitManage.class) {
                mInstance = new RetrofitManage();
            }
        }
        return mInstance;
    }

    /**
     * 获取retrofit对象
     */
    private Retrofit getRetrofit() {
        if (null == mRetrofit) {
            HttpsUtils.SSLParams sslParams = HttpsUtils.getSslSocketFactory(null, null, null);
            OkHttpClient.Builder builder = new OkHttpClient.Builder();
            builder.connectTimeout(30, TimeUnit.SECONDS);
            builder.writeTimeout(30, TimeUnit.SECONDS);
            builder.readTimeout(30, TimeUnit.SECONDS);
            builder.sslSocketFactory(sslParams.sSLSocketFactory, sslParams.trustManager);
            //SKU接口添加请求头
            builder.addInterceptor(new Interceptor() {
                @Override
                public Response intercept(Chain chain) throws IOException {

                    Request.Builder builder = chain.request().newBuilder();

                    UserInfo userInfo = UserInfo.getUserInfo();
                    if (userInfo != null) {

                        String tempID = userInfo.getTempID();

                        if (!TextUtils.isEmpty(tempID)) {
                            builder.addHeader("tempID", tempID);
                        }


                        String TOKEN = userInfo.getUserToken();
                        if (!TextUtils.isEmpty(TOKEN)) {
                            builder.addHeader("userToken", TOKEN);
                        }

                        String userUID = userInfo.getUserUID();
                        if (!TextUtils.isEmpty(userUID)) {
                            builder.addHeader("userUID", userUID);
                        }

                    }

                    builder.addHeader("clientID", PhoneUtil.getUniqueID());
                    builder.addHeader("clientType", String.valueOf(6));
                    builder.addHeader("brand", Build.BRAND);//手机品牌
                    builder.addHeader("model", Build.MODEL);//手机型号
                    builder.addHeader("version", BuildConfig.VERSION_NAME);//版本号
                    builder.addHeader("clientSource", String.valueOf(2));//客户端来源


                    Request request = builder.build();
                    Response response = chain.proceed(request);
                    return response;
                }
            });

            if (Build.VERSION.SDK_INT > Build.VERSION_CODES.KITKAT) {
                builder.addInterceptor(new com.zhy.http.okhttp.intercepter.HttpLoggingInterceptor("YJZY网络请求").setLevel(HttpLoggingInterceptor.Level.BODY));
            }


            //其他配置
            OkHttpClient okHttpClient = builder.build();
            OkHttpUtils.initClient(okHttpClient);

            mRetrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .client(okHttpClient)
                    //增加返回值为String的支持
                    .addConverterFactory(ScalarsConverterFactory.create())
                    //增加返回值为Gson的支持(以实体类返回)
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .build();
        }
        return mRetrofit;
    }

    public HttpService getHttpServiceConnection() {
        if (mHttpService == null) {
            mHttpService = getRetrofit().create(HttpService.class);
        }
        return mHttpService;
    }


    public static <T> void sendRequest(Call<BaseResponse<T>> call, final RequestCallback<T> requestCallback) {
        sendRequest(null, call, requestCallback);
    }


    static long count;

    public static synchronized <T> void sendRequest(Activity activity, Call<BaseResponse<T>> call, final RequestCallback<T> requestCallback) {

        RequestRunnable requestRunnable = new RequestRunnable<T>(activity, call, requestCallback, count++);
        new Thread(requestRunnable).start();

    }

    public interface RequestCallback<T> {
        void onResponse(Call<BaseResponse<T>> call, retrofit2.Response<BaseResponse<T>> response);

        void onFailure(Call<BaseResponse<T>> call, Throwable t);

    }


}
