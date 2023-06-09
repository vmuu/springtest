package com.itheima.dao;

import com.itheima.pojo.User;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

public interface UsersMapper {
    @Select("select * from tb_user where id = #{id}")
    @Results({@Result(id = true,column = "id",property = "id"),
            @Result(column = "username",property = "username"),
            @Result(column = "address",property = "address"),
            @Result(column = "id",property = "ordersList",many = @Many(select = "com.itheima.dao.OrderMapper.selecteOrderByUserId"))})
    User selectUserByIdTest(int id);
}
