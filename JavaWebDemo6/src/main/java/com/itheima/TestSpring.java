package com.itheima;

import com.itheima.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSpring {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("appli00000cationContext.xml");
        UserService userService = applicationContext.getBean("userService", UserService.class);
        Boolean flag = userService.login("张三", "1234");
        if (flag){
            System.out.println("登录成功！");
        }else {
            System.out.println("登录失败！");
        }
    }
}
