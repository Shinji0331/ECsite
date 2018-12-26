package com.internousdev.ecsite2.action;

import java.sql.SQLException;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite2.dao.CartListDeleteCompleteDAO;
import com.opensymphony.xwork2.ActionSupport;

public class CartListDeleteCompleteAction extends ActionSupport implements SessionAware {

	public Map<String,Object> session;

	public String execute()throws SQLException{
		CartListDeleteCompleteDAO dao = new CartListDeleteCompleteDAO();
		if(!(session.containsKey("login_user_id"))) {
			String user_master_id = session.get("tempUserId").toString();
			dao.cartListDelete(user_master_id);
		}else {
			String user_master_id = session.get("login_user_id").toString();
			dao.cartListDelete(user_master_id);
		}


		return SUCCESS;
	}

	public void setSession(Map<String,Object> session) {
		this.session = session;
	}



}
