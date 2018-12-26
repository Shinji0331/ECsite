package com.internousdev.ecsite2.action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite2.dao.BuyItemDAO;
import com.internousdev.ecsite2.dao.CartDAO;
import com.internousdev.ecsite2.dto.BuyItemDTO;
import com.opensymphony.xwork2.ActionSupport;

public class CartAction extends ActionSupport implements SessionAware {
	public Map<String,Object> session;
	private int itemId;
	private String itemName;
	private String itemPrice;
	private int count;
	private CartDAO cartDAO = new CartDAO();
	public List<BuyItemDTO> buyItemDTO = new ArrayList<BuyItemDTO>();
	BuyItemDAO buyItemDAO = new BuyItemDAO();

	public String execute()throws SQLException {


		session.put("itemId", itemId);
		session.put("buyItem_name", itemName);
		session.put("buyItem_price", itemPrice);
		session.put("count", count);
		int intCount = Integer.parseInt(session.get("count").toString());
		int intPrice = Integer.parseInt(session.get("buyItem_price").toString());
		session.put("total_price",intCount*intPrice);

		if(!(session.containsKey("login_user_id"))) {
			cartDAO.cartItemInfo(
					session.get("itemId").toString(),
					session.get("buyItem_name").toString(),
					session.get("total_price").toString(),
					session.get("count").toString(),
					session.get("tempUserId").toString()
					);
		}else {
			cartDAO.cartItemInfo(
					session.get("itemId").toString(),
					session.get("buyItem_name").toString(),
					session.get("total_price").toString(),
					session.get("count").toString(),
					session.get("login_user_id").toString()
					);
		}


		buyItemDTO = buyItemDAO.getBuyItemInfo();

		String result = SUCCESS;
		return result;

	}

	public void setItemId(int itemId){
		this.itemId = itemId;
	}
	public void setItemName(String itemName){
		this.itemName = itemName;
	}
	public void setItemPrice(String itemPrice){
		this.itemPrice = itemPrice;
	}
	public void setCount(int count){
		this.count = count;
	}
	public void setSession(Map<String,Object> session){
		this.session = session;
	}

}
