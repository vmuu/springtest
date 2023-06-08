import com.pojo.Book;
import com.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class MyBatisTest {
    /**
     * 根据ID查询证件信息
     */
    @Test
    public void findCardById(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        Object findCardById = sqlSession.selectOne("findCardById", 1);
        System.out.println(findCardById);
        sqlSession.close();
    }

    /**
     * 嵌套查询：通过执行另外一条SQL映射语句来返回预期的特殊类型
     */
    @Test
    public void findPersonById(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        Object findPersonById = sqlSession.selectOne("findPersonById", 1);
        System.out.println(findPersonById);
        sqlSession.close();
    }

    /**
     * 嵌套结果：使用嵌套结果映射来处理重复的联合结果的子集
     */
    @Test
    public void findPersonByIds(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        Object findPersonByIds = sqlSession.selectOne("findPersonByIds", 1);
        System.out.println(findPersonByIds);
        sqlSession.close();
    }

    /**
     * 一对多，嵌套结果
     */
    @Test
    public void findUsersById(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        Object findUserWithOrders = sqlSession.selectOne("findUserWithOrders", 1);
        System.out.println(findUserWithOrders);
        sqlSession.close();
    }

    /**
     * 多对多，嵌套查询
     */
    @Test
    public void findOrdersTest(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        Object findOrdersWithProduct = sqlSession.selectOne("findOrdersWithProduct", 1);
        System.out.println(findOrdersWithProduct);
        sqlSession.close();
    }

    /**
     * 多对多，嵌套结果
     */
    @Test
    public void findOrdersTest2(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        List<Object> findOrdersWithProduct = sqlSession.selectList("findOrdersWithOroduct2", 1);
        System.out.println(findOrdersWithProduct);
        sqlSession.close();
    }

    /**
     * 一级缓存实例，通过ID查询图书信息
     */
    @Test
    public void findBookById(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        Object findBookById = sqlSession.selectOne("findBookById", 1);
        System.out.println(findBookById);
        Object findBookById2 = sqlSession.selectOne("findBookById", 1);
        System.out.println(findBookById2);
        sqlSession.close();
    }

    /**
     * 一级缓存实例，通过ID更新图书信息，缓存会随着更新
     */
    @Test
    public void uptateBook(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        Object findBookById = sqlSession.selectOne("findBookById", 1);
        System.out.println(findBookById);
        Book javabook = new Book(1, "java基础入门", 45.1, "传智播客高教产品研发部");
        int updateBook = sqlSession.update("updateBook", javabook);
        sqlSession.commit();
        System.out.println(updateBook);
        Object findBookById2 = sqlSession.selectOne("findBookById", 1);
        System.out.println(findBookById2);
        sqlSession.close();
    }
    /**
     * 二级级缓存实例，通过ID查询图书信息
     */
    @Test
    public void findBookByIdTest(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        Object findBookById = sqlSession.selectOne("findBookById", 1);
        System.out.println(findBookById);
        sqlSession.close();
        SqlSession sqlSession1 = MybatisUtils.getSqlSession();
        Object findBookById1 = sqlSession1.selectOne("findBookById", 1);
        System.out.println(findBookById1);
        sqlSession1.close();
    }
    /**
     * 二级级缓存实例，更新后缓存更新
     */
    @Test
    public void findBookByIdTestUpdate(){
        SqlSession sqlSession1 = MybatisUtils.getSqlSession();
        SqlSession sqlSession2 = MybatisUtils.getSqlSession();
        SqlSession sqlSession3 = MybatisUtils.getSqlSession();
        Book book1 = sqlSession1.selectOne("findBookById", 1);
        System.out.println(book1);
        sqlSession1.close();
        Book book2 = new Book();
        book2.setId(2);
        book2.setBookName("Java Web 程序开发进阶");
        int update = sqlSession2.update("updateBook",book2);
        System.out.println(update);
        Book book3 = sqlSession3.selectOne("findBookById", 1);
        System.out.println(book3);
        sqlSession3.close();

    }
}
