package com.internousdev.ecsite2.action;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite2.dao.BillCompleteDAO;
import com.internousdev.ecsite2.dao.CartListDeleteCompleteDAO;
import com.internousdev.ecsite2.dto.BillCompleteDTO;
import com.opensymphony.xwork2.ActionSupport;

public class BillCompleteAction extends ActionSupport implements SessionAware {
	public Map<String,Object> session;
	private String pay;
	private List<BillCompleteDTO> billCompleteDTO;
	private BillCompleteDAO billCompleteDAO = new BillCompleteDAO();

	public String execute() throws SQLException{
		CartListDeleteCompleteDAO dao = new CartListDeleteCompleteDAO();
		String user_master_id = session.get("login_user_id").toString();
		billCompleteDTO = billCompleteDAO.getBillListInfo(user_master_id);
		dao.cartListDelete(user_master_id);

		String payment;
		if(pay.equals("1")){
			payment = "現金払い";
			session.put("pay",payment);
		}else{
			payment = "クレジットカード";
			session.put("pay",payment);
		}

		for(BillCompleteDTO dto:billCompleteDTO) {
			billCompleteDAO.buyItemInfo(
					dto.getItemTransactionId(),
					dto.getTotalPrice(),
					dto.getTotalCount(),
					dto.getUserMasterId(),
					session.get("pay").toString()
					);
		}


		dao.cartListDelete(user_master_id);

		String result = SUCCESS;
		return result;
	}


	public void setPay(String pay){
		this.pay = pay;
	}
	public void setSession(Map<String,Object> session){
		this.session = session;
	}
	public List<BillCompleteDTO> getBillCompleteDTO(){
		return this.billCompleteDTO;
	}

}


//package com.internousdev.ecsite2.action;
//
//import java.sql.SQLException;
//import java.util.List;
//import java.util.Map;
//
//import org.apache.struts2.interceptor.SessionAware;
//
//import com.internousdev.ecsite2.dao.BillCompleteDAO;
//import com.internousdev.ecsite2.dto.BillCompleteDTO;
//import com.opensymphony.xwork2.ActionSupport;
//
//public class BillCompleteAction extends ActionSupport implements SessionAware {
//	public Map<String,Object> session;
//	private String pay;
//	private List<BillCompleteDTO> billCompleteDTO;
//	private BillCompleteDAO billCompleteDAO = new BillCompleteDAO();
//
//	public String execute() throws SQLException{
//		String user_master_id = session.get("login_user_id").toString();
//		billCompleteDTO = billCompleteDAO.getBillListInfo(user_master_id);
//
//		String payment;
//		if(pay.equals("1")){
//			payment = "現金払い";
//			session.put("pay",payment);
//		}else{
//			payment = "クレジットカード";
//			session.put("pay",payment);
//		}
//
//		for(BillCompleteDTO dto:billCompleteDTO) {
//			billCompleteDAO.buyItemInfo(
//					dto.getItemTransactionId(),
//					dto.getTotalPrice(),
//					dto.getTotalPrice(),
//					dto.getUserMasterId(),
//					session.get("pay").toString()
//					);
//		}
//		String result = SUCCESS;
//		return result;
//	}
//
//
//	public void setPay(String pay){
//		this.pay = pay;
//	}
//	public void setSession(Map<String,Object> session){
//		this.session = session;
//	}
//	public List<BillCompleteDTO> getBillCompleteDTO(){
//		return this.billCompleteDTO;
//	}
//
//}
