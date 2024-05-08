package bai4;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class Connect {
	public static Connection conn;
    public static Statement statement;
    public static ResultSet resultSet;
    public static ResultSetMetaData rmsd;
    public Connect() throws SQLException {
    	try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3307/people", "root", "");
            System.out.println("connect successfully!");
        } catch (Exception ex) {
            System.out.println("connect failure!");
            ex.printStackTrace();
        }
	}
    public static String getData(String s) {
        try {
            // Kết nối tới cơ sở dữ liệu MySQL

            // Tạo câu truy vấn SQL
            String query = s;
            // Tạo đối tượng Statement
            statement = conn.createStatement();
            // Thực hiện truy vấn
            resultSet = statement.executeQuery(query);
            StringBuilder result = new StringBuilder();
            // Duyệt qua kết quả và tạo chuỗi
            while (resultSet.next()) {
                int userId = resultSet.getInt("Id");
                String name = resultSet.getString("Name");
                String address = resultSet.getString("Address");
                String total = resultSet.getString("Total");

                result.append("ID: ").append(userId)
                        .append(", Name: ").append(name)
                        .append(", Address: ").append(address)
                        .append(", Total: ").append(total)
                        .append("\n");
            }

            // In chuỗi kết quả
            return result.toString();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Đóng kết nối, statement và result set sau khi sử dụng
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
                if (statement != null) {
                    statement.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return "Loi Truy Van";
    }
}
