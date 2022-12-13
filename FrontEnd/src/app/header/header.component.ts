import { Component, OnChanges, OnDestroy, OnInit, SimpleChanges } from '@angular/core';
import { AuthService } from '../usuarios/auth.service';
import { UsuarioService } from '../usuarios/usuario.service';
import {Router} from '@angular/router';
import Swal from 'sweetalert2';
import { faCoins } from '@fortawesome/free-solid-svg-icons';
import { Usuario } from '../usuarios/usuario';
import { Observable } from 'rxjs';


@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit{

  faP = faCoins; 
  usuarios: Usuario[];
  usr: Usuario = new Usuario()

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

  registraPuntos(usuario:Usuario, code:string):void {
    this.usuarioService.registraPuntos(usuario, code).subscribe();
    Swal.fire('Registrado', `Se registró actividad ${code}, con éxito!`, 'success');
  }

  public getUsuario(): void {
    let id = Number(this.authService.usuario.id);
    this.usuarioService.getUsuario(id).subscribe(usr => this.usr = usr);
  }

  ngOnInit(): void {
    this.usuarioService.getUsuarios().subscribe(
      usuarios => this.usuarios = usuarios
    );
  }
}