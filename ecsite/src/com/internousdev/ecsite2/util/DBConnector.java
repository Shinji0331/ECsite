package com.internousdev.ecsite2.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnector {
	private static String driverName = "com.mysql.jdbc.Driver";
	private static String url = "jdbc:mysql://localhost/ecsite2";//ecsiteはDB名

	private static String user = "root";
	private static String password = "";

	public Connection getConnection(){
		Connection con = null; //接続する前に空っぽにしてから実行する。初期化

		try{
			Class.forName(driverName); //ドライバーネームを呼び出してから以下の接続を行う
			con = (Connection)DriverManager.getConnection(url,user,password); //ここで接続している
		}catch(ClassNotFoundException e){//クラス関連のエラー
			e.printStackTrace();
		}catch(SQLException e){//SQL関連のエラー
			e.printStackTrace();
		}
		return con;
	}

}
