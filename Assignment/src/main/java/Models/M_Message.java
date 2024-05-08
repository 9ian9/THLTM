package Models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import Models.Entity.E_Message;
import Models.JDBC.DB_Connection;

public class M_Message {
	public static void insertMessage(E_Message data) throws ClassNotFoundException, SQLException
	{
		DB_Connection obj_DB_Connection = new DB_Connection();
        Connection connection = obj_DB_Connection.get_connection();
        PreparedStatement ps = null;

        String sql = "insert into messages (message, senderName, senderEmail) values(?,?,?)";
        Class.forName("com.mysql.jdbc.Driver");
        
        ps = connection.prepareStatement(sql);
        ps.setString(1, data.getMessage());
        ps.setString(2, data.getSenderName());
        ps.setString(3, data.getSenderName());
        
        ps.executeUpdate();
	}
}
