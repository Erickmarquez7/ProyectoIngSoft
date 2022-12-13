import { Injectable } from '@angular/core';
import { Usuario } from './usuario';
import { Observable } from 'rxjs';
import { HttpClient, HttpHeaders } from "@angular/common/http";
import Swal from 'sweetalert2';
import { catchError, throwError } from 'rxjs';
import { Router } from '@angular/router';
import { AuthService } from '../usuarios/auth.service';


@Injectable({
  providedIn: 'root'
})
export class UsuarioService {

  private urlEndPoint: string = 'http://localhost:8090/api/usuarios';
  private urlEndPointCuenta: string = 'http://localhost:8090/api/cuenta';

  private httpHeaders = new HttpHeaders({'content-Type': 'application/json'})

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
   * Obtencion de los productos
   * @returns la lista de usuarios
   */
  getUsuarios(): Observable<Usuario[]> {
    return this.http.get<Usuario[]>(this.urlEndPoint);
  }

  /**
   * Creacion de los usuarios
   */
  create(usuario: Usuario): Observable<Usuario> {
    return this.http.post<any>(this.urlEndPoint, usuario, { headers: this.agregarAuthorizationHeader() }).pipe(

      catchError(e => {

        if (this.isNoAutorizado(e)) {
          return throwError(() => e);
        }


        Swal.fire(e.error.mensaje, e.error.error, 'error');
        return throwError(() => e);
      })
    )
  }

  // <<<<<<< HEAD
  //   getUsuario(id): Observable<Usuario> {
  //     return this.http.get<Usuario>(`${this.urlEndPoint}/${id}`).pipe(
  //       catchError(e =>{
  //         this.router.navigate(['/usuarios']);
  //         Swal.fire('Error al editar', e.error.mensaje, 'error');
  //         return throwError( () => e);
  //       })
  //     )
  //   }

  //   /**
  //    * Actualizar un usuario 
  //    */
  //   update(usuario: Usuario):Observable<Usuario> {
  //     return this.http.put<Usuario>(`${this.urlEndPoint}/${usuario.id}`, usuario, {headers: this.httpHeaders})
  //   }

  //   delete(id: number): Observable<Usuario>{
  //     return this.http.delete<Usuario>(`${this.urlEndPoint}/${id}`, {headers: this.agregarAuthorizationHeader()}).pipe(
  // =======
  getUsuario(id): Observable<Usuario> {
    return this.http.get<Usuario>(`${this.urlEndPoint}/${id}`, { headers: this.agregarAuthorizationHeader() }).pipe(
      //>>>>>>> verUsuario
      catchError(e => {

        if (this.isNoAutorizado(e)) {
          return throwError(() => e);
        }


        this.router.navigate(['/usuarios']);
        Swal.fire('Error al editar', e.error.mensaje, 'error');
        return throwError(() => e);
      })
    )
  }

  getUsuarioByUsername(username: string): Observable<Usuario> {
    return this.http.get<Usuario>(`${this.urlEndPoint}/nocuenta/${username}`, { headers: this.agregarAuthorizationHeader() }).pipe(
      catchError(e => {

        if (this.isNoAutorizado(e)) {
          return throwError(() => e);
        }


        this.router.navigate(['/usuarios']);
        Swal.fire('Error al encontrar al usuario', e.error.mensaje, 'error');
        return throwError(() => e);
      })
    )
  }

  /**
   * Actualiza un Usuario
   * @param usuario el producto a actualizar
   * @returns 
   */
  update(usuario: Usuario): Observable<Usuario> {
    return this.http.put<any>(`${this.urlEndPoint}/${usuario.id}`, usuario, { headers: this.agregarAuthorizationHeader() }).pipe(
      catchError(e => {

        if (this.isNoAutorizado(e)) {
          return throwError(() => e);
        }
        Swal.fire(e.error.mensaje, e.error.error, 'error');
        return throwError(() => e);
      })
    )
  }

  /**
  * Metodo que incrementa la cantidad de puma puntos 
  * @param id 
  * @returns 
  */
  sumar(usuario: Usuario, monto: number): Observable<any> {
    return this.http.put<any>(`${this.urlEndPointCuenta}/${usuario.id}/${monto}/1`, usuario, { headers: this.agregarAuthorizationHeader() }).pipe(
      catchError(e => {
        if (this.isNoAutorizado(e)) {
          return throwError(() => e);
        }
        Swal.fire(e.error.mensaje, e.error.error, 'error');
        return throwError(() => e);
      })
    )
  }

  /**
   * Metodo que incrementa la cantidad de puma puntos 
   * @param id 
   * @returns 
   */
  restar(usuario: Usuario, monto: number): Observable<any> {
    return this.http.put<any>(`${this.urlEndPointCuenta}/${usuario.id}/${monto}/0`, usuario, { headers: this.agregarAuthorizationHeader() }).pipe(
      catchError(e => {
        if (this.isNoAutorizado(e)) {
          return throwError(() => e);
        }
        Swal.fire(e.error.mensaje, e.error.error, 'error');
        return throwError(() => e);
      })
    )
  }

  /**
   * Acumula Puntos de actividad
   * @param usuario el producto a actualizar
   * @param code el codigo de actividad
   * @returns 
   */
  registraPuntos(usuario: Usuario, code: string): Observable<Usuario> {
    return this.http.put<any>(`${this.urlEndPoint}/${usuario.id}/${code}`, usuario, { headers: this.agregarAuthorizationHeader() }).pipe(
      catchError(e => {
        if (this.isNoAutorizado(e)) {
          return throwError(() => e);
        }
        Swal.fire(e.error.mensaje, e.error.error, 'error');
        return throwError(() => e);
      })
    )
  }

  delete(id: number): Observable<Usuario> {
    return this.http.delete<Usuario>(`${this.urlEndPoint}/${id}`, { headers: this.agregarAuthorizationHeader() }).pipe(
      catchError(e => {
        if (this.isNoAutorizado(e)) {
          return throwError(() => e);
        }
        Swal.fire(e.error.mensaje, e.error.error, 'error');
        return throwError(() => e);
      })
    )
  }


}