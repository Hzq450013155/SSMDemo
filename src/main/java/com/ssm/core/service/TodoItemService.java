package com.ssm.core.service;


import com.ssm.core.entity.TodoItem;

import java.util.List;


public interface TodoItemService {


    List<TodoItem> getList(TodoItem student);

    Integer insert(TodoItem student);

    Integer update(TodoItem student);

    Integer delete(TodoItem student);


}
