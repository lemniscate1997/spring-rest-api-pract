package com.rest.demo;

import com.rest.util.FirstFilter;
import com.rest.util.SecondFilter;
import java.util.Collections;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@ComponentScan("com.rest")
@SpringBootApplication
public class SpringrestserviceproApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringrestserviceproApplication.class, args);
    }

    @Bean
    public FilterRegistrationBean restFirstFilterRegistrationBean() {
        System.out.println("Setting up restRegistrationBean");
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
        filterRegistrationBean.setFilter(new FirstFilter());
        filterRegistrationBean.setUrlPatterns(Collections.singletonList("/api/*"));
        return filterRegistrationBean;
    }
    
    @Bean
    public FilterRegistrationBean restSecondFilterRegistrationBean() {
        System.out.println("Setting up restRegistrationBean");
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
        filterRegistrationBean.setFilter(new SecondFilter());
        filterRegistrationBean.setUrlPatterns(Collections.singletonList("/api/*"));
        return filterRegistrationBean;
    }
}
