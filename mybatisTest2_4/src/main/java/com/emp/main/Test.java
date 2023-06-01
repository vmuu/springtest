package com.emp.main;

import com.emp.pojo.Employee;
import com.emp.utils.MybatisUtils;
import org.apache.ibatis.exceptions.PersistenceException;
import org.apache.ibatis.session.SqlSession;
import java.sql.SQLIntegrityConstraintViolationException;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Test {
    static Scanner input = new Scanner(System.in);
    static SqlSession sqlSession = MybatisUtils.getSqlSeesion();

    public static void main(String[] args) throws IOException {
        while (true) {
            printMenu();
        }
    }

    // 打印选项菜单
    public static void printMenu() {
        System.out.println("\033[34m===========================员工管理系统===========================\033[0m");
        System.out.println("1. 查询所有员工信息");
        System.out.println("2. 根据员工编号查询员工信息");
        System.out.println("3. 添加员工信息");
        System.out.println("4. 修改员工信息");
        System.out.println("5. 删除员工信息");
        System.out.println("6. 退出");
        System.out.println("\033[33m请选择：\033[0m");
        System.out.println("\033[34m=================================================================\033[0m");
        String next = input.next();
        switch (next) {
            case "1":
                queryAllEmployeeInfo();
                break;
            case "2":
                queryEmployeeInfoById();
                break;
            case "3":
                addEmployeeInfo();
                break;
            case "4":
                updateEmployeeInfo();
                break;
            case "5":
                deleteEmployeeInfo();
                break;
            case "6":
                System.err.println("程序已退出！");
                System.exit(0);
                break;
                // 退出程序
            default:
                System.err.println("输入有误，请重新选择！");
        }
    }

    // 查询所有员工信息
    public static void queryAllEmployeeInfo() {

        List<Employee> employee = sqlSession.selectList("employeeInfoList");
        System.out.println("\033[34m=========================查询所有员工信息===========================\033[0m");
        for (Employee e : employee) {
            System.out.printf("Employee info: %s\n", e.toString());
        }
        System.out.println("\033[34m==================================================================\033[0m");
        System.out.println("\033[33m输入任意内容返回主菜单！\033[0m");
        try {
            System.in.read();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    // 根据员工编号查询员工信息
    public static void queryEmployeeInfoById() {
        System.out.println("\033[33m请输入要查询的员工编号：\033[0m");
        System.out.println("\033[34m====================根据员工编号查询员工信息=========================\033[0m");
        int id = input.nextInt();
        if (id == 0){
            printMenu();
        }
        sqlSession.clearCache();
        Employee employee = sqlSession.selectOne("employeeInfoById", id);
        if (employee == null){
            System.err.println("员工编号不存在，请重新输入！\033[33m输入 0 返回主菜单！\033[0m\"");
            if (id == 0){
                printMenu();
            }else {
                queryEmployeeInfoById();
            }
        }
        System.out.printf("Employee info: %s\n", employee.toString());
        System.out.println("\033[34m=================================================================\033[0m");
        System.out.println("\033[33m继续输入\033[32m用户编号\033[33m查询或输入 0 返回主菜单！\033[0m");
        queryEmployeeInfoById();
    }

    // 添加员工信息
    public static void addEmployeeInfo() {
        try {
            System.out.println("\033[34m===========================添加员工信息============================\033[0m");
            System.out.println("\033[34m=================================================================\033[0m");
            System.out.println("\033[33m请输入员工编号：\033[0m");
            int id = input.nextInt();
            System.out.println("\033[33m请输入员工姓名：\033[0m");
            String name = input.next();
            System.out.println("\033[33m请输入员工年龄：\033[0m");
            int age = input.nextInt();
            System.out.println("\033[33m请输入员工职位：\033[0m");
            String position = input.next();
            Employee employee = new Employee(id, name, age, position);
            // 执行插入操作
            int addEmployeeInfo = sqlSession.insert("addEmployeeInfo", employee);
            if (addEmployeeInfo == 1) {
                System.out.println("\033[33m添加成功！\033[0m");
            }
            sqlSession.commit();
        } catch (InputMismatchException e) {
            // 捕获输入不匹配异常
            System.err.println("输入的内容不合法，请重新输入！");
            addEmployeeInfo();
        } catch (PersistenceException e) {
            // 捕获 MyBatis 持久化异常
            Throwable cause = e.getCause();
            if (cause instanceof SQLIntegrityConstraintViolationException) {
                // 捕获主键重复异常
                System.err.println("添加员工信息失败：员工编号已存在！请重新输入！");
                addEmployeeInfo();
            } else {
                // 其他情况
                System.out.println("\033[33m添加员工信息失败：" + e.getMessage()+"\033[0m");
                addEmployeeInfo();
            }
        }
    }

    // 修改员工信息
    public static void updateEmployeeInfo() {
        System.out.println("\033[34m============================修改员工信息==============================\033[0m");
        try {
            System.out.println("\033[33m请输入需要修改的员工编号：");
            int id = input.nextInt();
            Employee employeeInfoById = sqlSession.selectOne("employeeInfoById", id);
            System.out.println("\033[35m当前修改的员工信息：" + employeeInfoById.toString());
            System.out.println("\033[33m请输入修改后的员工编号：\033[0m");
            id = input.nextInt();
            System.out.println("\033[33m请输入修改后的员工姓名：\033[0m");
            String name = input.next();
            System.out.println("\033[33m请输入修改后的员工年龄：\033[0m");
            int age = input.nextInt();
            System.out.println("\033[33m请输入需要修改后的员工职位：\033[0m");
            String position = input.next();
            Employee employee = new Employee(id, name, age, position);
            int updateEmployeeInfoById = sqlSession.update("updateEmployeeInfoById", employee);
            sqlSession.commit();
            if (updateEmployeeInfoById == 1) {
                System.out.println("\033[33m修改成功！\033[0m");
            } else {
                System.err.println("修改失败！");
            }
        } catch (InputMismatchException e) {
            System.err.println("输入的格式不正确，请输入整数！");
            input.nextLine(); // clear scanner buffer
        } catch (NullPointerException e) {
            System.err.println("该编号的员工信息不存在！");
            input.nextLine(); // clear scanner buffer
        }
    }

    // 删除员工信息
    public static void deleteEmployeeInfo() {
        System.out.println("\033[34m============================删除员工信息==============================\033[0m");
        try {
            System.out.println("\033[33m请输入需要删除的员工编号：");
            int id = input.nextInt();
            Employee employeeInfoById = sqlSession.selectOne("employeeInfoById", id);
            System.out.println("\033[35m删除的员工信息：" + employeeInfoById.toString());
            int deleteEmployeeInfoById = sqlSession.delete("deleteEmployeeInfoById", id);
            if (deleteEmployeeInfoById == 1) {
                System.out.println("\033[33m删除成功！\033[0m");
            } else {
                System.err.println("删除失败！");
            }
            sqlSession.commit();
        } catch (NullPointerException e) {
            System.err.println("该编号员工信息不存在！");
            input.nextLine(); // clear scanner buffer
        } catch (InputMismatchException e) {
            System.err.println("输入的格式不正确，请输入整数！");
            input.nextLine(); // clear scanner buffer
        }
    }

}