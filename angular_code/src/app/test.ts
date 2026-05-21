import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class Test {
  constructor(private httpclient: HttpClient) {}

  viewServiceStudent(): Observable<any> {
    return this.httpclient.get<any>('http://localhost:8098/firstspringboot/userview/viewdetails');
    //to get data from backend api by using httpClient
  }
}
