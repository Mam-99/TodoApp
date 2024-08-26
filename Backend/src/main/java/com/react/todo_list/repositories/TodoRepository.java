package com.react.todo_list.repositories;

import com.react.todo_list.entities.Todo;
import lombok.Setter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public interface TodoRepository extends JpaRepository<Todo, Integer> {

}
