package com.internousdev.ecsite2.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.internousdev.ecsite2.dto.CartListDTO;
import com.internousdev.ecsite2.util.DBConnector;


public class CartListDAO {
	private DBConnector db = new DBConnector();
	private Connection con = db.getConnection();

	public List<CartListDTO> getCartListInfo(String user_master_id)throws SQLException{
		List<CartListDTO> cartListDTO = new ArrayList<CartListDTO>();
		String sql = " select bt.item_name,bt.total_price,bt.total_count,bt.insert_date,lut.user_name "
				+ "from basket_transaction bt "
				+ "left join login_user_transaction lut "
				+ "on bt.user_master_id = lut.login_id "
				+ "where bt.user_master_id = ?";

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, user_master_id);
			ResultSet rs = ps.executeQuery();

			while(rs.next()) {
				CartListDTO dto = new CartListDTO();
				dto.setItemName(rs.getString("item_name"));
				dto.setTotalPrice(rs.getString("total_price"));
				dto.setTotalCount(rs.getString("total_count"));
				dto.setInsertDate(rs.getString("insert_date"));
				dto.setUserName(rs.getString("user_name"));
				cartListDTO.add(dto);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			con.close();
		}
		return cartListDTO;

	}

	public int updateUserMasterId(String login_user_id,String tempUserId) throws SQLException {
		String sql = "update basket_transaction set user_master_id = ? where user_master_id = ?";
		int count = 0;
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, login_user_id);
			ps.setString(2, tempUserId);
			count = ps.executeUpdate();
		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			con.close();
		}
		return count;
	}

}
