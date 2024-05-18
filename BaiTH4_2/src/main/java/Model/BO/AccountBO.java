package Model.BO;

import java.sql.SQLException;

import Model.BEAN.Account;
import Model.DAO.AccountDAO;

public class AccountBO {
	AccountDAO accountDAO = new AccountDAO();
	
	public Account checkAccount(String username, String password) throws ClassNotFoundException, SQLException
	{
		return accountDAO.checkAccount(username, password);
	}
}
