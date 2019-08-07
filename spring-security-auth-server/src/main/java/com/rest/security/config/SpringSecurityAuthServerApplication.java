package com.rest.security.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@ComponentScan("com.rest.security")
@SpringBootApplication
public class SpringSecurityAuthServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringSecurityAuthServerApplication.class, args);
    }
    
    @Bean
        public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurerAdapter() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**")
                        .allowedOrigins("http://localhost:4200")
                        .allowedMethods("GET","PUT","POST","DELETE");
//                        .allowedMethods("PUT", "DELETE", "GET", "POST")
//                        .allowedHeaders("header1", "header2", "header3")
//                        .exposedHeaders("header1", "header2")
//                        .allowCredentials(false).maxAge(3600);

            }
        };
    }

}
