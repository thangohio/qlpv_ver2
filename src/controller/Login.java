package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.bean.User;
import model.bo.LoginBO;

/**
 * Servlet implementation class Login
 */
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// variables

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Login() {
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
		response.setCharacterEncoding("UTF-8");

		PrintWriter out = response.getWriter();

		// Session to save user information
		HttpSession session = request.getSession(true);

		// check sent form
		String loginPressed = request.getParameter("loginPressed");
		if (loginPressed == null) {
			loginPressed = "";
		}

		String action = request.getParameter("action");
		if (action == null) {
			action = "";
		}

		if (action.equals("logout")) {
			session.invalidate();
			// request.getRequestDispatcher("login").include(request, response);
			response.sendRedirect("login");
		} else {

			switch (loginPressed) {
			case "yes": // check login
				LoginBO loginBO = new LoginBO();
				User user = null;
				String email = request.getParameter("email");
				String pass = request.getParameter("password");
				if (!loginBO.checkLogin(email, pass)) {
					// login fail
					out.println("Tài khoản hoặc mật khẩu sai! <br><a href=\"login\">Quay lại</a>");
				} else {
					// login successful
					user = loginBO.getCurrentUser();
					// save session
					session.setAttribute("currentUser", user);
					
					//request.setAttribute("currentUser", user);
					request.getRequestDispatcher("/home").include(request,
					 response);
				}
				break;
			case "":
				if (((User)session.getAttribute("currentUser")) != null) {
					response.sendRedirect("home");
				}
				else {
					request.getRequestDispatcher("WEB-INF/dang_nhap.jsp").include(request, response);
				}
				break;
			}

		}

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
