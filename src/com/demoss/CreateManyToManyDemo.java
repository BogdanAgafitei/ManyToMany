package com.demoss;

import com.entitiess.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateManyToManyDemo {
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
            Student student1 = new Student("Agafitei","Bogdan", "agafitei@mail.com");
            Student student2 = new Student("Mandache","Aura", "agafitei@mail.com");
            Student student3 = new Student("Bejan","Andrei", "bejan@mail.com");

            session.beginTransaction();

            int id = 11;
            Course tempCourse = session.get(Course.class, id);
            tempCourse.addStudents(student1);
            tempCourse.addStudents(student2);
            tempCourse.addStudents(student3);


            session.save(student1);
            session.save(student2);
            session.save(student3);

            session.getTransaction().commit();
        }
        finally {
            session.close();
        }
    }


}
