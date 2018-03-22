package controller;
//Nhan
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TicketManager
 */
@WebServlet("/ticketmanager")
public class TicketManager extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public TicketManager() {
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
		request.setCharacterEncoding("UTF-8");

		String actionRequest = request.getParameter("action");
		if (actionRequest == null) {
			actionRequest = "";
		}
		
		switch (actionRequest) {
		case "findTicket": // "findAvailableTickets"
			// tim ve trong
			// chuyen toi man hinh tim ve trong
			break;
		case "search":
			// tim ve da ban
			break;
			
		case "updateOrDelete":
			// sua hoa xoa, chia 2 truong hop
			//String actionDetail = request.getParameter("actionDetail");
			
			break;
		
		case "print":
			// in ve
			// chuyen toi man hinh in ve
			break;
			
		case "":
			request.getRequestDispatcher("/WEB-INF/quan_ly_ban_ve.jsp").include(request, response);
			break;
		default:
			break;
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
