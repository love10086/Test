package com.gemall.library.interface_list;

/**
 * @auther g-emall
 * @date 2019/4/16 14:22
 * @desc
 */
public interface ISendIdentityCodeListener {
    void onSuccess();
    void onFailure(String desc);
}
