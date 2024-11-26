package com.todo.todolist.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.todo.todolist.model.Todo;
import com.todo.todolist.repository.TodoRepository;

@Service
public class TodoService {

    @Autowired
    private TodoRepository todoRepository;


    public List<Todo> getAllTodos() {
        return todoRepository.findAll();
    }

    public Todo getTodoById(Long id) {
        return todoRepository.findById(id).orElse(null);
    }

    public Todo saveOrUpdate(Todo todo) {
        return todoRepository.save(todo);
    }

    public void deleteTodoById(Long id) {
        todoRepository.deleteById(id);
    }

    public void deleteAllTodos() {
        todoRepository.deleteAll();
    }

    public Todo updateTodo(Long id, Todo todoDetails) {
        Todo todoItem = getTodoById(id);
        todoItem.setTitle(todoDetails.getTitle());
        todoItem.setDescription(todoDetails.getDescription());
        todoItem.setCompleted(todoDetails.isCompleted());
        return todoRepository.save(todoItem);
    }

}
