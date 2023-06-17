import com.stu.dao.ClassMapper;
import com.stu.dao.StudentMapper;
import com.stu.pojo.Class;
import com.stu.pojo.Student;
import com.stu.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class MybatisTest {
    // 查询id为2的学生的信息
    @Test
    public void findStudentInfoById() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        Student student = (Student) mapper.selectStudentById(2);
        System.out.println(student);
        sqlSession.close();
    }
    // 将id为4的学生姓名修改为李晓，年龄修改为22。
    @Test
    public void updateStudentInfoById() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        Student student = new Student(4, "李晓", 22, 2);
        int updateStudent = sqlSession.update("updateStudentById", student);
        if (updateStudent > 0) {
            System.out.println("更新成功");
        } else {
            System.out.println("更新失败");
        }
        sqlSession.commit();
        sqlSession.close();
    }
    // 一对多：查询出二班所有学生的信息
    @Test
    public void findClass(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        ClassMapper mapper = sqlSession.getMapper(ClassMapper.class);
        Class aClass = new Class();
        aClass.setClassname("二班");
        List<Class> classes = mapper.selectStudentByClassname(aClass);
        for (Class aClass1 : classes) {
            System.out.println(aClass1);
        }
        sqlSession.close();
    }
}
