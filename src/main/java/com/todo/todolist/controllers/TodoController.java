package com.todo.todolist.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.todo.todolist.model.Todo;
import com.todo.todolist.service.TodoService;

@RestController
public class TodoController {

    @Autowired
    @Lazy
    private TodoService todoService;

    @GetMapping("/")
    public String home() {
        return "Welcome to the Todo List API!";
    }

    @GetMapping("/todos")
    public List<Todo> getTodos() {
        return this.todoService.getAllTodos();
    }

    @PostMapping("/todos")
    public ResponseEntity<Todo> createTodo(@RequestBody Todo todo) {
        return ResponseEntity.ok(todoService.saveOrUpdate(todo));
    }

    @DeleteMapping("/todos")
    public String deleteTodos() {
        try {
            this.todoService.deleteAllTodos();
            return "All todos deleted!";
        } catch (Exception e) {
            return "Error deleting todos!";
        }
    }

    @DeleteMapping("/todos/{id}")
    public String deleteTodo(@PathVariable Long id) {
        try {
            this.todoService.deleteTodoById(id);
            return "Todo deleted!";
        } catch (Exception e) {
            return "Error deleting todo!";
        }
    }

    @PutMapping("/todos/{id}")
    public ResponseEntity<Todo> updateTodo(@RequestBody Todo todo) {
        try {
            return ResponseEntity.ok(todoService.saveOrUpdate(todo));
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

}
