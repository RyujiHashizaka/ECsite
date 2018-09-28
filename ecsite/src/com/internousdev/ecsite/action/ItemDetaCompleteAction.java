package com.internousdev.ecsite.action;

import java.sql.SQLException;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite.dao.ItemDetaCompleteDAO;
import com.opensymphony.xwork2.ActionSupport;



public class ItemDetaCompleteAction extends ActionSupport implements SessionAware{
	private String message;
	private ItemDetaCompleteDAO itemDetaCompleteDAO = new ItemDetaCompleteDAO();
	public Map<String, Object> session;


	public String execute() throws SQLException{

		String result = ERROR;
		int res = 0;

		String selectItemId = session.get("selectItemId").toString();
		String selectItemName = session.get("selectItemName").toString();
		String selectItemPrice = session.get("selectItemPrice").toString();
		String selectItemStock = session.get("selectItemStock").toString();
		String selectItemText = session.get("selectItemText").toString();

		if (session.get("message").equals("update")) {

			res = itemDetaCompleteDAO.itemDetaUpdate(selectItemId, selectItemName , selectItemPrice, selectItemStock, selectItemText);

			if(res > 0){
				result = SUCCESS;
			}


		}else if (session.get("message").equals("delete")) {

			res = itemDetaCompleteDAO.itemDetaDelete(selectItemId);

			if(res > 0){
				result = SUCCESS;
			}


		}else if (session.get("message").equals("insert")) {

			res = itemDetaCompleteDAO.itemDetaInsert(selectItemName, selectItemPrice, selectItemStock, selectItemText);

			if(res > 0){
				result = SUCCESS;
			}

		}

		return result;

	}



	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}


	public Map<String, Object> getSession() {
		return session;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}


}
