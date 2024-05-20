package Model.DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import JDBC.JDBCUtil;
import Model.BEAN.Faculity;
import Model.BEAN.Grade;
import Model.BEAN.Student;
import Model.BEAN.Teacher;

public class StudentDAO {
	public Student getStudentInfoByAccountId(int accountId) throws SQLException {
		Student result = new Student();

		Connection Conn = JDBCUtil.getConnection();

		// Bước 3 : Thực hiện câu lệnh truy vấn
		Statement stmt = Conn.createStatement();
		String sqlCommand = "SELECT * FROM students where accountId = " + accountId;
		ResultSet rs = stmt.executeQuery(sqlCommand);

		// Bước 4 : Xem thong tin cua bang
		while (rs.next()) {
			result = new Student(rs.getInt("id"), rs.getString("name"), rs.getDate("birthday").toLocalDate(),
					rs.getString("gender"), rs.getString("tel"), rs.getString("email"), rs.getInt("yearOfStudent"),
					rs.getInt("classId"), rs.getInt("accountId"));
		}

		rs.close();
		stmt.close();

		JDBCUtil.closeConnection(Conn);

		return result;
	}
	public int insert(Student newItem) throws SQLException, ClassNotFoundException {
	    Connection con = JDBCUtil.getConnection();

	    String command = "INSERT INTO students (name, birthday, gender, tel, email, yearOfStudent, ClassId, accountId) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
	    PreparedStatement psm = con.prepareStatement(command, Statement.RETURN_GENERATED_KEYS);

	    psm.setString(1, newItem.getName());
	    psm.setDate(2, Date.valueOf(newItem.getBirthday()));
	    psm.setString(3, newItem.getGender());
	    psm.setString(4, newItem.getTel());
	    psm.setString(5, newItem.getEmail());
	    psm.setInt(6, newItem.getYearOfStudent());
	    psm.setInt(7, newItem.getClassId());
	    psm.setInt(8, newItem.getAccountId());
	    

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
		
		String command = "DELETE FROM Students WHERE id = ?";
		PreparedStatement psm = con.prepareStatement(command);
		
		psm.setInt(1, id);
		
		int executedRow = psm.executeUpdate(); 
		
		psm.close();
		
		JDBCUtil.closeConnection(con);
		return executedRow;
	}
	public int update(Student newItem) throws SQLException, ClassNotFoundException {
		
		Connection con = JDBCUtil.getConnection();
		
		String command = "UPDATE students SET name = ?, birthday = ?, gender = ?, tel = ?, email = ?, yearOfStudent = ?, classId = ?, accountId = ? WHERE id = ?";
		PreparedStatement psm = con.prepareStatement(command);
			
		psm.setString(1, newItem.getName());
	    psm.setDate(2, Date.valueOf(newItem.getBirthday()));
	    psm.setString(3, newItem.getGender());
	    psm.setString(4, newItem.getTel());
	    psm.setString(5, newItem.getEmail());
	    psm.setInt(6, newItem.getYearOfStudent());
	    psm.setInt(7, newItem.getClassId());
	    psm.setInt(8, newItem.getAccountId());
	    psm.setInt(9, newItem.getId());
	    
	
		int executedRow = psm.executeUpdate(); 
		
		psm.close();
		
		JDBCUtil.closeConnection(con);
		return executedRow;
	}
	public ArrayList<Student> getAllStudentByClassID(int ClassId) throws SQLException
	{
		ArrayList<Student> result = new ArrayList<Student>();
		
		Connection Conn = JDBCUtil.getConnection(); 
		
		//Bước 3 : Thực hiện câu lệnh truy vấn 
		Statement stmt = Conn.createStatement();
		String sqlCommand = "SELECT * FROM students where classId = " + ClassId;
		ResultSet rs = stmt.executeQuery(sqlCommand); 
		
		//Bước 4 : Xem thong tin cua bang
		while(rs.next())
		{
			result.add(new Student(rs.getInt("id"), rs.getString("name"), rs.getDate("birthday").toLocalDate(), rs.getString("gender"), rs.getString("tel"), rs.getString("email"), rs.getInt("yearOfStudent"), rs.getInt("classId"), rs.getInt("accountId")));
		}
		
		rs.close();
		stmt.close();
		
		JDBCUtil.closeConnection(Conn);
		
		return result;
	}
	public Student getStudentById(int id) throws SQLException
	{
		Student result = new Student();
		
		Connection Conn = JDBCUtil.getConnection(); 
		
		//Bước 3 : Thực hiện câu lệnh truy vấn 
		Statement stmt = Conn.createStatement();
		String sqlCommand = "SELECT * FROM students where id = " + id;
		ResultSet rs = stmt.executeQuery(sqlCommand); 
		
		//Bước 4 : Xem thong tin cua bang
		while(rs.next())
		{
			result = new Student(rs.getInt("id"), rs.getString("name"), rs.getDate("birthday").toLocalDate(), rs.getString("gender"), rs.getString("tel"), rs.getString("email"), rs.getInt("yearOfStudent"), rs.getInt("classId"), rs.getInt("accountId"));
		}
		
		rs.close();
		stmt.close();
		
		JDBCUtil.closeConnection(Conn);
		
		return result;
	}
}
