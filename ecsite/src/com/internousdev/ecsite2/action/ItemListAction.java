package com.internousdev.ecsite2.action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite2.dao.ItemListDAO;
import com.internousdev.ecsite2.dto.ItemListDTO;
import com.opensymphony.xwork2.ActionSupport;

public class ItemListAction extends ActionSupport implements SessionAware {
	public Map<String,Object> session;
	private String deleteFlg;
	private String message;
	private ArrayList<ItemListDTO> itemListDTO = new ArrayList<ItemListDTO>();
	private ItemListDAO itemListDAO = new ItemListDAO();

	public String execute()throws SQLException{
		if(deleteFlg == null) {
			itemListDTO = itemListDAO.getItemListInfo();
		}
		String result = SUCCESS;
		return result;
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
	public String getMessage() {
		return this.message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public ArrayList<ItemListDTO> getItemListDTO(){
		return this.itemListDTO;
	}


}
