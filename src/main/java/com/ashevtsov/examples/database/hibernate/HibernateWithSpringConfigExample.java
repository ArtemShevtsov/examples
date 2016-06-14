package com.ashevtsov.examples.database.hibernate;

import com.ashevtsov.examples.database.hibernate.pojo.Employee;
import com.ashevtsov.examples.database.hibernate.spring.configuration.JPAConfiguration;
import com.ashevtsov.examples.database.hibernate.spring.configuration.SpringConfiguration;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.serviceloader.ServiceFactoryBean;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by artem_shevtsov on 14.06.16.
 */
@Component
public class HibernateWithSpringConfigExample {
    @Autowired
    SessionFactory sessionFactory;

    @Resource
    @Qualifier("q_first")
    String thirdBean;

    @Autowired
    @Qualifier("q_second")
    String secondBean;

    public static void main(String[] args) {
        AnnotationConfigApplicationContext appContext = new AnnotationConfigApplicationContext();
        appContext.register(SpringConfiguration.class);
        appContext.refresh();

        HibernateWithSpringConfigExample app = appContext.getBean(HibernateWithSpringConfigExample.class);
        System.out.println(app.thirdBean);
        System.out.println(app.secondBean);

        try(Session session = app.sessionFactory.openSession()){
            Criteria employeeCriteria = session.createCriteria(Employee.class);
            List<Employee> employeeList = employeeCriteria.list();
            System.out.println("Employee List:");
            employeeList.stream().forEach(employee -> {
                System.out.printf("\t%s\n", employee.toString());
                employee.getJobPositions().stream().forEach(jobPosition -> {
                    System.out.printf("\t\t%s\n", jobPosition.toString());
                });
            });
        }
    }
}
