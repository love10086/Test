package com.gemall.library.interface_list;

/**
 * @auther g-emall
 * @date 2019/4/25 16:12
 * @desc
 */
public interface IConfirmReceiveGoodsListener {
     void onConfirmReceiveGoodsSuccess();
     void onConfirmReceiveGoodsBefore();
     void onConfirmReceiveGoodsFailure(String desc);
}
