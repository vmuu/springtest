import com.itheima.dao.OrdersMapper;
import com.itheima.dao.PersonMapper;
import com.itheima.dao.UsersMapper;
import com.itheima.pojo.Orders;
import com.itheima.pojo.Person;
import com.itheima.pojo.User;
import com.itheima.utils.MybatisUtils;
import com.itheima.dao.WorkerMapper;
import com.itheima.pojo.Worker;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

public class MybatisTest {
    /**
     *  @Select 实例
     */
    @Test
    public void findWorkerByIdTest(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        WorkerMapper mapper = sqlSession.getMapper(WorkerMapper.class);
        Worker worker = (Worker) mapper.selecteWorker(1);
        System.out.println(worker);
        sqlSession.close();
    }
    /**
     *  @Insert 实例
     */
    @Test
    public void insertWorkerTest(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        WorkerMapper mapper = sqlSession.getMapper(WorkerMapper.class);
        Worker worker = new Worker(1, "张三1", 33, "男", 0);
        int insertWorker = sqlSession.insert("insertWorker", worker);
        if (insertWorker>0){
            System.out.println("插入成功");
        }else {
            System.out.println("插入失败");
        }
        sqlSession.commit();
        sqlSession.close();
    }
    /**
     *  @Update 实例
     */
    @Test
    public void updateWorkerTest(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        WorkerMapper mapper = sqlSession.getMapper(WorkerMapper.class);
        Worker worker = new Worker(4, "张三2", 666, "男", 1004);
        int updateWorker = sqlSession.update("updateWorker", worker);
        if (updateWorker>0){
            System.out.println("更新成功");
        }else {
            System.out.println("更新失败");
        }
        sqlSession.commit();
        sqlSession.close();
    }
    /**
     *  @Delete 实例
     */
    @Test
    public void deleteWorkerTest(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        WorkerMapper mapper = sqlSession.getMapper(WorkerMapper.class);
        int deleteWorker = sqlSession.delete("deleteWorker", 4);
        if (deleteWorker>0){
            System.out.println("删除成功");
        }else {
            System.out.println("删除失败");
        }
        sqlSession.commit();
        sqlSession.close();
    }
    /**
     * @Param 实例
     */
    @Test
    public void selectWorkerByIdAndNameTest(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        WorkerMapper mapper = sqlSession.getMapper(WorkerMapper.class);
        Worker worker = mapper.selectWorkerByIdAndName(1, "张三");
        System.out.println(worker);
        sqlSession.close();
    }
    /**
     * @One 一对一关系实例
     */
    @Test
    public void selectPersonByIdTest(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        PersonMapper mapper = sqlSession.getMapper(PersonMapper.class);
        Person person = mapper.selectPersonById(1);
        System.out.println(person);
        sqlSession.close();
    }
    /**
     * @Many 一对多关系实例：查询用户信息，关联查询用户下的多个订单信息
     */
    @Test
    public void selectUserByIdTest(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UsersMapper mapper = sqlSession.getMapper(UsersMapper.class);
        User users = mapper.selectUserByIdTest(1);
        System.out.println(users);
        sqlSession.close();
    }
    /**
     * @Many 多对多关系实例：查询多订单信息，关联查询订单下的商品信息
     */
    @Test
    public void selectOrdersById(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        OrdersMapper mapper = sqlSession.getMapper(OrdersMapper.class);
        Orders orders = mapper.selectOerdersById(1);
        System.out.println(orders);
        sqlSession.close();
    }

}
