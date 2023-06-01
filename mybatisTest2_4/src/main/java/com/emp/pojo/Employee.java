package com.emp.pojo;

// 定义一个员工类
public class Employee {
    private int id; // 员工ID
    private String name; // 员工姓名
    private int age; // 员工年龄
    private String position; // 员工职位

    // 构造方法，用于创建Employee对象
    public Employee(int id, String name, int age, String position) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.position = position;
    }

    // 获取员工ID
    public int getId() {
        return id;
    }

    // 设置员工ID
    public void setId(int id) {
        this.id = id;
    }

    // 获取员工姓名
    public String getName() {
        return name;
    }

    // 设置员工姓名
    public void setName(String name) {
        this.name = name;
    }

    // 获取员工年龄
    public int getAge() {
        return age;
    }

    // 设置员工年龄
    public void setAge(int age) {
        this.age = age;
    }

    // 获取员工职位
    public String getPosition() {
        return position;
    }

    // 设置员工职位
    public void setPosition(String position) {
        this.position = position;
    }

    // 重写toString方法，用于将Employee对象转换为字符串
    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", position='" + position + '\'' +
                '}';
    }
}