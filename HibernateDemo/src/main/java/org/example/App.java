package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class App {
    static void main(String[] args) {
        String password = System.getenv("MYSQL_PASSWORD");

        Alien telusko=new Alien();

        AlienName aname=new AlienName();
        aname.setFname("Vijay");
        aname.setMname("Pratap");
        aname.setLname("Singh");

        // Add Values:
        telusko.setAid(102);
        telusko.setColour("Blue");
        telusko.setAname(aname);


        Configuration con=new Configuration().configure().addAnnotatedClass(Alien.class);
        con.setProperty("hibernate.connection.password", password);

        SessionFactory sf=con.buildSessionFactory();
        Session session=sf.openSession();
        Transaction tx=session.beginTransaction();
        session.persist(telusko);

        telusko=(Alien) session.find(Alien.class,101);

        tx.commit();

        System.out.println(telusko);


    }
    
}
