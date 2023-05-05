package com.emp.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;

/*
    Mybatis连接工具类
 */
public class MybatisUtils {
    // 定义SqlSessionFactory对象
    private static SqlSessionFactory sqlSessionFactory = null;
    // 初始化SqlSessionFactory对象
    static {
        try {
            // 使用Mybatis提供的Resources读取mybatis-config.xml配置文件
            Reader reader = Resources.getResourceAsReader("mybatis-config.xml");
            // 创建SqlSessionFactory对象
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        } catch (IOException e) {
            // 抛出运行时异常
            throw new RuntimeException(e);
        }

    }
    // 获取SqlSession对象的静态方法
    public static SqlSession getSqlSeesion(){
        return sqlSessionFactory.openSession();
    }
}
