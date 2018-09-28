package com.ssm.core.mapper;


import com.ssm.core.entity.TodoItem;

import java.util.List;

public interface TodoItemMapper {

    TodoItem getListById(Long todoItemId);

    List<TodoItem> getList(TodoItem todoItem);

    int delete(Long todoItemId);

    int insert(TodoItem record);

    int update(TodoItem record);

}