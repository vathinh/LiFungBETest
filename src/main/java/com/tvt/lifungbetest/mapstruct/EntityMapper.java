package com.tvt.lifungbetest.mapstruct;

import com.tvt.lifungbetest.model.ToDoEntity;
import com.tvt.lifungbetest.repository.ToDoRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class EntityMapper {

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    ToDoRepository toDoRepository;

    public ToDoEntity mappingTodo(Long todoId) {
        if (todoId == null) {
            return null;
        }
        return toDoRepository.findById(todoId).orElse(null);
    }

}
