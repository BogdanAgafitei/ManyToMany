package com.demoss;

import com.entitiess.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteCourseDemo {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Course.class)
                .addAnnotatedClass(Review.class)
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try{



            session.beginTransaction();
            int id = 11;

            Course returnedCourse = session.get(Course.class, id);
            session.delete(returnedCourse);






            session.getTransaction().commit();
        }
        finally {
            session.close();
        }
    }


}
