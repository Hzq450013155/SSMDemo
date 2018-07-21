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


    @RequestMapping(params = "getList")
    public ModelAndView getList(HttpServletRequest request, HttpServletResponse response, Student model) {
        List list = studentService.getList(model);
        request.setAttribute("list", list);
        return new ModelAndView("list");
    }


    @RequestMapping(params = "insert")
    public ModelAndView insert(HttpServletRequest request, HttpServletResponse response, Student model) {
        studentService.insert(model);
        return getList(request,response,new Student());
    }

    @RequestMapping(params = "update")
    public ModelAndView update(HttpServletRequest request, HttpServletResponse response, Student model) {
        studentService.update(model);
        return getList(request,response,new Student());
    }

    @RequestMapping(params = "delete")
    public ModelAndView delete(HttpServletRequest request, HttpServletResponse response, Student model) {
        studentService.delete(model);
        return getList(request,response,new Student());
    }


}
