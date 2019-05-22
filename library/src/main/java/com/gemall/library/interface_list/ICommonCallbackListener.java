package com.gemall.library.interface_list;

/**
 * @auther g-emall
 * @date 2019/5/10 17:49
 * @desc
 */
public interface ICommonCallbackListener {
    void onSuccess(String type);//添加个type参数，用于区别同一个页面不同接口调用改监听

    void onFailure(String type, String desc);
}
