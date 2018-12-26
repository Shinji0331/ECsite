package com.internousdev.ecsite2.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;


public class LogoutAction extends ActionSupport implements SessionAware {
	public Map<String,Object> session;
	public String execute(){
		session.clear();
		return SUCCESS;
	}

	public void setSession(Map<String,Object> session){
		this.session = session;
	}

}
