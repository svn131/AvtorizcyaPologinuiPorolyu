package org.example;

import org.example.configuration.MyConfig;
import org.example.model.User;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {


        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MyConfig.class);


Comunication comunication = context.getBean("comunication", Comunication.class);

        List<User> userList = comunication.showAllUser();
        System.out.println(userList);

        System.out.println("1111111111111111111111111");


    }
}
