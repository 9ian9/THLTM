package Model.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import JDBC.JDBCUtil;
import Model.BEAN.Faculity;

public class FaculityDAO {
	public ArrayList<Faculity> getAllListFaculity() throws SQLException
	{
		ArrayList<Faculity> result = new ArrayList<Faculity>();
		
		Connection Conn = JDBCUtil.getConnection(); 
		
		//Bước 3 : Thực hiện câu lệnh truy vấn 
		Statement stmt = Conn.createStatement();
		String sqlCommand = "SELECT * FROM faculities";
		ResultSet rs = stmt.executeQuery(sqlCommand); 
		
		//Bước 4 : Xem thong tin cua bang
		while(rs.next())
		{
			result.add(new Faculity(rs.getInt("id"), rs.getString("name")));
		}
		
		rs.close();
		stmt.close();
		
		JDBCUtil.closeConnection(Conn);
		
		return result;
	}
	public int insert(Faculity newItem) throws SQLException, ClassNotFoundException {
	    Connection con = JDBCUtil.getConnection();

	    String command = "INSERT INTO faculities (name) VALUES (?)";
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
		
		String command = "DELETE FROM faculities WHERE id = ?";
		PreparedStatement psm = con.prepareStatement(command);
		
		psm.setInt(1, id);
		
		int executedRow = psm.executeUpdate(); 
		
		psm.close();
		
		JDBCUtil.closeConnection(con);
		return executedRow;
	}
	public int update(Faculity t) throws SQLException, ClassNotFoundException {
		
		Connection con = JDBCUtil.getConnection();
		
		String command = "UPDATE faculities SET name = ? WHERE id = ?";
		PreparedStatement psm = con.prepareStatement(command);
			
		psm.setInt(2, t.getId());
		psm.setString(1, t.getName());
	
		int executedRow = psm.executeUpdate(); 
		
		psm.close();
		
		JDBCUtil.closeConnection(con);
		return executedRow;
	}
	public Faculity getFaculityById(int id) throws SQLException
	{
		Faculity result = new Faculity();
		
		Connection Conn = JDBCUtil.getConnection(); 
		
		//Bước 3 : Thực hiện câu lệnh truy vấn 
		Statement stmt = Conn.createStatement();
		String sqlCommand = "SELECT * FROM faculities where id = " + id;
		ResultSet rs = stmt.executeQuery(sqlCommand); 
		
		//Bước 4 : Xem thong tin cua bang
		while(rs.next())
		{
			result = new Faculity(rs.getInt("id"), rs.getString("name"));
		}
		
		rs.close();
		stmt.close();
		
		JDBCUtil.closeConnection(Conn);
		
		return result;
	}
	
	public boolean checkFaculityName(String name) throws SQLException
	{
		boolean result = false;
		
		Connection Conn = JDBCUtil.getConnection(); 
		
		//Bước 3 : Thực hiện câu lệnh truy vấn 
		Statement stmt = Conn.createStatement();
		String sqlCommand = "SELECT * FROM faculities ";
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
