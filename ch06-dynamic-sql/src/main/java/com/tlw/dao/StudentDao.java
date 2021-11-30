package com.tlw.dao;

import com.tlw.domain.Student;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface StudentDao {

   /**
    * if标签
    * @param stu
    * @return
    */
   List<Student> selectIf(Student stu);

   /**
    * where标签
    * @param stu
    * @return
    */
   List<Student> selectWhere(Student stu);


   /**
    * foreach标签 1
    * @param list
    * @return
    */
   List<Student> selectForeachOne(@Param("myList") List<Integer> list);

   /**
    * 测试pagehelper的分页功能
    * @return
    */
   List<Student> selectAllStudents();

}
