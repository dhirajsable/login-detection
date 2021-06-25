package com.contact.login.logindetectionservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
public class LoginDetectionServiceApplication {

  public static void main(String[] args) {
    SpringApplication.run(LoginDetectionServiceApplication.class, args);
  }
}
