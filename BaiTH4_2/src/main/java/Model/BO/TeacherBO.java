package Model.BO;

import java.sql.SQLException;
import java.util.ArrayList;

import Model.BEAN.Student;
import Model.BEAN.Teacher;
import Model.DAO.TeacherDAO;

public class TeacherBO {
	public TeacherDAO teacherDAO = new TeacherDAO();
	
	public int insert(Teacher newItem) throws ClassNotFoundException, SQLException
	{
		return teacherDAO.insert(newItem);
	}
	
	public int delete (int id) throws ClassNotFoundException, SQLException
	{
		return teacherDAO.delete(id);
	}
	
	public int update (Teacher newItem) throws ClassNotFoundException, SQLException
	{
		return teacherDAO.update(newItem);
	}
	public ArrayList<Teacher> getAllTeacherByFaculityId ( int FaculityId) throws SQLException
	{
		return teacherDAO.getAllTeacherByFaculityID(FaculityId);
	}
	public Teacher getTeacherById(int id) throws SQLException
	{
		return teacherDAO.getTeacherById(id);
	}
}
