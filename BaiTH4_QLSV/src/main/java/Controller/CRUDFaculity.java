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
import Model.BO.AccountBO;
import Model.BO.FaculityBO;

/**
 * Servlet implementation class CRUDFaculity
 */
@WebServlet("/CRUDFaculity")
public class CRUDFaculity extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private FaculityBO faculityBO = new FaculityBO();  
	
	public CRUDFaculity() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			int mode = Integer.parseInt(request.getParameter("mode") + "");
			if(mode == 1)
			{
				request.setAttribute("mode", mode);
				
				String destination = "/Admin/editFaculity.jsp";
				RequestDispatcher rd = getServletContext().getRequestDispatcher(destination);
				rd.forward(request, response);
			}
			else if(mode == 3)
			{
				int id = Integer.parseInt(request.getParameter("id") +"");
				
				request.setAttribute("mode", mode);
				request.setAttribute("updateFaculity", faculityBO.getFaculityById(id));
				
				String destination = "/Admin/editFaculity.jsp";
				RequestDispatcher rd = getServletContext().getRequestDispatcher(destination);
				rd.forward(request, response);
			}
			else if(mode == 4)
			{
				int id = Integer.parseInt(request.getParameter("id") +"");
			
				faculityBO.delete(id);
				
				ArrayList<Faculity> listFaculity = faculityBO.getAllFaculity();
				
				request.setAttribute("listFaculity", listFaculity);
				
				String destination = "/Admin/homepage.jsp";
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
			if(mode == 1)
			{
				String name = request.getParameter("name");
				
				if(faculityBO.checkFaculityName(name))
				{
					request.setAttribute("mode", mode);
					request.setAttribute("updateFaculity", new Faculity(-1, name));
					request.setAttribute("errorMessage", "this name is already existed, please choose another name");
				
					String destination = "/Admin/editFaculity.jsp";
					RequestDispatcher rd = getServletContext().getRequestDispatcher(destination);
					rd.forward(request, response);
				}

				System.out.println(faculityBO.insert(new Faculity(-1, name)));
			}
			else if(mode == 3)
			{
				String name = request.getParameter("name");
				int id = Integer.parseInt(request.getParameter("id") +"");
				
				if(faculityBO.checkFaculityName(name))
				{
					request.setAttribute("mode", mode);
					request.setAttribute("updateFaculity", new Faculity(id, name));
					request.setAttribute("errorMessage", "this name is already existed, please choose another name");
				
					String destination = "/Admin/editFaculity.jsp";
					RequestDispatcher rd = getServletContext().getRequestDispatcher(destination);
					rd.forward(request, response);
				}
				faculityBO.update(new Faculity(id, name));
			}
		

			ArrayList<Faculity> listFaculity = faculityBO.getAllFaculity();
			
			request.setAttribute("listFaculity", listFaculity);
			
			String destination = "/Admin/homepage.jsp";
			RequestDispatcher rd = getServletContext().getRequestDispatcher(destination);
			rd.forward(request, response);
		}
		catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
