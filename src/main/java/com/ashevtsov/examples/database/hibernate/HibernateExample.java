package com.ashevtsov.examples.database.hibernate;

import java.util.HashSet;
import java.util.List;
import com.ashevtsov.examples.database.hibernate.pojo.Employee;
import com.ashevtsov.examples.database.hibernate.pojo.JobPosition;
import com.ashevtsov.examples.database.hibernate.util.HibernateUtils;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 * Created by Artem_Shevtsov on 6/7/2016.
 */
public class HibernateExample {

    public static void main(String[] args) {
        HibernateExample hibernateExample = new HibernateExample();

//        hibernateExample.initDB();
        hibernateExample.showData();

        HibernateUtils.shutdown();
    }

    public void initDB(){
        JobPosition job1 = new JobPosition();
        JobPosition job2 = new JobPosition();
        JobPosition job3 = new JobPosition();
        JobPosition job4 = new JobPosition();
        job1.setJobName("Job Num One");
        job2.setJobName("Job Num Two");
        job3.setJobName("Job Num Three");
        job4.setJobName("Job Num Four");

        Employee emp1 = new Employee();
        Employee emp2 = new Employee();
        Employee emp3 = new Employee();
        Employee emp4 = new Employee();
        emp1.setFirstName("Vasya");
        emp1.setLastName("Pupkin");
        emp1.setFullName("Vasya Pupkin");

        emp2.setFirstName("Petya");
        emp2.setLastName("Vasechkin");
        emp2.setFullName("Petya Vasechkin");

        emp3.setFirstName("Kolya");
        emp3.setLastName("Petrov");
        emp3.setFullName("Nikolay Petrov");

        emp4.setFirstName("galya");
        emp4.setLastName("Michalivna");
        emp4.setFullName("Galyna Petrovna");

        HashSet<JobPosition> jobsOneAndTwo = new HashSet<>();
        jobsOneAndTwo.add(job1);
        jobsOneAndTwo.add(job2);

        HashSet<JobPosition> jobsTwoAndThree = new HashSet<>();
        jobsTwoAndThree.add(job2);
        jobsTwoAndThree.add(job3);

        HashSet<JobPosition> jobsThreeAndFour = new HashSet<>();
        jobsThreeAndFour.add(job3);
        jobsThreeAndFour.add(job4);

        HashSet<JobPosition> jobsFourAndOne = new HashSet<>();
        jobsFourAndOne.add(job4);
        jobsFourAndOne.add(job1);

        emp1.setJobPositions(jobsOneAndTwo);
        emp2.setJobPositions(jobsTwoAndThree);
        emp3.setJobPositions(jobsThreeAndFour);
        emp4.setJobPositions(jobsFourAndOne);

//        HashSet<Employee> empOneAndFour = new HashSet<>();
//        empOneAndFour.add(emp1);
//        empOneAndFour.add(emp4);
//
//        HashSet<Employee> empOneAndtwo = new HashSet<>();
//        empOneAndtwo.add(emp1);
//        empOneAndtwo.add(emp2);
//
//        HashSet<Employee> empTwoAndThree = new HashSet<>();
//        empTwoAndThree.add(emp2);
//        empTwoAndThree.add(emp3);
//
//        HashSet<Employee> empThreeAndFour = new HashSet<>();
//        empThreeAndFour.add(emp3);
//        empThreeAndFour.add(emp4);
//
//        job1.setEmployees(empOneAndFour);
//        job2.setEmployees(empOneAndtwo);
//        job3.setEmployees(empTwoAndThree);
//        job4.setEmployees(empThreeAndFour);

        SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
        try(Session session = sessionFactory.openSession()){
            Transaction transaction = session.beginTransaction();

            session.save(job1);
            session.save(job2);
            session.save(job3);
            session.save(job4);

            session.save(emp1);
            session.save(emp2);
            session.save(emp3);
            session.save(emp4);

            transaction.commit();
        }
    }

    public void showData(){
        SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
        try(Session session = sessionFactory.openSession()){

            Criteria employeeCriteria = session.createCriteria(Employee.class);
            List<Employee> employeeList = employeeCriteria.list();
            System.out.println("Employee List:");
            employeeList.stream().forEach(employee -> {
                System.out.printf("\t%s\n", employee.toString());
                employee.getJobPositions().stream().forEach(jobPosition -> {
                    System.out.printf("\t\t%s\n", jobPosition.toString());
                });
            });

            Criteria jobsCriteria = session.createCriteria(JobPosition.class);
            List<JobPosition> jobsList = jobsCriteria.list();
            System.out.println("\nJob Position List:");
            jobsList.stream().forEach(job -> {
                System.out.printf("\t%s\n", job.toString());
                job.getEmployees().stream().forEach(emp -> {
                    System.out.printf("\t\t%s\n", emp.toString());
                });
            });
        }
    }
}
