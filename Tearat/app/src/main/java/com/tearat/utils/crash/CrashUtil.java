package com.fyh.aramis.crash;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;

import com.fyh.aramis.http.HttpUtils;
import com.fyh.md5.NslmCryptoUtils;
import com.fyh.utils.HttpConstant;
import com.fyh.utils.LogUtil;
import com.fyh.utils.SharedPreferencesUtils;
import com.kymjs.rxvolley.client.HttpCallback;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

/**
 * CrashUtil
 * Created by Aramis on 2017/3/20.
 */

public class CrashUtil {
    private static final String TAG = "CrashUtil";
    private static final String crashSpName = "crashSpName";

    public void postCrash(Context context) {
        final SharedPreferences sp =
                SharedPreferencesUtils.getInstance().getSharedPreferences(context, crashSpName);
        if (checkCrash(sp) && !TextUtils.isEmpty(sp.getString(CrashBean.STR_versionCode, ""))) {
            HttpUtils.getInstance().jsonPost(HttpConstant.BUG_COLLECTION, getCrashValueMap(sp),
                    new HttpCallback() {
                        @Override
                        public void onSuccess(String t) {
                            super.onSuccess(t);
                            LogUtil.e(TAG, "onSuccess:" + t);
                            savaCrashIsPost(sp, true);
                        }

                        @Override
                        public void onFailure(int errorNo, String strMsg) {
                            super.onFailure(errorNo, strMsg);
                            LogUtil.e(TAG, "errorNo:" + errorNo + ",strMsg:" + strMsg);
                            savaCrashIsPost(sp, false);
                        }
                    });
        } else {
            LogUtil.e(TAG, "isPost:" + false + ",| sp=null");
        }
    }

    private boolean checkCrash(SharedPreferences sp) {
        return !sp.getBoolean("isPost", false);
    }

    private Map<String, Object> getCrashValueMap(SharedPreferences sp) {
        Map<String, Object> map = new HashMap<>();
        map.put(CrashBean.STR_versionCode, sp.getString(CrashBean.STR_versionCode, ""));
        map.put(CrashBean.STR_versionName, sp.getString(CrashBean.STR_versionName, ""));
        map.put(CrashBean.STR_type, sp.getString(CrashBean.STR_type, ""));
        map.put(CrashBean.STR_model, sp.getString(CrashBean.STR_model, ""));
        map.put(CrashBean.STR_time, sp.getString(CrashBean.STR_time, ""));
        map.put(CrashBean.STR_brand, sp.getString(CrashBean.STR_brand, ""));
        map.put(CrashBean.STR_cpu_abi, sp.getString(CrashBean.STR_cpu_abi, ""));
        try {
            String encrypt = NslmCryptoUtils.encrypt(sp.getString(CrashBean.STR_exception, ""));
            if (!TextUtils.isEmpty(encrypt)) map.put(CrashBean.STR_exception, encrypt);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return map;
    }

    private void savaCrashIsPost(SharedPreferences sp, boolean isPost) {
        sp.edit().putBoolean("isPost", isPost).apply();
        if (isPost) {
            File file = new File(sp.getString(CrashBean.STR_fileName, ""));
            if (file.exists()) file.delete();
        }
    }

    public void savaCrash(Context context, CrashBean crashBean, boolean isPost) {
        savaCrash(SharedPreferencesUtils.getInstance().getSharedPreferences(context, crashSpName), crashBean, isPost);
    }

    public void savaCrash(SharedPreferences sp, CrashBean crashBean, boolean isPost) {
        SharedPreferences.Editor edit = sp.edit();
        edit.putString(CrashBean.STR_versionCode, crashBean.getVersionCode());
        edit.putString(CrashBean.STR_versionName, crashBean.getVersionName());
        edit.putString(CrashBean.STR_type, crashBean.getType());
        edit.putString(CrashBean.STR_model, crashBean.getModel());
        edit.putString(CrashBean.STR_time, crashBean.getTime());
        edit.putString(CrashBean.STR_brand, crashBean.getBrand());
        edit.putString(CrashBean.STR_cpu_abi, crashBean.getCpu_abi());
        edit.putString(CrashBean.STR_exception, crashBean.getException());
        edit.putString(CrashBean.STR_fileName, crashBean.getFileName());
        edit.putBoolean("isPost", isPost);
        edit.apply();
    }

}
