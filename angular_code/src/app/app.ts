import { Component, OnInit, signal } from '@angular/core';
import { RouterOutlet, RouterLinkWithHref, RouterLink } from '@angular/router';
import { Test } from './test';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-root',
  imports: [RouterOutlet, RouterLink, CommonModule],
  templateUrl: './app.html',
  styleUrl: './app.css',
})
export class App {
  protected readonly title = signal('second-angualr-project');
  name: any = 'cttc';
}
