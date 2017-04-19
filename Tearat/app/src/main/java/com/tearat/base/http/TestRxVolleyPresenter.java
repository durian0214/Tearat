package com.fyh.aramis.http;

import android.content.Context;

import com.alibaba.fastjson.JSON;
import com.fyh.aramis.AramisUtils;
import com.fyh.aramis.http.interfaces.DefaultHttpListener;
import com.fyh.listen.StringListener;
import com.fyh.base.BasePresenter;
import com.fyh.utils.LogUtil;
import com.fyh.utils.OkHttpUtil;
import com.fyh.utils.RequestDTO;
import com.kymjs.rxvolley.RxVolley;
import com.kymjs.rxvolley.client.HttpCallback;
import com.kymjs.rxvolley.client.HttpParams;
import com.kymjs.rxvolley.client.JsonRequest;
import com.kymjs.rxvolley.client.RequestConfig;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import okhttp3.Request;

/**
 * Created by ASUS on 2017/3/1.
 */

public class TestRxVolleyPresenter extends BasePresenter<TestRxVolleyView> {
    public TestRxVolleyPresenter(TestRxVolleyView volleyView) {
        attachView(volleyView);
        this.context = context;
    }

    private Context context;

    //使用RxVollty post
    public void onRequestButtonClick(String url, Map<String, Object> params) {
        HttpCallback httpCallback = new HttpCallback() {
            @Override
            public void onSuccess(String t) {
                super.onSuccess(t);
                LogUtil.e(AramisUtils.TAG(), "http success:"+t);
                myView.onRequestButtonClick(t);
            }

            @Override
            public void onFailure(int errorNo, String strMsg) {
                super.onFailure(errorNo, strMsg);
                LogUtil.e(AramisUtils.TAG(), "http fail errorNo:" + errorNo + ",strMsg:" + strMsg);
                myView.onRequestButtonClick("errorNo:" + errorNo + ",strMsg:" + strMsg);
            }
        };
        DefaultHttpListener defaultHttpListener=new DefaultHttpListener() {
            @Override
            protected void onSuccessParsedFirst(int code, String data) {

            }
        };
//        HttpUtils.jsonPost(url, params,httpCallback);
//        RxVolley.post(url, httpParams, httpCallback);
//        JSONObject obj = new JSONObject();
        RequestDTO d =new RequestDTO();
        d.setReqSn("");
        d.setToken("");
        d.setData(params);
        RequestConfig requestConfig = new RequestConfig();
        requestConfig.mUrl = url;
        requestConfig.mMethod = RxVolley.Method.POST;
        requestConfig.mEncoding = "UTF-8";
        HttpParams baseHttpParams = HttpUtils.getInstance().getBaseHttpParams();
        baseHttpParams.putJsonParams( JSON.toJSONString(d));
        JsonRequest jsonRequest = new JsonRequest(requestConfig, baseHttpParams, httpCallback);

        RxVolley.getRequestQueue().add(jsonRequest);

//        RxVolley.Builder builder = new RxVolley.Builder();
//        builder.url(url).httpMethod(RxVolley.Method.POST).contentType(RxVolley.ContentType.JSON).params(baseHttpParams)
//                .callback(httpCallback).doTask();
    }

    //使用RxVolley get
    public void onRequestGet(String url) {
        RxVolley.get(url, new HttpCallback() {
            @Override
            public void onSuccess(String t) {
                super.onSuccess(t);
                LogUtil.e(AramisUtils.TAG(), "http success");
                myView.clickButtonGet(t);
            }

            @Override
            public void onFailure(int errorNo, String strMsg) {
                super.onFailure(errorNo, strMsg);
                LogUtil.e(AramisUtils.TAG(), "http fail errorNo:" + errorNo + ",strMsg:" + strMsg);
                myView.clickButtonGet("errorNo:" + errorNo + ",strMsg:" + strMsg);
            }
        });
    }

    //使用okhttp
    public void onRequestOkHttp(String url) {
        OkHttpUtil.getIntance().postHttp(url, null, new StringListener() {
            @Override
            public void onSusseccData(String msg) {
                myView.clickButtonOkHttp(msg);
            }

            @Override
            public void onError(Request request, IOException e) {
                myView.clickButtonOkHttp("error");
            }
        });
    }


}
