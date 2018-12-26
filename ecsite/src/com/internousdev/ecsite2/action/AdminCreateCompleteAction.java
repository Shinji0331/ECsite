package com.internousdev.ecsite2.action;

import java.sql.SQLException;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite2.dao.AdminCreateCompleteDAO;
import com.opensymphony.xwork2.ActionSupport;


public class AdminCreateCompleteAction extends ActionSupport implements SessionAware {
	private String createAdminId;
	private String createAdminPass;
	private String createAdminName;
	public Map<String,Object> session;
	private AdminCreateCompleteDAO accDAO = new AdminCreateCompleteDAO();

	public String execute()throws SQLException{
		accDAO.adminInfo(
				session.get("createAdminId").toString(),
				session.get("createAdminPass").toString(),
				session.get("createAdminName").toString(),
				session.get("adminFlg").toString()
				);
		String result = SUCCESS;
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

}
