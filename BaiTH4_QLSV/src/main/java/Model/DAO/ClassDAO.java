package Model.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import JDBC.JDBCUtil;
import Model.BEAN.Account;
import Model.BEAN.Faculity;
import Model.BEAN.Grade;

public class ClassDAO {
	public ArrayList<Grade> getAllGradeByFaculityId(int faculityId) throws SQLException
	{
		ArrayList<Grade> result = new ArrayList<Grade>();
		
		Connection Conn = JDBCUtil.getConnection(); 
		
		//Bước 3 : Thực hiện câu lệnh truy vấn 
		Statement stmt = Conn.createStatement();
		String sqlCommand = "SELECT * FROM classes where faculityId = " + faculityId;
		ResultSet rs = stmt.executeQuery(sqlCommand); 
		
		//Bước 4 : Xem thong tin cua bang
		while(rs.next())
		{
			result.add(new Grade(rs.getInt("id"), rs.getString("name"), rs.getInt("faculityId")));
		}
		
		rs.close();
		stmt.close();
		
		JDBCUtil.closeConnection(Conn);
		
		return result;
	}
	public int insert(Grade newItem) throws SQLException, ClassNotFoundException {
	    Connection con = JDBCUtil.getConnection();

	    String command = "INSERT INTO classes (name, faculityId) VALUES (?, ?)";
	    PreparedStatement psm = con.prepareStatement(command, Statement.RETURN_GENERATED_KEYS);

	    psm.setString(1, newItem.getName());
	    psm.setInt(2, newItem.getFaculityId());

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
		
		String command = "DELETE FROM classes WHERE id = ?";
		PreparedStatement psm = con.prepareStatement(command);
		
		psm.setInt(1, id);
		
		int executedRow = psm.executeUpdate(); 
		
		psm.close();
		
		JDBCUtil.closeConnection(con);
		return executedRow;
	}
	public int update(Grade t) throws SQLException, ClassNotFoundException {
		
		Connection con = JDBCUtil.getConnection();
		
		String command = "UPDATE classes SET name = ?, faculityId = ? WHERE id = ?";
		PreparedStatement psm = con.prepareStatement(command);
			
		psm.setInt(3, t.getId());
		psm.setString(1, t.getName());
		psm.setInt(2, t.getFaculityId());
	
		int executedRow = psm.executeUpdate(); 
		
		psm.close();
		
		JDBCUtil.closeConnection(con);
		return executedRow;
	}
	public Grade getGradeById(int id) throws SQLException
	{
		Grade result = new Grade();
		
		Connection Conn = JDBCUtil.getConnection(); 
		
		//Bước 3 : Thực hiện câu lệnh truy vấn 
		Statement stmt = Conn.createStatement();
		String sqlCommand = "SELECT * FROM classes where id = " + id;
		ResultSet rs = stmt.executeQuery(sqlCommand); 
		
		//Bước 4 : Xem thong tin cua bang
		while(rs.next())
		{
			result = new Grade(rs.getInt("id"), rs.getString("name"), rs.getInt("faculityId"));
		}
		
		rs.close();
		stmt.close();
		
		JDBCUtil.closeConnection(Conn);
		
		return result;
	}
	public boolean checkClassName(String name, int faculityId) throws SQLException
	{
		boolean result = false;
		
		Connection Conn = JDBCUtil.getConnection(); 
		
		//Bước 3 : Thực hiện câu lệnh truy vấn 
		Statement stmt = Conn.createStatement();
		String sqlCommand = "SELECT * FROM classes where faculityId = " + faculityId;
		ResultSet rs = stmt.executeQuery(sqlCommand); 
		
		//Bước 4 : Xem thong tin cua bang
		while(rs.next())
		{
			if(name.equals(rs.getString("name")))
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
