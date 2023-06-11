package com.itheima;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestUser1 {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext-User1.xml");
        User1 user1 = applicationContext.getBean("user1", User1.class);
        System.out.println(user1);
    }
}
