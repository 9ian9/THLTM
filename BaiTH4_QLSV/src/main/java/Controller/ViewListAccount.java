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
 * Servlet implementation class ViewListAccount
 */
@WebServlet("/ViewListAccount")
public class ViewListAccount extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private AccountBO accountBO = new AccountBO();

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewListAccount() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			ArrayList<Account> listAccount = accountBO.getAllAccount();
			
			request.setAttribute("listAccount", listAccount);
			
			String destination = "/Admin/listAccount.jsp";
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
