package org.example;
import java.sql.*;

public class _04_JdbcDAO {
    static void main(String[] args){
        StudentDAO dao=new StudentDAO();
        dao.connect();
        Student s1=dao.getStudent(12);
        System.out.println(s1.name);
        Student s2=new Student();
        s2.roll_no=14;
        s2.name="Neha";
        dao.addStudent(s2);
    }
}

class StudentDAO{

    Connection con=null;

    public void connect() {
        String url = "jdbc:mysql://localhost:3306/jdbc_sql";
        String user = "root";
        String pass = "YOUR_PASSWORD";
        try {
            con = DriverManager.getConnection(url, user, pass);
        }
        catch(Exception e){
            System.out.println(e);
        }
    }

    public Student getStudent(int roll_no){
        Student s = new Student();
        s.roll_no = roll_no;
        String query = "select name from student_dao where roll_no=" + roll_no;
        Statement st = null;
        try {
            st = con.createStatement();
            ResultSet rs = st.executeQuery(query);
            rs.next();
            s.name = rs.getString(1);
            return s;
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    public void addStudent(Student s){
        String query = "insert into student_dao values (?,?)";
        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement(query);
            ps.setInt(1,s.roll_no);
            ps.setString(2,s.name);
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}

class Student{
    int roll_no;
    String name;
}
