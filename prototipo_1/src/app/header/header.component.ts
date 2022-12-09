import { Component, OnInit } from '@angular/core';
import { AuthService } from '../usuarios/auth.service';
import { UsuarioService } from '../usuarios/usuario.service';
import {Router} from '@angular/router';
import Swal from 'sweetalert2';
import { faCoins } from '@fortawesome/free-solid-svg-icons';
import { Usuario } from '../usuarios/usuario';


@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {

  faP = faCoins;
  usuarios: Usuario[];

  constructor(public authService:AuthService, private usuarioService:UsuarioService, private router: Router ) { }

  //Como en la cabezera tendremos el boton de boton de cerrar sesión 
  //y este tiene comportamiento lógico entonces lo implementamos
  //Este boton aparece cuando ya haya iniciado sessión
  /**
   * 
   */
  logout():void {
    let username = this.authService.usuario.username;
    this.authService.logout();
    Swal.fire('Logout', `Hola ${username}, ha cerrado sesión con éxito!`, 'success');
    this.router.navigate(['/login']);
  }

  verHistorial():void {
    let username = this.authService.usuario.username;
    this.authService.logout();
    Swal.fire('Logout', `Hola ${username}, ha cerrado sesión con éxito!`, 'success');
    this.router.navigate(['/login']);
  }

  registraPuntos(usuario:Usuario, code:number):void {
    this.usuarioService.registraPuntos(usuario, code).subscribe();
  }

  verPuntos():string {
    let usuario = this.authService.usuario;
    let ptos = usuario.pumapuntos;
    return ptos.toString();
  }

  ngOnInit(): void {
    this.usuarioService.getUsuarios().subscribe(
      usuarios => this.usuarios = usuarios
    );
  }

}