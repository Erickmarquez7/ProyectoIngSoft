import { Injectable } from '@angular/core';
import { ACTIVIDAD } from './actividad.json';
import { Actividades } from './actividades';
import { Observable } from 'rxjs';
import { of } from 'rxjs';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class ActividadesService {

  constructor(private http: HttpClient) { }

  private urlEndPoint: string = 'http://localhost:8080/api/actividades'

  getActividades() : Observable<Actividades[]>{
    return this.http.get<Actividades[]>(this.urlEndPoint);
  }
}
