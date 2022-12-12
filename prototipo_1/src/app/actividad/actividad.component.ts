import { Component, OnInit } from '@angular/core';
import Swal from 'sweetalert2';
import { Usuario } from '../usuarios/usuario';
import { UsuarioService } from '../usuarios/usuario.service';
import { Actividades } from './actividades';
import { ActividadesService } from './actividades.service';

@Component({
  selector: 'app-actividad',
  templateUrl: './actividad.component.html',
  styleUrls: ['./actividad.component.css']
})
export class ActividadComponent implements OnInit {
  actividad: Actividades[];
  usuarios: Usuario[];
  usuarioService: UsuarioService;

  constructor(private actividadService: ActividadesService) { }

  ngOnInit(): void {
    this.actividadService.getActividades().subscribe(
      actividad => this.actividad = actividad
    );
  }

}
