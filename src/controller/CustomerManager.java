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

import model.bean.Customer;
import model.bean.User;
import model.bo.CustomerBO;

/**
 * Servlet implementation class CustomerManager
 */
public class CustomerManager extends HttpServlet {
	private static final long serialVersionUID = 1L;
	CustomerBO customerBO;
	ArrayList<Customer> customers = new ArrayList<Customer>();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CustomerManager() {
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
		customerBO = new CustomerBO();
		
		String requestParam = request.getParameter("action");
		if (requestParam == null) {
			requestParam = "";
		}

		switch (requestParam) {
		case "redirAddCustomer":
			request.getRequestDispatcher("/WEB-INF/them_khach_hang.jsp").include(request, response);
			break;
			
		case "add_customer":
			Customer cus = getRequestCustomer(request);
			customerBO.addCustomer(cus);
			
			response.sendRedirect("customermanager");
			break;
			
		case "updateOrDelete":
			String action = request.getParameter("actionDetail");
			if ("update".equals(action)) {
				Customer ucus = getRequestCustomer(request);
				customerBO.updateCustomer(ucus);
			}
			else {
				// delete				
				customerBO.deleteCustomer(request.getParameter("customerId"));
			}
			response.sendRedirect("customermanager");
			break;
			
		case "search":
			String searchBy = request.getParameter("searchBy");
			String searchContent = request.getParameter("searchContent");
			ArrayList<Customer> customers = new ArrayList<Customer>();
			switch (searchBy) {
			case "customerId":
				customers = customerBO.searchById(searchContent);
				break;
			case "fullName":
				customers = customerBO.searchByName(searchContent);
				break;
			case "phoneNumber":
				customers = customerBO.searchByPhoneNumber(searchContent);
				break;
			case "email":
				customers = customerBO.searchByEmail(searchContent);
				break;
			}
			
			request.setAttribute("customerList", customers);
			request.getRequestDispatcher("/WEB-INF/quan_ly_khach_hang.jsp").include(request, response);
			break;
		case "":
			//HttpSession session = request.getSession();

			
			customers = customerBO.getCustomerList();
			request.setAttribute("customerList", customers);

			request.getRequestDispatcher("/WEB-INF/quan_ly_khach_hang.jsp").include(request, response);
			break;
		default:
			break;
		}

	}

	private Customer getRequestCustomer(HttpServletRequest request) {
		String id = request.getParameter("customerId");
		String fullname = request.getParameter("fullname");
		String customerId = request.getParameter("customerId");
		SimpleDateFormat df = new SimpleDateFormat("yyyy-dd-mm");
		Date dob = new Date(2016, 23, 4);
		try {
			dob = new SimpleDateFormat("yyyy-mm-dd").parse(request.getParameter("dob"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		String gender = request.getParameter("gender");
		String personId = request.getParameter("personId");
		String passport = request.getParameter("passport");
		String email = request.getParameter("email");
		String phoneNumber = request.getParameter("phoneNumber");
		
		boolean isMale = ("F".equals(gender)) ? false : true;
		Customer cus = new Customer(id, fullname, dob, isMale, email, phoneNumber);
		cus.setPersonId(personId);
		cus.setPassport(passport);
		return cus;
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
