package com.internousdev.ecsite2.action;

import java.sql.SQLException;

import com.internousdev.ecsite2.dao.UserListDeleteCompleteDAO;
import com.opensymphony.xwork2.ActionSupport;

public class UserListDeleteCompleteAction extends ActionSupport{
	private String message;


	public String execute()throws SQLException{
		UserListDeleteCompleteDAO dao = new UserListDeleteCompleteDAO();

		int rs = dao.userListDelete();
		if(rs >0) {
			setMessage("ユーザー情報を削除しました");
		}else if(rs == 0) {
			setMessage("ユーザー情報の削除に失敗しました");
		}
		return SUCCESS;
	}

	public String getMessage() {
		return this.message;
	}
	public void setMessage(String message) {
		this.message = message;
	}

}
