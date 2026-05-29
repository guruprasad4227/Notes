import { Routes } from '@angular/router';
import { Home } from './home/home';
import { Example } from './example/example';
import { AddStudent } from './add-student/add-student';

export const routes: Routes = [
  { path: '', redirectTo: 'home', pathMatch:'full' },
  { path: 'home', component: Home },
  { path: 'example', component: Example },
  { path: 'add-student', component: AddStudent },

];
