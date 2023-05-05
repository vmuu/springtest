package com.emp.pojo;

public class Employee {
    private int id;
    private String name;
    private int age;
    private String position;
    // toString方法
    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name=" + name +
                ", age=" + age +
                ", position=" + position +
                '}';
    }
    // 无参构造
    public Employee() {
    }
    // 有参构造
    public Employee(int id, String name, int age, String position) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.position = position;
    }
    // get和set方法
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }
}