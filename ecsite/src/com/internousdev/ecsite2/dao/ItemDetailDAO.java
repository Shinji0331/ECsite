package com.internousdev.ecsite2.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.internousdev.ecsite2.dto.ItemDetailDTO;
import com.internousdev.ecsite2.util.DBConnector;

public class ItemDetailDAO {
	private DBConnector db = new DBConnector();
	private Connection con = db.getConnection();

	public List<ItemDetailDTO> getItemDetail(String itemId)throws SQLException{
		List<ItemDetailDTO> itemDetailDTO = new ArrayList<ItemDetailDTO>();
		String sql = "select * from item_info_transaction where item_id = ?";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, itemId);
			ResultSet rs = ps.executeQuery();

			if(rs.next()) {
				ItemDetailDTO dto = new ItemDetailDTO();
				dto.setItemId(rs.getInt("item_id"));
				dto.setItemName(rs.getString("item_name"));
				dto.setItemNameKana(rs.getString("item_name_kana"));
				dto.setItemDescription(rs.getString("item_description"));
				dto.setCategoryId(rs.getInt("category_id"));
				dto.setItemPrice(rs.getString("item_price"));
				dto.setImageFilePath(rs.getString("image_file_path"));
				dto.setImageFileName(rs.getString("image_file_name"));
				dto.setReleaseDate(rs.getDate("release_date"));
				dto.setReleaseCompany(rs.getString("release_company"));
				dto.setItemStock(rs.getInt("item_stock"));
				dto.setInsertDate(rs.getDate("insert_date"));
				dto.setUpdateDate(rs.getDate("update_date"));
				itemDetailDTO.add(dto);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			con.close();
		}
		return itemDetailDTO;

	}

}
