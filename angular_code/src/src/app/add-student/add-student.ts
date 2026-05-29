import { Component, OnInit } from '@angular/core';
import {
  Form,
  FormBuilder,
  FormGroup,
  FormsModule,
  ReactiveFormsModule,
  Validators,
} from '@angular/forms';
import { Test } from '../test';
import { Student } from '../student';

@Component({
  selector: 'app-add-student',
  imports: [FormsModule, ReactiveFormsModule],
  templateUrl: './add-student.html',
  styleUrl: './add-student.css',
})
export class AddStudent implements OnInit {
  registerForm: FormGroup;
  selectedFile: any;
  // userName: any;
  // password: any;
  // age: any;
  // salary: any;
  // email: any;
  // student:Student{

  // }
  constructor(
    private test: Test,
    private formbuilder: FormBuilder,
  ) {
    this.registerForm = this.formbuilder.group({
      userName: ['', Validators.required],
      password: ['', Validators.required],
      age: ['', Validators.required],
      salary: ['', Validators.required],
      userMail: ['', [Validators.required, Validators.email]],
    });
  }
  ngOnInit(): void {}

  saveStudent() {
    console.log(this.registerForm.value);
    // let student = {
    //   userName: this.userName,
    //   password: this.password,
    //   age: this.age,
    //   salary: this.salary,
    //   email: this.email,
    // };
    // console.log(student);
    console.log(this.registerForm.get('userName')?.value);
    console.log(this.registerForm.get('password')?.value);
    console.log(this.registerForm.get('userMail')?.value);
    let isValid = 0;
    if (
      this.registerForm.get('userName')?.value == null ||
      this.registerForm.get('userName')?.value == ''
    ) {
      alert('kindly fill userName');
      isValid = 1;
    } else if (
      this.registerForm.get('password')?.value == null ||
      this.registerForm.get('password')?.value == ''
    ) {
      alert('kindly fill password');
      isValid = 1;
    } else if (
      this.registerForm.get('userMail')?.value == null ||
      this.registerForm.get('userMail')?.value == ''
    ) {
      alert('kindly fill email');
      isValid = 1;
    }

    const formData = new FormData();
    formData.append('userName', this.registerForm.get('userName')?.value);
    formData.append('password', this.registerForm.get('password')?.value);
    formData.append('email', this.registerForm.get('userMail')?.value);
    formData.append('age', this.registerForm.get('age')?.value);
    formData.append('salary', this.registerForm.get('salary')?.value);
    formData.append('image', this.selectedFile);
    if (isValid == 0) {
      console.log(formData);

      this.test.addServiceStudent(formData).subscribe({
        next: (data) => {
          console.log(data);
          this.registerForm.reset();
        },
      });
    }
  }

  fileUpload(event: Event) {
    console.log(event);

    const element = event.target as HTMLInputElement;
    const file: File | null = element.files ? element.files[0] : null;
    this.selectedFile = file;
    console.log(event);
    console.log(file);
  }
}
