package org.example;

import org.example.configuration.MyConfig;
import org.example.model.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.web.filter.RequestContextFilter;

import java.util.List;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) {


        // здесь ваш код


        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MyConfig.class);


        Comunication comunication = context.getBean("comunication", Comunication.class);

//        List<User> userList = comunication.showAllUser();
        ResponseEntity<List<User>> response = comunication.showAllUser();
        List<User> userList = response.getBody();
        System.out.println(userList);

        System.out.println("1111111111111111111111111");


    }
}