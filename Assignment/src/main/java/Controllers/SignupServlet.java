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

import Models.M_User;
import Models.Entity.E_User;
import Models.JDBC.DB_Connection;

/**
 * Servlet implementation class SignupServlet
 */
@WebServlet("/SignupServerlet")
public class SignupServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SignupServlet() {
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
			String username = request.getParameter("newuser");
			String password = request.getParameter("newpass");
			String email = request.getParameter("newemail");
			String repassword = request.getParameter("newconpass");

			if (password.equals(repassword)) {

				E_User data = new E_User();
				data.setUsername(username);
				data.setEmail(email);
				data.setPassword(repassword);

				M_User.createAccount(data);

				out.println("<script type=\"text/javascript\">");
				out.println("alert('Registration Completed Successfully !!');");
				out.println("location='login.jsp';");
				out.println("</script>");
			} else {
				out.println("<script type=\"text/javascript\">");
				out.println("alert('Passwords missmatched !!');");
				out.println("location='signup.jsp';");
				out.println("</script>");
			}

		} catch (SQLException ex) {
			out.println(ex);
		} catch (ClassNotFoundException ex) {
			out.println(ex);
		}
	}

}
