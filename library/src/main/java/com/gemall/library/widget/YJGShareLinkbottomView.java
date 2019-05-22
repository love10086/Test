package com.gemall.library.widget;

import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.support.design.widget.BottomSheetDialog;
import android.text.ClipboardManager;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.gemall.library.R;
import com.gemall.library.util.SkuUtils;
import com.umeng.analytics.MobclickAgent;
import com.umeng.socialize.ShareAction;
import com.umeng.socialize.UMShareAPI;
import com.umeng.socialize.UMShareListener;
import com.umeng.socialize.bean.SHARE_MEDIA;
import com.umeng.socialize.media.UMImage;
import com.umeng.socialize.media.UMWeb;
import com.zhy.view.flowlayout.FlowLayout;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import okhttp3.RequestBody;

/**
 * Created by Gemall on 2018/3/13.
 */

public class YJGShareLinkbottomView extends LinearLayout implements View.OnClickListener {
    Activity activity;
    BottomSheetDialog bottomsheet;
    YJGShareLinkbottomEvent yjgShareLinkbottomEvent;
    int ShareMedia[];
    UMWeb web;
    UMImage umImage;
    boolean isaddUserShareRecord;//是否调用统计接口

    public YJGShareLinkbottomView(Activity activity, int... ShareMedia) {
        super(activity);
        this.ShareMedia = ShareMedia;
        init(activity);
    }

    public YJGShareLinkbottomView(Activity activity, YJGShareLinkbottomEvent yjgShareLinkbottomEvent, int... ShareMedia) {
        super(activity);
        this.yjgShareLinkbottomEvent = yjgShareLinkbottomEvent;
        this.ShareMedia = ShareMedia;
        init(activity);
    }

    private void init(Activity activity) {
        this.activity = activity;


        if (!activity.getPackageManager().hasSystemFeature(PackageManager.FEATURE_BLUETOOTH_LE)) {

            Toast.makeText(activity, "设备不支持蓝牙4.0", Toast.LENGTH_SHORT).show();
        }


        View bottomSheetDialog = LayoutInflater.from(activity).inflate(R.layout.share_link_bottom, null);
        TextView close = bottomSheetDialog.findViewById(R.id.close);
        close.setOnClickListener(this);
        close.setTag(-1);
        FlowLayout flowLayout = bottomSheetDialog.findViewById(R.id.flowlayout);


        ArrayList<HashMap<String, Object>> arrayList = new ArrayList<>();
        HashMap<String, Object> hashMap;
        for (int Media : ShareMedia) {

            switch (Media) {
                case 0:
                    hashMap = new HashMap<>();
                    hashMap.put("ico", R.drawable.jiguang_socialize_wechat);
                    hashMap.put("name", "微信好友");
                    hashMap.put("type", 0);
                    arrayList.add(hashMap);

                    break;
                case 1:
                    hashMap = new HashMap<>();
                    hashMap.put("ico", R.drawable.jiguang_socialize_wxcircle);
                    hashMap.put("name", "朋友圈");
                    hashMap.put("type", 1);
                    arrayList.add(hashMap);

                    break;
                case 2:
                    hashMap = new HashMap<>();
                    hashMap.put("ico", R.drawable.jiguang_socialize_qq);
                    hashMap.put("name", "QQ");
                    hashMap.put("type", 2);
                    arrayList.add(hashMap);

                    break;
                case 3:
//                    hashMap = new HashMap<>();
//                    hashMap.put("ico", R.drawable.jiguang_socialize_qzone);
//                    hashMap.put("name", "QQ空间");
//                    hashMap.put("type", 3);
//                    arrayList.add(hashMap);

                    break;
                case 4:
//                    hashMap = new HashMap<>();
//                    hashMap.put("ico",R.mipmap.share_wb);
//                    hashMap.put("name","新浪微博");
//                    hashMap.put("type",4);
//                    arrayList.add(hashMap);

                    break;
                case 5:
                    hashMap = new HashMap<>();
                    hashMap.put("ico", R.drawable.jiguang_socialize_copyurl);
                    hashMap.put("name", "复制链接");
                    hashMap.put("type", 5);
                    arrayList.add(hashMap);

                    break;

                case 7:
                    hashMap = new HashMap<>();
                    hashMap.put("ico", R.drawable.share_qrcode);
                    hashMap.put("name", "iBeacon");
                    hashMap.put("type", 7);
                    arrayList.add(hashMap);

                    break;

                case 6:
                    hashMap = new HashMap<>();
                    hashMap.put("ico", R.drawable.share_qrcode);
                    hashMap.put("name", "二维码");
                    hashMap.put("type", 6);
                    arrayList.add(hashMap);

                    break;
            }


        }


        for (int i = 0; i < arrayList.size(); i++) {

            HashMap<String, Object> hashMap1 = arrayList.get(i);

            View share_Link_bottom_item = LayoutInflater.from(activity).inflate(R.layout.share_link_bottom_item, null);
            ImageView imageView = share_Link_bottom_item.findViewById(R.id.ico);
            TextView textView = share_Link_bottom_item.findViewById(R.id.name);
            imageView.setImageResource((Integer) hashMap1.get("ico"));
            textView.setText(hashMap1.get("name").toString());
            imageView.setTag(hashMap1.get("type"));
            imageView.setOnClickListener(this);
            flowLayout.addView(share_Link_bottom_item);
        }

        bottomsheet = new BottomSheetDialog(activity, R.style.MyBottomSheetDialog);

        bottomsheet.setContentView(bottomSheetDialog);
        bottomsheet.setCancelable(true);


    }

//    public void setShareMedia(int ...ShareMedia){
//
//    }


    public void show() {
        bottomsheet.show();
    }


    public void setData(UMWeb web) {
        setData(web,false);
    }

    public void setData(UMWeb web,boolean isaddUserShareRecord) {
        this.web = web;
        this.isaddUserShareRecord = isaddUserShareRecord;
    }


    public void setData(UMImage umImage) {
        setData(umImage,false);
    }
    public void setData(UMImage umImage,boolean isaddUserShareRecord) {
        this.umImage = umImage;
        this.isaddUserShareRecord = isaddUserShareRecord;
    }

    @Override
    public void onClick(View view) {
        final int tag = (int) view.getTag();

        if (tag == 7) {

            bottomsheet.dismiss();

//            iBeaconShareView iBeaconShareView = new iBeaconShareView(activity);
//            DialogCreate dialogCreate = new DialogCreate(activity, iBeaconShareView, true, null);
//            dialogCreate.setCloseViewOnClickListener(new OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    iBeaconShareView.stopAdvertise();
//                    dialogCreate.dismiss();
//                }
//            });
//
//            iBeaconShareView.startAdvertise();
//            dialogCreate.show();


        } else {
            SHARE_MEDIA platform = null;
            bottomsheet.dismiss();
            switch (tag) {
                case -1:
                    return;
                case 0:
                    platform = SHARE_MEDIA.WEIXIN;
                    if (!UMShareAPI.get(getContext()).isInstall(activity, SHARE_MEDIA.WEIXIN)) {
                        Toast.makeText(activity, "未安装微信", Toast.LENGTH_SHORT).show();
                    }
                    break;
                case 1:
                    platform = SHARE_MEDIA.WEIXIN_CIRCLE;
                    if (!UMShareAPI.get(getContext()).isInstall(activity, SHARE_MEDIA.WEIXIN_CIRCLE)) {
                        Toast.makeText(activity, "未安装微信", Toast.LENGTH_SHORT).show();
                    }
                    break;
                case 2:
                    platform = SHARE_MEDIA.QQ;
                    if (!UMShareAPI.get(getContext()).isInstall(activity, SHARE_MEDIA.QQ)) {
                        Toast.makeText(activity, "未安装QQ", Toast.LENGTH_SHORT).show();
                    }
                    break;
                case 3:
                    platform = SHARE_MEDIA.QZONE;
                    break;
                case 4:
                    platform = SHARE_MEDIA.SINA;
                    break;
                case 5:
                    ClipboardManager cm = (ClipboardManager) activity.getSystemService(Context.CLIPBOARD_SERVICE);
                    // 将文本内容放到系统剪贴板里。
                    cm.setText(web.toUrl());
//                ToastDialog.show(activity, "复制成功，可以发给朋友们了。", 1);
                    Toast.makeText(activity, "复制成功，可以发给朋友们了 ~ ", Toast.LENGTH_LONG).show();
                    return;
                case 6:
                    if (yjgShareLinkbottomEvent != null) {
                        yjgShareLinkbottomEvent.QREvent();
                    }
                    return;
            }

            ShareAction shareAction = new ShareAction(activity)
                    .setPlatform(platform)
                    .setCallback(new UMShareListener() {
                        @Override
                        public void onStart(SHARE_MEDIA share_media) {

                            MobclickAgent.onEvent(activity, "sharesuccess");
                            SkuUtils.printf("************onStart 分享啦");

                            if(isaddUserShareRecord){
                                Map<String, String> maps = new HashMap<>();
                                maps.put("platformType",tag+"");
                                RequestBody body = RequestBody.create(okhttp3.MediaType.parse("application/json; charset=utf-8"), SkuUtils.gson.toJson(maps));
//                                RetrofitManage.sendRequest(RetrofitManage.getInstance().getHttpServiceConnection().addUserShareRecord(body), null);
                            }
                        }

                        @Override
                        public void onResult(SHARE_MEDIA platform) {
                            SkuUtils.printf("************分享成功啦");
//                            MobclickAgent.onEvent(activity, "sharesuccess");


                        }

                        @Override
                        public void onError(SHARE_MEDIA platform, Throwable t) {
                            SkuUtils.printf("************分享失败啦");
                            MobclickAgent.onEvent(activity, "shareError");
                        }

                        @Override
                        public void onCancel(SHARE_MEDIA platform) {
                            SkuUtils.printf("************分享取消了");
                        }
                    });
//                .withText("Hello 豆瓣")

            if(web != null){
                shareAction.withMedia(web);
            }else if(umImage != null){
                shareAction.withMedia(umImage);
            }else {
                return;
            }
            shareAction.share();
        }


    }


    public static abstract class YJGShareLinkbottomEvent {

        public void QREvent() {
        }

    }

}
