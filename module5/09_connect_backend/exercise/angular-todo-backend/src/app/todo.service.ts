import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Todo} from './todo/todo';

@Injectable({
  providedIn: 'root'
})
export class TodoService {
  private URL = 'http://localhost:3000';
  constructor(private http: HttpClient) { }

  getAll(): Observable<Todo[]> {
      return this.http.get<Todo[]>(this.URL + '/todoList');
  }

  saveTodo(todo): Observable<Todo> {
    return this.http.post<Todo>(this.URL + '/todoList', todo);
  }

  delete(id: number): Observable<Todo> {
    return this.http.delete<Todo>(`${this.URL}/todoList/${id}`) ;
  }
}
