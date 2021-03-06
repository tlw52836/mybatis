package com.tlw;

import com.github.pagehelper.PageHelper;
import com.tlw.dao.StudentDao;
import com.tlw.domain.Student;
import com.tlw.utils.MybatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.io.IOException;
import java.util.List;


public class MyTest {
    @Test
    public void testSelectIf() throws IOException {
        //1.获取SqlSession
        SqlSession sqlSession = MybatisUtil.getSqlSession();

        //2.获取dao的代理
        StudentDao studentDao = sqlSession.getMapper(StudentDao.class);

        Student stu = new Student();
        stu.setName("%李%");
        stu.setAge(24);

        List<Student> stus = studentDao.selectIf(stu);

        stus.forEach(s-> System.out.println(s));

        sqlSession.close();
    }

    @Test
    public void testSelectWhere() throws IOException {
        //1.获取SqlSession
        SqlSession sqlSession = MybatisUtil.getSqlSession();

        //2.获取dao的代理
        StudentDao studentDao = sqlSession.getMapper(StudentDao.class);

        Student stu = new Student();
        stu.setName("%李%");
        stu.setAge(24);

        List<Student> stus = studentDao.selectWhere(stu);

        stus.forEach(s-> System.out.println(s));

        sqlSession.close();
    }

    @Test
    public void testSelectForeachOne() throws IOException {
        //1.获取SqlSession
        SqlSession sqlSession = MybatisUtil.getSqlSession();

        //2.获取dao的代理
        StudentDao studentDao = sqlSession.getMapper(StudentDao.class);

        Student stu = new Student();
        stu.setName("%李%");
        stu.setAge(24);

        List<Student> stus = studentDao.selectWhere(stu);

        stus.forEach(s-> System.out.println(s));

        sqlSession.close();
    }

    @Test
    public void testPageHelper() throws IOException {
        //1.获取SqlSession
        SqlSession sqlSession = MybatisUtil.getSqlSession();

        //2.获取dao的代理
        StudentDao studentDao = sqlSession.getMapper(StudentDao.class);
        //pageNum:第几页  pageSize:每页几条数据
        PageHelper.startPage(2, 2);
        List<Student> stus = studentDao.selectAllStudents();

        stus.forEach(s-> System.out.println(s));

        sqlSession.close();
    }
}
