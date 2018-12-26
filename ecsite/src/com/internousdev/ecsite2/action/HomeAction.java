package com.internousdev.ecsite2.action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite2.dao.BuyItemDAO;
import com.internousdev.ecsite2.dto.BuyItemDTO;
import com.internousdev.ecsite2.dto.CreatePageNumberDTO;
import com.internousdev.ecsite2.util.CreatePageNumber;
import com.internousdev.ecsite2.util.RamdomValue;
import com.opensymphony.xwork2.ActionSupport;

public class HomeAction extends ActionSupport implements SessionAware {
	public Map<String,Object> session;
	public List<BuyItemDTO> buyItemDTOList = new ArrayList<BuyItemDTO>();
	private int pageNo = 0;
	BuyItemDAO buyItemDAO = new BuyItemDAO();
	RamdomValue ramdomValue = new RamdomValue();

	public String execute()throws SQLException{
		buyItemDTOList = buyItemDAO.getBuyItemInfo();
		session.put("buyItemDTOList", buyItemDTOList);

		if(!(session.containsKey("tempUserId"))) {
			String tempUserId = ramdomValue.getRamdomValue();
			session.put("tempUserId", tempUserId);
		}

		CreatePageNumber createPageNumber = new CreatePageNumber();
		CreatePageNumberDTO createPageNumberDTO = new CreatePageNumberDTO();
		if(pageNo == 0) {
			createPageNumberDTO = createPageNumber.getPage(buyItemDTOList, 9,1);
		}else {
			createPageNumberDTO = createPageNumber.getPage(buyItemDTOList, 9,pageNo);
		}

		session.put("totalPageSize", createPageNumberDTO.getTotalPageSize());
		session.put("nowPageNo", createPageNumberDTO.getNowPageNo());
		session.put("nowPageIteminfo",createPageNumberDTO.getNowPageIteminfo());

		String result = SUCCESS;
		return result;
	}

	public void setSession(Map<String,Object> session){
		this.session = session;
	}
	public Map<String,Object> getSession(){
		return this.session;
	}
	public int getPageNo() {
		return pageNo;
	}
	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}
}
