package com.internousdev.ecsite.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import com.internousdev.ecsite.dto.ItemDetaDTO;
import com.internousdev.ecsite.util.DBConnector;



public class ItemDetaDAO {

	private DBConnector dbConnector = new DBConnector();
	private Connection connection = dbConnector.getConnection();



	public ItemDetaDTO getSelectItemDeta(String id) throws SQLException {

		ItemDetaDTO dto = new ItemDetaDTO();

		String sql = "SELECT * FROM item_info_transaction WHERE id = ?";

		try{
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, id);

			ResultSet resultSet = preparedStatement.executeQuery();

			if(resultSet.next()){
				dto.setSelectItemId(resultSet.getString("id"));
				dto.setSelectItemName(resultSet.getString("item_name"));
				dto.setSelectItemPrice(resultSet.getString("item_price"));
				dto.setSelectItemStock(resultSet.getString("item_stock"));
				dto.setSelectItemText(resultSet.getString("item_text"));
				dto.setSelectItemInsertDate(resultSet.getString("insert_date"));
			}

		}catch(Exception e){
			e.printStackTrace();

		}finally {
			connection.close();
		}

		return dto;

	}


}
