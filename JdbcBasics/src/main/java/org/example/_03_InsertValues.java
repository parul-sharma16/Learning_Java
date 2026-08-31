package org.example;

import java.sql.*;

public class _03_InsertValues {
    static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/jdbc_sql";
        String uname = "root";
        String pass = "YOUR_PASSWORD";
        /* inserting using Statement-->
        int id=4;
        String stud_name="Drishti";
        String query = "insert into student values("+id+",'"+stud_name+"'"+",20)";
        */

        // inserting using Prepared Statement-->
        int id=5;
        String stud_name="Erica";
        String query="insert into student values (?,?,?)";

        try (
                Connection con = DriverManager.getConnection(url, uname, pass);
                /*
                Statement st = con.createStatement();
                Statement can cause sql injection so PreparedStatement is preferred.
                */
                PreparedStatement st=con.prepareStatement(query);
        ) {
            /* need to give query as parameter if using Statement.
            int cnt= st.executeUpdate(query);
            */
            st.setInt(1,id);
            st.setString(2,stud_name);
            st.setInt(3,21);
            int cnt=st.executeUpdate();
            System.out.println(cnt+" row(s) affected.");
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
