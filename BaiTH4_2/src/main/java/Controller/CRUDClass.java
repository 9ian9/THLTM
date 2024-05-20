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
import Model.BEAN.Grade;
import Model.BO.ClassBO;
import Model.BO.FaculityBO;

/**
 * Servlet implementation class CRUDClass
 */
@WebServlet("/CRUDClass")
public class CRUDClass extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private ClassBO classBO = new ClassBO();
    private FaculityBO faculityBO = new FaculityBO();
    public CRUDClass() {
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
				
				String destination = "/Admin/editClass.jsp";
				RequestDispatcher rd = getServletContext().getRequestDispatcher(destination);
				rd.forward(request, response);
			}
			else if(mode == 3)
			{
				int id = Integer.parseInt(request.getParameter("id") +"");
				
				request.setAttribute("mode", mode);
				request.setAttribute("updateClass", classBO.getClassById(id));
				request.setAttribute("faculityInfo", faculityBO.getFaculityById(faculityId));
				
				String destination = "/Admin/editClass.jsp";
				RequestDispatcher rd = getServletContext().getRequestDispatcher(destination);
				rd.forward(request, response);
			}
			else if(mode == 4)
			{
				int id = Integer.parseInt(request.getParameter("id") +"");
			
				classBO.delete(id);
				
				ArrayList<Grade> listGrade = classBO.getAllClassByFaculityId(faculityId);
				
				request.setAttribute("listClass", listGrade);
				request.setAttribute("faculity", faculityBO.getFaculityById(faculityId));
				
				String destination = "/Admin/listClass.jsp";
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
				
				if(classBO.checkClassName(name, faculityId))
				{
					request.setAttribute("mode", mode);
					request.setAttribute("updateClass", new Grade(-1, name, faculityId));
					request.setAttribute("faculityInfo", faculityBO.getFaculityById(faculityId));
					request.setAttribute("errorMessage", "this name is already existed in this faculity, please choose another name");
				
					String destination = "/Admin/editClass.jsp";
					RequestDispatcher rd = getServletContext().getRequestDispatcher(destination);
					rd.forward(request, response);
				}

				System.out.println(classBO.insert(new Grade(-1, name, faculityId)));
			}
			else if(mode == 3)
			{
				String name = request.getParameter("name");
				int id = Integer.parseInt(request.getParameter("id") +"");
				
				if(classBO.checkClassName(name, faculityId))
				{
					request.setAttribute("mode", mode);
					request.setAttribute("updateClass", new Grade(id, name, faculityId));
					request.setAttribute("faculityInfo", faculityBO.getFaculityById(faculityId));
					request.setAttribute("errorMessage", "this name is already existed in this faculity, please choose another name");
				
					String destination = "/Admin/editClass.jsp";
					RequestDispatcher rd = getServletContext().getRequestDispatcher(destination);
					rd.forward(request, response);
				}
				classBO.update(new Grade(id, name, faculityId));
			}
		

			ArrayList<Grade> listGrade = classBO.getAllClassByFaculityId(faculityId);
			
			request.setAttribute("listClass", listGrade);
			request.setAttribute("faculity", faculityBO.getFaculityById(faculityId));
			
			String destination = "/Admin/listClass.jsp";
			RequestDispatcher rd = getServletContext().getRequestDispatcher(destination);
			rd.forward(request, response);
		}
		catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
