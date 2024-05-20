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

import Model.BEAN.Account;
import Model.BEAN.Faculity;
import Model.BO.AccountBO;

/**
 * Servlet implementation class CRUDAccount
 */
@WebServlet("/CRUDAccount")
public class CRUDAccount extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private AccountBO accountBO = new AccountBO();
    public CRUDAccount() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			int mode = Integer.parseInt(request.getParameter("mode") + "");
			if(mode == 1)
			{
				request.setAttribute("mode", mode);
				
				String destination = "/Admin/editAccount.jsp";
				RequestDispatcher rd = getServletContext().getRequestDispatcher(destination);
				rd.forward(request, response);
			}
			else if(mode == 3)
			{
				int id = Integer.parseInt(request.getParameter("id") +"");
				
				request.setAttribute("mode", mode);
				request.setAttribute("updateAccount", accountBO.getAccountById(id));
				
				String destination = "/Admin/editAccount.jsp";
				RequestDispatcher rd = getServletContext().getRequestDispatcher(destination);
				rd.forward(request, response);
			}
			else if(mode == 4)
			{
				int id = Integer.parseInt(request.getParameter("id") +"");
			
				accountBO.delete(id);
				
				ArrayList<Account> listAccount = accountBO.getAllAccount();
				
				request.setAttribute("listAccount", listAccount);
				
				String destination = "/Admin/listAccount.jsp";
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
				String username = request.getParameter("username");
				String password = request.getParameter("password");
				
				if(accountBO.checkAccountName(username, -1))
				{
					request.setAttribute("mode", mode);
					request.setAttribute("updateAccount", new Account(-1, username, password, 1));
					request.setAttribute("errorMessage", "this username is already existed, please choose another username");
				
					String destination = "/Admin/editAccount.jsp";
					RequestDispatcher rd = getServletContext().getRequestDispatcher(destination);
					rd.forward(request, response);
				}

				System.out.println(accountBO.insert(new Account(-1, username, password, 1)));
			}
			else if(mode == 3)
			{
				String username = request.getParameter("username");
				String password = request.getParameter("password");
				int id = Integer.parseInt(request.getParameter("id") +"");
				
				if(accountBO.checkAccountName(username, id))
				{
					request.setAttribute("mode", mode);
					request.setAttribute("updateAccount", new Account(id, username, password, 1));
					request.setAttribute("errorMessage", "this username is already existed, please choose another username");
				
					String destination = "/Admin/editAccount.jsp";
					RequestDispatcher rd = getServletContext().getRequestDispatcher(destination);
					rd.forward(request, response);
				}
				accountBO.update(new Account(id, username, password, 1));
			}
		

			ArrayList<Account> listAccount = accountBO.getAllAccount();
			
			request.setAttribute("listAccount", listAccount);
			
			String destination = "/Admin/listAccount.jsp";
			RequestDispatcher rd = getServletContext().getRequestDispatcher(destination);
			rd.forward(request, response);
		}
		catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
