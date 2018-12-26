package com.internousdev.ecsite2.action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite2.dao.ItemDetailDAO;
import com.internousdev.ecsite2.dto.ItemDetailDTO;
import com.opensymphony.xwork2.ActionSupport;

public class ItemDetailAction extends ActionSupport implements SessionAware {
	private Map<String,Object> session;
	private int itemId;
	ItemDetailDAO itemDetailDAO = new ItemDetailDAO();
	public List<ItemDetailDTO> itemDetailDTO = new ArrayList<ItemDetailDTO>();


	public String execute() throws SQLException {
		session.put("itemDetailId", itemId);
		itemDetailDTO = itemDetailDAO.getItemDetail(session.get("itemDetailId").toString());
		session.put("itemDetailDTO", itemDetailDTO);

//		session.put("itemId", buyItemDTO.getItemId());
//		session.put("itemName", buyItemDTO.getItemName());
//		session.put("itemNameKana",buyItemDTO.getItemNameKana());
//		session.put("itemDescription", buyItemDTO.getItemDescription());
//		session.put("categoryId", buyItemDTO.getCategoryId());
//		session.put("itemPrice", buyItemDTO.getItemPrice());
//		session.put("imageFilePath", buyItemDTO.getImageFilePath());
//		session.put("imageFileName", buyItemDTO.getImageFileName());
//		session.put("releaseDate", buyItemDTO.getReleaseDate());
//		session.put("releaseCompany", buyItemDTO.getReleaseCompany());
//		session.put("itemStock", buyItemDTO.getItemStock());
//		session.put("insertDate", buyItemDTO.getInsertDate());
//		session.put("updateDate", buyItemDTO.getUpdateDate());
		String result = SUCCESS;
		return result;
	}


	public int getItemId() {
		return itemId;
	}
	public void setItemId(int itemId) {
		this.itemId = itemId;
	}
	public void setSession(Map<String,Object> session){
		this.session = session;
	}
	public Map<String,Object> getSession(){
		return this.session;
	}
}
