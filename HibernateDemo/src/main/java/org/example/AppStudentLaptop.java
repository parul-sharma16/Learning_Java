package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Collection;

public class AppStudentLaptop {
    static void main() {
        String password = System.getenv("MYSQL_PASSWORD");
        Student s = new Student();
        Laptop l = new Laptop();

        l.setLid(101);
        l.setLname("HP");

        s.setRoll(3301);
        s.setName("Parul");
        s.getLaptop().add(l);   //One-to-many (student-laptop)
        l.setStudent(s);

//        l.getS().add(s); //One-to-many (laptop-student)

//        l.setStudent(s); //One-to-one (laptop-student)
//        s.setLaptop(l); //One-to-one (student-laptop)

        Configuration con = new Configuration().configure().addAnnotatedClass(Student.class).addAnnotatedClass(Laptop.class);
        con.setProperty("hibernate.connection.password", password);

        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();
        session.persist(l);
        session.persist(s);

        Student s1= session.find(Student.class, 3301);
        session.getTransaction().commit();
        System.out.println(s1.getName());
        /*
        //LAZY FETCH
        Collection<Laptop> laps=s1.getLaptop();
        for(Laptop lap:laps)
        {
            System.out.println(lap);
        }
        */

        //EAGER fetch type uses left join and automatically fetches laptop details as well.

        tx.commit();
    }
}
