import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { of } from 'rxjs';
import { catchError , throwError} from 'rxjs';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import Swal from 'sweetalert2';

import { Router } from '@angular/router';
import { AuthService } from '../usuarios/auth.service';
import { Producto } from '../productos/producto';
import { Usuario } from '../usuarios/usuario';

@Injectable({
  providedIn: 'root'
})
export class ReporteService {

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
      this.router.navigate(['/reportes'])
    return true;
    }
    return false;
  }
  
  /**
    * Obtencion de las rentas
     * @returns la lista de rentas
     */
  getRentasSem(): Observable<Object[]>{
    return this.http.get<Object[]>(this.urlEndPoint+"reportes/1");
  }

  /**  
    * Obtencion de productos mas baratos 
     * @returns la lista de rentas
     */
  getBaratos(): Observable<Producto[]>{
    return this.http.get<Producto[]>(this.urlEndPoint+"reportes/2");
  }

  /**
   * Obtencion de los productos mas rentados en el mes 
   */
  getMasRentados(): Observable<Object[]>{
    return this.http.get<Object[]>(this.urlEndPoint+"reportes/3");
  }

  getUsuariosNoActivos() : Observable<Object[]> { 
    return this.http.get<Object[]>(this.urlEndPoint+"reportes/4");
  }

  getUsuariosPorCarrera(): Observable<Object[]>{
    return this.http.get<Object[]>(this.urlEndPoint+"reportes/5");
  }


  /**
   * Obtiene todos los usuarios activos 
   * @returns 
   */
  getUsuariosActivos(): Observable<Usuario[]>{
    return this.http.get<Usuario[]>(`${this.urlEndPoint}reportes6/`,{ headers: this.agregarAuthorizationHeader() });
  }



}