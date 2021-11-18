import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Department } from '../model/department.model';

const baseUrl = "http://localhost:8080/api/departments";

@Injectable({
  providedIn: 'root'
})
export class DepartmentService {

  constructor(private http: HttpClient) { }


  /**
   * Get the list of all Department
   * 
   * @returns http get request
   */
   list(): Observable<any> {
    return this.http.get(baseUrl);
  }

 
  /**
   * Find a Department by id
   * 
   * @param id 
   * @returns http get request
   */
  get(id: any): Observable<any> {
    return this.http.get(`${baseUrl}/${id}`);
  }

  /**
   * Create a new Department
   * 
   * @param data 
   * @returns http post request
   */
  create(data: Department): Observable<any> {
    return this.http.post(baseUrl, data);
  }

  /**
   * Update a Department
   * 
   * @param id 
   * @param data 
   * @returns http put request
   */
  update(id: string, data: Department): Observable<any> {
    return this.http.put(`${baseUrl}/${id}`, data);
  }
  
    /**
   * save a Department
   * 
   * @param id 
   * @param data 
   * @returns http put request
   */
  save(id: string, data: Department): Observable<any> {
    return this.http.put(`${baseUrl}/${id}`, data);
  }

  /**
   * Delete a Department
   * 
   * @param id 
   * @returns http delete request
   */
  delete(id: any): Observable<any> {
    return this.http.delete(`${baseUrl}/${id}`);
  }


}


