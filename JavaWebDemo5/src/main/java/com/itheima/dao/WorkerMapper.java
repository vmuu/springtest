package com.itheima.dao;

import com.itheima.pojo.Worker;
import org.apache.ibatis.annotations.*;

public interface WorkerMapper {
    @Select("select * from tb_worker where id = #{id}")
    Worker selecteWorker(int id);
    @Insert("insert into tb_worker(name,age,sex,worker_id) value(#{name},#{age},#{sex},#{worker_id})")
    int insertWorker(Worker worker);
    @Update("update tb_worker set name=#{name},age=#{age},sex=#{sex},worker_id=#{worker_id} where id=#{id}")
    int updateWorker(Worker worker);
    @Delete("delete from tb_worker where id=#{id}")
    int deleteWorker(int id);
    @Select("select * from tb_worker where id=#{id} and name=#{name}")
    Worker selectWorkerByIdAndName(@Param("id") int id,@Param("name") String name);

}
