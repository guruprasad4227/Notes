import { Component, OnInit } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { Test } from '../test';
import { Student } from '../student';

@Component({
  selector: 'app-add-student',
  imports: [FormsModule],
  templateUrl: './add-student.html',
  styleUrl: './add-student.css',
})
export class AddStudent implements OnInit {
  userName: any;
  password: any;
  age: any;
  salary: any;
  // student:Student{

  // }

  constructor(private test: Test) {}
  ngOnInit(): void {}

  saveStudent() {
    console.log(this.userName);
    let student = {
      userName: this.userName,
      password: this.password,
      age: this.age,

      salary: this.salary,
    };
    console.log(student);

    this.test.addServiceStudent(student).subscribe({
      next: (data) => {
        console.log(data);
        alert('success');
        ((this.userName = ''), (this.password = ''), (this.age = ''), (this.salary = ''));
      },
    });
  }
}
