package com.internousdev.ecsite.action;

import java.sql.SQLException;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

public class UserDetaConfirmAction extends ActionSupport implements SessionAware{

	private String userLoginId;
	private String userLoginPass;
	private String userName;
	private String userAddress;
	private String userTitle;

	public Map<String, Object> session;


	public String execute() throws SQLException{

		String result =ERROR;

		if (userTitle.equals("1")) {
			userTitle = "admin";
		}else if (userTitle.equals("2")) {
			userTitle = "user";
		}

		session.put("selectUserLoginId", userLoginId);
		session.put("selectUserLoginPass", userLoginPass);
		session.put("selectUserName", userName);
		session.put("selectUserAddress", userAddress);
		session.put("selectUserTitle", userTitle);



		if (session.get("message").equals("insert")) {

			result = SUCCESS;

		}else if (session.get("message").equals("update")) {

			result = SUCCESS;

		}else if (session.get("message").equals("delete")) {

			result = SUCCESS;
		}

		return result;

	}


	public Map<String, Object> getSession() {
		return session;
	}
	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}


	public String getUserLoginId() {
		return userLoginId;
	}
	public void setUserLoginId(String userLoginId) {
		this.userLoginId = userLoginId;
	}


	public String getUserLoginPass() {
		return userLoginPass;
	}
	public void setUserLoginPass(String userLoginPass) {
		this.userLoginPass = userLoginPass;
	}


	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}


	public String getUserAddress() {
		return userAddress;
	}
	public void setUserAddress(String userAddress) {
		this.userAddress = userAddress;
	}


	public String getUserTitle() {
		return userTitle;
	}
	public void setUserTitle(String userTitle) {
		this.userTitle = userTitle;
	}

}
