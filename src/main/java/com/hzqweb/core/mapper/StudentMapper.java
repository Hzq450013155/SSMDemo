package com.hzqweb.core.mapper;

import com.hzqweb.core.entity.Student;

import java.util.List;

public interface StudentMapper {

    public Student getStudentByid(Student student);

    public List<Student> getList();

    public void insertStudent(Student student);

    public void updateStudent(Student student);
}
