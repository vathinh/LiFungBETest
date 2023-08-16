package com.tvt.lifungbetest.service.impl;

import com.tvt.lifungbetest.config.security.services.UserDetailsImpl;
import com.tvt.lifungbetest.dto.todo.ToDoRequest;
import com.tvt.lifungbetest.dto.todo.ToDoResponse;
import com.tvt.lifungbetest.dto.todo.UpdateTodoRequest;
import com.tvt.lifungbetest.mapstruct.TodoMapper;
import com.tvt.lifungbetest.model.ToDoEntity;
import com.tvt.lifungbetest.repository.ToDoRepository;
import com.tvt.lifungbetest.service.ToDoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class TodoServiceImpl implements ToDoService {
    private final ToDoRepository toDoRepository;
    private final TodoMapper todoMapper;

    @Override
    @Transactional(readOnly = true)
    public List<ToDoResponse> getAll() {
        return toDoRepository.findAll().stream()
                .map(todoMapper::toResponse)
                .toList();
    }

    @Override
    @Transactional(readOnly = true)
    public List<ToDoResponse> getAllForCurrentUser() {
        String currentUserEmail = getCurrentUserEmail();
        List<ToDoEntity> toDoEntities = toDoRepository.findByOwnerEmail(currentUserEmail);

        return toDoEntities.stream()
                .map(todoMapper::toResponse)
                .collect(Collectors.toList());
    }

    private String getCurrentUserEmail() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null && authentication.getPrincipal() instanceof UserDetailsImpl) {
            return ((UserDetailsImpl) authentication.getPrincipal()).getEmail();
        }
        return null;
    }

    @Override
    @Transactional(readOnly = true)
    public ToDoResponse getById(Long id) {
        ToDoEntity entity = toDoRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Entity not found"));
        return todoMapper.toResponse(entity);
    }

    @Override
    @Transactional
    public void create(ToDoRequest toDoRequest) {
        ToDoEntity newTodo = todoMapper.toEntity(toDoRequest);
        toDoRepository.save(newTodo);
    }

    @Override
    @Transactional
    public void update(Long id, UpdateTodoRequest updateTodoRequest) {
        ToDoEntity entity = toDoRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Entity not found"));
        todoMapper.updateMapper(updateTodoRequest, entity);
        toDoRepository.save(entity);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        ToDoEntity entity = toDoRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Entity not found"));
        entity.setDeleteFlag(true);
        toDoRepository.save(entity);
    }

}
