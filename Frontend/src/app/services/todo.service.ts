import { Injectable } from '@angular/core';
import { Todo } from '../models/todo.model';
import { HttpClient } from '@angular/common/http';
import { enviroment } from '../../enviroments/enviroment.prod';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class TodoService {

  private apiUrl = enviroment.apiUrl;

  myTodoList: Todo[] = [];

  constructor(private http: HttpClient) { }

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

  get(path: String): Observable<any> {
    return this.http.get<any>(this.apiUrl + path);
  }

  post(path: String, data?: any): Observable<any> {
    return this.http.post(this.apiUrl + path, data);
  }

  put(path: String, data?: any): Observable<any> {
    return this.http.put(this.apiUrl + path, data);
  }

  delete(path: String, data?: any): Observable<any> {
    return this.http.delete(this.apiUrl + path, data);
  }
}
