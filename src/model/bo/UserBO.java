package model.bo;

import java.util.ArrayList;

import model.bean.Customer;
import model.bean.User;
import model.dao.UserDAO;

public class UserBO {

	UserDAO userDAO;
	public UserBO() {
		userDAO = new UserDAO();
	}
	
	public boolean addUser(User user) {
		if (userDAO.addUser(user)) {
			return true;
		};
		return false;
	}

	public boolean updateUser(User user) {
		return userDAO.updateUser(user);
	}

	public User getUser(String userId) {
		return userDAO.getUser(userId);
	}
	
	public ArrayList<User> getUsers() {
		return userDAO.getUsers();
	}
	
	public boolean deleteUser(String userId) {
		return userDAO.deleteUser(userId);
	}

	public ArrayList<User> searchById(String searchContent) {
		return userDAO.searchBy("MaNhanVien", searchContent);
	}

	public ArrayList<User> searchByPhoneNumber(String searchContent) {
		return userDAO.searchBy("SDT", searchContent);
	}
	public ArrayList<User> searchByName(String searchContent) {
		return userDAO.searchBy("TenKhachHang", searchContent);
	}
	public ArrayList<User> searchByEmail(String searchContent) {
		return userDAO.searchBy("Email", searchContent);
	}

	
	
}
