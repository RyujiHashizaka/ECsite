package com.internousdev.ecsite.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.internousdev.ecsite.util.DBConnector;
import com.internousdev.ecsite.util.DateUtil;



public class ItemDetaCompleteDAO {


	private DBConnector dbConnector = new DBConnector();
	private Connection connection = dbConnector.getConnection();

	private DateUtil dateUtil = new DateUtil();




	public int itemDetaUpdate(String selectItemId, String selectItemName, String selectItemPrice, String selectItemStock, String selectItemText) throws SQLException{
		String sql = "UPDATE item_info_transaction SET delete_date = ? WHERE id = ?";

		PreparedStatement preparedStatement;
		int result = 0;

		try{
			preparedStatement =connection.prepareStatement(sql);
			preparedStatement.setString(1, dateUtil.getDate());
			preparedStatement.setString(2, selectItemId);

		result = preparedStatement.executeUpdate();

			sql ="INSERT INTO item_info_transaction(item_name, item_price, item_stock, item_text, insert_date) VALUES(?,?,?,?,?)";

			preparedStatement =connection.prepareStatement(sql);

			preparedStatement.setString(1, selectItemName);
			preparedStatement.setString(2, selectItemPrice);
			preparedStatement.setString(3, selectItemStock);
			preparedStatement.setString(4, selectItemText);
			preparedStatement.setString(5, dateUtil.getDate());

			result = preparedStatement.executeUpdate();

			}catch(Exception e){
				e.printStackTrace();

			}finally {
				connection.close();
			}

		return result;

	}


	public int itemDetaDelete(String selectItemId) throws SQLException{

		PreparedStatement preparedStatement;
		int result = 0;

		String sql =
				  "UPDATE "
					+ "item_info_transaction "
				+ "SET "
					+ "delete_date = ? "
				+ "WHERE "
					+ "id = ?";

		try{
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, dateUtil.getDate());
			preparedStatement.setString(2, selectItemId);

			result = preparedStatement.executeUpdate();

		}catch(Exception e){
			e.printStackTrace();

		}finally {
			connection.close();
		}

		return result;

	}


	public int itemDetaInsert(String selectItemName, String selectItemPrice, String selectItemStock, String selectItemText) throws SQLException{

		PreparedStatement preparedStatement;
		int result = 0;

		String sql =
				  "INSERT INTO "
						+ "item_info_transaction "
						+ "(item_name, item_price, item_stock, item_text, insert_date) VALUES(?,?,?,?,?)";

		try{
			preparedStatement = connection.prepareStatement(sql);

			preparedStatement.setString(1, selectItemName);
			preparedStatement.setString(2, selectItemPrice);
			preparedStatement.setString(3, selectItemStock);
			preparedStatement.setString(4, selectItemText);
			preparedStatement.setString(5, dateUtil.getDate());

			result = preparedStatement.executeUpdate();

		}catch(Exception e){
			e.printStackTrace();

		}finally {
			connection.close();
		}

		return result;

	}


}
