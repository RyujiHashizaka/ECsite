package com.internousdev.ecsite.action;

import java.sql.SQLException;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;



public class ItemDetaConfirmAction extends ActionSupport implements SessionAware{

	private String itemName;
	private String itemPrice;
	private String itemStock;
	private String itemText;

	public Map<String, Object> session;


	public String execute() throws SQLException{

		String result =ERROR;


		session.put("selectItemName", itemName);
		session.put("selectItemPrice", itemPrice);
		session.put("selectItemStock", itemStock);
		session.put("selectItemText", itemText);


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


	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}


	public String getItemPrice() {
		return itemPrice;
	}

	public void setItemPrice(String itemPrice) {
		this.itemPrice = itemPrice;
	}


	public String getItemStock() {
		return itemStock;
	}

	public void setItemStock(String itemStock) {
		this.itemStock = itemStock;
	}


	public String getItemText() {
		return itemText;
	}

	public void setItemText(String itemText) {
		this.itemText = itemText;
	}


}
