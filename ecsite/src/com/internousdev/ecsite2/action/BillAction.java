package com.internousdev.ecsite2.action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite2.dao.CartListDAO;
import com.internousdev.ecsite2.dto.CartListDTO;
import com.opensymphony.xwork2.ActionSupport;

public class BillAction extends ActionSupport implements SessionAware {
	public Map<String,Object> session;

	private String message;
	private List<CartListDTO> cartListDTO = new ArrayList<CartListDTO>();
	private CartListDAO cartListDAO = new CartListDAO();

	public String execute()throws SQLException{
		if(!(session.containsKey("login_user_id"))) {
			String result = "login";
			return result;
		}else {
			String user_master_id = session.get("login_user_id").toString();
			cartListDTO = cartListDAO.getCartListInfo(user_master_id);

			String result = SUCCESS;
			return result;
		}

	}

	public void setSession(Map<String,Object> session) {
		this.session = session;
	}
	public String getMessage() {
		return this.message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public List<CartListDTO> getCartListDTO(){
		return this.cartListDTO;
	}


}
