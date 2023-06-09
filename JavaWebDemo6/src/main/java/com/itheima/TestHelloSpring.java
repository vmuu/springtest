package com.itheima;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestHelloSpring {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        HelloSpring helloSpring  = (HelloSpring) applicationContext.getBean("helloSpring");
        helloSpring.show();
    }
}
