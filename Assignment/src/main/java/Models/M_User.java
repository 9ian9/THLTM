package Models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Models.Entity.E_User;
import Models.JDBC.DB_Connection;

public class M_User {
	public static E_User validLogin(E_User user) throws ClassNotFoundException, SQLException
	{
		DB_Connection obj_DB_Connection = new DB_Connection();
        Connection connection = obj_DB_Connection.get_connection();
        PreparedStatement ps = null;
        ResultSet rs = null;

        String sql = "select username,password,type from users where username=? and password=?";
        Class.forName("com.mysql.jdbc.Driver");
        ps = connection.prepareStatement(sql);
        
        ps.setString(1, user.getUsername());
        ps.setString(2, user.getPassword());
        rs = ps.executeQuery();
        
        E_User result = new E_User();
        
        while (rs.next()) {
            result.setUsername(rs.getString(1));
            result.setPassword(rs.getString(2));
            result.setType(rs.getString(3));
        }
        
        return result;
	}

	public static void createAccount(E_User data) throws ClassNotFoundException, SQLException
	{
		DB_Connection obj_DB_Connection = new DB_Connection();
        Connection connection = obj_DB_Connection.get_connection();
        PreparedStatement ps = null;

        String sql = "insert into users ( username, password, email, type) values(?,?,?,?)";
        Class.forName("com.mysql.jdbc.Driver");
        
        ps = connection.prepareStatement(sql);
        ps.setString(1, data.getUsername());
        ps.setString(2, data.getPassword());
        ps.setString(3, data.getEmail());
        ps.setString(4, "user");
        
        ps.executeUpdate();
	}
}
