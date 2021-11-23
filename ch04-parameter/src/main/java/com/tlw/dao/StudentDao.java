package com.tlw.dao;

import com.tlw.domain.Student;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface StudentDao {
    /**
     * 一个参数
     * @param id
     * @return
     */
    Student selectById(Integer id);

    /**
     * 多个参数
     * @param name
     * @param email
     * @return
     */
    List<Student> selectByNameOrEmail(@Param(value = "myName") String name, @Param("myEmail") String email);

    /**
     * 对象
     * @param stu
     * @return
     */
    List<Student> selectByObject(Student stu);

    /**
     * Map
     * @param map
     * @return
     */
    List<Student> selectByMap(Map<String, Object> map);

}
