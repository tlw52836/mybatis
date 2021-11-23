package com.tlw;

import com.tlw.domain.Student;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;


public class MyTest {
    @Test
    public void testSelectStudentById() throws IOException {
        //获取SqlSessionFactory
        InputStream inputStream = Resources.getResourceAsStream("mybatis.xml");
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);

        //获取SqlSession
        SqlSession sqlSession = factory.openSession();

        String sqlId = "com.tlw.dao.StudentDao.selectStudentById";
        Student stu = sqlSession.selectOne(sqlId, 1002);

        System.out.println(stu);

        sqlSession.close();
    }

    @Test
    public void testInsetStudent() throws IOException {
        InputStream inputStream = Resources.getResourceAsStream("mybatis.xml");
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);

        SqlSession sqlSession = factory.openSession();

        String sqlId = "com.tlw.dao.StudentDao.insertStudent";

        Student stu = new Student();
        stu.setId(1004);
        stu.setName("张飞");
        stu.setEmail("zhangfei@qq.com");
        stu.setAge(45);

        int rows = sqlSession.insert(sqlId, stu);

        //mybatis默认执行sql语句是手工提交事务模式，在做insert，update，delete后需要提交事务
        sqlSession.commit();

        System.out.println(rows);

        sqlSession.close();
    }
}
