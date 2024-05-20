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

import Model.BEAN.Grade;
import Model.BEAN.Teacher;
import Model.BO.FaculityBO;
import Model.BO.TeacherBO;

/**
 * Servlet implementation class CRUDTeacher
 */
@WebServlet("/CRUDTeacher")
public class CRUDTeacher extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private TeacherBO teacherBO = new TeacherBO();
    private FaculityBO faculityBO = new FaculityBO();
	public CRUDTeacher() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			int mode = Integer.parseInt(request.getParameter("mode") + "");
			int faculityId = Integer.parseInt(request.getParameter("faculityId") + "");
			
			if(mode == 1)
			{
				request.setAttribute("mode", mode);
				request.setAttribute("faculityInfo", faculityBO.getFaculityById(faculityId));
				
				String destination = "/Admin/editTeacher.jsp";
				RequestDispatcher rd = getServletContext().getRequestDispatcher(destination);
				rd.forward(request, response);
			}
			else if(mode == 3)
			{
				int id = Integer.parseInt(request.getParameter("id") +"");
				
				request.setAttribute("mode", mode);
				request.setAttribute("updateTeacher", teacherBO.getTeacherById(id));
				request.setAttribute("faculityInfo", faculityBO.getFaculityById(faculityId));
				
				String destination = "/Admin/editTeacher.jsp";
				RequestDispatcher rd = getServletContext().getRequestDispatcher(destination);
				rd.forward(request, response);
			}
			else if(mode == 4)
			{
				int id = Integer.parseInt(request.getParameter("id") +"");
			
				teacherBO.delete(id);
				
				ArrayList<Teacher> listTeacher = teacherBO.getAllTeacherByFaculityId(faculityId);
				
				request.setAttribute("listTeacher", listTeacher);
				request.setAttribute("faculity", faculityBO.getFaculityById(faculityId));
				
				String destination = "/Admin/listTeacher.jsp";
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
			int faculityId = Integer.parseInt(request.getParameter("faculityId") + "");
			
			if(mode == 1)
			{
				String name = request.getParameter("name");
				String email = request.getParameter("email");

				System.out.println(teacherBO.insert(new Teacher(-1, name, faculityId, email)));
			}
			else if(mode == 3)
			{
				String name = request.getParameter("name");
				String email = request.getParameter("email");
				int id = Integer.parseInt(request.getParameter("id") +"");
				
				teacherBO.update(new Teacher(id, name, faculityId, email));
			}
		

			ArrayList<Teacher> listTeacher = teacherBO.getAllTeacherByFaculityId(faculityId);
			
			request.setAttribute("listTeacher", listTeacher);
			request.setAttribute("faculity", faculityBO.getFaculityById(faculityId));
			
			String destination = "/Admin/listTeacher.jsp";
			RequestDispatcher rd = getServletContext().getRequestDispatcher(destination);
			rd.forward(request, response);
		}
		catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
