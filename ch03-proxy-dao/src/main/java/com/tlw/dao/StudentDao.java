package com.tlw.dao;

import com.tlw.domain.Student;

import java.util.List;

public interface StudentDao {
    Student selectStudentById(Integer id);

    List<Student> selectStudents();

    int insertStudent(Student stu);
}
