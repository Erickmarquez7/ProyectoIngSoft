import { Injectable } from '@angular/core';
import { Historial } from './historial';
import { Observable } from 'rxjs';
import { of } from 'rxjs';
import { catchError , throwError} from 'rxjs';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import Swal from 'sweetalert2';

import { Router } from '@angular/router';
import { AuthService } from '../usuarios/auth.service';


@Injectable({
    providedIn: 'root'
  })

export class HistorialService {

    private urlEndPoint:string = 'http://localhost:8090/api/';

    private httpHeaders = new HttpHeaders({'Content-Type': 'application/json'})
  
    constructor(private http: HttpClient, private router: Router, private authService: AuthService) { }

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

    /**
   * Si es que no estamos autorizados
   */
  private isNoAutorizado(e): boolean{
    if(e.status==401){
      if(this.authService.isAuthenticated()){
        this.authService.logout();
      }
      this.router.navigate(['/login'])
      return true;
    }

    if(e.status==403){
      Swal.fire('Acceso denegado', `Hola ${this.authService.usuario.username} no tienes acceso a este recurso!`, 'warning');
      this.router.navigate(['/historial'])
      return true;
    }
    return false;
  }

  /**
   * Obtencion de las rentas
   * @returns la lista de rentas
   */
   getHistorial(): Observable<Historial[]>{
    let user_id = this.authService.usuario.id;
    return this.http.get<Historial[]>(this.urlEndPoint+"usuarios/"+user_id+"/rentas");
  }

}