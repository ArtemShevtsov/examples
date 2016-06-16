package com.ashevtsov.examples.database.hibernate.spring.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;

import java.util.Properties;

/**
 * Created by artem_shevtsov on 14.06.16.
 */
@Configuration
public class JPAConfiguration {


    private DriverManagerDataSource dataSource(){
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost/mysql_training");
        dataSource.setUsername("root");
        dataSource.setPassword("mysqlroot");

        return dataSource;
    }

    @Bean
    public LocalSessionFactoryBean sessionFactory(){
        Properties hibernateProps = new Properties();
        hibernateProps.setProperty("hbm2ddl.auto", "update");
        hibernateProps.setProperty("hibernate.connection.pool_size", String.valueOf(20));

        LocalSessionFactoryBean localSessionFactory = new LocalSessionFactoryBean();
        localSessionFactory.setDataSource(dataSource());
        localSessionFactory.setHibernateProperties(hibernateProps);
        localSessionFactory.setPackagesToScan("com.ashevtsov.examples.database.hibernate.pojo");

        return localSessionFactory;
    }
}
