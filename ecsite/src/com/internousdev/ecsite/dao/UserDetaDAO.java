package com.internousdev.ecsite.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.internousdev.ecsite.dto.UserDetaDTO;
import com.internousdev.ecsite.util.DBConnector;

public class UserDetaDAO {

	private DBConnector dbConnector = new DBConnector();
	private Connection connection = dbConnector.getConnection();


	public UserDetaDTO getSelectUserDeta(String id) throws SQLException {

		UserDetaDTO dto = new UserDetaDTO();

		String sql = "SELECT * FROM login_user_transaction WHERE id = ?";

		try{
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, id);

			ResultSet resultSet = preparedStatement.executeQuery();

			if(resultSet.next()){
				dto.setSelectUserId(resultSet.getString("id"));
				dto.setSelectUserLoginId(resultSet.getString("login_id"));
				dto.setSelectUserLoginPass(resultSet.getString("login_pass"));
				dto.setSelectUserName(resultSet.getString("user_name"));
				dto.setSelectUserAddress(resultSet.getString("user_address"));
				dto.setSelectUserTitle(resultSet.getString("user_title"));
				dto.setSelectUserInsertDate(resultSet.getString("insert_date"));
			}

		}catch(Exception e){
			e.printStackTrace();

		}finally {
			connection.close();
		}

		return dto;

	}

}
