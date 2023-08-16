package com.tvt.lifungbetest.dto.todo;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UpdateTodoRequest {
    private String description;
}
