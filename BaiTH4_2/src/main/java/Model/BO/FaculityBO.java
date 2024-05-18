package Model.BO;

import java.sql.SQLException;
import java.util.ArrayList;

import Model.BEAN.Faculity;
import Model.DAO.FaculityDAO;

public class FaculityBO {
	FaculityDAO faculityDAO = new FaculityDAO();
	public ArrayList<Faculity> getAllFaculity() throws SQLException
	{
		return faculityDAO.getAllListFaculity();
	}
}
