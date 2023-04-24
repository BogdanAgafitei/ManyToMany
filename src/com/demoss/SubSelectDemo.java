package com.demoss;

import com.entitiess.Result;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class SubSelectDemo {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Result.class)
                .buildSessionFactory();
        Session session = factory.getCurrentSession();

        session.beginTransaction();
       Result result = new Result();
       List<Result> list  = session.createQuery("from Result", Result.class).getResultList();
        System.out.println(list);

        session.getTransaction().commit();
    }



}
