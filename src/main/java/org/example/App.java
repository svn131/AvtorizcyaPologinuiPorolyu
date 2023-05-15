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


        User newUser = new User();
        newUser.setId(3L);
        newUser.setName("James");
        newUser.setLastName("Brown");
        newUser.setAge((byte) 30);

        comunication.saveUser(newUser);

        System.out.println("222222222222222222222222222222222222222222222");


        User updatedUser = new User();
        updatedUser.setId(3L);
        updatedUser.setName("Thomas");
        updatedUser.setLastName("Shelby");
        updatedUser.setAge((byte) 30);

        comunication.updateUser(updatedUser);

        System.out.println("333333333333333333333333333333333333333333333333333333333333333");

        comunication.deleteUser(3L);

        System.out.println("FINISH");

    }
}