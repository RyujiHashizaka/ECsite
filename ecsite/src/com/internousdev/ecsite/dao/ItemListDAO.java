package com.internousdev.ecsite.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.internousdev.ecsite.dto.ItemListDTO;
import com.internousdev.ecsite.util.DBConnector;

public class ItemListDAO {


	private DBConnector dbConnector = new DBConnector();
	private Connection connection = dbConnector.getConnection();


	public ArrayList<ItemListDTO> getItemListInfo() throws SQLException {

		ArrayList<ItemListDTO> itemListDTOList = new ArrayList<ItemListDTO>();

		String sql = "SELECT * FROM item_info_transaction WHERE delete_date IS NULL";

		try{
			PreparedStatement preparedStatement = connection.prepareStatement(sql);

			ResultSet resultSet = preparedStatement.executeQuery();

			while(resultSet.next()){
				ItemListDTO dto = new ItemListDTO();
				dto.setId(resultSet.getString("id"));
				dto.setItem_name(resultSet.getString("item_name"));
				dto.setItem_price(resultSet.getString("item_price"));
				dto.setItem_stock(resultSet.getString("item_stock"));
				dto.setItem_text(resultSet.getString("item_text"));
				dto.setInsert_date(resultSet.getString("insert_date"));
				itemListDTOList.add(dto);
			}

		}catch(Exception e){
			e.printStackTrace();

		}finally {
			connection.close();
		}

		return itemListDTOList;

	}


}
