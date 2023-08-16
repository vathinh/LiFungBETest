package com.tvt.lifungbetest.controller;


import com.tvt.lifungbetest.dto.todo.ToDoRequest;
import com.tvt.lifungbetest.dto.todo.ToDoResponse;
import com.tvt.lifungbetest.dto.todo.UpdateTodoRequest;
import com.tvt.lifungbetest.service.ToDoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.tvt.lifungbetest.controller.ControllerEndPoints.TODO_PATH;

@RestController
@RequestMapping(TODO_PATH)
@Slf4j
@RequiredArgsConstructor
public class ToDoController {

    private final ToDoService toDoService;

    @GetMapping
    public List<ToDoResponse> get() {
        return toDoService.getAllForCurrentUser();
    }

    @GetMapping("getAll")
    @PreAuthorize("hasRole('ADMIN')")
    public List<ToDoResponse> getAll() {
        return toDoService.getAll();
    }

    @PostMapping
    public void create(@RequestBody ToDoRequest toDoRequest) {
        toDoService.create(toDoRequest);
    }

    @PutMapping("{id}")
    public void update(@PathVariable Long id, @RequestBody UpdateTodoRequest updateTodoRequest) {
        toDoService.update(id, updateTodoRequest);
    }

    @GetMapping("{id}")
    public ToDoResponse getById(@PathVariable Long id){
        return toDoService.getById(id);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Long id){
        toDoService.delete(id);
    }
}
