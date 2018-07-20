package com.hzqweb.core.controller;

import com.hzqweb.core.entity.Student;
import com.hzqweb.core.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;


@Controller
@RequestMapping("studentController")
public class StudentController {

    @Autowired
    private StudentService studentService;

    /*
     *  学生数据展示
     * @author zongqi.hao@hand-china.com
     * @date 2018-07-18 10:14
     * @param [request, response, model]
     * @return org.springframework.web.servlet.ModelAndView
     */
    @RequestMapping(params = "datagrid")
    public ModelAndView datagrid(HttpServletRequest request, HttpServletResponse response, Student model) {

        List list = null;
        if (model.getId() == null) {
            list = studentService.getList();
        } else {
            Student student = studentService.getStudentByid(model);
            if (student != null) {
                list.add(student);
            }
        }
        request.setAttribute("list", list);
        return new ModelAndView("list");
    }


    @RequestMapping(params = "insert")
    public ModelAndView insert(HttpServletRequest request, HttpServletResponse response, Student model) {
        studentService.insertStudent(model);
        return datagrid(request,response,new Student());
    }


}
