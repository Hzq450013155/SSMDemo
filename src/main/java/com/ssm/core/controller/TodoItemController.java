package com.ssm.core.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ssm.core.entity.TodoItem;
import com.ssm.core.service.TodoItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("todoItemController")
public class TodoItemController {

    @Autowired
    private TodoItemService todoItemService;

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));   //true:允许输入空值，false:不能为空值
    }


    /**
     * 获取待办事项列表
     *
     * @param request, response, model
     * @return org.springframework.web.servlet.ModelAndView
     * @author zongqi.hao@hand-china.com
     * @date 2018-07-21 15:42
     */
    @RequestMapping(params = "getList")
    public ModelAndView getList(@RequestParam(value = "pn", defaultValue = "1") Integer pn, HttpServletRequest request, HttpServletResponse response, TodoItem model) {
        model.setUserId((Long) request.getSession().getAttribute("userId"));
        //多数据源不能使用静态分页，线程不安全会导致数据错误
//        PageHelper.startPage(pn, 5);
        List<TodoItem> list = todoItemService.getList(model);
//        PageInfo page = new PageInfo(list, 5);
        ModelAndView mv = new ModelAndView("todoItemList");
//        mv.addObject("page", page);
        mv.addObject("list", list);
        return mv;
    }

    /**
     * @param request, response, model
     * @return java.util.List
     * @author zongqi.hao@hand-china.com
     * @date 2018-07-23 16:40
     */
    @RequestMapping(params = "getListJson")
    @ResponseBody
    public PageInfo getListJson(@RequestParam(value = "pn", defaultValue = "1") Integer pn, HttpServletRequest request, HttpServletResponse response, TodoItem model) {
        model.setUserId((Long) request.getSession().getAttribute("userId"));
        PageHelper.startPage(pn, 5);
        List<TodoItem> list = todoItemService.getList(model);
        PageInfo page = new PageInfo(list, 5);
        return page;
    }

    /**
     * 增加待办事项
     *
     * @param request, response, model
     * @return org.springframework.web.servlet.ModelAndView
     * @author zongqi.hao@hand-china.com
     * @date 2018-07-21 15:43
     */
    @RequestMapping(params = "insert")
    public ModelAndView insert(HttpServletRequest request, HttpServletResponse response, TodoItem model) {
        model.setUserId((Long) request.getSession().getAttribute("userId"));
        model.setCreationDate(new Date());
        todoItemService.insert(model);
        return getList(1, request, response, model);
    }

    /**
     * 更新待办事项
     *
     * @param request, response, model
     * @return org.springframework.web.servlet.ModelAndView
     * @author zongqi.hao@hand-china.com
     * @date 2018-07-21 15:43
     */
    @RequestMapping(params = "update")
    public ModelAndView update(HttpServletRequest request, HttpServletResponse response, TodoItem model) {
        todoItemService.update(model);
        model.setUserId((Long) request.getSession().getAttribute("userId"));
        model.setLastUpdateDate(new Date());
        todoItemService.update(model);
        return getList(1, request, response, model);
    }

    /**
     * 删除待办事项
     *
     * @param
     * @return
     * @author zongqi.hao@hand-china.com
     * @date 2018-07-21 15:44
     */
    @RequestMapping(params = "delete")
    @ResponseBody
    public Integer delete(HttpServletRequest request, HttpServletResponse response, TodoItem model) {
        Integer n = todoItemService.delete(model);
        if (n >= 1) {
            return 1;
        } else {
            return 0;
        }
    }


}
