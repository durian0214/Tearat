package com.fyh.aramis.custom;

import java.io.Serializable;

/**
 * 根bean
 * Created by ASUS on 2017/3/2.
 */

public class BaseBean implements Serializable{
    private String timestamp;
    private String results;
    private String msg;
    private int status;

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getResults() {
        return results;
    }

    public void setResults(String results) {
        this.results = results;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
