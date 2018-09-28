package com.ssm.core.serviceImpl;

import com.ssm.core.entity.TodoItem;
import com.ssm.core.mapper.TodoItemMapper;
import com.ssm.core.service.TodoItemService;
import com.ssm.datasource.DataSourceHolder;
import com.ssm.datasource.DataSourceType;
import com.ssm.datasource.DynamicDataSource;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Copyright (C), 2015-2018, 上海汉得信息技术股份有限公司
 * FileName: TodoItemServiceImpl
 * Author:   zqh
 * Date:     2018-07-17 14:05
 * Description:
 */

@Service
public class TodoItemServiceImpl implements TodoItemService {

    private static final Logger logger = Logger.getLogger(TodoItemServiceImpl.class);

    @Autowired
    private TodoItemMapper todoItemMapper;

    /*
     *  查询待办事项列表
     * @author zongqi.hao@hand-china.com
     * @date 2018-07-21 15:24
     * @param [model]
     * @return java.util.List<com.ssm.core.entity.TodoItem>
     */
//    @Transactional(transactionManager = "transactionManager",readOnly = false)
    public List<TodoItem> getList(TodoItem model) {
        logger.info("===================查询待办事项列表=====================");
//        if (model.getTodoItemId() == null) {
//        } else {
//            TodoItem todoItem = todoItemMapper.getListById(model.getTodoItemId());
//            list.add(todoItem);
//        }

        List<TodoItem> list = todoItemMapper.getList(model);
        DataSourceHolder.setDataSourceType(DataSourceType.dataSource2);
        List<TodoItem> list2 = todoItemMapper.getList(model);
        list.addAll(list2);
        return list;
    }


    /*
     *  新增待办事项（事务）
     * @author zongqi.hao@hand-china.com
     * @date 2018-07-18 15:33
     * @param [model]
     * @return void
     */
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public Integer insert(TodoItem model) {
        logger.info("===================新增待办事项=====================");
        return todoItemMapper.insert(model);
    }

    /*
     *  更新待办事项
     * @author zongqi.hao@hand-china.com
     * @date 2018-07-18 15:34
     * @param [model]
     * @return void
     */
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public Integer update(TodoItem model) {
        logger.info("===================更新待办事项=====================");
        return todoItemMapper.update(model);
    }

    /*
     *  删除待办事项
     * @author zongqi.hao@hand-china.com
     * @date 2018-07-21 15:24
     * @param [model]
     * @return void
     */
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public Integer delete(TodoItem model) {
        logger.info("===================删除待办事项=====================");
        return todoItemMapper.delete(model.getTodoItemId());
    }
}