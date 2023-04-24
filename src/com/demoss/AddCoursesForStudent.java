package com.demoss;

import com.entitiess.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class AddCoursesForStudent {
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

            Course course = new Course("literatura");

            session.beginTransaction();
            int id = 2;
            Student returnedStudent = session.get(Student.class,id);

            returnedStudent.addCourses(course);
            session.save(course);



            session.getTransaction().commit();
        }
        finally {
            session.close();
        }
    }


}
