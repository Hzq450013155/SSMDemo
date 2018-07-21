package com.hzqweb.core.service;


import com.hzqweb.core.entity.Student;

import java.util.List;


public interface StudentService {


    public List<Student> getList(Student student);

    public void insert(Student student);

    public void update(Student student);

    public void delete(Student student);


}
