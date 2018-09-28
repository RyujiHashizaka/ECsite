package com.internousdev.ecsite.action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite.dao.UserListDAO;
import com.internousdev.ecsite.dto.UserListDTO;
import com.opensymphony.xwork2.ActionSupport;

public class UserListAction extends ActionSupport implements SessionAware{

	public Map<String, Object> session;
	private UserListDAO userListDAO = new UserListDAO();
	private ArrayList<UserListDTO> userList = new ArrayList<UserListDTO>();
	private String message;


	public String execute() throws SQLException {

		userList = userListDAO.getUserListInfo();

		if (userList.size() == 0) {
			userList = null;
		}


		String result = SUCCESS;
		return result;

	}






	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}


	public ArrayList<UserListDTO> getUserList() {
		return userList;
	}


	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
