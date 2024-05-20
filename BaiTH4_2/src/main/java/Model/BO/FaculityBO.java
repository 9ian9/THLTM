package Model.BO;

import java.sql.SQLException;
import java.util.ArrayList;

import Model.BEAN.Faculity;
import Model.BEAN.Grade;
import Model.DAO.FaculityDAO;

public class FaculityBO {
	FaculityDAO faculityDAO = new FaculityDAO();
	
	public ArrayList<Faculity> getAllFaculity() throws SQLException
	{
		return faculityDAO.getAllListFaculity();
	}
	
	public Faculity getFaculityById(int id) throws SQLException
	{
		return faculityDAO.getFaculityById(id);
	}
	
	public int insert(Faculity newItem) throws ClassNotFoundException, SQLException
	{
		return faculityDAO.insert(newItem);
	}
	
	public int delete (int id) throws ClassNotFoundException, SQLException
	{
		return faculityDAO.delete(id);
	}
	
	public int update (Faculity newItem) throws ClassNotFoundException, SQLException
	{
		return faculityDAO.update(newItem);
	}
	
	public boolean checkFaculityName(String name) throws SQLException
	{
		return faculityDAO.checkFaculityName(name);
	}
}
