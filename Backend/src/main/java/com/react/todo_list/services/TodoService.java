package com.react.todo_list.services;

import com.react.todo_list.dtos.TodoDTO;
import com.react.todo_list.entities.Todo;
import com.react.todo_list.exceptions.TodoBadRequestException;
import com.react.todo_list.repositories.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Service
public class TodoService {
    @Autowired
    TodoRepository todoRepository;

    public Todo createTodo(TodoDTO todoDTO) {
        Todo todo = new Todo();
        todo.setName(todoDTO.getName());
        todo.setDescription(todoDTO.getDescription());
        todo.setStatus(todoDTO.isStatus());

        todoRepository.save(todo);
        return todo;
    }

    public Todo updateTodo(TodoDTO todoDTO, int id) {
        Optional<Todo> todo = todoRepository.findById(id);
        if(todo.isEmpty()) {
            throw new TodoBadRequestException("Todo with id " + id + " not found!");
        }

        todo.get().setName(todoDTO.getName());
        todo.get().setDescription(todoDTO.getDescription());
        todo.get().setStatus(todoDTO.isStatus());

        todoRepository.save(todo.get());

        return todo.get();
    }

    public List<Todo> getAllTodos(){
        return todoRepository.findAll();
    }

    public Todo getTodoById(int id) {
        Optional<Todo> todo = todoRepository.findById(id);
        if(todo.isEmpty()) {
            throw new TodoBadRequestException("Todo with id " + id + " not found!");
        }

        return todo.get();
    }

    public void deleteTodo(int id) {
        Optional<Todo> todo = todoRepository.findById(id);
        if(todo.isEmpty()) {
            throw new TodoBadRequestException("Todo with id " + id + " not found!");
        }

        todoRepository.delete(todo.get());
    }
}
