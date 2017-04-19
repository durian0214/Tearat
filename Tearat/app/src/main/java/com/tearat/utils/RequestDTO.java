package com.fyh.utils;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;



public class RequestDTO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String reqSn;
	private String token;
	private Map<String,Object> data = new HashMap<String,Object>();
	
	
	public RequestDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getReqSn() {
		return reqSn;
	}
	public void setReqSn(String reqSn) {
		this.reqSn = reqSn;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public Map<String, Object> getData() {
		return data;
	}
	public void setData(Map<String, Object> data) {
		this.data = data;
	}

}
