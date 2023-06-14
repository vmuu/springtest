package com.itheima;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Bean3Test {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationBean3.xml");
        Bean3 bean3 = applicationContext.getBean("bean3", Bean3.class);
        System.out.println(bean3);
    }
}
