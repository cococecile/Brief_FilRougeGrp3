import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { Employee } from '../model/employee.model';



const baseUrl = 'http://localhost:4200/api/employees';

@Injectable({
  providedIn: 'root'
})

export class EmployeeService {

  constructor(private http: HttpClient) { }

  /**
   * Get the list of all Employee
   * 
   * @returns http get request
   */
   list(): Observable<any> {
    return this.http.get(baseUrl);
  }
 
  /**
   * Find a Employee by id
   * 
   * @param id 
   * @returns http get request
   */
  get(id: any): Observable<any> {
    return this.http.get(`${baseUrl}/${id}`);
  }

  /**
   * Create a new Employee
   * 
   * @param data 
   * @returns http post request
   */
  create(data: Employee): Observable<any> {
    return this.http.post(baseUrl, data);
  }

  /**
   * Update a Employee
   * 
   * @param id 
   * @param data 
   * @returns http put request
   */
  update(id: string, data: Employee): Observable<any> {
    return this.http.put(`${baseUrl}/${id}`, data);
  }

  /**
   * Delete a Employee
   * 
   * @param id 
   * @returns http delete request
   */
  delete(id: string): Observable<any> {
    return this.http.delete(`${baseUrl}/${id}`);
  }
}