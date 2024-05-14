import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Bai4 {
	private static List<ClientHandler> clients = new ArrayList<>();
	
	public static ArrayList<Person> selectAll() throws SQLException, ClassNotFoundException {
			
			Connection Conn = JDBCUtil.getConnection(); 
			List<Person> list = new ArrayList<>();
			
			//Bước 3 : Thực hiện câu lệnh truy vấn 
			Statement stmt = Conn.createStatement();
			String sqlCommand = "SELECT * FROM person";
			ResultSet rs = stmt.executeQuery(sqlCommand); 
			
			//Bước 4 : Xem thong tin cua bang
			while(rs.next())
			{
				int ID = rs.getInt("id");
				String Name = rs.getString("name");
				String Address = rs.getString("address");
				
				Person temp = new Person(ID, Name, Address);
				list.add(temp);
			}
			
			rs.close();
			stmt.close();
			
			JDBCUtil.closeConnection(Conn);
			return (ArrayList<Person>) list;
	}
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
        try {
        	ArrayList<Person> people = selectAll();
            ServerSocket server = new ServerSocket(7000);
            System.out.println("Server is started");
            
            while (true) {
              Socket socket = server.accept();
              DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
              String result = "";
              for(Person person : people)
              {
            	  result += person + "\n";
              }
              dos.writeUTF("data from table ltm : " + "\n" + result);
              dos.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
	
}

class Person {
	private int ID;
	private String Name;
	private String Address;
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getAddress() {
		return Address;
	}
	public void setAddress(String address) {
		Address = address;
	}
	public Person(int iD, String name, String address) {
		super();
		ID = iD;
		Name = name;
		Address = address;
	}
	@Override
	public String toString() {
		return "ID : " + this.ID + ", Name : " + this.Name + ", Address : " + this.Address;
	}
}