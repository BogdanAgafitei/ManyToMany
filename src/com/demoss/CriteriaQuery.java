package com.demoss;

import com.entitiess.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import javax.persistence.criteria.*;
import java.util.List;

public class CriteriaQuery {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Course.class)
                .addAnnotatedClass(Review.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        session.beginTransaction();
        // create criteria builder
        CriteriaBuilder cb = session.getCriteriaBuilder();

        // create criteria query
        javax.persistence.criteria.CriteriaQuery<Student> cr = cb.createQuery(Student.class);

        // create the root
        Root<Student> root = cr.from(Student.class);
        cr.select(root);
        cr.where(cb.like(root.get("firstName"), "A%"));

        Query<Student> query = session.createQuery(cr);

        List<Student> result = query.getResultList();

        System.out.println(result);

        session.getTransaction().commit();
    }





}
