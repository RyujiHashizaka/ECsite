package com.internousdev.ecsite.dto;

public class UserListDTO {

	private String id;
	private String login_id;
	private String login_pass;
	private String user_name;
	private String user_address;
	private String user_title;
	private String insert_date;


	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}


	public String getLogin_id() {
		return login_id;
	}
	public void setLogin_id(String login_id) {
		this.login_id = login_id;
	}


	public String getLogin_pass() {
		return login_pass;
	}
	public void setLogin_pass(String login_pass) {
		this.login_pass = login_pass;
	}


	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}


	public String getUser_address() {
		return user_address;
	}
	public void setUser_address(String user_address) {
		this.user_address = user_address;
	}


	public String getUser_title() {
		return user_title;
	}
	public void setUser_title(String user_title) {
		this.user_title = user_title;
	}


	public String getInsert_date() {
		return insert_date;
	}
	public void setInsert_date(String insert_date) {
		this.insert_date = insert_date;
	}

}
