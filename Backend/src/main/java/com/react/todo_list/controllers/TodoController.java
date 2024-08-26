package com.react.todo_list.controllers;

import com.react.todo_list.dtos.TodoDTO;
import com.react.todo_list.entities.Todo;
import com.react.todo_list.services.TodoService;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class TodoController {
    @Autowired
    TodoService todoService;

    @PostMapping(value = "/todos")
    @ResponseStatus(HttpStatus.CREATED)
    public Todo addTodo(@RequestBody TodoDTO todoDTO) {
        return this.todoService.createTodo(todoDTO);
    }

    @GetMapping(value = "/todos")
    @ResponseStatus(HttpStatus.OK)
    public List<Todo> getAllTodos() {
        return this.todoService.getAllTodos();
    }

    @GetMapping(value = "/todos/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Todo getTodo(@PathVariable(name = "id") int id) {
        return this.todoService.getTodoById(id);
    }

    @PutMapping(value = "/todos/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Todo updateTodo(@PathVariable(name = "id") int id, @RequestBody TodoDTO todoDTO){
        return this.todoService.updateTodo(todoDTO, id);
    }

    @DeleteMapping(value = "/todos/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteTodo(@PathVariable(name = "id") int id) {
        this.todoService.deleteTodo(id);
    }
}
