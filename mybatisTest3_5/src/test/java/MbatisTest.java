import com.stu.pojo.Student;
import com.stu.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class MbatisTest {
    // 多条件查询
    @Test
    public void selectStuInfoByNameOrMajor1(){
        Student student = new Student();
        student.setName("杨明金");
        student.setMajor("计算机科学与技术");
        SqlSession sqlSessionFactory = MybatisUtils.getSqlSessionFactory();
        List<Student> selectStuInfoByNameOrMajor = sqlSessionFactory.selectList("selectStuInfoByNameOrMajor", student);
        System.out.println("当用户输入的学生姓名不为空，则只根据学生姓名进行学生信息的查询：");
        for (Student stu:selectStuInfoByNameOrMajor) {
            System.out.println(stu);
        }
        sqlSessionFactory.close();
    }
    @Test
    public void selectStuInfoByNameOrMajor2(){
        Student student = new Student();
        student.setMajor("计算机科学与技术");
        SqlSession sqlSessionFactory = MybatisUtils.getSqlSessionFactory();
        List<Student> selectStuInfoByNameOrMajor = sqlSessionFactory.selectList("selectStuInfoByNameOrMajor", student);
        System.out.println("当用户输入的学生姓名为空，而学生专业不为空时，则只根据学生专业进行学生信息的查询：");
        for (Student stu:selectStuInfoByNameOrMajor) {
            System.out.println(stu);
        }
        sqlSessionFactory.close();
    };
    @Test
    public void selectStuInfoByNameOrMajor3(){
        Student student = new Student();
        SqlSession sqlSessionFactory = MybatisUtils.getSqlSessionFactory();
        List<Student> selectStuInfoByNameOrMajor = sqlSessionFactory.selectList("selectStuInfoByNameOrMajor", student);
        System.out.println("当用户输入的学生姓名和专业都为空，则要求查询出所有学号不为空的学生信息：");
        for (Student stu:selectStuInfoByNameOrMajor) {
            System.out.println(stu);
        }
    }
    // 单条件查询
    @Test
    public void findByListTest() {
        SqlSession sqlSession = MybatisUtils.getSqlSessionFactory();
        List<Integer> ids = new ArrayList<Integer>();
        for (int i = 1; i < 5; i++) {
            ids.add(i);
        }
        System.out.println("查询出所有id值小于5且姓李的学生信息：");
        List<Student> students = sqlSession.selectList("findByList", ids);
        for (Student student : students) {
            System.out.println(student);
        }
        sqlSession.close();
    }
    @Test
    public void findByArrayTest() {
        SqlSession sqlSession = MybatisUtils.getSqlSessionFactory();
        System.out.println("查询出各门课的学生人数：");
        List<Object> findByArray = sqlSession.selectList("selectStudentCountByMajor");
        for (Object o : findByArray) {
            System.out.println(o);
        }
        sqlSession.close();
    }

}
