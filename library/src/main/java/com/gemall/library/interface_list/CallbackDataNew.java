package com.gemall.library.interface_list;

/**
 * Created by g-emall on 2018/12/6.
 */

/**多功能回调接口*/
public interface CallbackDataNew<X>{
    X callbackData_new(String action, Object... objectData);
}