package com.fyh.aramis.http;

import android.widget.TextView;

import com.fyh.R;
import com.fyh.base.BaseActivity;

/**
 * 测试rxVolley
 * Created by ASUS on 2017/3/1.
 */

public class TestRxVolleyActivity extends BaseActivity implements TestRxVolleyView {
    private TextView text_rxvolley, text_rxvolley2, text_rxvolley3, text_rxvolley4;
    private String url = "http://v.juhe.cn/toutiao/index?type=top&key=3da2c1265d8d3c7cdbbab830829b9bee";
    private TestRxVolleyPresenter presenter;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_rxvolley_test;
    }

    @Override
    public void initView() {
        presenter = new TestRxVolleyPresenter(this);
        text_rxvolley = (TextView) findViewById(R.id.text_rxvolley);
        text_rxvolley2 = (TextView) findViewById(R.id.text_rxvolley2);
        text_rxvolley3 = (TextView) findViewById(R.id.text_rxvolley3);
        text_rxvolley4 = (TextView) findViewById(R.id.text_rxvolley4);
    }

    @Override
    public void setOnclick() {
//        String ip = "http://139.129.192.157:8081/fyh-mobile";
////        String ip = "http://192.168.0.237:8080/fyh-mobile";
//        url = ip + "/api/room/findRecommendList";
//
//        findViewById(R.id.btn_rxvolley).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                LogUtil.e(AramisUtils.TAG(), "button1 click");
//                HttpParams baseHttpParams = HttpUtils.getBaseHttpParams();
////                baseHttpParams.put("token", "token");
//                presenter.onRequestButtonClick(url, baseHttpParams);
//            }
//        });
//        findViewById(R.id.btn_rxvolley2).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                LogUtil.e(AramisUtils.TAG(), "button2 click");
//                HttpParams baseHttpParams = HttpUtils.getBaseHttpParams();
//                presenter.onRequestGet(url);
//            }
//        });
//        findViewById(R.id.btn_rxvolley3).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                LogUtil.e(AramisUtils.TAG(), "button3 click");
//                HttpParams baseHttpParams = HttpUtils.getBaseHttpParams();
//                baseHttpParams.put("token", "token");
//                presenter.onRequestOkHttp(url);
//            }
//        });
//        findViewById(R.id.btn_rxvolley4).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                LogUtil.e(AramisUtils.TAG(), "button3 click");
//                HttpParams baseHttpParams = HttpUtils.getBaseHttpParams();
//                baseHttpParams.put("token", "token");
//                presenter.onRequestRetrofit(url);
//            }
//        });
    }

    @Override
    public <T extends BaseActivity> T getCurrentActivity() {
        return (T) this;
    }

    @Override
    public void onRequestButtonClick(String response) {
        text_rxvolley.setText(response);
    }

    @Override
    public void clickButtonGet(String response) {
        text_rxvolley2.setText(response);
    }

    @Override
    public void clickButtonOkHttp(String response) {
        text_rxvolley3.setText(response);
    }

    @Override
    public void clickButtonRetrofit(String response) {
        text_rxvolley4.setText(response);
    }
}
