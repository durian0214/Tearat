package com.fyh.aramis.http.interfaces;


import com.alibaba.fastjson.JSON;
import com.fyh.aramis.custom.BaseBean;
import com.fyh.aramis.custom.LoadingDialog;
import com.fyh.aramis.custom.PromptView;

/**
 * 默认json object Listener(当T instanceof BaseBean时，返回null，只用于判断成功与否用途)
 * Created by admin on 2016/9/12.
 */
public abstract class DefaultObjectHttpListener<T> extends DefaultHttpListener<T> {
//    private final String TAG = "===DefaultObjectHttp";
    private Class<T> clazz;

    public DefaultObjectHttpListener() {
        super();
        init();
    }

    public DefaultObjectHttpListener(PromptView errorView) {
        super(errorView);
        init();
    }

    public DefaultObjectHttpListener(PromptView errorView, LoadingDialog loadingDialog) {
        super(errorView, loadingDialog);
        init();
    }

    protected void init() {
        clazz = getParsedClass();
    }

    @Override
    protected void onSuccessParsedFirst(int code, String data) {
        if (clazz == BaseBean.class) {
            onSuccessParsed(null);
        } else {
            T tt = JSON.parseObject(data, clazz);
            if (tt != null) {
                onSuccessParsed(tt);
            }
        }
    }

    public abstract void onSuccessParsed(T result);
}