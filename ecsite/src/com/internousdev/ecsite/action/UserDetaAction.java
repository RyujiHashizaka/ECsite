package com.internousdev.ecsite.action;

import java.sql.SQLException;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite.dao.UserDetaDAO;
import com.internousdev.ecsite.dto.UserDetaDTO;
import com.opensymphony.xwork2.ActionSupport;

public class UserDetaAction extends ActionSupport implements SessionAware{

	private String userDetaFlg;
	private String userDetaId;
	private String message;
	public Map<String, Object> session;


	public String execute() throws SQLException {

		String result = ERROR;
		UserDetaDTO userDetaDTO = new UserDetaDTO();
		UserDetaDAO userDetaDAO = new UserDetaDAO();

		if (userDetaId != null) {

/*			if (session.get("selectUserId").equals(null)) {*/
				session.put("selectUserId", userDetaId);
/*			}*/

		}


		if(userDetaFlg.equals("insert")){

			message = "insert";
			session.put("message", message);
			result = SUCCESS;

		}else {

			userDetaDTO = userDetaDAO.getSelectUserDeta(session.get("selectUserId").toString());
			session.put("selectUserId", userDetaDTO.getSelectUserId());
			session.put("selectUserLoginId", userDetaDTO.getSelectUserLoginId());
			session.put("selectUserLoginPass", userDetaDTO.getSelectUserLoginPass());
			session.put("selectUserName", userDetaDTO.getSelectUserName());
			session.put("selectUserAddress", userDetaDTO.getSelectUserAddress());
			session.put("selectUserTitle", userDetaDTO.getSelectUserTitle());
			session.put("selectUserInsertDate", userDetaDTO.getSelectUserInsertDate());

			if(userDetaFlg.equals("update")){

				message = "update";
				session.put("message", message);

				if (session.get("selectUserTitle").toString().equals("admin")) {
					session.put("userTitleValue", 1);
				}else {
					session.put("userTitleValue", 2);
				}

				result = SUCCESS;


			}else if (userDetaFlg.equals("delete")) {

				message = "delete";
				session.put("message", message);
				result = "delete";
			}

		}


		System.out.println(session.get("selectUserId"));
		System.out.println(session.get("selectUserLoginId"));
		System.out.println(session.get("selectUserLoginPass"));
		System.out.println(session.get("selectUserName"));
		System.out.println(session.get("selectUserAddress"));
		System.out.println(session.get("selectUserTitle"));

		return result;

	}


	public String getUserDetaFlg() {
		return userDetaFlg;
	}
	public void setUserDetaFlg(String userDetaFlg) {
		this.userDetaFlg = userDetaFlg;
	}


	public String getUserDetaId() {
		return userDetaId;
	}
	public void setUserDetaId(String userDetaId) {
		this.userDetaId = userDetaId;
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
