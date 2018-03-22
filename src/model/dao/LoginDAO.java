package model.dao;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.bean.User;

public class LoginDAO extends Database {
	User currentUser = null;

	public boolean checkLogin(String email, String pass) {
		ArrayList<User> users = new ArrayList<User>();
		String query = "select * from NHANVIEN where TaiKhoan = '" 
				+ email + "' and MatKhau = '" + pass + "'";
		try {
			ResultSet rs = execute(query);
			if (rs.next()) { // login successful
				//get information for the current user;
				String id = rs.getString("MaNhanVien");
				String fullName = rs.getString("TenNhanVien");
				Date dob = rs.getDate("NgaySinh");
				Boolean isMale = rs.getBoolean("GioiTinh");
				String phoneNumber = rs.getString("SDT");
				String privilege = rs.getString("Quyen");				
				
				currentUser = new User(id, fullName, dob, isMale, email, pass, phoneNumber, privilege);
				return true;
			}
		} catch (SQLException e) {			
			e.printStackTrace();
		}		
		return false;
	}

	public User getCurrentUser() {
		return currentUser;

	}
}
