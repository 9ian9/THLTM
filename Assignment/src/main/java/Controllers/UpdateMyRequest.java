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
import Models.JDBC.DB_Connection;

/**
 * Servlet implementation class UpdateMyRequest
 */
@WebServlet("/UpdateMyRequest")
public class UpdateMyRequest extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UpdateMyRequest() {
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
			String update_adults = request.getParameter("Adults_update_input");
			String update_kids = request.getParameter("Kids_update_input");
			String update_checkIn = request.getParameter("CheckIn_update_input");
			String update_checkOut = request.getParameter("CheckOut_update_input");

			E_Room data = new E_Room();
			data.setId(Integer.parseInt(room_id));
			data.setAdults(Integer.parseInt(update_adults));
			data.setKids(Integer.parseInt(update_kids));
			data.setCheckIn(update_checkIn);
			data.setCheckOut(update_checkOut);

			M_Room.updateRequest(data);

			out.println("<script type=\"text/javascript\">");
			out.println("alert('Your Changes has been Saved !');");
			out.println("location='user/myrequests.jsp';");
			out.println("</script>");

		} catch (SQLException ex) {
			out.println(ex);
		} catch (ClassNotFoundException ex) {
			out.println(ex);
		}
	}

}
