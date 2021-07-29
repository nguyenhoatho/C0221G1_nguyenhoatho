import { Component, OnInit } from '@angular/core';
import {FormControl, FormGroup} from '@angular/forms';
import {TodoService} from '../../todo.service';
import {Todo} from '../todo';

@Component({
  selector: 'app-todo-create',
  templateUrl: './todo-create.component.html',
  styleUrls: ['./todo-create.component.css']
})
export class TodoCreateComponent implements OnInit {
  formTodo: FormGroup ;
  todoList: Todo[] = [] ;

  constructor(private todoService: TodoService) {
    this.formTodo = new FormGroup({
      content : new FormControl('')
    });
  }

  ngOnInit(): void {
    this.getAll();
  }
  getAll() {
    this.todoService.getAll().subscribe(todo => {
      this.todoList = todo;
    });
  }

  change() {
    const todo = this.formTodo.value;
    this.todoService.saveTodo(todo).subscribe(() => {
      this.formTodo.reset();
      alert('Khởi Tạo Thành Công : ' + todo.content);
      this.getAll();
    }, error => {
      alert('khởi tạo thất bại !!! ') ;
    });
  }
  delete(id: number) {
    this.todoService.delete(id).subscribe(() => {
      alert('delete thanh cong') ;
      this.getAll();
    }, error => {
      alert(' That Bai ') ;
    });
  }

}
