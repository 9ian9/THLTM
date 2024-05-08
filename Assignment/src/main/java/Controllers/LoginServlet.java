package Controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Models.M_User;
import Models.Entity.E_User;
import Models.JDBC.DB_Connection;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServerlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        try {

            String username = request.getParameter("user");
            String password = request.getParameter("pass");

            E_User inputUser = new E_User(0, username, password, "", "");
            
            E_User dbUser = M_User.validLogin(inputUser);
            
            
            if (username.equals(dbUser.getUsername()) && password.equals(dbUser.getPassword())) {
            	
            	HttpSession session = request.getSession();
            	session.setAttribute("LogedInUserName", username);
            	
            	session.setAttribute("LogedInUserType", dbUser.getType());
            	
            	if(dbUser.getType().equals("owner")) {
            		session.setAttribute("LogedInOwnerName", username);
            		
            		out.println("<script type=\"text/javascript\">");
                    out.println("location='owner/home.jsp';");
                    out.println("</script>");
            	}
            	else if(dbUser.getType().equals("manager")) {
            		session.setAttribute("LogedInManagerName", username);
            		
            		out.println("<script type=\"text/javascript\">");
                    out.println("location='manager/home.jsp';");
                    out.println("</script>");
            	}
            	else {
            		session.setAttribute("LogedInUserName", username);
            		
            		out.println("<script type=\"text/javascript\">");
                    out.println("location='user/home.jsp';");
                    out.println("</script>");
            	}
                
                
            } else {
                out.println("<script type=\"text/javascript\">");
                out.println("alert('Username Or Password is wrong !!');");
                out.println("location='login.jsp';");
                out.println("</script>");
            }

        } catch (SQLException ex) {
            out.println(ex);
        } catch (ClassNotFoundException ex) {
            out.println(ex);
        }
	}

}
