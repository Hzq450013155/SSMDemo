/**
 * Copyright (C), 2015-2018, 上海汉得信息技术股份有限公司
 * FileName: StudentServiceImpl
 * Author:   zqh
 * Date:     2018-07-17 14:05
 * Description:
 */
package com.hzqweb.core.serviceImpl;

import com.hzqweb.core.entity.Student;
import com.hzqweb.core.mapper.StudentMapper;
import com.hzqweb.core.service.StudentService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    private static final Logger logger = Logger.getLogger(StudentServiceImpl.class);

    @Autowired
    private StudentMapper studentMapper;


    public List<Student> getList(Student student) {
        logger.info("===================查询学生列表=====================");
        List list = null;
        if (student.getId() == null) {
            list = studentMapper.getList(student);
        } else {
            list = studentMapper.getListByid(student);
        }
        return list;
    }

    /*
     *  新增学生（事务）
     * @author zongqi.hao@hand-china.com
     * @date 2018-07-18 15:33
     * @param [student]
     * @return void
     */
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void insert(Student student) {
        logger.info("===================新增学生=====================");
        studentMapper.insert(student);
    }

    /*
     *  更新学生
     * @author zongqi.hao@hand-china.com
     * @date 2018-07-18 15:34
     * @param [student]
     * @return void
     */
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void update(Student student) {
        logger.info("===================更新学生=====================");
        studentMapper.update(student);
    }

    public void delete(Student student) {
        logger.info("===================删除学生=====================");
        studentMapper.delete(student);
    }
}
