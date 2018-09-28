package com.internousdev.ecsite.action;

import java.sql.SQLException;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite.dao.UserDetaCompleteDAO;
import com.opensymphony.xwork2.ActionSupport;



public class UserDetaCompleteAction extends ActionSupport implements SessionAware{

	private String message;
	private UserDetaCompleteDAO userDetaCompleteDAO = new UserDetaCompleteDAO();
	public Map<String, Object> session;


	public String execute() throws SQLException{

		String result = ERROR;
		int res = 0;


		String selectUserLoginId = session.get("selectUserLoginId").toString();
		String selectUserLoginPass = session.get("selectUserLoginPass").toString();
		String selectUserName = session.get("selectUserName").toString();
		String selectUserAddress = session.get("selectUserAddress").toString();
		String selectUserTitle = session.get("selectUserTitle").toString();

		if (session.get("message").equals("update")) {

			String selectUserId = session.get("selectUserId").toString();
			res = userDetaCompleteDAO.userDetaUpdate(selectUserId, selectUserLoginId , selectUserLoginPass, selectUserName, selectUserAddress, selectUserTitle);

			if(res > 0){
				result = SUCCESS;
			}


		}else if (session.get("message").equals("delete")) {

			String selectUserId = session.get("selectUserId").toString();
			res = userDetaCompleteDAO.userDetaDelete(selectUserId);

			if(res > 0){
				result = SUCCESS;
			}


		}else if (session.get("message").equals("insert")) {

			res = userDetaCompleteDAO.userDetaInsert(selectUserLoginId, selectUserLoginPass, selectUserName, selectUserAddress, selectUserTitle);

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
