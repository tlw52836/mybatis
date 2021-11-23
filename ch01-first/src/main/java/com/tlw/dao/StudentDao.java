package com.tlw.dao;

import com.tlw.domain.Student;

public interface StudentDao {
    Student selectStudentById(Integer id);
    int insertStudent(Student stu);
}
