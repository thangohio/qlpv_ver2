package model.bo;

import java.util.ArrayList;

import model.bean.Customer;
import model.bean.User;
import model.dao.CustomerDAO;

public class CustomerBO {
	CustomerDAO customerDAO;
	
	public CustomerBO(){
		customerDAO = new CustomerDAO();
	}
	
	public ArrayList<Customer> getCustomerList() {
		return customerDAO.getCustomersList();
	}
	
	public ArrayList<Customer> searchBy(String type, String searchContent) {
		return customerDAO.searchBy(type, searchContent);
	}
	
	public ArrayList<Customer> searchByName(String searchContent) {
		return customerDAO.searchBy("TenKhachHang", searchContent);
	}
	
	public ArrayList<Customer> searchByEmail(String searchContent) {
		return customerDAO.searchBy("Email", searchContent);
	}
	
	public ArrayList<Customer> searchById(String searchContent) {
		return customerDAO.searchBy("MaKhachHang", searchContent);
	}
	
	public ArrayList<Customer> searchByPhoneNumber(String searchContent) {
		return customerDAO.searchBy("SDT", searchContent);
	}
	
	public boolean addCustomer(Customer cus) {
		if (customerDAO.addCustomer(cus)) {
			return true;
		};
		return false;
	}

	public boolean updateCustomer(Customer cus) {
		return customerDAO.updateCustomer(cus);
	}

	public Customer getCustomer(int cusId) {
		return customerDAO.getCustomer(cusId);
	}
	
	public boolean deleteCustomer(String cusId) {
		return customerDAO.deleteCustomer(cusId);
	}
}
