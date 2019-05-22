package com.gemall.library.http;

import java.util.HashMap;
import java.util.Map;

public class HttpInfo {


    private static HttpInfo mHttpInfo;

    private static Map<String,String> parMap;

    private HttpInfo(){
        parMap = new HashMap<>();
    }
    public static HttpInfo getHttpInfo(){

        if(mHttpInfo == null){
            mHttpInfo = new HttpInfo();
        }
        return mHttpInfo;
    }


    public Map<String,String> getParMap(){
        return parMap;
    }


//Map<String,String> stringStringMap = HttpInfo.getHttpInfo().getParMap();
}
