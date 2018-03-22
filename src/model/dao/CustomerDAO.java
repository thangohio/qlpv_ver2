package model.dao;

import java.util.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import model.bean.Customer;

public class CustomerDAO extends Database{
	
	public CustomerDAO() {
		super();
	}
	
public boolean addCustomer(Customer cus) {
	
	SimpleDateFormat df = new SimpleDateFormat("yyyy-mm-dd");
	String insertDob = df.format(cus.getDob());
	System.out.println("In database: " + insertDob);
		String queryStr = "insert into KHACHHANG (MaKhachHang, TenKhachHang, NgaySinh, GioiTinh, CMND, HoChieu, Email, SDT) "
				+ "values ('" + cus.getId() + "', '" + cus.getFullName() 
				+ "', '" + insertDob + "', "
				 + (cus.isMale() ? "b'1'" : "b'0'") + ",'" + cus.getPersonId() + "', '" + cus.getPassport() + "', '" + cus.getEmail()
				+ "', '" + cus.getPhoneNumber() + "');";	

		System.out.println(queryStr);
		
		try {
			update(queryStr);
		}
		catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

public boolean deleteCustomer(String cusId) {
	String queryStr = "delete from KHACHHANG where MaKhachHang = '" + cusId + "';";
	try {
		update(queryStr);
		System.out.println("deleted " + cusId);
		return true;
	} catch (SQLException e) {
		e.printStackTrace();
		return false;
	}
}

	public boolean updateCustomer(Customer cus) {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-mm-dd");
		String newDob = df.format(cus.getDob());
		
		String queryStr = "update KHACHHANG set "
				+ "TenKhachHang = '" + cus.getFullName() + "', NgaySinh = '" + newDob + "', "
				+ "GioiTinh = " + (cus.isMale() ? "b'1'" : "b'0'") +
				"CMND = '" + cus.getPersonId() + "', HoChieu = '" + cus.getPassport() + "',"
				+ "Email = '" + cus.getEmail()
				+ "', SDT = '" + cus.getPhoneNumber()
				+ "' where MaKhachHang = '" + cus.getId() + "';";
		try {
			update(queryStr);
			System.err.println("Updated " + cus.getId());
		}
		catch (SQLException e) {
			e.printStackTrace();
			return false;
		}		
		return true;
	}

	public Customer getCustomer(int cusId) {
		String queryStr = "select * from KHACHHANG where MaKhachHang='" + cusId + "'";
		Customer cus = null;
		try {
			ResultSet rs = execute(queryStr);
			if (rs.next()) {
				cus = getCustomerFromQueryResult(rs);
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return cus;
	}

	private Customer getCustomerFromQueryResult(ResultSet rs) throws SQLException {
		Customer cus;
		String id = rs.getString("MaKhachHang");
		String fullName = rs.getString("TenKhachHang");
		Date dob = rs.getDate("NgaySinh");
		Boolean isMale = rs.getBoolean("GioiTinh");
		String personId = rs.getString("CMND");
		String passport = rs.getString("HoChieu");
		String email = rs.getString("Email");
		String phoneNumber = rs.getString("SDT");
		cus = new Customer(id, fullName, dob, isMale, email, phoneNumber);
		cus.setPersonId(personId);
		cus.setPassport(passport);
		return cus;
	}
	
	public ArrayList<Customer> getCustomersList() {
		String queryStr = "select * from KHACHHANG;";
		ArrayList<Customer> customers = new ArrayList<Customer>();
		
		try {
			ResultSet rs = execute(queryStr);
			while (rs.next()) {
				customers.add(getCustomerFromQueryResult(rs));
			}
		}
		catch (SQLException ex) {
			ex.printStackTrace();
		}		
		return customers;
		
	}

	public ArrayList<Customer> searchBy(String type, String searchContent) {
		String queryStr = "select * from KHACHHANG where " + type + "= '"  + searchContent + "';";
		ArrayList<Customer> customers = new ArrayList<Customer>();
		try {
			ResultSet rs = execute(queryStr);
			while (rs.next()) {
				String id = rs.getString("MaKhachHang");
				String fullName = rs.getString("TenKhachHang");				
				Date dob = rs.getDate("NgaySinh");
				boolean isMale = rs.getBoolean("GioiTinh");
				String email = rs.getString("Email");
				String phoneNumber = rs.getString("SDT");
				Customer cus = new Customer(id, fullName, dob, isMale, email, phoneNumber);
				customers.add(cus);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return customers;
	}

}
