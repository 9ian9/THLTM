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

import Models.M_Message;
import Models.Entity.E_Message;
import Models.JDBC.DB_Connection;

/**
 * Servlet implementation class SendMessageByUser
 */
@WebServlet("/SendMessageByUser")
public class SendMessageByUser extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SendMessageByUser() {
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
			String senderName = request.getParameter("current_user");
			String message = request.getParameter("Message");
			String senderEmail = request.getParameter("Email");

			E_Message data = new E_Message(0, message, senderName, senderEmail);
			M_Message.insertMessage(data);

			out.println("<script type=\"text/javascript\">");
			out.println("alert('Message has benn Send ! ');");
			out.println("location='user/contact.jsp';");
			out.println("</script>");

		} catch (SQLException ex) {
			out.println(ex);
		} catch (ClassNotFoundException ex) {
			out.println(ex);
		}
	}

}
