package model.bo;
import model.dao.*;
import java.sql.SQLException;
import java.util.ArrayList;
import model.bean.*;
public class DepartmentBO {
	DepartmentDAO departmentDAO = new DepartmentDAO();
	
	public ArrayList<Department> getAllDepartment() throws SQLException
	{
		return departmentDAO.getAllListFaculity();
	}
	
	public Department getDepartmentById(int id) throws SQLException
	{
		return departmentDAO.getDepartmentById(id);
	}
	
	public int insert(Department newItem) throws ClassNotFoundException, SQLException
	{
		return departmentDAO.insert(newItem);
	}
	
	public int delete (int id) throws ClassNotFoundException, SQLException
	{
		return departmentDAO.delete(id);
	}
	
	public int update (Department newItem) throws ClassNotFoundException, SQLException
	{
		return departmentDAO.update(newItem);
	}
	
	public boolean checkDepartmentName(String name) throws SQLException
	{
		return departmentDAO.checkDepartmentName(name);
	}
}
