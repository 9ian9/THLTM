import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.Bean.Wife;

public class CheckLoginDAO {
	
	public boolean isExistUser(String username, String password) throws ClassNotFoundException, SQLException {
		
		boolean isValid = false;
		
		try{
        	Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/jsp", "root", "");
            Statement sm = conn.createStatement();
            String sql = "SELECT * FROM login";
            
            // Truy van thong tin tu bang login
            ResultSet rs = sm.executeQuery(sql);
            while(rs.next())
            {
            	if(username.equals(rs.getString("username")) && password.equals(rs.getString("password")))
                {
                	isValid = true;
                	break;
                }
            }
        } catch(Exception e)
        {
            e.printStackTrace();
        }
		return isValid;
	}
	
	public ArrayList<Wife> getWifeList(String username)
	{
		ArrayList<Wife> result = new ArrayList<Wife>();
		
		try{
        	Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/jsp", "root", "");
            Statement sm = conn.createStatement();
            String sql = "SELECT * FROM wife";
            
            // Truy van thong tin tu bang login
            ResultSet rs = sm.executeQuery(sql);
            while(rs.next())
            {
            	result.add(new Wife(rs.getString("name"), rs.getString("address"), rs.getBoolean("alive")));
            }
        } catch(Exception e)
        {
            e.printStackTrace();
        }
		
		return result;
	}
}