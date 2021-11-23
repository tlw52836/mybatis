package com.tlw;

import com.tlw.dao.StudentDao;
import com.tlw.domain.Student;
import com.tlw.utils.MybatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.io.IOException;
import java.util.List;


public class MyTest {
    @Test
    public void testSelectStudentById() throws IOException {
        //1.获取SqlSession
        SqlSession sqlSession = MybatisUtil.getSqlSession();

        //2.获取dao的代理
        StudentDao studentDao = sqlSession.getMapper(StudentDao.class);

        Student stu = studentDao.selectStudentById(1001);

        System.out.println(stu);

        //3.关闭SqlSession
        sqlSession.close();

    }

    @Test
    public void testSelectStudents() {
        SqlSession sqlSession = MybatisUtil.getSqlSession();

        StudentDao studentDao = sqlSession.getMapper(StudentDao.class);

        List<Student> stus = studentDao.selectStudents();

        for (Student stu:stus) {
            System.out.println(stu);
        }

        sqlSession.close();
    }

    @Test
    public void testInsetStudent() throws IOException {
        SqlSession sqlSession = MybatisUtil.getSqlSession();

        StudentDao studentDao = sqlSession.getMapper(StudentDao.class);

        Student stu = new Student();
        stu.setId(1004);
        stu.setName("张飞");
        stu.setEmail("zhangfei@qq.com");
        stu.setAge(45);

        int rows = studentDao.insertStudent(stu);

        System.out.println("rows:" + rows);

        sqlSession.close();
    }
}
