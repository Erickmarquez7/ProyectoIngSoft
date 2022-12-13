import { Component, OnInit } from '@angular/core';
import { Reporte } from './reporte';
import { ReporteService } from './reporte.service';
import Swal from 'sweetalert2';
import { AuthService } from '../usuarios/auth.service';
import { Router } from '@angular/router';


import { Producto } from '../productos/producto';
import { Usuario } from '../usuarios/usuario';
import { Observable } from 'rxjs/internal/Observable';

@Component({
  selector: 'app-reportes',
  templateUrl: './reportes.component.html',
  styleUrls: ['./reportes.component.css']
})
export class ReportesComponent implements OnInit {

  constructor(private reporteService: ReporteService, private authService:AuthService, private router: Router) { }

  usuarios : Usuario[]; 

  

  ngOnInit(): void {
    this.reporteService.getUsuariosActivos().subscribe(
      usuarios => this.usuarios = usuarios
    ); 
  }

  public getBaratos():Observable<Producto[]>{
    return this.reporteService.getBaratos(); 
  }

  public getUsuariosActivos(){
    this.reporteService.getUsuariosActivos().subscribe(
      usuarios => this.usuarios = usuarios
    ); 
  }


}
