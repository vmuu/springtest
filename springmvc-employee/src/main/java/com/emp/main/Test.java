package com.emp.main;

import com.emp.pojo.Employee;
import com.emp.utils.MybatisUtils;

import org.apache.ibatis.session.SqlSession;

import java.io.IOException;

public class Test {
    public static void main(String[] args) throws IOException {
        SqlSession sqlSession = MybatisUtils.getSqlSeesion();
        Employee employee = sqlSession.selectOne("employeeInfoById", 1);
        System.out.printf("Employee info: %s\n", employee.toString());
        sqlSession.close();
    }
}
