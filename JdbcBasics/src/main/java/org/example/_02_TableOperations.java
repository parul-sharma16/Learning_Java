package org.example;

import java.sql.*;

public class _02_TableOperations {
    static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/jdbc_sql";
        String uname = "root";
        String pass = "YOUR_PASSWORD";
        String query = "select * from student";
        try (
                Connection con = DriverManager.getConnection(url, uname, pass);
                PreparedStatement ps = con.prepareStatement(query);
        ) {
            try (ResultSet rs = ps.executeQuery()) {
                String student_data;
                while (rs.next()){
                    student_data=rs.getInt(1)+" : "+rs.getString(2);
                    System.out.println(student_data);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
