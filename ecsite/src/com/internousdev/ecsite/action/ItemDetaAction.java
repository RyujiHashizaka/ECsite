package com.internousdev.ecsite.action;

import java.sql.SQLException;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite.dao.ItemDetaDAO;
import com.internousdev.ecsite.dto.ItemDetaDTO;
import com.opensymphony.xwork2.ActionSupport;



public class ItemDetaAction extends ActionSupport implements SessionAware{


	private String itemDetaFlg;
	private String itemDetaId;
	private String message;
	public Map<String, Object> session;


	public String execute() throws SQLException {

		String result = ERROR;
		ItemDetaDTO itemDetaDTO = new ItemDetaDTO();
		ItemDetaDAO itemDetaDAO = new ItemDetaDAO();


		if(itemDetaFlg.equals("insert")){

			message = "insert";
			session.put("message", message);
			result = SUCCESS;

		}else {

			itemDetaDTO = itemDetaDAO.getSelectItemDeta(itemDetaId);
			session.put("selectItemId", itemDetaDTO.getSelectItemId());
			session.put("selectItemName", itemDetaDTO.getSelectItemName());
			session.put("selectItemPrice", itemDetaDTO.getSelectItemPrice());
			session.put("selectItemStock", itemDetaDTO.getSelectItemStock());
			session.put("selectItemText", itemDetaDTO.getSelectItemText());
			session.put("selectItemInsertDate", itemDetaDTO.getSelectItemInsertDate());

			if(itemDetaFlg.equals("update")){

				message = "update";
				session.put("message", message);
				result = SUCCESS;

			}else if (itemDetaFlg.equals("delete")) {

				message = "delete";
				session.put("message", message);
				result = "delete";
			}

		}

		return result;

	}


	public String getItemDetaFlg() {
		return itemDetaFlg;
	}


	public void setItemDetaFlg(String itemDetaFlg) {
		this.itemDetaFlg = itemDetaFlg;
	}


	public String getItemDetaId() {
		return itemDetaId;
	}


	public void setItemDetaId(String itemDetaId) {
		this.itemDetaId = itemDetaId;
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
