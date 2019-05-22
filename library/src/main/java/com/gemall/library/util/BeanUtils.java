package com.gemall.library.util;

import android.content.Context;

import com.gemall.library.bean.LoginInfo;
import com.gemall.library.bean.OrderInfo;
import com.gemall.library.bean.OrderTransforDataBean;
import com.gemall.library.config.PreferenceConst;
import com.gemall.library.crypt.DesUtil;
import com.gemall.library.hepler.PreferenceUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @auther g-emall
 * @date 2019/4/16 20:08
 * @desc 保存bean数据，转换bean类型
 */
public class BeanUtils {
    public static void saveLoginSuccessData(Context context, LoginInfo loginInfo) {
        String loginInfoJson = SkuUtils.gson.toJson(loginInfo);
        try {
            String enLoginInfo = DesUtil.encryptDes(loginInfoJson);
            SkuUtils.setAccountInfo("UserInfo", enLoginInfo);
            //SkuUtils.setAccountInfo("UserInfo", SkuUtils.gson.toJson(loginInfo));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static List<OrderTransforDataBean> transforData(List<OrderInfo.ListBean> list) {
        List<OrderTransforDataBean> result = new ArrayList<>();
        int index = 0;
        for (int i = 0; i < list.size(); i++) {
            OrderInfo.ListBean bean = list.get(i);
            List<Object> statusList = getSalesOrderStatus(bean.getSalesOrderStatus());
            //头部数据
            OrderTransforDataBean.OrderTopBean orderTopBean = new OrderTransforDataBean.OrderTopBean(
                    bean.getCreateTime(), String.valueOf(statusList.get(0)));
            result.add(new OrderTransforDataBean(OrderTransforDataBean.TOP_ITEM, orderTopBean));
            List<OrderInfo.ListBean.SalesItemBean> salesItem = bean.getSalesItem();
            //商品数据
            int totalProductCount = 0;
            for (int j = 0; j < salesItem.size(); j++) {
                salesItem.get(j).setOrderStatus(bean.getSalesOrderStatus());
                salesItem.get(j).setOrderUid(bean.getSalesOrderUID());
                result.add(new OrderTransforDataBean(OrderTransforDataBean.PRODUCT_ITEM, salesItem.get(j)));
                totalProductCount += salesItem.get(j).getQuantity();
            }
            //价格数据
            OrderTransforDataBean.OrderPricesBean orderPricesBean = new OrderTransforDataBean.OrderPricesBean(totalProductCount + "", bean.getPayAmount() + "");
            result.add(new OrderTransforDataBean(OrderTransforDataBean.PRICES_ITEM, orderPricesBean));
            //底部数据
            if (statusList.size() >= 2) {
                result.add(new OrderTransforDataBean(Integer.parseInt(String.valueOf(statusList.get(1))), bean));
            }

        }
        return result;
    }

    private static List<Object> getSalesOrderStatus(int salesOrderStatus) {
        List<Object> result = new ArrayList<>();

        switch (salesOrderStatus) {
            case 1:
                result.add("待付款");
                result.add(OrderTransforDataBean.BOTTOM_WAIT_PAY_ITEM);
                break;
            case 2:
                result.add("待发货");
                result.add(OrderTransforDataBean.BOTTOM_WAIT_SEND_PRODUCT_ITEM);
                break;
            case 3:
                result.add("待收货");
                result.add(OrderTransforDataBean.BOTTOM_WAIT_RECEIVE_PRODUCT_ITEM);
                break;
            case 4:
                result.add("交易成功");
                result.add(OrderTransforDataBean.BOTTOM_WAIT_EVALUATE_ITEM);
                break;
            case 5:
                result.add("交易成功");
                result.add(OrderTransforDataBean.BOTTOM_EVALUATED_ITEM);
                break;
            case 6:
                result.add("交易关闭");
                result.add(OrderTransforDataBean.BOTTOM_CLOSED_ITEM);
                break;
        }


        if (result.size() < 2) {
            result.clear();
            result.add("");
        }
        return result;
    }

}
