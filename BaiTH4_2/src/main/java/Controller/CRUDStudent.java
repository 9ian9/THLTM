package Controller;

import java.io.Console;
import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.BEAN.Account;
import Model.BEAN.Grade;
import Model.BEAN.Student;
import Model.BEAN.Teacher;
import Model.BO.AccountBO;
import Model.BO.ClassBO;
import Model.BO.StudentBO;

/**
 * Servlet implementation class CRUDStudent
 */
@WebServlet("/CRUDStudent")
public class CRUDStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private StudentBO studentBO = new StudentBO();
	private ClassBO classBO = new ClassBO();
	private AccountBO accountBO = new AccountBO();
	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy"); // Định dạng của chuỗi ngày

	public CRUDStudent() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			int mode = Integer.parseInt(request.getParameter("mode") + "");
			
			if(mode == 1)
			{
				int classId = Integer.parseInt(request.getParameter("classId") + "");
				request.setAttribute("mode", mode);
				request.setAttribute("classInfo", classBO.getClassById(classId));
				
				String destination = "/Admin/editStudent.jsp";
				RequestDispatcher rd = getServletContext().getRequestDispatcher(destination);
				rd.forward(request, response);
			}
			else if(mode == 3)
			{
				int id = Integer.parseInt(request.getParameter("id") +"");
			
				Student updateStudent = studentBO.getStudentById(id);
				
				request.setAttribute("mode", mode);
				request.setAttribute("updateStudent", updateStudent);
				request.setAttribute("updateAccount", accountBO.getAccountById(updateStudent.getAccountId()));
				request.setAttribute("classInfo", classBO.getClassById(updateStudent.getClassId()));
				
				String destination = "/Admin/editStudent.jsp";
				RequestDispatcher rd = getServletContext().getRequestDispatcher(destination);
				rd.forward(request, response);
			}
			else if(mode == 4)
			{
				int id = Integer.parseInt(request.getParameter("id") +"");
				int classId = Integer.parseInt(request.getParameter("classId"));
				int faculityId = Integer.parseInt(request.getParameter("faculityId"));
				
				studentBO.delete(id);
				
				ArrayList<Student> listStudent = studentBO.getAllStudentByClassId(classId);
				
				request.setAttribute("listStudent", listStudent);
				request.setAttribute("faculityId", faculityId);
				request.setAttribute("classInfo", classBO.getClassById(classId));
				
				String destination = "/Admin/listStudent.jsp";
				RequestDispatcher rd = getServletContext().getRequestDispatcher(destination);
				rd.forward(request, response);
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			int mode = Integer.parseInt(request.getParameter("mode") + "");
			int classId = Integer.parseInt(request.getParameter("classId") + "");
			int yearStudent = Integer.parseInt(request.getParameter("yearOfStudent"));
			String name = request.getParameter("name") + "";
			LocalDate birthday = LocalDate.parse(request.getParameter("birthday"), formatter);
			String gender = request.getParameter("gender");
			String tel = request.getParameter("tel");
			String email = request.getParameter("email");
			String accountUserName = request.getParameter("username");
			String accountPassword = request.getParameter("password");
			Grade classInfo = classBO.getClassById(classId);
			
			if(mode == 1)
			{
				if(accountBO.checkAccountName(accountUserName))
				{
					ArrayList<Student> listStudent = studentBO.getAllStudentByClassId(classId);
					
					request.setAttribute("listStudent", listStudent);
					request.setAttribute("faculityId", classInfo.getFaculityId());
					request.setAttribute("classInfo", classInfo);
					request.setAttribute("updateStudent", new Student(-1, name, birthday, gender, tel, email, yearStudent, classId, -1));
					request.setAttribute("updateAccount", new Account(-1, accountUserName, accountPassword, 2));
					request.setAttribute("errorMessage", "this account's username are already existed, please choose another username");
					request.setAttribute("mode", 1);
					
					String destination = "/Admin/listStudent.jsp";
					RequestDispatcher rd = getServletContext().getRequestDispatcher(destination);
					rd.forward(request, response);
				}
				
				int accountId =  accountBO.insert(new Account(-1, accountUserName, accountPassword, 2));
				System.out.println(studentBO.insert(new Student(-1, name, birthday, gender, tel, email, yearStudent, classId, accountId)));
			}
			else if(mode == 3)
			{
				int id = Integer.parseInt(request.getParameter("id"));
				Student studentInfo = studentBO.getStudentById(id);
			
				if(accountBO.checkAccountName(accountUserName))
				{
					ArrayList<Student> listStudent = studentBO.getAllStudentByClassId(classId);
					
					request.setAttribute("listStudent", listStudent);
					request.setAttribute("faculityId", classInfo.getFaculityId());
					request.setAttribute("classInfo", classInfo);
					request.setAttribute("updateStudent", new Student(id, name, birthday, gender, tel, email, yearStudent, classId, studentInfo.getAccountId()));
					request.setAttribute("updateAccount", new Account(studentInfo.getAccountId(), accountUserName, accountPassword, 2));
					request.setAttribute("errorMessage", "this account's username are already existed, please choose another username");
					request.setAttribute("mode", 1);
					
					String destination = "/Admin/listStudent.jsp";
					RequestDispatcher rd = getServletContext().getRequestDispatcher(destination);
					rd.forward(request, response);
				}
				
				accountBO.update(new Account(studentInfo.getAccountId(), accountUserName, accountPassword, 1));
				studentBO.update(new Student(id, name, birthday, gender, tel, email, yearStudent, classId, studentInfo.getAccountId()));
			}
			
			ArrayList<Student> listStudent = studentBO.getAllStudentByClassId(classId);
			
			request.setAttribute("listStudent", listStudent);
			request.setAttribute("faculityId", classInfo.getFaculityId());
			request.setAttribute("classInfo", classBO.getClassById(classId));
			
			String destination = "/Admin/listStudent.jsp";
			RequestDispatcher rd = getServletContext().getRequestDispatcher(destination);
			rd.forward(request, response);
		
		}
		catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
