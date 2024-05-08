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
import Models.JDBC.DB_Connection;

/**
 * Servlet implementation class DeleteRequestByManager
 */
@WebServlet("/DeletRequestByManager")
public class DeleteRequestByManager extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DeleteRequestByManager() {
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
			String room_id = request.getParameter("req_id");

			M_Room.deleteRoomById(room_id);

			out.println("<script type=\"text/javascript\">");
			out.println("alert('Delete Success !');");
			out.println("location='manager/allrequests.jsp';");
			out.println("</script>");

		} catch (SQLException ex) {
			out.println(ex);
		} catch (ClassNotFoundException ex) {
			out.println(ex);
		}
	}

}
