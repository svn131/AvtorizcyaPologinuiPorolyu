package org.example;

import org.example.configuration.MyConfig;
import org.example.model.User1;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;


public class App {
    public static void main(String[] args) {





        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MyConfig.class);


        Comunication comunication = context.getBean("comunication", Comunication.class);

        List<User1> userList = comunication.showAllUser();

        System.out.println(userList);












        //3-1-6
//        ResponseEntity<List<User>> response = comunication.showAllUser();
//        List<User> userList = response.getBody();
//        System.out.println(userList);
//
//        System.out.println("1111111111111111111111111");
//
//
//        User newUser = new User();
//        newUser.setId(3L);
//        newUser.setName("James");
//        newUser.setLastName("Brown");
//        newUser.setAge((byte) 30);
//
//        comunication.saveUser(newUser);
//
//        System.out.println("222222222222222222222222222222222222222222222");
//
//
//        User updatedUser = new User();
//        updatedUser.setId(3L);
//        updatedUser.setName("Thomas");
//        updatedUser.setLastName("Shelby");
//        updatedUser.setAge((byte) 30);
//
//        comunication.updateUser(updatedUser);
//
//        System.out.println("333333333333333333333333333333333333333333333333333333333333333");
//
//        comunication.deleteUser(3L);
//
//        System.out.println("FINISH");

    }
}