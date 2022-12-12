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

  //Esto es para sumar PumaPuntos 
  montoS : number = 0; 
  montoR : number = 0; 


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
        Swal.fire('Nuevo Usuario', `${usuario.nombre} creado con éxito`, 'success')
      }
    )
  }

  public update(): void{
    this.usuarioService.update(this.usuario).subscribe(usuario => {
      this.router.navigate(['/usuarios'])
      Swal.fire('Producto Actualizado', `${this.usuario.nombre} actualizado con éxito`, 'success')
    })

  }

  public sumar(): void{
    this.usuarioService.sumar(this.usuario, this.montoS).subscribe(usuario => {
      this.router.navigate(['/usuarios'])
      //Swal.fire('Se sumo correctamente los puntos', `${this.usuario.nombre} con éxito`, 'success')
    })

  }

  public restar(): void{
    this.usuarioService.restar(this.usuario, this.montoR).subscribe(usuario => {
      this.router.navigate(['/usuarios'])
      //Swal.fire('Se sumo correctamente los puntos', `${this.usuario.nombre} con éxito`, 'success')
    })

  }

}