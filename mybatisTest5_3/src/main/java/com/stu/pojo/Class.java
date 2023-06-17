package com.stu.pojo;

import java.util.List;

public class Class {
    private int id;
    private String classname;
    private List<Student> studentList;

    @Override
    public String toString() {
        return "Class{" +
                "id=" + id +
                ", classname='" + classname + '\'' +
                ", studentList=" + studentList +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getClassname() {
        return classname;
    }

    public void setClassname(String classname) {
        this.classname = classname;
    }

    public List<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
    }

    public Class(int id, String classname, List<Student> studentList) {
        this.id = id;
        this.classname = classname;
        this.studentList = studentList;
    }

    public Class() {
    }
}