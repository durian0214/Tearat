package com.fyh.utils;

import android.content.Context;
import android.content.SharedPreferences;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * SharedPreferencesUtils
 * Created by Aramis on 2017/3/20.
 */

public class SharedPreferencesUtils {
    private static volatile SharedPreferencesUtils sharedPreferencesUtils;

    private SharedPreferencesUtils() {

    }

    public static SharedPreferencesUtils getInstance() {
        if (sharedPreferencesUtils == null) {
            synchronized (SharedPreferencesUtils.class) {
                if (sharedPreferencesUtils == null)
                    sharedPreferencesUtils = new SharedPreferencesUtils();
            }
        }
        return sharedPreferencesUtils;
    }

    public SharedPreferences getSharedPreferences(Context context, String spName) {
        return context.getSharedPreferences(spName, Context.MODE_PRIVATE);
    }

    public Map<String, Object> getValueMap(SharedPreferences sp, List<String> keys) {
        Map<String, Object> map = new HashMap<>();
        if (keys != null) {
            for (String key : keys) {
                String value = "";
//                if (sp.contains(key)) value=sp.get
            }
        }
        Map<String, ?> all = sp.getAll();
        Set<String> keySet = all.keySet();
        Iterator<String> iterator = keySet.iterator();
        while (iterator.hasNext()) {

        }

        return map;
    }

    public Object getValue(SharedPreferences sp, String key) {
        String simpleName = key.getClass().getSimpleName();
        switch (simpleName) {
            case "String":
                return sp.getString(key, "");
            case "Integer":
                return sp.getInt(key, 0);
            case "Boolean":
                return sp.getBoolean(key, false);
            case "Float":
                return sp.getFloat(key, 0);
            case "Long":
                return sp.getLong(key, 0);
        }
        return null;
    }

    public Object getValue(SharedPreferences sp, String key, Object defaultValue) {
        String simpleName = key.getClass().getSimpleName();
        switch (simpleName) {
            case "String":
                return sp.getString(key, (String) defaultValue);
            case "Integer":
                return sp.getInt(key, (Integer) defaultValue);
            case "Boolean":
                return sp.getBoolean(key, (Boolean) defaultValue);
            case "Float":
                return sp.getFloat(key, (Float) defaultValue);
            case "Long":
                return sp.getLong(key, (Long) defaultValue);
        }

        return null;
    }
}
