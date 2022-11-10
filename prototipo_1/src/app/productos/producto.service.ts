import { Injectable } from '@angular/core';
import { Producto } from './producto';
import { PRODUCTOS } from './productoslist.json';
import { Observable } from 'rxjs';
import { of } from 'rxjs';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class ProductoService {

  constructor(private http: HttpClient) { }

  private urlEndPoint:string = 'http://localhost:8090/api/productos'

  getProductos(): Observable<Producto[]>{
    return this.http.get<Producto[]>(this.urlEndPoint)
  }
}
