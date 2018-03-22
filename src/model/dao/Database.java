/**
 * 
 */
package model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import net.ucanaccess.jdbc.UcanaccessDriver;

public class Database {
	Connection connection = null;
	Statement statement = null;
	private String dbName = "qlpvdb";
	/**
	 * Khi tạo mới đối tượng Database sẽ tự động tìm và nạp driver cũng như CSDL
	 */
	public Database() {
//		String connectionURL = "jdbc:mysql://localhost:3306/" + dbName + "?useUnicode=true&characterEncoding=UTF-8";
//		try {
//			// register drive sql jdbc
//			Class.forName("com.mysql.jdbc.Driver");
//			// create connection;
//			connection = (Connection) DriverManager.getConnection(connectionURL, "root", "");
//			statement = connection.createStatement();
//			// System.out.println("Connection is OK");
//		} catch (SQLException | ClassNotFoundException e) {
//			System.err.println("[Database constructor] Lỗi: " + e);
//		}
		
		 try {
		 Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
		 // Đường dẫn ở thư mục mã nguồn, để test CSDL
		 String address = UcanaccessDriver.URL_PREFIX
		 + "E:/Projects/10-VtcLucky/Viduvegit/WebContent/WEB-INF/QLPV.accdb";
		
		 connection = DriverManager.getConnection(address);
		 statement = connection.createStatement();
		 } catch (Exception e) {
		 System.err.println("[Database constructor] Lỗi: " + e);
		 }
	}

	public int update(String query) throws SQLException {
		return statement.executeUpdate(query);
	}

	public ResultSet execute(String query) throws SQLException {
		ResultSet resultSet = statement.executeQuery(query);
		return resultSet;
	}

	public void close() throws SQLException {
		if (statement != null) {
			statement.close();
		}
		if (connection != null) {
			connection.close();
		}
	}

}
