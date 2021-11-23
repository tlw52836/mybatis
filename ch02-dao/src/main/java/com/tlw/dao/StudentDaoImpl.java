package com.tlw.dao;

import com.tlw.domain.Student;
import com.tlw.utils.MybatisUtil;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;
import java.util.List;

public class StudentDaoImpl implements StudentDao{
    @Override
    public Student selectStudentById(Integer id) {
        SqlSession sqlSession = MybatisUtil.getSqlSession();

        String sqlId = "com.tlw.dao.StudentDao.selectStudentById";
        Student stu = sqlSession.selectOne(sqlId, 1002);

        sqlSession.close();

        return stu;
    }

    @Override
    public List<Student> selectStudents() {
        SqlSession sqlSession = MybatisUtil.getSqlSession();

        String sqlId = "com.tlw.dao.StudentDao.selectStudents";
        List<Student> stus = sqlSession.selectList(sqlId);

        return stus;
    }

    @Override
    public int insertStudent(Student stu) {

        SqlSession sqlSession = MybatisUtil.getSqlSession();

        String sqlId = "com.tlw.dao.StudentDao.insertStudent";

        int rows = sqlSession.insert(sqlId, stu);

        //mybatis默认执行sql语句是手工提交事务模式，在做insert，update，delete后需要提交事务
        sqlSession.commit();

        sqlSession.close();

        return rows;
    }
}
