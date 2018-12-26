package com.internousdev.ecsite2.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.internousdev.ecsite2.util.DBConnector;
import com.internousdev.ecsite2.util.DateUtil;

public class ItemCreateCompleteDAO {
	private DBConnector db = new DBConnector();
	private Connection con = db.getConnection();
	private DateUtil dateUtil = new DateUtil();

	private String sql = "insert into item_info_transaction(item_name,item_price,item_stock,insert_date)values(?,?,?,?)";
	public void itemCreate(String createItemName,String createItemPrice,String createItemStock)throws SQLException{
		try{
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1,createItemName);
			ps.setString(2, createItemPrice);
			ps.setString(3, createItemStock);
			ps.setString(4, dateUtil.getDate());

			ps.execute();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			con.close();
		}
	}

}
