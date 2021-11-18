import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

const baseUrl = 'http://localhost:8080/api/mission';
@Injectable({
  providedIn: 'root'
})

export class MissionService {

  constructor(private http: HttpClient) {}
  /**
   * Get the list of all Mission
   * 
   * @returns http get request
   */
   getAll(): Observable<any> {
    return this.http.get(baseUrl);
   }
  /**
   * Find a Mission by id
   * 
   * @param id 
   * @returns http get request
   */
   get(id): Observable<any> {
    return this.http.get(`${baseUrl}/${id}`);
  }
  /**
   * Update a Mission
   * 
   * @param id 
   * @param data 
   * @returns http put request
   */
   update(id, data): Observable<any> {
    return this.http.put(`${baseUrl}/${id}`, data);
  }
    /**
   * Delete a Mission
   * 
   * @param id 
   * @returns http delete request
   */
     delete(id: string): Observable<any> {
      return this.http.delete(`${baseUrl}/${id}`);
    }
}
