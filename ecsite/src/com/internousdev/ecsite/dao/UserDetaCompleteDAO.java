package com.internousdev.ecsite.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.internousdev.ecsite.util.DBConnector;
import com.internousdev.ecsite.util.DateUtil;



public class UserDetaCompleteDAO {

	private DBConnector dbConnector = new DBConnector();
	private Connection connection = dbConnector.getConnection();

	private DateUtil dateUtil = new DateUtil();


	public int userDetaUpdate(String selectUserId, String selectUserLoginId, String selectUserLoginPass, String selectUserName, String selectUserAddress, String selectUserTitle) throws SQLException{
		String sql = "UPDATE login_user_transaction SET login_id = ?, login_pass = ?, user_name = ?, user_address = ?, user_title = ? WHERE id = ?";

		PreparedStatement preparedStatement;
		int result = 0;

		try{
			preparedStatement =connection.prepareStatement(sql);
			preparedStatement.setString(1, selectUserLoginId);
			preparedStatement.setString(2, selectUserLoginPass);
			preparedStatement.setString(3, selectUserName);
			preparedStatement.setString(4, selectUserAddress);
			preparedStatement.setString(5, selectUserTitle);
			preparedStatement.setString(6, selectUserId);

			result = preparedStatement.executeUpdate();


			}catch(Exception e){
				e.printStackTrace();

			}finally {
				connection.close();
			}

		return result;

	}


	public int userDetaDelete(String selectUserId) throws SQLException{

		PreparedStatement preparedStatement;
		int result = 0;

		String sql =
				  "UPDATE "
					+ "login_user_transaction "
				+ "SET "
					+ "delete_date = ? "
				+ "WHERE "
					+ "id = ?";

		try{
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, dateUtil.getDate());
			preparedStatement.setString(2, selectUserId);

			result = preparedStatement.executeUpdate();

		}catch(Exception e){
			e.printStackTrace();

		}finally {
			connection.close();
		}

		return result;

	}


	public int userDetaInsert(String selectUserLoginId, String selectUserLoginPass, String selectUserName, String selectUserAddress, String selectUserTitle) throws SQLException{

		PreparedStatement preparedStatement;
		int result = 0;

		String sql =
				  "INSERT INTO "
						+ "login_user_transaction "
						+ "(login_id, login_pass, user_name, user_address, user_title, insert_date) VALUES(?,?,?,?,?,?)";

		try{
			preparedStatement = connection.prepareStatement(sql);

			preparedStatement.setString(1, selectUserLoginId);
			preparedStatement.setString(2, selectUserLoginPass);
			preparedStatement.setString(3, selectUserName);
			preparedStatement.setString(4, selectUserAddress);
			preparedStatement.setString(5, selectUserTitle);
			preparedStatement.setString(6, dateUtil.getDate());

			result = preparedStatement.executeUpdate();

		}catch(Exception e){
			e.printStackTrace();

		}finally {
			connection.close();
		}

		return result;

	}

}
