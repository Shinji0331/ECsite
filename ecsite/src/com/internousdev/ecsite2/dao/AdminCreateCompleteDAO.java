package com.internousdev.ecsite2.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.internousdev.ecsite2.util.DBConnector;
import com.internousdev.ecsite2.util.DateUtil;

public class AdminCreateCompleteDAO {
	private DBConnector db = new DBConnector();
	private Connection con = db.getConnection();
	private DateUtil dateUtil = new DateUtil();
	private String sql = "insert into login_user_transaction(login_id,login_pass,user_name,admin_flg,insert_date)values(?,?,?,?,?)";

	public void adminInfo(String login_id,String login_pass,String user_name,String admin_flg)throws SQLException {
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, login_id);
			ps.setString(2, login_pass);
			ps.setString(3, user_name);
			ps.setString(4, admin_flg);
			ps.setString(5, dateUtil.getDate());
			ps.execute();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			con.close();
		}

	}

}
