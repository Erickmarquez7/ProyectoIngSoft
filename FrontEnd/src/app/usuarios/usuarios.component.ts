import { Component, OnInit } from '@angular/core';
import { UsuarioService } from "./usuario.service";
import { Usuario } from "./usuario";
import Swal from 'sweetalert2';
import { AuthService } from '../usuarios/auth.service';


@Component({
  selector: 'app-usuarios',
  templateUrl: './usuarios.component.html',
  styleUrls: ['./usuarios.component.css']
})
export class UsuariosComponent implements OnInit {

  usuarios: Usuario[];
  username: string = '';

  constructor(private usuarioService: UsuarioService, public authService: AuthService) { }

  ngOnInit(): void {
    this.usuarioService.getUsuarios().subscribe(
      usuarios => this.usuarios = usuarios
    );
  }

  delete(usuario:Usuario):void {
    const swalWithBootstrapButtons = Swal.mixin({
      customClass: {
        confirmButton: 'btn btn-success',
        cancelButton: 'btn btn-danger'
      },
      buttonsStyling: false
    })
    
    swalWithBootstrapButtons.fire({
      title: '¿Estás seguro?',
      text: "¡No se podrá restaurar!",
      icon: 'warning',
      showCancelButton: true,
      confirmButtonText: '¡Sí, borrálo!',
      cancelButtonText: '¡No, cancelalo!',
      reverseButtons: true
    }).then((result) => {
      if (result.isConfirmed) {
        this.usuarioService.delete(usuario.id).subscribe(
          Response => {
            this.usuarios = this.usuarios.filter(usr => usr !== usuario)
            swalWithBootstrapButtons.fire(
              '¡Eliminado!',
              'Usuario eliminado.',
              'success'
            )
          }
        )
        
      }
    })
  }

  registraPuntos(usuario:Usuario, code:string):void {
    this.usuarioService.registraPuntos(usuario, code).subscribe()
  }

}