package controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.bean.Transaction;
import model.bo.TransactionBO;

/**
 * Servlet implementation class TransactionManager
 */
public class TransactionManager extends HttpServlet {
	private static final long serialVersionUID = 1L;
	TransactionBO transactionBO;
	ArrayList<Transaction> transactions = new ArrayList<Transaction>();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public TransactionManager() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		transactionBO = new TransactionBO();
		
		String requestParam = request.getParameter("action");
		if (requestParam == null) {
			requestParam = "";
		}

		Transaction trans;
		
		switch (requestParam) {
		case "redirAddTransaction":
			request.getRequestDispatcher("/WEB-INF/them_giao_dich.jsp").include(request, response);
			break;
			
		case "add_transaction":
			trans = getRequestTransaction(request);
			transactionBO.addTransaction(trans);
			
			response.sendRedirect("transactionmanager");
			break;
			
		case "updateOrDelete":
			String action = request.getParameter("actionDetail");
			if ("update".equals(action)) {
				trans = getRequestTransaction(request);
				transactionBO.updateTransaction(trans);
			}
			else {
				// delete				
				long transId = Long.parseLong(request.getParameter("transactionId"));
				transactionBO.deleteTransaction(transId);
			}
			response.sendRedirect("transactionmanager");
			break;
			
		case "search":
			String searchBy = request.getParameter("searchBy");
			String searchContent = request.getParameter("searchContent");
			ArrayList<Transaction> transactions = new ArrayList<Transaction>();
			switch (searchBy) {
			case "magiaodich":
				transactions = transactionBO.searchByMaGiaoDich(searchContent);
				break;
			case "mave":
				transactions = transactionBO.searchByMaVe(searchContent);
				break;
			case "makhachhang":
				transactions = transactionBO.searchByMaKhachHang(searchContent);
				break;
			case "manhanvien":
				transactions = transactionBO.searchByMaNhanVien(searchContent);
				break;
			}
			
			request.setAttribute("transactionList", transactions);
			request.getRequestDispatcher("/WEB-INF/quan_ly_giao_dich.jsp").include(request, response);
			break;
		case "":
			//HttpSession session = request.getSession();

			
			transactions = transactionBO.getTransactionList();
			request.setAttribute("transactionList", transactions);

			request.getRequestDispatcher("/WEB-INF/quan_ly_giao_dich.jsp").include(request, response);
			break;
		default:
			break;
		}

	}

	private Transaction getRequestTransaction(HttpServletRequest request) {
		long maGd = Long.parseLong(request.getParameter("magiaodich"));
		String maVe = request.getParameter("mave");
		String maKh = request.getParameter("makhachhang");
		String maNv = request.getParameter("manhanvien");
		SimpleDateFormat df = new SimpleDateFormat("yyyy-dd-mm");
		Date ngayBan = new Date(2018, 22, 3);
		try {
			ngayBan = new SimpleDateFormat("yyyy-mm-dd").parse(request.getParameter("ngayban"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		Transaction trans = new Transaction(maGd, maVe, maKh, maNv, ngayBan);
		//trans.setPersonId(personId);
		//trans.setPassport(passport);
		return trans;
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
