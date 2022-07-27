package com.Dhia;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {

        ApplicationContext context= new ClassPathXmlApplicationContext("spring.xml");

        Device obj = (Device)context.getBean("ordinateur");
        obj.utiliser();



    }
}
