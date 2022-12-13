import { Component, OnInit } from '@angular/core';
import { Usuario } from './usuario';
import { AuthService } from '../usuarios/auth.service';
import { UsuarioService } from './usuario.service';
import { ActivatedRoute, Router } from '@angular/router';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-buscar',
  templateUrl: './buscar.component.html',
  styleUrls: ['./buscar.component.css']
})
export class BuscarComponent implements OnInit {

  usuario: Usuario = new Usuario();

  constructor(private usuarioService: UsuarioService, private router: Router, private activatedRoute: ActivatedRoute, public authService: AuthService) {
    let params: any = this.activatedRoute.snapshot.params;
  }

  ngOnInit(): void {
    this.findUserByUsername();
  }

  public findUserByUsername() {
    const username = this.activatedRoute.snapshot.paramMap.get('username');
    this.usuarioService.getUsuarioByUsername(username).subscribe(usuario => this.usuario = usuario);
  }

  delete(usuario: Usuario): void {
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
            // this.usuarios = this.usuarios.filter(usr => usr !== usuario)
            swalWithBootstrapButtons.fire(
              '¡Eliminado!',
              'Usuario eliminado.',
              'success'
            )
            this.router.navigate(['/usuarios']);
          }
        )

      }
    })
  }
}
