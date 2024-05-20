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

import Model.BEAN.Faculity;
import Model.BEAN.Student;
import Model.BO.ClassBO;
import Model.BO.StudentBO;

/**
 * Servlet implementation class ViewListStudent
 */
@WebServlet("/ViewListStudent")
public class ViewListStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private StudentBO studentBO = new StudentBO();
	private ClassBO classBO = new ClassBO();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewListStudent() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			int classId = Integer.parseInt(request.getParameter("classId") + "");
			ArrayList<Student> listStudent = studentBO.getAllStudentByClassId(classId);
			
			request.setAttribute("classInfo", classBO.getClassById(classId));
			request.setAttribute("faculityId", request.getParameter("faculityId"));
			request.setAttribute("listStudent", listStudent);
			
			String destination = "/Admin/listStudent.jsp";
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
