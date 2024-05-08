package model.BO;

import java.sql.SQLException;
import java.util.ArrayList;

import model.Bean.Wife;
import model.DAO.CheckLoginDAO;

public class CheckLoginBO {
	CheckLoginDAO checkLoginDAO = new CheckLoginDAO();
	
	public boolean isValidUser(String username, String password) throws ClassNotFoundException, SQLException
	{
		
		return checkLoginDAO.isExistUser(username, password);
	}
	
	public ArrayList<Wife> getWifeList(String username)
	{
		return checkLoginDAO.getWifeList(username);
	}
}
