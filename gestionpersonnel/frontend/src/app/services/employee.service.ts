import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { EmployeeDto } from '../model/employee.model';
import { HttpClient } from '@angular/common/http';



const baseUrl = 'http://localhost:4200/api/employees';

@Injectable({
  providedIn: 'root'
})

export class EmployeeService {

  

  constructor(private http: HttpClient ) {

   }
   
   list(): Observable<any> {
    return this.http.get(baseUrl);
  }
  
  create(data: EmployeeDto): Observable<any> {
    return this.http.post(baseUrl, data);
  }
  
  update(id: string, data: EmployeeDto): Observable<any> {
    return this.http.put(`${baseUrl}/${id}`, data);
  }

  delete(id: string): Observable<any> {
    return this.http.delete(`${baseUrl}/${id}`);
  }
  
}
