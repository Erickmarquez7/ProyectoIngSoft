import { Injectable } from '@angular/core';
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

  constructor(private http: HttpClient,  private router: Router, private authService: AuthService) { }

  private urlEndPoint: string = 'http://localhost:8080/api/actividades';

  /**
   * Si ya estamos autorizados
   */
  private agregarAuthorizationHeader(){
    let token = this.authService.token;
    if(token != null){
      return this.httpHeaders.append('Authorization', 'Bearer ' + token);
    }
    return this.httpHeaders;
  }

  getActividades() : Observable<Actividades[]>{
    return this.http.get<Actividades[]>(this.urlEndPoint);
  }

  getActividad(id: string): Observable<Actividades> {
    return this.http.get<Actividades>(`${this.urlEndPoint}/${id}`, {headers: this.agregarAuthorizationHeader() }).pipe(
      catchError(e => {
        this.router.navigate(['/']);
        Swal.fire('Error al buscar', e.error.mensaje, 'error');
        return throwError( () => e );
      })
    )
  }
}
