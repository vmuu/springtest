package com.emp.main;

import com.emp.pojo.Employee;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;

public class Test {
    public static void main(String[] args) throws IOException {
        String resource = "mybatis-config.xml";
        Reader reader = null;
        try {
            reader = Resources.getResourceAsReader(resource);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        SqlSessionFactory sqlMapper = new SqlSessionFactoryBuilder().build(reader);
        SqlSession sqlSession = sqlMapper.openSession();
        Employee employee = sqlSession.selectOne("employeeInfoById", 1);
        System.out.printf("Employee info: %s\n", employee.toString());
        sqlSession.close();
    }
}
