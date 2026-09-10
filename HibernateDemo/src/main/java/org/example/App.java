package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class App {
    static void main(String[] args) {
        String password = System.getenv("MYSQL_PASSWORD");

        Alien telusko = new Alien();

        AlienName aname = new AlienName();
        aname.setFname("Vijay");
        aname.setMname("Pratap");
        aname.setLname("Singh");

        // Add Values:
        telusko.setAid(102);
        telusko.setColour("Blue");
        telusko.setAname(aname);


        Configuration con = new Configuration().configure().addAnnotatedClass(Alien.class);
        con.setProperty("hibernate.connection.password", password);

        SessionFactory sf = con.buildSessionFactory();

        /* basic demo:
        Session session=sf.openSession();
        Transaction tx=session.beginTransaction();
        session.persist(telusko);

        telusko=(Alien) session.find(Alien.class,101);

        tx.commit();
        System.out.println(telusko);
         */

        //----CACHING----
        Alien a = null;
        Session session1 = sf.openSession();
        session1.beginTransaction();
        a = (Alien) session1.find(Alien.class, 101);
        System.out.println(a);

        /* if the same query is requested again, in the same session, it will be fetched from the first level cache instead of being fired again.
        a=(Alien) session1.find(Alien.class,101);
        System.out.println(a);
        */

        /* can also do query cache for sql-like queries:
        Query<Alien> q1 = session1.createQuery("from Alien where aid = 101", Alien.class);
        q1.setCacheable(true);
        a = q1.getSingleResult();
        System.out.println(a);
        */

        session1.getTransaction().commit();
        session1.close();

        //same query but different session, thus not present in the first level cache thus, query fired again.
        Session session2 = sf.openSession();
        session2.beginTransaction();
        a = (Alien) session2.find(Alien.class, 101);
        System.out.println(a);

        /* for sql-like query:
        Query<Alien> q2 = session2.createQuery("from Alien where aid = 101", Alien.class);
        q2.setCacheable(true);
        a = q2.getSingleResult();
        System.out.println(a);
        */

        session2.getTransaction().commit();
        session2.close();
    }
}