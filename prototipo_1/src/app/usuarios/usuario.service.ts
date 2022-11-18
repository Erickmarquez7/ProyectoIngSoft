import { Injectable } from '@angular/core';
import {Usuario} from './usuario';
import { Observable } from 'rxjs';
import { HttpClient, HttpHeaders } from "@angular/common/http";


@Injectable({
  providedIn: 'root'
})
export class UsuarioService {

  private urlEndPoint:string = 'http://localhost:8080/api/usuarios';

  private httpHeaders = new HttpHeaders({'content-Type': 'application/json'})

  constructor(private http: HttpClient) { }

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
  create(usuario: Usuario):Observable<Usuario> {
    return this.http.post<Usuario>(this.urlEndPoint, usuario, {headers: this.httpHeaders})
  }

  /**
   * Obtencion de un Usuario por su id.
   */
  getUsuario(id): Observable<Usuario> {
    return this.http.get<Usuario>(`${this.urlEndPoint}/${id}`)
  }

  /**
   * Actualizar un usuario 
   */
  update(usuario: Usuario):Observable<Usuario> {
    return this.http.put<Usuario>(`${this.urlEndPoint}/${usuario.id}`, usuario, {headers: this.httpHeaders})
  }

  delete(id: number): Observable<Usuario> {
    return this.http.delete<Usuario>(`${this.urlEndPoint}/${id}`, {headers:this.httpHeaders})
  }
}