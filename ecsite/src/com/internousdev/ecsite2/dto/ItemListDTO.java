package com.internousdev.ecsite2.dto;

public class ItemListDTO {
	private String id;
	private String itemName;
	private String itemPrice;
	private String itemStock;
	private String insertDate;
	private String userMasterId;
	private String itemCount;

	public String getId() {
		return this.id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getItemName() {
		return this.itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public String getItemPrice() {
		return this.itemPrice;
	}
	public void setItemPrice(String itemPrice) {
		this.itemPrice = itemPrice;
	}
	public String getItemStock() {
		return this.itemStock;
	}
	public void setItemStock(String itemStock) {
		this.itemStock = itemStock;
	}
	public String getInsertDate() {
		return this.insertDate;
	}
	public void setInsertDate(String insertDate) {
		this.insertDate = insertDate;
	}
	public String getUserMasterId() {
		return this.userMasterId;
	}
	public void setUserMasterId(String userMasterId) {
		this.userMasterId = userMasterId;
	}
	public String getItemCount() {
		return this.itemCount;
	}
	public void setItemCount(String itemCount) {
		this.itemCount = itemCount;
	}

}
