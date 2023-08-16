package com.tvt.lifungbetest.mapstruct;

import com.tvt.lifungbetest.dto.todo.ToDoRequest;
import com.tvt.lifungbetest.dto.todo.ToDoResponse;
import com.tvt.lifungbetest.dto.todo.UpdateTodoRequest;
import com.tvt.lifungbetest.model.ToDoEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring", uses = EntityMapper.class)
public interface TodoMapper {

    ToDoEntity toEntity(ToDoRequest toDoRequest);

    ToDoResponse toResponse(ToDoEntity toDoEntity);

    void updateMapper(UpdateTodoRequest request,
                      @MappingTarget ToDoEntity entity);
}
