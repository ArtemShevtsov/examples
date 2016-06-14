package com.ashevtsov.examples.database.hibernate.spring.configuration;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by artem_shevtsov on 14.06.16.
 */
@Configuration
public class DemoConfig {
    @Bean
    @Qualifier("q_first")
    public String firstBean(){
        return "first_bean";
    }

    @Bean
    @Qualifier("q_first")
    public String secondBean(){
        return "second_bean";
    }

    @Bean
    @Qualifier("q_second")
    public String thirdBean(){
        return "third_bean";
    }
}
