package com.training;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class HelloApp {

    public static void main(String[] args) {

        //TODO load application context with classpath from XML Configuration File
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");

        //TODO get bean Hello
        Hello hello = context.getBean(Hello.class);

        System.out.println("My name is : " + hello.getName());

        //TODO load application context with file system from XML Configuration File

        ApplicationContext fileContext =
                new FileSystemXmlApplicationContext("//Users//amanurat//Traning//Workshop//Comscience//Training5//training-spring-practices-prototype//01-why-spring//02-with-spring-di//src//main//resources//spring-config.xml");

        Hello hello2 = fileContext.getBean("hello", Hello.class);
        System.out.println("Name is : "+ hello2.getName());

    }

}
