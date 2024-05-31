import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { Profesor } from '../entity/profesor';

@Injectable({
  providedIn: 'root'
})
export class ServiceTeacherService {
  profesorURL = environment.apiResrURL + '/profesor';

  constructor(private httpClient: HttpClient) {}
  
  public getAll(): Observable<Profesor[]> {
    return this.httpClient.get<Profesor[]>(this.profesorURL);
  }

  public detail(id: number): Observable<Profesor> {
    return this.httpClient.get<Profesor>(this.profesorURL + `/${id}`); 
  }

  public create(profesor: Profesor): Observable<Profesor>{
    return this.httpClient.post<Profesor>(this.profesorURL, profesor);
  }

  public update(id: number, profesor: Profesor): Observable<Profesor>{
    return this.httpClient.put<Profesor>(this.profesorURL + `/${id}`, profesor);
  }

  public delete(id: number): Observable<Profesor> {
    return this.httpClient.delete<Profesor>(this.profesorURL + `/${id}`); 
  }
}