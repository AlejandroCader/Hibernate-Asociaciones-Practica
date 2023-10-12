package org.HibernateApp;

import jakarta.persistence.EntityManager;
import org.HibernateApp.entity.Student;
import org.HibernateApp.entity.Mark;
import org.HibernateApp.util.JpaUtil;
import java.util.Date;

public class Main {
    public static void main(String[] args) {

        EntityManager em = JpaUtil.getEntityManager();

        try {
            em.getTransaction().begin();

            Student student = new Student("Miguel", "Cruz");

            Mark m1 = new Mark(new Date(), 10);
            Mark m2 = new Mark(new Date(), 9);

            student.getMarks().add(m1);
            student.getMarks().add(m2);
            em.persist(student);

            System.out.println(student);

        } catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
        }finally {
            em.close();
        }
    }
}