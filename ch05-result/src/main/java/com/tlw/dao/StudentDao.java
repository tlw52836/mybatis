package com.tlw.dao;

import com.tlw.domain.People;
import com.tlw.domain.Student;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface StudentDao {

    /**
     *
     * @param id
     * @return
     */
    People selectById(@Param("stuId") Integer id);

    /**
     * 返回一个简单参数
     * @return
     */
    long countStudent();


    /**
     * Map只能返回一行数据
     * @param id
     * @return
     */
    Map selectMap(@Param("stuId") Integer id);

    /**
     * like的第一种方式
     * @param name
     * @return
     */
    List<Student> likeOne(@Param("stuName") String name);

    /**
     * like的第二种方式
     * @param name
     * @return
     */
    List<Student> likeTwo(@Param("stuName") String name);

}
