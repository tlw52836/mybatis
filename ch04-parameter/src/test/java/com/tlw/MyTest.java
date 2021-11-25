package com.tlw;

import com.tlw.dao.StudentDao;
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

        Student stu = studentDao.selectById(1001);

        System.out.println(stu);

        //3.关闭SqlSession
        sqlSession.close();

    }

    @Test
    public void selectByNameOrEmail() {
        //1.获取SqlSession
        SqlSession sqlSession = MybatisUtil.getSqlSession();

        //2.获取dao的代理
        StudentDao studentDao = sqlSession.getMapper(StudentDao.class);

        List<Student> stus = studentDao.selectByNameOrEmail("张三", "lisi@qq.com");

        for (Student stu:stus) {
            System.out.println(stu);
        }

        //3.关闭SqlSession
        sqlSession.close();
    }

    @Test
    public void selectByObject() {
        //1.获取SqlSession
        SqlSession sqlSession = MybatisUtil.getSqlSession();

        //2.获取dao的代理
        StudentDao studentDao = sqlSession.getMapper(StudentDao.class);

        Student stu = new Student();
        stu.setName("张三");
        stu.setAge(24);

        List<Student> stus = studentDao.selectByObject(stu);

        for (Student s:stus) {
            System.out.println(s);
        }

        //3.关闭SqlSession
        sqlSession.close();
    }

    @Test
    public void selectByMap() {
        //1.获取SqlSession
        SqlSession sqlSession = MybatisUtil.getSqlSession();

        //2.获取dao的代理
        StudentDao studentDao = sqlSession.getMapper(StudentDao.class);

        Map<String, Object> map = new HashMap<>();
        map.put("myName", "李四");
        map.put("myAge", 22);


        List<Student> stus = studentDao.selectByMap(map);

        for (Student s:stus) {
            System.out.println(s);
        }

        //3.关闭SqlSession
        sqlSession.close();
    }

}
