import com.pojo.Customer;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.utils.MybatisUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MyTest {
    /**
     * 根据客户姓名和职业组合条件查询客户信息列表
     */
    @Test
    public void findAll(){
       // 通过工具类获取SqlSession对象
        SqlSession sqlSession = MybatisUtils.getSqlSessionFactory();
        // 创建Customer对象，封装需要组合查询的条件
        List<Object> findAll = sqlSession.selectList("findAll");
        for (Object o : findAll) {
            System.out.println(o);
        }
        // 关闭SqlSession
        sqlSession.close();
    }
    /**
     * 根据客户的姓名和职业查询客户信息
     */
    @Test
    public void findCustomerByNameAndJobs(){
        SqlSession sqlSessionFactory = MybatisUtils.getSqlSessionFactory();
        Customer customer = new Customer();
//        customer.setUsername("joy");
        customer.setJobs("teacher");
        List<Object> customerByNameAndJobs = sqlSessionFactory.selectList("findCustomerByNameAndJobs", customer);
        for (Object o : customerByNameAndJobs) {
            System.out.println(o);
        }
        sqlSessionFactory.close();
    }
    /**
     * 根据客户的姓名或职业查询客户信息
     */
    @Test
    public void findCustomerByNameOrJobs(){
        SqlSession sqlSessionFactory = MybatisUtils.getSqlSessionFactory();
        Customer customer = new Customer();
//        customer.setUsername("joy");
//        customer.setJobs("teacher");
        List<Object> customerByNameOrJobs = sqlSessionFactory.selectList("findCustomerByNameOrJobs", customer);
        for (Object o : customerByNameOrJobs) {
            System.out.println(o);
        }
    }
    /**
     * 使用trim优化sql语句，根据客户的姓名或职业查询客户信息
     */
    @Test
    public void findCustomerByNameOrJobsByTrim(){
        SqlSession sqlSessionFactory = MybatisUtils.getSqlSessionFactory();
        Customer customer = new Customer();
//        customer.setUsername("joy");
//        customer.setJobs("teacher");
        List<Object> customerByNameOrJobs = sqlSessionFactory.selectList("findCustomerByNameAndJobsTrim", customer);
        for (Object o : customerByNameOrJobs) {
            System.out.println(o);
        }
    }
    /**
     * 使用trim优化sql语句，根据客户的姓名或职业查询客户信息
     */
    @Test
    public void updateCustomerBySetTest(){
        SqlSession sqlSessionFactory = MybatisUtils.getSqlSessionFactory();
        Customer customer = new Customer();
        customer.setId(1);
        customer.setUsername("joy");
        customer.setJobs("teacher");
        int i = sqlSessionFactory.update("updateCustomerBySetTest", customer);
        System.out.println(i);
        sqlSessionFactory.commit();
        sqlSessionFactory.close();
    }
    @Test
    /**
     * 使用trim优化sql语句，动态更新客户信息
     */
    public void updateCustomerTrimTest(){
        SqlSession sqlSessionFactory = MybatisUtils.getSqlSessionFactory();
        Customer customer = new Customer();
        customer.setId(1);
        customer.setUsername("joy");
        customer.setJobs("teacher");
        sqlSessionFactory.update("updateCustomerTrimTest", customer);
        sqlSessionFactory.commit();
        sqlSessionFactory.close();
    }
    /**
     * 通过数组查询客户信息
     */

    @Test
    public void findByArrayTest(){
        SqlSession sqlSessionFactory = MybatisUtils.getSqlSessionFactory();
        int[] id= {1,2,3};
        List<Object> findByArrayTest = sqlSessionFactory.selectList("findByArrayTest", id);
        for (Object o : findByArrayTest) {
            System.out.println(o);
        }
        sqlSessionFactory.close();
    }
    /**
     * 通过List查询客户信息
     */
    @Test
    public void findByListTest(){
        SqlSession sqlSessionFactory = MybatisUtils.getSqlSessionFactory();
        ArrayList<Integer> customers = new ArrayList<>();
        customers.add(1);
        customers.add(2);
        List<Object> findByListTest = sqlSessionFactory.selectList("findByListTest", customers);
        for (Object o : findByListTest) {
            System.out.println(o);
        }
        sqlSessionFactory.close();
    }
    /**
     * 通过Map查询客户信息
     */
    @Test
    public void findByMapTest(){
        SqlSession sqlSessionFactory = MybatisUtils.getSqlSessionFactory();
        ArrayList<Integer> integers = new ArrayList<>();
        integers.add(1);
        integers.add(2);
        HashMap<String, Object> stringObjectHashMap = new HashMap<>();
        stringObjectHashMap.put("id",integers);
        stringObjectHashMap.put("jobs","teacher");
        List<Customer> findByMapTest = sqlSessionFactory.selectList("findByMapTest", stringObjectHashMap);
        for (Customer c:findByMapTest) {
            System.out.println(c);
        }

    }
}
