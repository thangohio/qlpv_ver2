package model.dao;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import model.bean.Customer;
import model.bean.User;

public class UserDAO extends Database {

	public boolean addUser(User user) {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-mm-dd");
		String insertDob = df.format(user.getDob());
			String queryStr = "insert into NHANVIEN (MaNhanVien, TenNhanVien, NgaySinh, GioiTinh, TaiKhoan, MatKhau, SDT, Quyen) "
					+ "values ('" + user.getId() + "', '" + user.getFullName() 
					+ "', '" + insertDob + "', "
					 + (user.isMale() ? "b'1'" : "b'0'") + ", '" + user.getEmail()
					+ "', '" + user.getPwd() + "', '" + user.getPhoneNumber() + "', '" + user.getPrivilege() + "');";		
			try {
				update(queryStr);
			}
			catch (SQLException e) {
				e.printStackTrace();
				return false;
			}
			return true;
		/*
		String queryStr = "insert into NHANVIEN (MaNhanVien, TenNhanVien, NgaySinh, GioiTinh, TaiKhoan, MatKhau, SDT, Quyen)"
				+ "values ('" + user.getId() + "', " + user.getFullName() + "', " + user.getDob()
				+ "', " + user.isMale() + "', " + user.getEmail() + "', " + user.getPwd()
				+ "', " + user.getPhoneNumber() + "', " + user.getPrivilege() + "');";
		try {
			update(queryStr);
		}
		catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;*/
	}

	public boolean deleteUser(String userId) {
		String queryStr = "delete from NHANVIEN where MaNhanVien = '" + userId + "';";
		
		try {
			update(queryStr);
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean updateUser(User user) {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-mm-dd");
		String newDob = df.format(user.getDob());
		
		String queryStr = "update NHANVIEN set "
				+ "TenNhanVien = '" + user.getFullName() + "', NgaySinh = '" + newDob + "', "
				+ "GioiTinh = " + (user.isMale() ? "b'1'" : "b'0'") + ", TaiKhoan = '" + user.getEmail()
				+ "', SDT = '" + user.getPhoneNumber()+ "', Quyen = '" + user.getPrivilege() +"'"
				+ " where MaNhanVien = '" + user.getId() + "';";
		try {
			update(queryStr);
			System.err.println("Updated " + user.getId());
		}
		catch (SQLException e) {
			e.printStackTrace();
			return false;
		}		
		return true;
	}

	public User getUser(String userId) {
		String queryStr = "select * from NHANVIEN where MaNhanVien='" + userId + "'";
		User user = null;
		try {
			ResultSet rs = execute(queryStr);
			if (rs.next()) {
				String id = rs.getString("MaNhanVien");
				String fullName = rs.getString("TenNhanVien");
				Date dob = rs.getDate("NgaySinh");
				Boolean isMale = rs.getBoolean("GioiTinh");
				String email = rs.getString("TaiKhoan");
				String pwd = rs.getString("MatKhau");
				String phoneNumber = rs.getString("SDT");
				String privilege = rs.getString("Quyen");
				
				// TODO add more properties
				user = new User(id, fullName, dob, isMale, email, pwd, phoneNumber, privilege);
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}
	
	public ArrayList<User> getUsers() {
		String queryStr = "select * from NHANVIEN;";
		ArrayList<User> users = new ArrayList<User>();
		
		try {
			ResultSet rs = execute(queryStr);
			while (rs.next()) {
				String id = rs.getString("MaNhanVien");
				String fullName = rs.getString("TenNhanVien");				
				Date dob = rs.getDate("NgaySinh");
				boolean isMale = rs.getBoolean("GioiTinh");
				String email = rs.getString("TaiKhoan");
				String pwd = rs.getString("MatKhau");
				String phoneNumber = rs.getString("SDT");
				String privilege = rs.getString("Quyen");
				
				User user = new User(id, fullName, dob, isMale, email, pwd, phoneNumber, privilege);
				users.add(user);
			}
		}
		catch (SQLException ex) {
			ex.printStackTrace();
		}		
		return users;
		
	}

	public ArrayList<User> searchBy(String type, String searchContent) {
		String queryStr = "select * from NHANVIEN where " + type + "= '"  + searchContent + "';";
		ArrayList<User> users = new ArrayList<User>();
		try {
			ResultSet rs = execute(queryStr);
			while (rs.next()) {
				String id = rs.getString("MaNhanVien");
				String fullName = rs.getString("TenNhanVien");				
				Date dob = rs.getDate("NgaySinh");
				boolean isMale = rs.getBoolean("GioiTinh");
				String email = rs.getString("TaiKhoan");
				String pwd = rs.getString("MatKhau");
				String phoneNumber = rs.getString("SDT");
				String privilege = rs.getString("Quyen");
				
				User user = new User(id, fullName, dob, isMale, email, pwd, phoneNumber, privilege);
				users.add(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return users;
	}

}
