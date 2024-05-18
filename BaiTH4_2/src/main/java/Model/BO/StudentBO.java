package Model.BO;

import java.sql.SQLException;

import Model.BEAN.Student;
import Model.DAO.StudentDAO;

public class StudentBO {
	
	StudentDAO studentDAO = new StudentDAO();
	
	public Student getStudentInfoByAccountId(int accountId) throws SQLException {
		return studentDAO.getStudentInfoByAccountId(accountId);
	}
}
