package Controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Models.M_Room;
import Models.Entity.E_Room;
import Models.Entity.E_User;
import Models.JDBC.DB_Connection;

/**
 * Servlet implementation class ReserveARoom
 */
@WebServlet("/ReserverARoom")
public class ReserverARoom extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ReserverARoom() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		try {
			String current_user_val = request.getParameter("current_user");
			String CheckIn_val = request.getParameter("CheckIn");
			String CheckOut_val = request.getParameter("CheckOut");
			String Adults_val = request.getParameter("Adults");
			String Kids_val = request.getParameter("Kids");

			E_Room data = new E_Room(0, CheckIn_val, CheckOut_val, Integer.parseInt(Adults_val),
					Integer.parseInt(Kids_val), 0, 0, current_user_val, null);

			M_Room.insertRoom(data);

			out.println("<script type=\"text/javascript\">");
			out.println("alert('Request Success !');");
			out.println("location='user/home.jsp';");
			out.println("</script>");

		} catch (SQLException ex) {
			out.println(ex);
		} catch (ClassNotFoundException ex) {
			out.println(ex);
		}
	}

}
