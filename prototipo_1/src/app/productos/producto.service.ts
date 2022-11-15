import { Injectable } from '@angular/core';
import { Producto } from './producto';
import { PRODUCTOS } from './productoslist.json';
import { Observable } from 'rxjs';
import { of } from 'rxjs';
import { HttpClient, HttpHeaders } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class ProductoService {

  constructor(private http: HttpClient) { }

  private urlEndPoint:string = 'http://localhost:8090/api/productos'

  private httpHeaders = new HttpHeaders({'Content-Type': 'application/json'})

  /**
   * Obtenemos todos los productos
   * @returns una lista de productos
   */

  getProductos(): Observable<Producto[]>{
    //la extrae del puerto 8080
    return this.http.get<Producto[]>(this.urlEndPoint)
  }

  /**
   * Agrega un nuevo producto
   * @param producto el producto a agregar
   * @returns el producto observable
   */
   create(producto: Producto): Observable<Producto>{
    return this.http.post<Producto>(this.urlEndPoint, producto, {headers: this.httpHeaders} )
  }
}
