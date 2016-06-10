package com.ashevtsov.examples.database.hibernate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;
import com.ashevtsov.examples.database.hibernate.pojo.Employee;
import com.ashevtsov.examples.database.hibernate.util.HibernateUtils;
import org.hibernate.SessionFactory;

/**
 * Created by Artem_Shevtsov on 6/7/2016.
 */
public class HibernateEntityManagerExample {
    public static void main(String[] args) {
        SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("com.ashevtsov.examples.database.hibernate.pojo");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();
        List<Employee> result = entityManager.createQuery( "from Event", Employee.class ).getResultList();
        for ( Employee employee : result ) {
            System.out.println(employee);
        }
        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
