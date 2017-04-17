package com.tearat.utils;

import android.content.Context;
import android.widget.Toast;
/**
 * Durian
 * 2017-2017/3/15
 */
public class ToastUtils {
    /**
     * 短提示
     * @param mContext
     * @param msg
     */
    public static void showToastS(Context  mContext, int msg){
        Toast.makeText(mContext,msg,Toast.LENGTH_SHORT).show();
    }
    public static void showToastS(Context mContext, CharSequence msg){
        Toast.makeText(mContext,msg,Toast.LENGTH_SHORT).show();
    }
    /**
     * 自定义显示Toast时间
     */
    public static void showToast(Context context, CharSequence msg, int duration)
    {
            Toast.makeText(context, msg, duration).show();
    }

    public static void showToast(Context context, int msg, int duration)
    {
            Toast.makeText(context, msg, duration).show();
    }
}
