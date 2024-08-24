import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
import { Todo } from '../../models/todo.model';
import { TodoService } from '../../services/todo.service';

@Component({
  selector: 'app-add-todo',
  templateUrl: './add-todo.component.html',
  styleUrl: './add-todo.component.css'
})
export class AddTodoComponent implements OnInit {
  
  myForm: FormGroup;

  constructor(private todoService: TodoService) {
    this.myForm = new FormGroup({
      name: new FormControl(''),
      description: new FormControl('')
    })
  }

  ngOnInit(): void {
    
  }

  onSubmit() {
    const todo: Todo = {
      name: this.myForm.get("name")?.value,
      description: this.myForm.get("description")?.value,
      completed: false
    }

    console.log("New Todo: ", todo);
    this.todoService.createNewTodo(todo);

    this.myForm.reset();
  }
}
