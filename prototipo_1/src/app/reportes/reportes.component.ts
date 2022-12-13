import { Component, OnInit } from '@angular/core';
import { Reporte } from './reporte';
import { ReporteService } from './reporte.service';
import Swal from 'sweetalert2';
import { AuthService } from '../usuarios/auth.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-reportes',
  templateUrl: './reportes.component.html',
  styleUrls: ['./reportes.component.css']
})
export class ReportesComponent implements OnInit {

  constructor(private reporteService: ReporteService, private authService:AuthService, private router: Router) { }

  ngOnInit(): void {
    //this.reporteService.getBaratos();
  }

}
