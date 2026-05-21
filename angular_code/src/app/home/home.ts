import { Component, OnInit } from '@angular/core';
import { Test } from '../test';

@Component({
  selector: 'app-home',
  imports: [],
  templateUrl: './home.html',
  styleUrl: './home.css',
})
export class Home implements OnInit {
  users: any = [];
  constructor(private testService: Test) {}

  ngOnInit(): void {
    this.viewStudent();
  }

  viewStudent() {
    this.testService.viewServiceStudent().subscribe({
      next: (data) => {
        console.log(data);
        this.users= data;
      },
    });
  }
}
