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

public class AccountDAO {
	public ArrayList<Account> getAllListAccount() throws SQLException
	{
		ArrayList<Account> result = new ArrayList<Account>();
		
		Connection Conn = JDBCUtil.getConnection(); 
		
		//Bước 3 : Thực hiện câu lệnh truy vấn 
		Statement stmt = Conn.createStatement();
		String sqlCommand = "SELECT * FROM accounts";
		ResultSet rs = stmt.executeQuery(sqlCommand); 
		
		//Bước 4 : Xem thong tin cua bang
		while(rs.next())
		{
			result.add(new Account(rs.getInt("id"), rs.getString("username"), rs.getString("password"), rs.getInt("role")));
		}
		
		rs.close();
		stmt.close();
		
		JDBCUtil.closeConnection(Conn);
		
		return result;
	}
	public Account checkAccount(String username, String password) throws ClassNotFoundException, SQLException {
		Account result = null;
		
		Connection Conn = JDBCUtil.getConnection(); 
		
		//Bước 3 : Thực hiện câu lệnh truy vấn 
		Statement stmt = Conn.createStatement();
		String sqlCommand = "SELECT * FROM accounts";
		ResultSet rs = stmt.executeQuery(sqlCommand); 
		
		//Bước 4 : Xem thong tin cua bang
		while(rs.next())
		{
			if(username.equals(rs.getString("username")) &&  password.equals(rs.getString("password"))) {
				result= new Account(rs.getInt("id"), rs.getString("username"), rs.getString("password"), rs.getInt("role"));
				break;
			}
		}
		
		rs.close();
		stmt.close();
		
		JDBCUtil.closeConnection(Conn);
		
		return result;
	}
	public int insert(Account newItem) throws SQLException, ClassNotFoundException {
	    Connection con = JDBCUtil.getConnection();

	    String command = "INSERT INTO accounts (username, password, role) VALUES (?, ?, ?)";
	    PreparedStatement psm = con.prepareStatement(command, Statement.RETURN_GENERATED_KEYS);

	    psm.setString(1, newItem.getUsername());
	    psm.setString(2, newItem.getPassword());
	    psm.setInt(3, newItem.getRole());

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
		
		String command = "DELETE FROM accounts WHERE id = ?";
		PreparedStatement psm = con.prepareStatement(command);
		
		psm.setInt(1, id);
		
		int executedRow = psm.executeUpdate(); 
		
		psm.close();
		
		JDBCUtil.closeConnection(con);
		return executedRow;
	}
	public int update(Account t) throws SQLException, ClassNotFoundException {
		
		Connection con = JDBCUtil.getConnection();
		
		String command = "UPDATE accounts SET username = ?, password = ?, role = ? WHERE id = ?";
		PreparedStatement psm = con.prepareStatement(command);
			
		psm.setInt(4, t.getId());
		psm.setString(1, t.getUsername());
		psm.setString(2, t.getPassword());
		psm.setInt(3, t.getRole());
	
		int executedRow = psm.executeUpdate(); 
		
		psm.close();
		
		JDBCUtil.closeConnection(con);
		return executedRow;
	}
	public Account getAccountById(int id) throws SQLException
	{
		Account result = new Account();
		
		Connection Conn = JDBCUtil.getConnection(); 
		
		//Bước 3 : Thực hiện câu lệnh truy vấn 
		Statement stmt = Conn.createStatement();
		String sqlCommand = "SELECT * FROM accounts where id = " + id;
		ResultSet rs = stmt.executeQuery(sqlCommand); 
		
		//Bước 4 : Xem thong tin cua bang
		while(rs.next())
		{
			result = new Account(rs.getInt("id"), rs.getString("username"), rs.getString("password"), rs.getInt("role"));
		}
		
		rs.close();
		stmt.close();
		
		JDBCUtil.closeConnection(Conn);
		
		return result;
	}
	
	public boolean checkAccountName(String name) throws SQLException
	{
		boolean result = false;
		
		Connection Conn = JDBCUtil.getConnection(); 
		
		//Bước 3 : Thực hiện câu lệnh truy vấn 
		Statement stmt = Conn.createStatement();
		String sqlCommand = "SELECT * FROM accounts ";
		ResultSet rs = stmt.executeQuery(sqlCommand); 
		
		//Bước 4 : Xem thong tin cua bang
		while(rs.next())
		{
			if(name.equals(rs.getString("username")))
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
