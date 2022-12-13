import { Injectable } from '@angular/core';
import { Producto } from '../productos/producto';
import { Observable } from 'rxjs';
import { of } from 'rxjs';
import { catchError , throwError} from 'rxjs';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import Swal from 'sweetalert2';

import { Router } from '@angular/router';
import { AuthService } from '../usuarios/auth.service';
import { Rentar } from './rentar';

@Injectable({
  providedIn: 'root'
})
/**
 * De manera similar al backend definimos los servicios de 
 * rentar, el crud de rentar en angular
 */
export class RentarService {

  //de donde vamos a extraer los datos de nuestra bd local
  private urlEndPoint:string = 'http://localhost:8090/api/productos';

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
      this.router.navigate(['/productos'])
      return true;
    }
    return false;
  }


  /**
   * Obtencion de las rentas
   * @returns la lista de rentas
   */
  getRentas(): Observable<Rentar[]>{
    return this.http.get<Rentar[]>(this.urlEndPoint);
  }

  /**
   * Crea una renta
   * @param renta la renta a crear
   * @returns un observable para que sea asincrono
   */
  create(renta: Rentar): Observable<any>{
    return this.http.post<any>(this.urlEndPoint, renta, {headers: this.agregarAuthorizationHeader()} ).pipe(
      
      catchError(e => {

        if(this.isNoAutorizado(e)){
          return throwError( () => e );
        }


        Swal.fire(e.error.mensaje, e.error.error, 'error');
        return throwError( () => e );
      })
    )
  }

  /**
   * Obtiene una renta por id
   * @param id el id de la renta
   * @returns Un observable para permitir asincronia
   */
  getRenta(id): Observable<Rentar>{
    return this.http.get<Rentar>(`${this.urlEndPoint}/${id}`, {headers: this.agregarAuthorizationHeader() }).pipe(
      catchError(e => {

        if(this.isNoAutorizado(e)){
          return throwError( () => e );
        }


        this.router.navigate(['/productos']);
        Swal.fire('Error al editar', e.error.mensaje, 'error');
        return throwError( () => e );
      })
    )
  }

  /**
   * Actualiza una renta
   * @param renta la renta a actualizar
   * @returns 
   */
  update(renta: Rentar): Observable<any>{
    return this.http.put<any>(`${this.urlEndPoint}/${renta.id}`, renta, {headers: this.agregarAuthorizationHeader()}).pipe(
      catchError(e => {

        if(this.isNoAutorizado(e)){
          return throwError( () => e );
        }
        Swal.fire(e.error.mensaje, e.error.error, 'error');
        return throwError( () => e );
      })
    )
  }

  /**
   * Elimina una renta
   * @param id el id del producto a eliminar
   * @returns 
   */
  delete(id): Observable<Rentar>{
    return this.http.delete<Rentar>(`${this.urlEndPoint}/${id}`, {headers: this.agregarAuthorizationHeader()}).pipe(
      catchError(e => {

        if(this.isNoAutorizado(e)){
          return throwError( () => e );
        }

        
        Swal.fire(e.error.mensaje, e.error.error, 'error');
        return throwError( () => e );
      })
    )
  }
}
