package com.internousdev.ecsite2.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

public class AdminCreateConfirmAction extends ActionSupport implements SessionAware {
	private String createAdminId;
	private String createAdminPass;
	private String createAdminName;
	public Map<String,Object> session;
	private String errorMessage;

	public String execute() {
		String result = SUCCESS;

		if(!(createAdminId.equals(""))&&!(createAdminPass.equals(""))&&!(createAdminName.equals(""))) {
			session.put("createAdminId", createAdminId);
			session.put("createAdminPass", createAdminPass);
			session.put("createAdminName", createAdminName);
			session.put("adminFlg", "1");
		}else {
			setErrorMessage("未入力の項目があります。");
			result = ERROR;
		}
		return result;
	}

	public String getCreateAdminId() {
		return this.createAdminId;
	}
	public void setCreateAdminId(String createAdminId) {
		this.createAdminId = createAdminId;
	}
	public String getCreateAdminPass() {
		return this.createAdminPass;
	}
	public void setCreateAdminPass(String createAdminPass) {
		this.createAdminPass = createAdminPass;
	}
	public String getCreateAdminName() {
		return this.createAdminName;
	}
	public void setCreateAdminName(String createAdminName) {
		this.createAdminName = createAdminName;
	}
	public void setSession(Map<String,Object> session) {
		this.session = session;
	}
	public String getErrorMessage() {
		return this.errorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}



}
