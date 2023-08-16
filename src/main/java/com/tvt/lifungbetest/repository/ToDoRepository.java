package com.tvt.lifungbetest.repository;

import com.tvt.lifungbetest.model.ToDoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ToDoRepository extends JpaRepository<ToDoEntity, Long> {

    @Query("SELECT t FROM ToDoEntity t WHERE t.deleteFlag = false AND t.createdBy = :email")
    List<ToDoEntity> findByOwnerEmail(@Param("email") String email);
}
