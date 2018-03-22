package model.dao;

import java.util.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import model.bean.Customer;
import model.bean.Transaction;

public class TransactionDAO extends Database{
	
	public TransactionDAO() {
		super();
	}
	
public boolean addTransaction(Transaction tran) {
	
	SimpleDateFormat df = new SimpleDateFormat("yyyy-mm-dd");
	String insertNgb = df.format(tran.getNgayBan());
	System.out.println("In database: " + insertNgb);
		String queryStr = "insert into GIAODICH (MaVe, MaKhachHang, MaNhanVien, NgayBan) "
				+ "values ('" + tran.getMaVe() + "', '" + tran.getMaKhachHang() 
				+ "', '" + tran.getMaNhanVien() + "', '" + insertNgb + "');";	

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

public boolean deleteTransaction(Long transId) {
	String queryStr = "delete from GIAODICH where MaGiaoDich = " + transId;
	try {
		update(queryStr);
		System.out.println("deleted " + transId);
		return true;
	} catch (SQLException e) {
		e.printStackTrace();
		return false;
	}
}

	public boolean updateTransaction(Transaction tran) {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-mm-dd");
		String newNgb = df.format(tran.getNgayBan());
		
		String queryStr = "update GIAODICH set "
				+ "MaVe = '" + tran.getMaVe() + "', MaKhachHang = '" + tran.getMaKhachHang() + "', "
				+ "MaNhanVien = '" + tran.getMaNhanVien() + "'"
				+ "NgayBan = '" + newNgb + "';";
		try {
			update(queryStr);
			System.err.println("Updated " + tran.getMaGiaoDich());
		}
		catch (SQLException e) {
			e.printStackTrace();
			return false;
		}		
		return true;
	}

	public Transaction getTransaction(long transId) {
		String queryStr = "select * from GIAODICH where MaGiaoDich=" + transId;
		Transaction trans = null;
		try {
			ResultSet rs = execute(queryStr);
			if (rs.next()) {
				trans = getTransactionFromQueryResult(rs);
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return trans;
	}

	private Transaction getTransactionFromQueryResult(ResultSet rs) throws SQLException {
		Transaction trans;
		long maGd = rs.getLong("MaGiaoDich");
		String maVe = rs.getString("MaVe");
		String maKh = rs.getString("MaKhachHang");
		String maNv = rs.getString("MaNhanVien");
		Date ngayBan = rs.getDate("NgayBan");
		
		trans = new Transaction(maGd, maVe, maKh, maNv, ngayBan);
		trans.setMaGiaoDich(maGd);
		trans.setMaVe(maVe);
		trans.setMaKhachHang(maKh);
		trans.setMaNhanVien(maNv);
		trans.setNgayBan(ngayBan);
		return trans;
	}
	
	public ArrayList<Transaction> getTransactionList() {
		String queryStr = "select * from GIAODICH;";
		ArrayList<Transaction> transactions = new ArrayList<Transaction>();
		
		try {
			ResultSet rs = execute(queryStr);
			while (rs.next()) {
				transactions.add(getTransactionFromQueryResult(rs));
			}
		}
		catch (SQLException ex) {
			ex.printStackTrace();
		}		
		return transactions;
		
	}

	public ArrayList<Transaction> searchBy(String type, String searchContent) {
		String queryStr = "select * from GIAODICH where " + type + "= '"  + searchContent + "';";
		ArrayList<Transaction> transactions = new ArrayList<Transaction>();
		try {
			ResultSet rs = execute(queryStr);
			while (rs.next()) {
				long maGd = rs.getLong("MaGiaoDich");
				String maVe = rs.getString("MaVe");
				String maKh = rs.getString("MaKhachHang");
				String maNv = rs.getString("MaNhanVien");
				Date ngayBan = rs.getDate("NgayBan");
				
				Transaction trans = new Transaction(maGd, maVe, maKh, maNv, ngayBan);
				transactions.add(trans);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return transactions;
	}

}
