package com.contact.login.logindetectionservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.contact.login.logindetectionservice*")
@EnableTransactionManagement
@EntityScan(basePackages = "com.contact.login.logindetectionservice*")
public class LoginDetectionServiceApplication {

    public static void main(String[] args) {
        try {
            SpringApplication.run(LoginDetectionServiceApplication.class, args);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}
