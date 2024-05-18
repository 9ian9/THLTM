package Model.DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import JDBC.JDBCUtil;
import Model.BEAN.Student;

public class StudentDAO {
	public Student getStudentInfoByAccountId(int accountId) throws SQLException {
		Student result = new Student();

		Connection Conn = JDBCUtil.getConnection();

		// Bước 3 : Thực hiện câu lệnh truy vấn
		Statement stmt = Conn.createStatement();
		String sqlCommand = "SELECT * FROM students";
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
}
