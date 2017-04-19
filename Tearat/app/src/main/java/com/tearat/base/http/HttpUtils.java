package com.fyh.aramis.http;

import com.alibaba.fastjson.JSON;
import com.fyh.aramis.http.interfaces.DefaultHttpListener;
import com.fyh.utils.RequestDTO;
import com.kymjs.rxvolley.client.HttpCallback;
import com.kymjs.rxvolley.client.HttpParams;
import com.kymjs.rxvolley.client.ProgressListener;

import java.io.File;
import java.util.Map;
import java.util.Set;

/**
 * http工具类，再封装一次，更换网络框架时比较方便
 * Created by ASUS on 2017/3/1.
 */

public class HttpUtils {
    private static volatile HttpUtils httpUtils;

    private HttpUtils() {
    }

    public static HttpUtils getInstance() {
        if (httpUtils == null) {
            synchronized (HttpUtils.class) {
                if (httpUtils == null) httpUtils = new HttpUtils();
            }
        }
        return httpUtils;
    }

    public static final int ERROR = 500;//未知错误
    public static final int NOT_FOUND = 404;//数据未找到
    public static final int HAS_FOUND = 405;//数据已经存在
    public static final int PASSWORD_ERROR = 501;//密码错误
    public static final int SUCCESS = 200;//成功
    public static final int TOKEN_EXPIRE = 300;//token过期
    public static final int TOKEN_HASUSED = 301;//token已经使用
    public static final int FAIL_VAILDATE = 502;//验证码错误
    public static final int REQUESTPARAM_BAD = 310;//传入参数不合规
    public static final int RESPONSE_NULL = 601;//返回数据为空
    public static final int RESPONSE_ERROR = 602;//请求错误

    public static final String RESPONSE_NULL_STR = "返回数据为空", RESPONSE_ERROR_STR = "请求错误";

    public HttpParams getBaseHttpParams() {
        HttpParams httpParams = new HttpParams();
        return httpParams;
    }

    public String getRequestDTOJson(String token, String reqSn, Map<String, Object> data) {
        RequestDTO requestDTO = new RequestDTO();
        requestDTO.setToken(token);
        requestDTO.setReqSn(reqSn);
        requestDTO.setData(data);
        return JSON.toJSONString(requestDTO);
    }

    public void jsonPost(String url, Map<String, Object> data, HttpCallback defaultHttpListener) {
        HttpParams baseHttpParams = httpUtils.getBaseHttpParams();
        baseHttpParams.putJsonParams(httpUtils.getRequestDTOJson(null, null, data));
        ArRxVolley.jsonPost(url, baseHttpParams, defaultHttpListener);
    }

    private void post(String url, HttpParams params, ProgressListener listener,
                      HttpCallback defaultHttpListener) {
        ArRxVolley.post(url, params, listener, defaultHttpListener);
    }

    private void uploadFile(String url, String filePath, Map<String, String> params, ProgressListener listener,
                            DefaultHttpListener defaultHttpListener) {
        HttpParams baseHttpParams = httpUtils.getBaseHttpParams();
        baseHttpParams.put("file", new File(filePath));
        Set<String> strings = params.keySet();
        for (String next : strings) {
            baseHttpParams.put(next, params.get(next));
        }
        post(url, baseHttpParams, listener, defaultHttpListener);
    }

    private void download(String storeFilePath, String url,
                          ProgressListener progressListener, DefaultHttpListener defaultHttpListener) {
        ArRxVolley.download(storeFilePath, url, progressListener, defaultHttpListener);
    }

}
