package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HQLDemoApp {
    static void main() {
        String password = System.getenv("MYSQL_PASSWORD");
        Configuration con=new Configuration().configure().addAnnotatedClass(HQLDemoStudent.class);
        con.setProperty("hibernate.connection.password",password);
        SessionFactory sf=con.buildSessionFactory();
        Session session=sf.openSession();
        session.beginTransaction();

//        Random r=new Random();
//        for(int i=1; i<=50; i++)
//        {
//            HQLDemoStudent s=new HQLDemoStudent();
//            s.setRoll_no(i);
//            s.setName("Stud"+i);
//            s.setMarks(r.nextInt(100));
//            session.persist(s);
//        }
        Query<HQLDemoStudent> q1 =session.createQuery("from HQLDemoStudent where marks>=50",HQLDemoStudent.class);
        List<HQLDemoStudent> s1 = q1.list();
        for(HQLDemoStudent s: s1)
        {
            System.out.println(s);
        }

        System.out.println();
        Query<HQLDemoStudent> q2=session.createQuery("from HQLDemoStudent where roll_no=39",HQLDemoStudent.class);
        HQLDemoStudent s2 =q2.getSingleResult();
        System.out.println(s2);

        System.out.println();
        Query<Object[]> q3=session.createQuery("select roll_no, name from HQLDemoStudent where roll_no=45",Object[].class);
        Object[] s3 =q3.getSingleResult();
        for(Object o: s3)
        {
            System.out.println(o);
        }

        /*for selecting all columns (select*) I can use the return type of the query as HQLDemoStudent, but if I only want some of the
        columns then I can't use HQLDemoStudent as the return type, and instead have to use either <?> or <Object[]> if i know the return type.
         */
        System.out.println();
        Query<Object[]> q4 =session.createQuery("select roll_no, name from HQLDemoStudent",Object[].class);
        List<Object[]> s4 = (List<Object[]>) q4.list();
        for(Object[] o: s4)
        {
            System.out.println(o[0]+" : "+o[1]);
        }

        System.out.println();
        NativeQuery<HQLDemoStudent> q5 =session.createNativeQuery("select* from HQLDemoStudent where marks>70", HQLDemoStudent.class);
        q5.addEntity(HQLDemoStudent.class);
        List<HQLDemoStudent> s5 = q5.list();
        //I can replace the HQLDemoStudent inside the generic with <?> if i am not sure of the return type.
        for(Object o: s5)
        {
            System.out.println(o);
        }

        System.out.println();
        NativeQuery<?> q6=session.createNativeQuery("select name, marks from HQLDemoStudent where marks>90");
        q6.setTupleTransformer((tuple,aliases)->
        {
            Map<String, Object> mpp=new HashMap<>();
            for(int i=0; i<aliases.length; i++)
            {
                mpp.put(aliases[i], tuple[i]);
            }
            return mpp;
        });
        List<?> s6=q6.list();
        for(Object o: s6)
        {
            Map<?,?> m=(Map<?,?>)o;
            System.out.println(m.get("name")+" : "+m.get("marks"));
        }
        
        session.getTransaction().commit();
    }
}
