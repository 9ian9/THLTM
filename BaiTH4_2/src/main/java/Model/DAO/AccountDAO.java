package Model.DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import JDBC.JDBCUtil;
import Model.BEAN.Account;

public class AccountDAO {
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
	
}
