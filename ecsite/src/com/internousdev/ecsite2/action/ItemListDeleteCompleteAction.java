package com.internousdev.ecsite2.action;

import java.sql.SQLException;

import com.internousdev.ecsite2.dao.ItemListDeleteCompleteDAO;
import com.opensymphony.xwork2.ActionSupport;

public class ItemListDeleteCompleteAction extends ActionSupport{

	public String execute()throws SQLException{
		ItemListDeleteCompleteDAO dao = new ItemListDeleteCompleteDAO();

		dao.itemListDelete();
		return SUCCESS;
	}


}