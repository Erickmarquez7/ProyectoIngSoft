import { Component, OnInit } from '@angular/core';
import {Usuario} from './usuario';
import {UsuarioService} from './usuario.service';
import {Router, ActivatedRoute} from '@angular/router';
import Swal from 'sweetalert2';
import { ActividadesService } from '../actividad/actividades.service';
import { Actividades } from '../actividad/actividades';


@Component({
  selector: 'app-form',
  templateUrl: './form.component.html',
  styleUrls: ['./form.component.css']
})
export class FormComponent implements OnInit {

  titulo: string = "Añadir usuario"
  usuario: Usuario = new Usuario()
  actividad: Actividades = new Actividades()
  actividadService: ActividadesService;

  constructor(private usuarioService: UsuarioService, actividadService: ActividadesService, private router:Router, private activatedRoute: ActivatedRoute) { }

  ngOnInit(): void {
    this.cargarUsuario()
  }

  public cargarUsuario():void{
    this.activatedRoute.params.subscribe(params => {
      let id = params['id']
      if(id) {
        this.usuarioService.getUsuario(id).subscribe((usuario)=> this.usuario=usuario)
      }
    })
  }

  public create():void{
    this.usuarioService.create(this.usuario).subscribe(usuario => 
      {
        this.router.navigate(['/usuarios'])
        Swal.fire('Nuevo Usuario', ` ${usuario.username} creado con éxito`, 'success')
      }
    )
  }

  public update():void {
    this.usuarioService.update(this.usuario).subscribe(usuario =>
    {
      this.router.navigate(['/usuarios'])
      Swal.fire('Usuario ', ` ${usuario.username} Actualizado con éxito`, 'success')
    })
  }
}