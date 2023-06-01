import cn.ik20.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import javax.annotation.Resource;
import java.io.IOException;
import java.io.Reader;

public class UserTest {
    @Test
    public void userByIdTest() throws IOException {
        // 创建流
        Reader reader = null;
        // 读取mybatis-config.xml 文件内容分到reader对象中
        reader = Resources.getResourceAsReader("mybatis-config.xml");
        // 初始化Mybatis数据库，创建SqlSessionFactory对象
        SqlSessionFactory sqlMapper = new SqlSessionFactoryBuilder().build(reader);
        // 创建SqlSession实例
        SqlSession sqlSession = sqlMapper.openSession();
        // 传入参数查询，返回结构
        User user = sqlSession.selectOne("findById",1);
        // 输出结果
        System.out.println(user.toString());
        // 关闭SqlSession
        sqlSession.close();
    }
}
