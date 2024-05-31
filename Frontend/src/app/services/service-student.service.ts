import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { Estudiante } from '../entity/estudiante';

@Injectable({
  providedIn: 'root'
})
export class ServiceStudentService {
  estudianteURL = environment.apiResrURL + '/estudiante';

  constructor(private httpClient: HttpClient) {}
  
  public getAll(): Observable<Estudiante[]> {
    return this.httpClient.get<Estudiante[]>(this.estudianteURL);
  }

  public detail(id: number): Observable<Estudiante> {
    return this.httpClient.get<Estudiante>(this.estudianteURL + `/${id}`); 
  }

  public create(estudiante: Estudiante): Observable<Estudiante>{
    return this.httpClient.post<Estudiante>(this.estudianteURL, estudiante);
  }

  public update(id: number, estudiante: Estudiante): Observable<Estudiante>{
    return this.httpClient.put<Estudiante>(this.estudianteURL + `/${id}`, estudiante);
  }

  public delete(id: number): Observable<Estudiante> {
    return this.httpClient.delete<Estudiante>(this.estudianteURL + `/${id}`); 
  }
}
