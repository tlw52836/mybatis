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
    People selectById(Integer id);

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
    Map selectMap(Integer id);


}
