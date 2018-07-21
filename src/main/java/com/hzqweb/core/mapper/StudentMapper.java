package com.hzqweb.core.mapper;

import com.hzqweb.core.entity.Student;

import java.util.List;

public interface StudentMapper {

    public List<Student> getListByid(Student student);

    public List<Student> getList(Student student);

    public void insert(Student student);

    public void update(Student student);

    public void delete(Student student);
}
