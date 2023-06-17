package com.stu.dao;

import com.stu.pojo.Student;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface StudentMapper {
    // 查询id为2的学生的信息
    @Select("select * from s_student where id=#{id}")
    Student selectStudentById(int id);
    // 将id为4的学生姓名修改为李晓，年龄修改为22。
    @Update("update s_student set name=#{name},age=#{age} where id=#{id}")
    int updateStudentById(Student student);
}
