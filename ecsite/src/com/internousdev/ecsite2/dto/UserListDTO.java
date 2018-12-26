package com.internousdev.ecsite2.dto;

public class UserListDTO {
	private String id;
	private String loginId;
	private String loginPass;
	private String userName;
	private String insertDate;

	public String getId() {
		return this.id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getLoginId() {
		return this.loginId;
	}
	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}
	public String getLoginPass() {
		return this.loginPass;
	}
	public void setLoginPass(String loginPass) {
		this.loginPass = loginPass;
	}
	public String getUserName() {
		return this.userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getInsertDate() {
		return this.insertDate;
	}
	public void setInsertDate(String insertDate) {
		this.insertDate = insertDate;
	}


}
