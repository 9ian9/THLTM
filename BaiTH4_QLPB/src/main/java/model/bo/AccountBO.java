package model.bo;
import model.bean.*;
import java.sql.SQLException;
import java.util.ArrayList;

import model.dao.*;
public class AccountBO {
	AccountDAO accountDAO = new AccountDAO();
	
	public Account checkAccount(String username, String password) throws ClassNotFoundException, SQLException
	{
		return accountDAO.checkAccount(username, password);
	}
	
	public int insert(Account newItem) throws ClassNotFoundException, SQLException
	{
		return accountDAO.insert(newItem);
	}
	
	public int delete (int id) throws ClassNotFoundException, SQLException
	{
		return accountDAO.delete(id);
	}
	
	public int update (Account newItem) throws ClassNotFoundException, SQLException
	{
		return accountDAO.update(newItem);
	}
	public ArrayList<Account> getAllAccount() throws SQLException
	{
		return accountDAO.getAllListAccount();
	}
	
	public Account getAccountById(int id) throws SQLException
	{
		return accountDAO.getAccountById(id);
	}
	
	public boolean checkAccountName(String name, int accountId) throws SQLException
	{
		return accountDAO.checkAccountName(name, accountId);
	}
}
