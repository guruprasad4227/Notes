import { ChangeDetectorRef, Component, inject, OnInit } from '@angular/core';
import { Test } from '../test';
import { RouterLink } from "@angular/router";

@Component({
  selector: 'app-home',
  imports: [RouterLink],
  templateUrl: './home.html',
  styleUrl: './home.css',
})
export class Home implements OnInit {
  users: any = [];
  // constructor(private testService: Test) {}
  private readonly testService = inject(Test);
  private cdr = inject(ChangeDetectorRef);

  ngOnInit(): void {
    this.viewStudent();
  }

  viewStudent() {
    this.testService.viewServiceStudent().subscribe({
      next: (data) => {
        console.log(data);
        this.users = data;
        this.cdr.detectChanges();
      },
    });
  }
}
