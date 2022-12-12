import { Component, OnInit } from '@angular/core';
import { Historial } from './historial';
import { HistorialService } from './historial.service';
import Swal from 'sweetalert2';
import { AuthService } from '../usuarios/auth.service';;

@Component({
  selector: 'app-historial',
  templateUrl: './historial.component.html',
  styleUrls: ['./historial.component.css']
})
export class HistorialComponent implements OnInit {

  historial: Historial[];

  constructor(private historialService: HistorialService, public authService: AuthService ) { }

  ngOnInit(): void {
    this.historialService.getHistorial().subscribe(
      historial => this.historial = historial
    );
  }

}
