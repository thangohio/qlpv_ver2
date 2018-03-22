package model.bo;

import java.util.ArrayList;

import model.bean.Transaction;
import model.dao.TransactionDAO;

public class TransactionBO {
	TransactionDAO transactionDAO;
	
	public TransactionBO(){
		transactionDAO = new TransactionDAO();
	}
	
	public ArrayList<Transaction> getTransactionList() {
		return transactionDAO.getTransactionList();
	}
	
	public ArrayList<Transaction> searchBy(String type, String searchContent) {
		return transactionDAO.searchBy(type, searchContent);
	}
	
	public ArrayList<Transaction> searchByMaVe(String searchContent) {
		return transactionDAO.searchBy("MaVe", searchContent);
	}
	
	public ArrayList<Transaction> searchByMaNhanVien(String searchContent) {
		return transactionDAO.searchBy("MaNhanVien", searchContent);
	}
	
	public ArrayList<Transaction> searchByMaGiaoDich(String searchContent) {
		return transactionDAO.searchBy("MaGiaoDich", searchContent);
	}
	
	public ArrayList<Transaction> searchByMaKhachHang(String searchContent) {
		return transactionDAO.searchBy("MaKhachHang", searchContent);
	}
	
	public boolean addTransaction(Transaction tran) {
		if (transactionDAO.addTransaction(tran)) {
			return true;
		};
		return false;
	}

	public boolean updateTransaction(Transaction tran) {
		return transactionDAO.updateTransaction(tran);
	}

	public Transaction getTransaction(long transId) {
		return transactionDAO.getTransaction(transId);
	}
	
	public boolean deleteTransaction(long transId) {
		return transactionDAO.deleteTransaction(transId);
	}
}
