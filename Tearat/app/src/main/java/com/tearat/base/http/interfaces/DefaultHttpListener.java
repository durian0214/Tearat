package com.fyh.aramis.http.interfaces;

import android.text.TextUtils;
import android.view.View;

import com.fyh.aramis.custom.BaseBean;
import com.fyh.aramis.custom.LoadingDialog;
import com.fyh.aramis.custom.PromptView;
import com.fyh.aramis.http.HttpUtils;
import com.fyh.utils.GsonUtil;
import com.fyh.utils.LogUtil;
import com.kymjs.rxvolley.client.HttpCallback;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;


/**
 * 网络回调父类
 * Created by Aramis on 2016/11/14.
 */

public abstract class DefaultHttpListener<T> extends HttpCallback {
    private final String TAG = "===DefaultHttpListener";
    private Class<T> clazz;
    private PromptView errorView;
    private LoadingDialog loadingDialog;

    public DefaultHttpListener() {
        init(null, null);
    }

    public DefaultHttpListener(PromptView errorView) {
        init(errorView, null);
    }

    public DefaultHttpListener(PromptView errorView, LoadingDialog loadingDialog) {
        init(errorView, loadingDialog);
    }

    private void init(PromptView errorView, LoadingDialog loadingDialog) {
//        if (errorView != null && errorView.getId() == R.id.layout_http_error)
//            this.errorView = errorView;
        this.loadingDialog = loadingDialog;

        Type modelType = getClass().getGenericSuperclass();
        if ((modelType instanceof ParameterizedType)) {
            Type[] modelTypes = ((ParameterizedType) modelType).getActualTypeArguments();
            clazz = ((Class) modelTypes[0]);
        }
    }

    protected Class<T> getParsedClass() {
        return clazz;
    }

    protected PromptView getErrorView() {
        return errorView;
    }

    protected LoadingDialog getLoadingDialog() {
        return loadingDialog;
    }

    @Override
    public void onSuccess(String t) {
        super.onSuccess(t);
        LogUtil.i("data=",t);
//        LogUtil.e("dd", "===================" + t);
        if (loadingDialog != null && loadingDialog.isShowing()) loadingDialog.dismiss();
        if (errorView != null) errorView.setVisibility(View.GONE);
        if (!TextUtils.isEmpty(t)) {
//            BaseBean baseBean = JSON.parseObject(t, BaseBean.class);
            BaseBean baseBean = GsonUtil.getIntance().parseObject(t, BaseBean.class);
            if (baseBean != null) {
                int status = baseBean.getStatus();
                if (status == HttpUtils.SUCCESS) {
                    String data = baseBean.getResults();

                    if (clazz == BaseBean.class || !TextUtils.isEmpty(data)) {
                        onSuccessParsedFirst(baseBean.getStatus(), data);
                    } else {
                        onFailWithCode(status,
                                HttpUtils.RESPONSE_ERROR, HttpUtils.RESPONSE_ERROR_STR);
                    }
                } else {
                    onFailWithCode(status,
                            HttpUtils.RESPONSE_ERROR, HttpUtils.RESPONSE_ERROR_STR);
                }
            } else {
                onFailWithCode(HttpUtils.RESPONSE_NULL,
                        HttpUtils.RESPONSE_NULL, HttpUtils.RESPONSE_NULL_STR);
            }
        } else {
            onFailWithCode(HttpUtils.RESPONSE_NULL,
                    HttpUtils.RESPONSE_NULL, HttpUtils.RESPONSE_NULL_STR);
        }
    }

    protected abstract void onSuccessParsedFirst(int code, String data);

    @Override
    public void onFailure(int errorNo, String strMsg) {
        super.onFailure(errorNo, strMsg);
        onFailWithCode(errorNo, errorNo, strMsg);
    }

    protected void onFailWithCode(int code, int errorNo, String strMsg) {
        super.onFailure(errorNo, strMsg);
        LogUtil.e(TAG, "errorNo:" + errorNo + ",strMsg:" + strMsg);
        if (loadingDialog != null && loadingDialog.isShowing()) loadingDialog.dismiss();
        if (errorView != null) {
            switch (errorNo) {
                case -1:
//                    errorView.setLoadingImg(R.drawable.icon_no_network);
                    errorView.setLoadingText("别嚎啦，一会儿网就来...", "请检查网络后点击重新加载...");
                    break;
                case HttpUtils.RESPONSE_NULL:
//                    errorView.setLoadingImg(R.drawable.ico_fb_nodata);
                    errorView.setLoadingText("暂无数据", null);
                    break;
                case HttpUtils.RESPONSE_ERROR:
//                    errorView.setLoadingImg(R.drawable.icon_no_permission);
                    errorView.setLoadingText("暂无权限查看他人数据", "请重新选择筛选条件哦");
                    break;
                default:
//                    errorView.setLoadingImg(R.drawable.icon_who_me);
                    errorView.setLoadingText("木有找到任何数据呢", "快去看看别的吧~");
                    break;

            }

            errorView.setVisibility(View.VISIBLE);
        }
    }
}
