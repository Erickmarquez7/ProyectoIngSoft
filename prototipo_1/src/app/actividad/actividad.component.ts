import { Component, OnInit } from '@angular/core';
import { Actividades } from './actividades';
import { ActividadesService } from './actividades.service';

@Component({
  selector: 'app-actividad',
  templateUrl: './actividad.component.html',
  styleUrls: ['./actividad.component.css']
})
export class ActividadComponent implements OnInit {
  actividad: Actividades[];

  constructor(private actividadService: ActividadesService) { }

  ngOnInit(): void {
    this.actividadService.getActividades().subscribe(
      actividad => this.actividad = actividad
    );
  }

}
