import { Routes } from '@angular/router';
import { Home } from './home/home';
import { Example } from './example/example';

export const routes: Routes = [
    {path:'home', component:Home},
    {path:'example', component:Example}
];
