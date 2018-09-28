package com.internousdev.ecsite.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.internousdev.ecsite.dto.UserListDTO;
import com.internousdev.ecsite.util.DBConnector;

public class UserListDAO {

	private DBConnector dbConnector = new DBConnector();
	private Connection connection = dbConnector.getConnection();


	public ArrayList<UserListDTO> getUserListInfo() throws SQLException {

		ArrayList<UserListDTO> userListDTOList = new ArrayList<UserListDTO>();

		String sql = "SELECT * FROM login_user_transaction WHERE delete_date IS NULL";

		try{
			PreparedStatement preparedStatement = connection.prepareStatement(sql);

			ResultSet resultSet = preparedStatement.executeQuery();

			while(resultSet.next()){
				UserListDTO dto = new UserListDTO();
				dto.setId(resultSet.getString("id"));
				dto.setLogin_id(resultSet.getString("login_id"));
				dto.setLogin_pass(resultSet.getString("login_pass"));
				dto.setUser_name(resultSet.getString("user_name"));
				dto.setUser_address(resultSet.getString("user_address"));
				dto.setUser_title(resultSet.getString("user_title"));
				dto.setInsert_date(resultSet.getString("insert_date"));
				userListDTOList.add(dto);
			}

		}catch(Exception e){
			e.printStackTrace();

		}finally {
			connection.close();
		}

		return userListDTOList;

	}

}
