package com.itheima;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ScopeTest {
    public static void main(String[] args) {
        // 单例模式测试 singleton，默认单例模式
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationBean1Scope.xml");
        Bean1 bean1_1 = applicationContext.getBean("bean1Scope", Bean1.class);
        Bean1 bean1_2 = applicationContext.getBean("bean1Scope", Bean1.class);
        System.out.println(bean1_1==bean1_2);
    }
}
