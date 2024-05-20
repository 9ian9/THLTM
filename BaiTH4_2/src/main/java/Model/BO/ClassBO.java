package Model.BO;

import java.sql.SQLException;
import java.util.ArrayList;

import Model.BEAN.Account;
import Model.BEAN.Grade;
import Model.DAO.ClassDAO;

public class ClassBO {
	ClassDAO classDAO = new ClassDAO();
	
	public ArrayList<Grade> getAllClassByFaculityId (int faculityId) throws SQLException
	{
		return classDAO.getAllGradeByFaculityId(faculityId);
	}
	
	public Grade getClassById (int classId) throws SQLException
	{
		return classDAO.getGradeById(classId);
	}
	
	public int insert(Grade newItem) throws ClassNotFoundException, SQLException
	{
		return classDAO.insert(newItem);
	}
	
	public int delete (int id) throws ClassNotFoundException, SQLException
	{
		return classDAO.delete(id);
	}
	
	public int update (Grade newItem) throws ClassNotFoundException, SQLException
	{
		return classDAO.update(newItem);
	}

	public boolean checkClassName(String name, int faculityId) throws SQLException
	{
		return classDAO.checkClassName(name, faculityId);
	}
}
