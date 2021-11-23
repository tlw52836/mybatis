package com.tlw;

import com.tlw.dao.StudentDao;
import com.tlw.dao.StudentDaoImpl;
import com.tlw.domain.Student;
import com.tlw.utils.MybatisUtil;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;


public class MyTest {
    @Test
    public void testSelectStudentById() throws IOException {
        StudentDao studentDao = new StudentDaoImpl();

        Student stu = studentDao.selectStudentById(1001);

        System.out.println(stu);

    }

    @Test
    public void testSelectStudents() {
        StudentDao studentDao = new StudentDaoImpl();

        List<Student> stus = studentDao.selectStudents();

        for (Student stu:stus) {
            System.out.println(stu);
        }
    }

    @Test
    public void testInsetStudent() throws IOException {
        StudentDao studentDao = new StudentDaoImpl();

        Student stu = new Student();
        stu.setId(1004);
        stu.setName("张飞");
        stu.setEmail("zhangfei@qq.com");
        stu.setAge(45);

        int rows = studentDao.insertStudent(stu);

        System.out.println("rows:" + rows);


    }
}
