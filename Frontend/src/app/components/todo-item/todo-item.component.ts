import { Component, Input, OnInit } from '@angular/core';
import { TodoService } from '../../services/todo.service';

@Component({
  selector: 'app-todo-item',
  templateUrl: './todo-item.component.html',
  styleUrl: './todo-item.component.css'
})
export class TodoItemComponent implements OnInit {

  @Input()
  name: String = "";

  @Input()
  description: String = "";

  @Input()
  completed: boolean = false;

  constructor(private todoService: TodoService) {}

  ngOnInit(): void {
    
  }

  completeTodo() {
    this.todoService.completeTodo(this.name);
    this.completed = true;
  }

  deleteTodo() {
    this.todoService.deleteNewTodo(this.name);
  }
}
