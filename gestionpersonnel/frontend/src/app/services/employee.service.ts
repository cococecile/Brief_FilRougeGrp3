import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';




const baseUrl = 'http://localhost:8080/api/employees';

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
   getAll(): Observable<any> {
    return this.http.get(baseUrl);
  }
 
  /**
   * Find a Employee by id
   * 
   * @param id 
   * @returns http get request
   */
   get(id): Observable<any> {
    return this.http.get(`${baseUrl}/${id}`);
  }

  /**
   * Create a new Employee
   * 
   * @param data 
   * @returns http post request
   */
   create(data): Observable<any> {
    return this.http.post(baseUrl, data);
  }


  /**
   * Update a Employee
   * 
   * @param id 
   * @param data 
   * @returns http put request
   */
  update(id, data): Observable<any> {
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