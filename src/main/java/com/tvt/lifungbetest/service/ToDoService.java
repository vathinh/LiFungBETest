package com.tvt.lifungbetest.service;

import com.tvt.lifungbetest.dto.todo.ToDoRequest;
import com.tvt.lifungbetest.dto.todo.ToDoResponse;
import com.tvt.lifungbetest.dto.todo.UpdateTodoRequest;

import java.util.List;

public interface ToDoService {
    List<ToDoResponse> getAll();
    List<ToDoResponse> getAllForCurrentUser();
    ToDoResponse getById(Long id);
    void create(ToDoRequest toDoRequest);
    void update(Long id, UpdateTodoRequest updateTodoRequest);
    void delete(Long id);
}
