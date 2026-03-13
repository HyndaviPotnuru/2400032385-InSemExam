package com.klef.fsad.exam;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.Date;

public class ClientDemo {

    public static void main(String[] args) {

        // Load configuration
        Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");

        // Create SessionFactory
        SessionFactory sf = cfg.buildSessionFactory();

        // Open session
        Session session = sf.openSession();

        // Begin transaction
        session.beginTransaction();

        // INSERT
        Supplier s = new Supplier();
        s.setName("ABC Supplier");
        s.setDescription("Electronics Supplier");
        s.setDate(new Date());
        s.setStatus("Active");

        session.save(s);

        System.out.println("Record Inserted");

        // UPDATE
        Supplier s1 = session.get(Supplier.class, 1);

        if (s1 != null) {
            s1.setStatus("Inactive");
            System.out.println("Record Updated");
        }

        // Commit
        session.getTransaction().commit();

        session.close();
        sf.close();
    }
}