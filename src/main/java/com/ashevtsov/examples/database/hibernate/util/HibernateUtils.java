package com.ashevtsov.examples.database.hibernate.util;

import com.ashevtsov.examples.database.hibernate.pojo.Employee;
import com.ashevtsov.examples.database.hibernate.pojo.JobPosition;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;

/**
 * Created by Artem_Shevtsov on 6/7/2016.
 */
public class HibernateUtils {
    private static final SessionFactory sessionFactory = buildSessionFactory();

    private static SessionFactory buildSessionFactory(){

        SessionFactory sessionFactory = new Configuration()
//                .addPackage("com.ashevtsov.examples.database.hibernate.pojo")
                .addAnnotatedClass(Employee.class)
                .addAnnotatedClass(JobPosition.class)
                .configure().buildSessionFactory();

        return sessionFactory;
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public static void shutdown(){
        sessionFactory.close();
    }
}
