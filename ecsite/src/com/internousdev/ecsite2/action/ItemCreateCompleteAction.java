package com.internousdev.ecsite2.action;

import java.sql.SQLException;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite2.dao.ItemCreateCompleteDAO;
import com.opensymphony.xwork2.ActionSupport;

public class ItemCreateCompleteAction extends ActionSupport implements SessionAware {
	private String createItemName;
	private String createItemPrice;
	private String createItemStock;
	public Map<String,Object> session;
	private ItemCreateCompleteDAO itemCreateCompleteDAO = new ItemCreateCompleteDAO();

	public String execute()throws SQLException{
		itemCreateCompleteDAO.itemCreate(
				session.get("createItemName").toString(),
				session.get("createItemPrice").toString(),
				session.get("createItemStock").toString()
				);
		String result = SUCCESS;
		return result;
	}

	public String getCreateItemName(){
		return this.createItemName;
	}
	public void setCreateItemName(String createItemName){
		this.createItemName = createItemName;
	}
	public String getCreateItemPrice(){
		return this.createItemPrice;
	}
	public void setCreateItemPrice(String createItemPrice){
		this.createItemPrice = createItemPrice;
	}
	public String getCreateItemStock(){
		return this.createItemStock;
	}
	public void setCreateItemStock(String createItemStock){
		this.createItemStock = createItemStock;
	}
	public void setSession(Map<String,Object> session){
		this.session = session;
	}



}
