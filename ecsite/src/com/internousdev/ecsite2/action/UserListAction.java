package com.internousdev.ecsite2.action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite2.dao.UserListDAO;
import com.internousdev.ecsite2.dto.UserListDTO;
import com.opensymphony.xwork2.ActionSupport;


public class UserListAction extends ActionSupport implements SessionAware {
	public Map<String,Object> session;
	private String deleteFlg;
	private ArrayList<UserListDTO> userListDTO = new ArrayList<UserListDTO>();
	private UserListDAO userListDAO = new UserListDAO();

	public String execute()throws SQLException{
		if(deleteFlg == null) {
			userListDTO = userListDAO.getUserListInfo();
		}
		String result = SUCCESS;
		return result;
	}


	public Map<String,Object> getSession() {
		return this.session;
	}
	public void setSession(Map<String,Object> session) {
		this.session = session;
	}
	public String getDeleteFlg() {
		return this.deleteFlg;
	}
	public void setDeleteFlg(String deleteFlg) {
		this.deleteFlg = deleteFlg;
	}
	public ArrayList<UserListDTO> getUserListDTO(){
		return this.userListDTO;
	}
	public void setUserListDTO(ArrayList<UserListDTO> userListDTO) {
		this.userListDTO = userListDTO;
	}

}
