import { Injectable } from '@angular/core';
import { ACTIVIDAD } from './actividad.json';
import { Actividades } from './actividades';
import { Observable } from 'rxjs';
import { of } from 'rxjs';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Usuario } from '../usuarios/usuario';
import Swal from 'sweetalert2';
import { catchError, throwError} from 'rxjs';

import { Router } from '@angular/router';
import { AuthService } from '../usuarios/auth.service';

@Injectable({
  providedIn: 'root'
})
export class ActividadesService {
  private httpHeaders = new HttpHeaders({'content-Type': 'application/json'})

  constructor(private http: HttpClient) { }

  private urlEndPoint: string = 'http://localhost:8090/api/actividades'

  getActividades() : Observable<Actividades[]>{
    return this.http.get<Actividades[]>(this.urlEndPoint);
  }

  /**
   * Actualizar un usuario 
   */
   registra(usuario: Usuario):Observable<Usuario> {
    return this.http.put<Usuario>(`${this.urlEndPoint}/${usuario.id}`, usuario, {headers: this.httpHeaders})
  }
}
