package com.tvt.lifungbetest.dto.todo;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ToDoResponse {
    private Long id;
    private String description;
    private String createdBy;
}
