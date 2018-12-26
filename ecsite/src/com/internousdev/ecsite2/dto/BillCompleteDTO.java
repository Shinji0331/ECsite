package com.internousdev.ecsite2.dto;

public class BillCompleteDTO {
	private String itemTransactionId;
	private String totalPrice;
	private String totalCount;
	private String userMasterId;
	private String insertDate;
	private String itemStock;

	public String getItemTransactionId() {
		return this.itemTransactionId;
	}
	public void setItemTransactionId(String itemTransactionId) {
		this.itemTransactionId = itemTransactionId;
	}
	public String getTotalPrice() {
		return this.totalPrice;
	}
	public void setTotalPrice(String totalPrice) {
		this.totalPrice = totalPrice;
	}
	public String getTotalCount() {
		return this.totalCount;
	}
	public void setTotalCount(String totalCount) {
		this.totalCount = totalCount;
	}
	public String getUserMasterId() {
		return this.userMasterId;
	}
	public void setUserMasterId(String userMasterId) {
		this.userMasterId = userMasterId;
	}
	public String getInsertDate() {
		return this.insertDate;
	}
	public void setInsertDate(String insertDate) {
		this.insertDate = insertDate;
	}
	public String getItemStock() {
		return this.itemStock;
	}
	public void setItemStock(String itemStock) {
		this.itemStock = itemStock;
	}


}
