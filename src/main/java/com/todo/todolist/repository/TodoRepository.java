package com.todo.todolist.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.todo.todolist.model.Todo;

@Repository
public interface TodoRepository extends JpaRepository<Todo, Long> {
    public Todo findById(int id);
}
