package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import JDBC.JDBCUtil;
import model.bean.*;

public class DepartmentDAO {
	public ArrayList<Department> getAllListFaculity() throws SQLException
	{
		ArrayList<Department> result = new ArrayList<Department>();
		
		Connection Conn = JDBCUtil.getConnection(); 
		
		//Bước 3 : Thực hiện câu lệnh truy vấn 
		Statement stmt = Conn.createStatement();
		String sqlCommand = "SELECT * FROM department";
		ResultSet rs = stmt.executeQuery(sqlCommand); 
		
		//Bước 4 : Xem thong tin cua bang
		while(rs.next())
		{
			result.add(new Department(rs.getInt("id"), rs.getString("department_name")));
		}
		
		rs.close();
		stmt.close();
		
		JDBCUtil.closeConnection(Conn);
		
		return result;
	}
	public int insert(Department newItem) throws SQLException, ClassNotFoundException {
	    Connection con = JDBCUtil.getConnection();

	    String command = "INSERT INTO department (department_name) VALUES (?)";
	    PreparedStatement psm = con.prepareStatement(command, Statement.RETURN_GENERATED_KEYS);

	    psm.setString(1, newItem.getName());

	    int executedRow = psm.executeUpdate();

	    int generatedId = -1; // Default value if ID is not generated
	    if (executedRow > 0) {
	        ResultSet generatedKeys = psm.getGeneratedKeys();
	        if (generatedKeys.next()) {
	            generatedId = generatedKeys.getInt(1); // Get the generated ID
	        }
	        generatedKeys.close();
	    }

	    psm.close();
	    JDBCUtil.closeConnection(con);
	    return generatedId;
	}
	public int delete(int id) throws SQLException, ClassNotFoundException {
		
		Connection con = JDBCUtil.getConnection();
		
		String command = "DELETE FROM department WHERE id = ?";
		PreparedStatement psm = con.prepareStatement(command);
		
		psm.setInt(1, id);
		
		int executedRow = psm.executeUpdate(); 
		
		psm.close();
		
		JDBCUtil.closeConnection(con);
		return executedRow;
	}
	public int update(Department t) throws SQLException, ClassNotFoundException {
		
		Connection con = JDBCUtil.getConnection();
		
		String command = "UPDATE department SET department_name = ? WHERE id = ?";
		PreparedStatement psm = con.prepareStatement(command);
			
		psm.setInt(2, t.getId());
		psm.setString(1, t.getName());
	
		int executedRow = psm.executeUpdate(); 
		
		psm.close();
		
		JDBCUtil.closeConnection(con);
		return executedRow;
	}
	public Department getDepartmentById(int id) throws SQLException
	{
		Department result = new Department();
		
		Connection Conn = JDBCUtil.getConnection(); 
		
		//Bước 3 : Thực hiện câu lệnh truy vấn 
		Statement stmt = Conn.createStatement();
		String sqlCommand = "SELECT * FROM department where id = " + id;
		ResultSet rs = stmt.executeQuery(sqlCommand); 
		
		//Bước 4 : Xem thong tin cua bang
		while(rs.next())
		{
			result = new Department(rs.getInt("id"), rs.getString("department_name"));
		}
		
		rs.close();
		stmt.close();
		
		JDBCUtil.closeConnection(Conn);
		
		return result;
	}
	
	public boolean checkDepartmentName(String name) throws SQLException
	{
		boolean result = false;
		
		Connection Conn = JDBCUtil.getConnection(); 
		
		//Bước 3 : Thực hiện câu lệnh truy vấn 
		Statement stmt = Conn.createStatement();
		String sqlCommand = "SELECT * FROM department ";
		ResultSet rs = stmt.executeQuery(sqlCommand); 
		
		//Bước 4 : Xem thong tin cua bang
		while(rs.next())
		{
			if(name.equals(rs.getString("department_name")))
			{
				result=true;
				break;
			}
		}
		
		rs.close();
		stmt.close();
		
		JDBCUtil.closeConnection(Conn);
		
		return result;
	}
	
}
