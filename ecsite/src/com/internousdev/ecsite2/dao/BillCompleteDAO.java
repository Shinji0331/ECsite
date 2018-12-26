package com.internousdev.ecsite2.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.internousdev.ecsite2.dto.BillCompleteDTO;
import com.internousdev.ecsite2.util.DBConnector;
import com.internousdev.ecsite2.util.DateUtil;


public class BillCompleteDAO {
	private DBConnector db = new DBConnector();
	private Connection con = db.getConnection();
	private DateUtil dateUtil = new DateUtil();

	public List<BillCompleteDTO> getBillListInfo(String user_master_id)throws SQLException{
		List<BillCompleteDTO> billCompleteDTO = new ArrayList<BillCompleteDTO>();
		String sql = "select bt.item_transaction_id,bt.total_price,bt.total_count,bt.user_master_id,bt.insert_date "
				+ "from basket_transaction bt "
				+ "left join login_user_transaction lut "
				+ "on bt.user_master_id = lut.login_id "
				+ "where bt.user_master_id = ?";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, user_master_id);
			ResultSet rs = ps.executeQuery();

			while(rs.next()) {
				BillCompleteDTO dto = new BillCompleteDTO();
				dto.setItemTransactionId(rs.getString("item_transaction_id"));
				dto.setTotalPrice(rs.getString("total_price"));
				dto.setTotalCount(rs.getString("total_count"));
				dto.setUserMasterId(rs.getString("user_master_id"));
				dto.setInsertDate(rs.getString("insert_date"));
				billCompleteDTO.add(dto);

				itemStockControl(rs.getString("total_count"),rs.getString("item_transaction_id"));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			con.close();
		}
		return billCompleteDTO;
	}

	public void buyItemInfo(String item_transaction_id,String total_price,String total_count,String user_master_id,String pay)throws SQLException {
		Connection con = db.getConnection();
		String sql = "insert into user_buy_item_transaction(item_transaction_id,total_price,total_count,user_master_id,pay,insert_date)values(?,?,?,?,?,?)";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, item_transaction_id);
			ps.setString(2, total_price);
			ps.setString(3, total_count);
			ps.setString(4, user_master_id);
			ps.setString(5, pay);
			ps.setString(6, dateUtil.getDate());
			ps.execute();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			con.close();
		}

	}

	public void itemStockControl(String totalCount,String id)throws SQLException {
		Connection con = db.getConnection();
		String sql = "update item_info_transaction set item_stock = item_stock - ? where id = ?";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1,totalCount);
			ps.setString(2,id);
			ps.execute();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			con.close();
		}
	}




}


//package com.internousdev.ecsite2.dao;
//
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.util.ArrayList;
//import java.util.List;
//
//import com.internousdev.ecsite2.dto.BillCompleteDTO;
//import com.internousdev.ecsite2.util.DBConnector;
//import com.internousdev.ecsite2.util.DateUtil;
//
//
//public class BillCompleteDAO {
//	private DBConnector db = new DBConnector();
//	private Connection con = db.getConnection();
//	private DateUtil dateUtil = new DateUtil();
//
//	public List<BillCompleteDTO> getBillListInfo(String user_master_id)throws SQLException{
//		List<BillCompleteDTO> billCompleteDTO = new ArrayList<BillCompleteDTO>();
//		String sql = "select bt.item_transaction_id,bt.total_price,bt.total_count,bt.user_master_id,bt.insert_date "
//				+ "from basket_transaction bt "
//				+ "left join login_user_transaction lut "
//				+ "on bt.user_master_id = lut.login_id "
//				+ "where bt.user_master_id = ?";
//		try {
//			PreparedStatement ps = con.prepareStatement(sql);
//			ps.setString(1, user_master_id);
//			ResultSet rs = ps.executeQuery();
//
//			while(rs.next()) {
//				BillCompleteDTO dto = new BillCompleteDTO();
//				dto.setItemTransactionId(rs.getString("item_transaction_id"));
//				dto.setTotalPrice(rs.getString("total_price"));
//				dto.setTotalCount(rs.getString("total_count"));
//				dto.setUserMasterId(rs.getString("user_master_id"));
//				dto.setInsertDate(rs.getString("insert_date"));
//				billCompleteDTO.add(dto);
//			}
//		}catch(Exception e) {
//			e.printStackTrace();
//		}finally {
//			con.close();
//		}
//		return billCompleteDTO;
//	}
//
//	public void buyItemInfo(String item_transaction_id,String total_price,String total_count,String user_master_id,String pay)throws SQLException {
//		String sql = "insert into user_buy_item_transaction(item_transaction_id,total_price,total_count,user_master_id,pay,insert_date)values(?,?,?,?,?,?)";
//		try {
//			PreparedStatement ps = con.prepareStatement(sql);
//			ps.setString(1, item_transaction_id);
//			ps.setString(2, total_price);
//			ps.setString(3, total_count);
//			ps.setString(4, user_master_id);
//			ps.setString(5, pay);
//			ps.setString(6, dateUtil.getDate());
//			ps.execute();
//		}catch(Exception e){
//			e.printStackTrace();
//		}finally{
//			con.close();
//		}
//
//	}
//
//
//
//
//}
