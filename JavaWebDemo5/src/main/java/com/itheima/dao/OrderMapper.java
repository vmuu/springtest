package com.itheima.dao;

import com.itheima.pojo.Order;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface OrderMapper {
    @Select("select * from tb_orders")
    @Results({@Result(id = true,column = "id",property = "id"),@Result(column = "number",property = "number")})
    List<Order> selecteOrderByUserId(int i);
}
