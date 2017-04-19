package com.fyh.aramis.crash;

import java.io.Serializable;

/**
 * CrashBean
 * Created by Aramis on 2017/3/21.
 */

public class CrashBean implements Serializable {
    public static String STR_versionCode = "versionCode";
    public static String STR_versionName = "versionName";
    public static String STR_type = "type";
    public static String STR_model = "model";
    public static String STR_time = "time";
    public static String STR_brand = "brand";
    public static String STR_cpu_abi = "cpu_abi";
    public static String STR_exception = "exception";
    public static String STR_fileName = "fileName";
    private String versionCode;
    private String versionName;
    private String type;
    private String model;
    private String time;
    private String brand;
    private String cpu_abi;
    private String exception;
    private String fileName;

    public CrashBean() {

    }

    public CrashBean(String versionCode, String versionName, String type, String model,
                     String time, String brand, String cpu_abi, String exception, String fileName) {
        this.versionCode = versionCode;
        this.versionName = versionName;
        this.type = type;
        this.model = model;
        this.time = time;
        this.brand = brand;
        this.cpu_abi = cpu_abi;
        this.exception = exception;
        this.fileName = fileName;
    }

    public String getVersionCode() {
        return versionCode;
    }

    public void setVersionCode(String versionCode) {
        this.versionCode = versionCode;
    }

    public String getVersionName() {
        return versionName;
    }

    public void setVersionName(String versionName) {
        this.versionName = versionName;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getCpu_abi() {
        return cpu_abi;
    }

    public void setCpu_abi(String cpu_abi) {
        this.cpu_abi = cpu_abi;
    }

    public String getException() {
        return exception;
    }

    public void setException(String exception) {
        this.exception = exception;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public String toString() {
        return "CrashBean{" +
                "versionCode='" + versionCode + '\'' +
                ", versionName='" + versionName + '\'' +
                ", type='" + type + '\'' +
                ", model='" + model + '\'' +
                ", time='" + time + '\'' +
                ", brand='" + brand + '\'' +
                ", cpu_abi='" + cpu_abi + '\'' +
                ", exception='" + exception + '\'' +
                ", fileName='" + fileName + '\'' +
                '}';
    }
}
