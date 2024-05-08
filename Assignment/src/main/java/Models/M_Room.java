package Models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import Models.Entity.E_Room;
import Models.JDBC.DB_Connection;

public class M_Room {
	public static void updateRoom(String status, String room_number, String room_id) throws ClassNotFoundException, SQLException {
		DB_Connection obj_DB_Connection = new DB_Connection();
		Connection connection = obj_DB_Connection.get_connection();
		PreparedStatement ps = null;

		String sql = "UPDATE rooms SET Status = ?, RoomNo= ? WHERE id = ? ";
		Class.forName("com.mysql.jdbc.Driver");

		ps = connection.prepareStatement(sql);
		ps.setString(1, status);
		ps.setString(2, room_number);
		ps.setString(3, room_id);

		ps.executeUpdate();
	}
	
	public static void updateRequest(E_Room data) throws ClassNotFoundException, SQLException
	{
		DB_Connection obj_DB_Connection = new DB_Connection();
        Connection connection = obj_DB_Connection.get_connection();
        PreparedStatement ps = null;
        
        String sql = "UPDATE rooms SET Adults = ?,Kids = ?,	CheckIn = ?,CheckOut = ? WHERE id = ? ";
        Class.forName("com.mysql.jdbc.Driver");

        ps = connection.prepareStatement(sql);
        ps.setString(1, data.getAdults() + "");
        ps.setString(2, data.getKids() + "");
        ps.setString(3, data.getCheckIn());
        ps.setString(4, data.getCheckOut());
        ps.setString(5, data.getId() + "");

        
        ps.executeUpdate();
	}
	
	public static void deleteAllRoom() throws ClassNotFoundException, SQLException
	{
		DB_Connection obj_DB_Connection = new DB_Connection();
        Connection connection = obj_DB_Connection.get_connection();
        PreparedStatement ps = null;
        		
        String sql = "DELETE FROM rooms";
        Class.forName("com.mysql.jdbc.Driver");
        
        ps = connection.prepareStatement(sql);

        ps.executeUpdate();
	}
	
	public static void deleteRoomById(String room_id) throws ClassNotFoundException, SQLException
	{
		DB_Connection obj_DB_Connection = new DB_Connection();
        Connection connection = obj_DB_Connection.get_connection();
        PreparedStatement ps = null;
        		
        String sql = "DELETE FROM rooms WHERE id= ? ";
        Class.forName("com.mysql.jdbc.Driver");
        
        ps = connection.prepareStatement(sql);
        ps.setString(1, room_id);
        
        ps.executeUpdate();
	}
	
	public static void insertRoom(E_Room data) throws ClassNotFoundException, SQLException
	{
		DB_Connection obj_DB_Connection = new DB_Connection();
        Connection connection = obj_DB_Connection.get_connection();
        PreparedStatement ps = null;

        String sql = "insert into rooms (CheckIn, CheckOut, Adults, Kids, Status, RoomNo, RequestMadeBy) values(?,?,?,?,?,?,?)";
        Class.forName("com.mysql.jdbc.Driver");
        
        ps = connection.prepareStatement(sql);
        ps.setString(1, data.getCheckIn());
        ps.setString(2, data.getCheckOut());
        ps.setString(3, data.getAdults() + "");
        ps.setString(4, data.getKids() + "");
        ps.setString(5, "0");
        ps.setString(6, null);
        ps.setString(7, data.getRequestMadeBy());
        
        ps.executeUpdate();
	}
}
