import { Injectable } from '@angular/core';
//import { PRODUCTOS } from './productos.json';
import { Producto } from './producto';
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
/**
 * De manera similar al backend definimos los servicios de 
 * los productos, el crud de los productos en angular
 */
export class ProductoService {

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
   * Obtencion de los productos
   * @returns la lista de productos
   */
  getProductos(): Observable<Producto[]>{
    return this.http.get<Producto[]>(this.urlEndPoint);
  }

  /**
   * Crea un producto
   * @param producto el producto a crear
   * @returns un observable para que sea asincrono
   */
  create(producto: Producto): Observable<any>{
    return this.http.post<any>(this.urlEndPoint, producto, {headers: this.agregarAuthorizationHeader()} ).pipe(
      
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
   * Obtiene un producto por id
   * @param id el id del producto
   * @returns Un observable para permitir asincronia
   */
  getProducto(id): Observable<Producto>{
    return this.http.get<Producto>(`${this.urlEndPoint}/${id}`, {headers: this.agregarAuthorizationHeader() }).pipe(
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
   * Actualiza un producto
   * @param producto el producto a actualizar
   * @returns 
   */
  update(producto: Producto): Observable<any>{
    return this.http.put<any>(`${this.urlEndPoint}/${producto.idProducto}`, producto, {headers: this.agregarAuthorizationHeader()}).pipe(
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
   * Elimina un producto
   * @param id el id del producto a eliminar
   * @returns 
   */
  delete(id: number): Observable<Producto>{
    return this.http.delete<Producto>(`${this.urlEndPoint}/${id}`, {headers: this.agregarAuthorizationHeader()}).pipe(
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
