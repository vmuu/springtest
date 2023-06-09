package com.itheima.dao;

import com.itheima.pojo.Orders;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

public interface OrdersMapper {
    @Select("select * from tb_orders where id = #{id}")
    @Results({@Result(id = true,column = "id",property = "id"),
            @Result(column = "number",property = "number")
            ,@Result(column = "id",property = "productList",many = @Many(select = "com.itheima.dao.ProductMapper.selectProductByOrdersId"))})
    Orders selectOerdersById(int id);
}
