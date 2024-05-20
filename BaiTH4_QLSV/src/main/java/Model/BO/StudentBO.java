package Model.BO;

import java.sql.SQLException;
import java.util.ArrayList;

import Model.BEAN.Faculity;
import Model.BEAN.Student;
import Model.DAO.StudentDAO;

public class StudentBO {
	
	StudentDAO studentDAO = new StudentDAO();
	
	public Student getStudentInfoByAccountId(int accountId) throws SQLException {
		return studentDAO.getStudentInfoByAccountId(accountId);
	}
	
	public int insert(Student newItem) throws ClassNotFoundException, SQLException
	{
		return studentDAO.insert(newItem);
	}
	
	public int delete (int id) throws ClassNotFoundException, SQLException
	{
		return studentDAO.delete(id);
	}
	
	public int update (Student newItem) throws ClassNotFoundException, SQLException
	{
		return studentDAO.update(newItem);
	}
	
	public ArrayList<Student> getAllStudentByClassId (int classId) throws SQLException
	{
		return studentDAO.getAllStudentByClassID(classId);
	}
	public Student getStudentById(int id) throws SQLException
	{
		return studentDAO.getStudentById(id);
	}
}
