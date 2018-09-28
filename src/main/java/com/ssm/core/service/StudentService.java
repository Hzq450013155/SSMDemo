package com.ssm.core.service;


import com.ssm.core.entity.Student;

import java.util.List;


public interface StudentService {


    List<Student> getList(Student student);

    void insert(Student student);

    void update(Student student);

    void delete(Student student);


}
