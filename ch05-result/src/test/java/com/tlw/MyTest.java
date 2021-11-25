package com.tlw;

import com.tlw.dao.StudentDao;
import com.tlw.domain.People;
import com.tlw.domain.Student;
import com.tlw.utils.MybatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class MyTest {
    @Test
    public void testSelectById() throws IOException {
        //1.获取SqlSession
        SqlSession sqlSession = MybatisUtil.getSqlSession();

        //2.获取dao的代理
        StudentDao studentDao = sqlSession.getMapper(StudentDao.class);

        People people = studentDao.selectById(1001);

        System.out.println(people);

        //3.关闭SqlSession
        sqlSession.close();

    }

    @Test
    public void testCountStudent() {
        //1.获取SqlSession
        SqlSession sqlSession = MybatisUtil.getSqlSession();

        //2.获取dao的代理
        StudentDao studentDao = sqlSession.getMapper(StudentDao.class);

        long count = studentDao.countStudent();

        System.out.println("count:" + count);
    }

    @Test
    public void testSelectMap() {
        //1.获取SqlSession
        SqlSession sqlSession = MybatisUtil.getSqlSession();

        //2.获取dao的代理
        StudentDao studentDao = sqlSession.getMapper(StudentDao.class);

        Map map = studentDao.selectMap(1001);

        System.out.println("Map:" + map);
    }
}
