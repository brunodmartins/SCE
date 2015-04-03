package com.sce.app;

import java.io.File;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MessageRunner {

    /**
     * Main method.
     */
    public static void main(String[] args) {
        
    	System.out.println(new File("$WORKSPAC_LOC").getAbsolutePath());
    	
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("/applicationContext.xml");
        
        Cliente message = (Cliente) applicationContext.getBean("message");

        System.out.println("message='" + message.getMessage() + "'");
    }

}