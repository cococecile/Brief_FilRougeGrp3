import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Manager } from '../model/manager.model';

const baseUrl = "http://localhost:4200/api/managers";

@Injectable({
  providedIn: 'root'
})
export class ManagerService {

  constructor(private http: HttpClient) { }



  /**
   * Get the list of all manager
   * 
   * @returns http get request
   */
   list(): Observable<any> {
    return this.http.get(baseUrl);
  }

 
  /**
   * Find a manager by id
   * 
   * @param id 
   * @returns http get request
   */
  get(id: any): Observable<any> {
    return this.http.get(`${baseUrl}/${id}`);
  }

  /**
   * Create a new Manager
   * 
   * @param data 
   * @returns http post request
   */
  create(data: Manager): Observable<any> {
    return this.http.post(baseUrl, data);
  }

  /**
   * Update a Manager
   * 
   * @param id 
   * @param data 
   * @returns http put request
   */
  update(id: string, data: Manager): Observable<any> {
    return this.http.put(`${baseUrl}/${id}`, data);
  }

  /**
   * Delete a Manager
   * 
   * @param id 
   * @returns http delete request
   */
  delete(id: string): Observable<any> {
    return this.http.delete(`${baseUrl}/${id}`);
  }


}