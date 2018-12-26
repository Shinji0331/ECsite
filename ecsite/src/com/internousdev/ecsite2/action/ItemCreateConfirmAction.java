package com.internousdev.ecsite2.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

public class ItemCreateConfirmAction extends ActionSupport implements SessionAware {
	private String createItemName;
	private String createItemPrice;
	private String createItemStock;
	public Map<String,Object> session;
	private String errorMessage;

	public String execute(){
		String result = SUCCESS;

		if(!(createItemName.equals(""))&&!(createItemStock.equals(""))&&!(createItemStock.equals(""))){
			session.put("createItemName", createItemName);
			session.put("createItemPrice", createItemPrice);
			session.put("createItemStock", createItemStock);
		}else{
			setErrorMessage("未入力の項目があります");
			result = ERROR;
		}
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
	public String getErrorMessage(){
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage){
		this.errorMessage = errorMessage;
	}

}
