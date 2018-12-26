package com.internousdev.ecsite2.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.internousdev.ecsite2.dto.CartDTO;
import com.internousdev.ecsite2.util.DBConnector;
import com.internousdev.ecsite2.util.DateUtil;


public class CartDAO {
	private DBConnector db = new DBConnector();
	private DateUtil dateUtil = new DateUtil();
	CartDTO dto = new CartDTO();


	public void cartItemInfo(String item_transaction_id,String item_name,String total_price,String total_count,String user_master_id) throws SQLException{
		Connection con = db.getConnection();
		String sql = "insert into basket_transaction(item_transaction_id,item_name,total_price,total_count,user_master_id,insert_date)values(?,?,?,?,?,?)";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, item_transaction_id);
			ps.setString(2, item_name);
			ps.setString(3, total_price);
			ps.setString(4, total_count);
			ps.setString(5, user_master_id);
			ps.setString(6, dateUtil.getDate());
			ps.execute();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			con.close();
		}

	}

	public CartDTO stockCheck()throws SQLException {
		Connection con = db.getConnection();
		String sql = "select item_stock from item_info_transaction";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			dto.setItemStock(rs.getInt("item_stock"));
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			con.close();
		}
		return dto;
	}



}
