import { Injectable } from '@angular/core';
import { Todo } from '../models/todo.model';

@Injectable({
  providedIn: 'root'
})
export class TodoService {

  myTodoList: Todo[] = [];

  constructor() { }

  createNewTodo(todo: Todo) {
    this.myTodoList.push(todo);
  } 

  deleteNewTodo(name: String) {
    const index = this.myTodoList.findIndex(item => item.name === name);
    if(index !== -1) {
      this.myTodoList.splice(index, 1);
    }
  }

  completeTodo(name: String) {
    const todoUpdate = this.myTodoList.find(item => item.description === name);

    if(todoUpdate) {
      todoUpdate.completed = true;
    }
  }
}
