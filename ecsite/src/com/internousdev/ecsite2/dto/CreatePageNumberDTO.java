package com.internousdev.ecsite2.dto;

import java.util.List;

public class CreatePageNumberDTO {
	private int totalPageSize;//全ページ数
	private int nowPageNo;// 現在のページ数
	private int startItemListNo;// 開始レコード番号
	private int endItemListNo;// 終了レコード番号
	private List<BuyItemDTO> nowPageIteminfo;// １ページ分のリストページ情報（商品情報）

	public int getTotalPageSize() {
		return totalPageSize;
	}
	public void setTotalPageSize(int totalPageSize) {
		this.totalPageSize = totalPageSize;
	}
	public int getNowPageNo() {
		return nowPageNo;
	}
	public void setNowPageNo(int nowPageNo) {
		this.nowPageNo = nowPageNo;
	}
	public int getStartItemListNo() {
		return startItemListNo;
	}
	public void setStartItemListNo(int startItemListNo) {
		this.startItemListNo = startItemListNo;
	}
	public int getEndItemListNo() {
		return endItemListNo;
	}
	public void setEndItemListNo(int endItemListNo) {
		this.endItemListNo = endItemListNo;
	}
	public List<BuyItemDTO> getNowPageIteminfo() {
		return nowPageIteminfo;
	}
	public void setNowPageIteminfo(List<BuyItemDTO> nowPageIteminfo) {
		this.nowPageIteminfo = nowPageIteminfo;
	}
}
