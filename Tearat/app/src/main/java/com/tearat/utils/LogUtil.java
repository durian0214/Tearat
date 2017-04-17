package com.tearat.utils;

import android.util.Log;

/**
 * Durian
 * 2017-2017/3/15
 */
public class LogUtil {
    /**
     * 打印输出日志信息 Log.d(tag, message);
     *
     * @param tag
     * @param message
     *            要打印的内容
     */
    public static void showLog(String tag, String message) {
        if (Constant.isLog) {
            Log.d(tag, message);
        }
    }

    /**
     * 打印输出日志信息 System.out.println(message);
     *
     * @param message
     *            要打印的内容
     */
    public static void show(String message) {
        if(Constant.isLog)
        {
            Log.v("System.out", message);
        }

    }

    /**
     * log打印i级别的信息，带有tag的
     * @param tag
     * @param msg
     */
    public static void i(String tag, String msg){
        if(Constant.isLog){
            Log.i(tag, msg);
        }
    }

    public static void i(Object object, String msg){
        if(Constant.isLog){
            Log.i(object.getClass().getSimpleName(), msg);
        }
    }

    /**
     * 打印e级别的信息
     * @param tag
     * @param msg
     */
    public static void e(String tag, String msg){
        if(Constant.isLog){
            Log.e(tag, msg);
        }
    }

    public static void e(Object object, String msg){
        if(Constant.isLog){
            Log.e(object.getClass().getSimpleName(), msg);
        }
    }
}
