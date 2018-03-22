package controller;

import java.io.IOException;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bean.User;
import model.bo.UserBO;

/**
 * Servlet implementation class UserManager
 */
public class UserManager extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserBO userBO;
	private ArrayList<User> users = new ArrayList<User>();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UserManager() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		userBO = new UserBO();
		String action = request.getParameter("action");
		if (action == null) {
			action = "";
		}

		switch (action) {

		case "redirAddUsers":
			request.getRequestDispatcher("/WEB-INF/them_nhan_vien.jsp").include(request, response);
			break;

		case "addUser":
			User cus = getRequestUser(request);
			userBO.addUser(cus);

			response.sendRedirect("usermanager");
			break;

		case "updateOrDelete":
			
			String actionDetail = request.getParameter("actionDetail");
			if ("update".equals(actionDetail)) {
				User upUser = getRequestUser(request);
				userBO.updateUser(upUser);
			} else {
				// delete
				userBO.deleteUser(request.getParameter("userId"));
			}
			response.sendRedirect("usermanager");
			break;

		case "search":
			String searchBy = request.getParameter("searchBy");
			String searchContent = request.getParameter("searchContent");
			ArrayList<User> users = new ArrayList<User>();
			switch (searchBy) {
			case "userId":
				users = userBO.searchById(searchContent);
				break;
			case "fullName":
				users = userBO.searchByName(searchContent);
				System.out.println(searchContent);
				break;
			case "phoneNumber":
				users = userBO.searchByPhoneNumber(searchContent);
				break;
			case "email":
				users = userBO.searchByEmail(searchContent);
				break;
			}

			request.setAttribute("userList", users);
			request.getRequestDispatcher("/WEB-INF/quan_ly_nhan_vien.jsp").include(request, response);
			break;

		case "":
			users = userBO.getUsers();

			request.setAttribute("userList", users);
			request.getRequestDispatcher("/WEB-INF/quan_ly_nhan_vien.jsp").include(request, response);

			break;
		default:
			break;

		}

	}

	private User getRequestUser(HttpServletRequest request) {
		String id = request.getParameter("userId");
		String fullName = request.getParameter("fullname");
		String password = request.getParameter("password");
		Date dob = new Date(2016, 23, 4);
		try {
			dob = new SimpleDateFormat("yyyy-mm-dd").parse(request.getParameter("dob"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		boolean isMale = ("F".equals(request.getParameter("gender"))) ? false : true;
		String email = request.getParameter("email");
		String phoneNumber = request.getParameter("phoneNumber");
		String privilege = request.getParameter("privilege");
		
		return new User(id, fullName, dob, isMale, email, password, phoneNumber, privilege);
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
