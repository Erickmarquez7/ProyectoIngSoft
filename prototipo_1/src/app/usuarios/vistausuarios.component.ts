import { Component, OnInit } from '@angular/core';
import { Usuario } from './usuario';
import { ActivatedRoute, Router } from '@angular/router';
import { UsuarioService } from './usuario.service';
import { AuthService } from '../usuarios/auth.service';


@Component({
  selector: 'app-vistausuarios',
  templateUrl: './vistausuarios.component.html',
  styleUrls: ['./vistausuarios.component.css']
})
export class VistausuariosComponent implements OnInit {

  usuario: Usuario = new Usuario()

  constructor(private usuarioService: UsuarioService, private router: Router, private activatedRoute: ActivatedRoute, public authService: AuthService) { 
    let params: any = this.activatedRoute.snapshot.params;
  }

  ngOnInit(): void {
    this.getUsuario()
  }

  public getUsuario(): void {//Observable <Usuario>{
    const id = Number(this.activatedRoute.snapshot.paramMap.get('id'));
    this.usuarioService.getUsuario(id).subscribe(usuario => this.usuario = usuario);
  }

}
