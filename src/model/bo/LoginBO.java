package model.bo;

import model.bean.User;
import model.dao.LoginDAO;

public class LoginBO {
	LoginDAO loginDAO;
	
	public LoginBO() {
		loginDAO = new LoginDAO();
	}

	public boolean checkLogin(String email, String pass) {	
		
		if (loginDAO.checkLogin(email, pass)) {
			return true;
		}		
		return false;
	}

	public User getCurrentUser() {		
		return loginDAO.getCurrentUser();
	}
	
}
