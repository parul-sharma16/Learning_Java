package org.example;

import java.sql.*;

public class Main {
    static void main(String[] args){
        String url="jdbc:mysql://localhost:3306/jdbc_sql";
        String uname="root";
        String pass="YOUR_PASSWORD";
        String query="select name from student where roll_no=?";
        try(
                Connection con=DriverManager.getConnection(url,uname,pass);
                PreparedStatement ps=con.prepareStatement(query);
        ){
            ps.setInt(1, 2);
            try(ResultSet rs=ps.executeQuery()){
                while(rs.next()) System.out.println(rs.getString("name"));
            }
        }
        catch(SQLException e){
            e.printStackTrace();
        }

        /* OLD WAY: [telusko does this way but now the driver is automatically loaded by maven.
        So no need to write Class.forName()].

        Class.forName("com.mysql.jdbc.Driver");
        Connection con=DriverManager.getConnection(url,uname,pass);
        Statement st=con.createStatement();
        ResultSet rs=st.executeQuery(query);
        rs.next();
        String name=rs.getString("username");
        System.out.println(name);
        st.close();
        con.close();
        */

        }
}
