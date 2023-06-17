package com.stu.dao;

import com.stu.pojo.Class;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface ClassMapper {
    // 一对多查询：查询出二班所有学生的信息
    @Select("select s.*,classname from s_student s,c_class c WHERE s.cid=c.id and classname=#{classname}")
    List<Class> selectStudentByClassname(Class classname);

}
