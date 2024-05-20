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
 * Servlet implementation class ViewListTeacher
 */
@WebServlet("/ViewListTeacher")
public class ViewListTeacher extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private TeacherBO teacherBO = new TeacherBO();
	private FaculityBO faculityBO = new FaculityBO();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewListTeacher() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int faculityId = Integer.parseInt(request.getParameter("faculityId"));
		
		try {
			ArrayList<Teacher> listTeacher = teacherBO.getAllTeacherByFaculityId(faculityId);
			
			request.setAttribute("listTeacher", listTeacher);
			request.setAttribute("faculity", faculityBO.getFaculityById(faculityId));
			
			String destination = "/Admin/listTeacher.jsp";
			RequestDispatcher rd = getServletContext().getRequestDispatcher(destination);
			rd.forward(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
