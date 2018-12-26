package com.internousdev.ecsite2.action;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite2.dao.CartListDAO;
import com.internousdev.ecsite2.dao.LoginDAO;
import com.internousdev.ecsite2.dto.BuyItemDTO;
import com.internousdev.ecsite2.dto.LoginDTO;
import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport implements SessionAware {
	private String loginUserId;
	private String loginPassword;
	public Map<String,Object> session;
	public List<BuyItemDTO> buyItemDTOList = new ArrayList<BuyItemDTO>();

	private LoginDAO loginDAO = new LoginDAO();
	private LoginDTO loginDTO = new LoginDTO();
//	private BuyItemDAO buyItemDAO = new BuyItemDAO();

	public String execute()throws SQLException{
		CartListDAO cartListDAO = new CartListDAO();
		String result = ERROR;
		loginDTO = loginDAO.getLoginUserInfo(loginUserId,loginPassword);
		session.put("loginUser", loginDTO);

		//入力値からユーザー情報の検索をする
		//ログイン認証が成功した場合、次の画面で商品情報が必要なため商品情報を取得
		if(((LoginDTO)session.get("loginUser")).getLoginFlg()){
			result = SUCCESS;
//			buyItemDTOList = buyItemDAO.getBuyItemInfo();
//			session.put("buyItemDTOList", buyItemDTOList);
			session.put("login_user_id",loginDTO.getLoginId());
			String login_user_id = session.get("login_user_id").toString();
			String tempUserId = session.get("tempUserId").toString();
			int count = cartListDAO.updateUserMasterId(
					login_user_id,
					tempUserId);
			if(count > 0) {
				session.put("tempUserId", null);
			}
			if(((LoginDTO)session.get("loginUser")).getAdminFlg()) {
				session.put("adminId", loginDTO.getLoginId());
			}

			return result;
		}
		return result;
	}

	public String getLoginUserId(){
		return this.loginUserId;
	}
	public void setLoginUserId(String loginUserId){
		this.loginUserId = loginUserId;
	}
	public String getLoginPassword(){
		return this.loginPassword;
	}
	public void setLoginPassword(String loginPassword){
		this.loginPassword = loginPassword;
	}
	public void setSession(Map<String,Object> session){
		this.session = session;
	}

}
