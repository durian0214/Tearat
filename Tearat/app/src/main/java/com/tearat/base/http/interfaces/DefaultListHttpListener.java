package com.fyh.aramis.http.interfaces;


import android.view.View;

import com.fyh.aramis.custom.BaseBean;
import com.fyh.aramis.custom.LoadingDialog;
import com.fyh.aramis.custom.PromptView;
import com.fyh.utils.GsonUtil;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

/**
 * 默认json list Listener
 * Created by admin on 2016/9/12.
 */
public abstract class DefaultListHttpListener<T> extends DefaultHttpListener<T> {
    private final String TAG = "===DefaultListHttp";
    private Class<T> clazz;
    private String jsonArrayName;

    public DefaultListHttpListener() {
        super();
        init();
    }

    public DefaultListHttpListener(PromptView errorView) {
        super(errorView);
        init();
    }

    public DefaultListHttpListener(PromptView errorView, LoadingDialog loadingDialog) {
        super(errorView, loadingDialog);
        init();
    }

    protected void init() {
        clazz = getParsedClass();
        jsonArrayName="list";//默认
    }

    public void setJsonArrayName(String jsonName) {
        this.jsonArrayName = jsonName;
    }

    @Override
    protected void onSuccessParsedFirst(int code, String data) {
//        LogUtil.e(TAG, "onSuccessParsedFirst============== code:" + code+",data:"+data);
        try {
            if (data.charAt(0) == '[') {
                parseArray(data);
            } else if (data.charAt(0) == '{') {
                JSONObject obj = new JSONObject(data);
                if (!obj.isNull(jsonArrayName)) {
                    parseArray(obj.getString(jsonArrayName));
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private void parseArray(String data) {
//        LogUtil.e(TAG, "data==============" + data);
        List<T> tt = GsonUtil.getIntance().parseArray(data, clazz);
        if (tt != null && tt.size() > 0) {
            onSuccessParsed(tt);
        } else {
            PromptView errorView = getErrorView();
            if (errorView != null) {
//                errorView.setLoadingImg(R.drawable.ico_fb_nodata);
                errorView.setLoadingText("暂无数据", null);
                errorView.setVisibility(View.VISIBLE);
            }
            onListSizeZero();
        }
    }

    public abstract void onSuccessParsed(List<T> result);

    public abstract void onListSizeZero();
}