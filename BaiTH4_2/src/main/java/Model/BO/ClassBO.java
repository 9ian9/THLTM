package Model.BO;

import java.sql.SQLException;
import java.util.ArrayList;

import Model.BEAN.Grade;
import Model.DAO.ClassDAO;

public class ClassBO {
	ClassDAO classDAO = new ClassDAO();
	
	public ArrayList<Grade> getAllClassByFaculityId (int faculityId) throws SQLException
	{
		return classDAO.getAllGradeByFaculityId(faculityId);
	}
	
}
