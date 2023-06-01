// 在org.utils包中的MybatisUtils类
package org.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.Reader;

public class MybatisUtils {
    // 定义一个SqlSessionFactory对象，它是MyBatis的核心对象，用来创建SqlSession
    private static SqlSessionFactory sqlSessionFactory = null;

    // 使用静态代码块在类加载时初始化SqlSessionFactory
    static {
        try{
            // 读取MyBatis配置文件
            Reader reader = Resources.getResourceAsReader("mybatis-config.xml");

            // 使用SqlSessionFactoryBuilder创建SqlSessionFactory
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        }catch (Exception e){
            // 打印异常堆栈信息
            e.printStackTrace();
        }
    }

    // 提供一个静态方法，用于从SqlSessionFactory获取SqlSession
    public static SqlSession getSqlSessionFactory(){
        // 创建一个新的SqlSession并返回
        return sqlSessionFactory.openSession();
    }
}