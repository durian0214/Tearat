package com.fyh.utils;

import com.alibaba.fastjson.JSON;

import java.util.List;

/**
 * json解析工具
 * Created by Cbt on 2016/12/19.
 */
public class GsonUtil {
    volatile private static GsonUtil intance  = null;
    private GsonUtil(){}
    public static GsonUtil getIntance() {
        synchronized (GsonUtil.class){
        if (intance == null) {
            intance = new GsonUtil();
        }}
        return intance;
    }



    public final <T> T parseObject(String data, Class<T> clazz) {
        LogUtil.i("===",data);
        return JSON.parseObject(data, clazz);
    }


    public final <T> List<T> parseArray(String data, Class<T> clazz) {
        LogUtil.i("===",data);
        return JSON.parseArray(data, clazz);
    }


}
