package com.internousdev.ecsite2.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.internousdev.ecsite2.util.DBConnector;

public class CartListDeleteCompleteDAO {
	private DBConnector db = new DBConnector();
	private Connection con = db.getConnection();

	public int cartListDelete(String user_master_id)throws SQLException{
		String sql = "delete from basket_transaction where user_master_id = ?";
		int result = 0;
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, user_master_id);
			result = ps.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			con.close();
		}
		return result;
	}

//	public int cartListDelete(String user_master_id)throws SQLException{
//		String sql = "delete from basket_transaction where user_master_id = ?";
//		int result = 0;
//		try {
//			PreparedStatement ps = con.prepareStatement(sql);
//			ps.setString(1, user_master_id);
//			result = ps.executeUpdate();
//		}catch(SQLException e) {
//			e.printStackTrace();
//		}finally {
//			con.close();
//		}
//		return result;
//	}

}
