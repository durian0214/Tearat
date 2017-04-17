package com.tearat.home.bean;

import com.google.gson.annotations.SerializedName;

import java.util.logging.SimpleFormatter;

/**
 * Durian
 * 2017-2017/4/17
 */

public class HomeItemBean extends SimpleFormatter{
    @SerializedName("n")
    private String name;
    private String detail;
    private float price;
    private String url;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
