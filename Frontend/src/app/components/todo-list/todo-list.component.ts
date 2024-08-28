import { Component, OnInit } from '@angular/core';
import { Todo } from '../../models/todo.model';
import { TodoService } from '../../services/todo.service';

@Component({
  selector: 'app-todo-list',
  templateUrl: './todo-list.component.html',
  styleUrl: './todo-list.component.css'
})
export class TodoListComponent implements OnInit {

  myTodos: Todo[] = [];

  myTodosDatabase: Todo[] = [];

  constructor(private todoService: TodoService) {}

  ngOnInit(): void {
    this.myTodos = this.todoService.myTodoList;
    this.getTodosFromDatabase();
  }

  getTodosFromDatabase() {
    this.todoService.get("todos").subscribe(res => {
      if(!res.err) {
        console.log("Response from GET-Methode: ", res);

        for(let item of res) {
          let todo: Todo = {
            name: item.name,
            description: item.description,
            completed: item.status
          }

          this.myTodosDatabase.push(todo);
        }
      }
    })
  }
}
