package Controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.bean.*;
import model.bo.*;

/**
 * Servlet implementation class CheckLoginServlet
 */
@WebServlet("/CheckLoginServlet")
public class CheckLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	AccountBO accountBO = new AccountBO();
	DepartmentBO departmentBO = new DepartmentBO();
    public CheckLoginServlet() {
        // TODO Auto-generated constructor stub
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String destination = null;
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		HttpSession session = request.getSession();
		
		try {
			Account checkAccount = accountBO.checkAccount(username, password);
			if(checkAccount != null) {
				if(checkAccount.getRole() == 3)
				{
					ArrayList<Department> listFaculity = departmentBO.getAllDepartment();
					
					request.setAttribute("listDepartment", listFaculity);
					session.setAttribute("accountInfo", checkAccount);
					
					destination = "/Admin/homepage.jsp";
					RequestDispatcher rd = getServletContext().getRequestDispatcher(destination);
					rd.forward(request, response);
				}
				else
				{
//					System.out.println(checkAccount.getId());
//					Student studentInfo = studentBO.getStudentInfoByAccountId(checkAccount.getId());
//					
//					Grade classInfo = classBO.getClassById(studentInfo.getClassId());
//					Department faculityInfo = faculityBO.getFaculityById(classInfo.getFaculityId());
//					Account accountInfo = accountBO.getAccountById(studentInfo.getAccountId());
//					
//					request.setAttribute("accountInfo", accountInfo);
//					request.setAttribute("studentInfo", studentInfo);
//					request.setAttribute("classInfo", classInfo);
//					request.setAttribute("faculityInfo", faculityInfo);
//					
//					destination = "/Student/homepage.jsp";
//					RequestDispatcher rd = getServletContext().getRequestDispatcher(destination);
//					rd.forward(request, response);
				}
			}
			else
			{
				request.setAttribute("errorMessage", "Invalid username and password");
				destination = "/Login.jsp";
				RequestDispatcher rd = getServletContext().getRequestDispatcher(destination);
				rd.forward(request, response);
			}
		}catch ( ClassNotFoundException | SQLException | IOException e) {
			e.printStackTrace();
		}
	}

}
