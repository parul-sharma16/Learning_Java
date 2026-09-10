package org.jpaDemo;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.HashMap;
import java.util.Map;

public class App {
    static void main() {
        Map<String, Object> props = new HashMap<>();
        props.put("jakarta.persistence.jdbc.password",System.getenv("MYSQL_PASSWORD"));

        EntityManagerFactory emf=Persistence.createEntityManagerFactory("pu", props);
        EntityManager em=emf.createEntityManager();

        /*
        Alien a=em.find(Alien.class,3);
        System.out.println(a);
         */

        Alien a=new Alien();
        a.setId(4);
        a.setName("Neha");
        a.setSkill("ML");

        em.getTransaction().begin();
        em.persist(a);
        em.getTransaction().commit();
        System.out.println(a);
    }
}