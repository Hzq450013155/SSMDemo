package com.ssm.core.mapper;

import com.ssm.core.entity.Student;

import java.util.List;

public interface StudentMapper {

    List<Student> getListByid(Student student);

    List<Student> getList(Student student);

    void insert(Student student);

    void update(Student student);

    void delete(Student student);
}
