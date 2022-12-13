import { Component, OnInit } from '@angular/core';
import { Rentar } from '../rentar/rentar';
import { RentarService } from '../rentar/rentar.service';
import Swal from 'sweetalert2';
import { AuthService } from '../usuarios/auth.service';

@Component({
  selector: 'app-rentar',
  templateUrl: './rentar.component.html',
  styleUrls: ['./rentar.component.css']
})
export class RentarComponent implements OnInit {

  renta: Rentar[];

  constructor(private rentarService: RentarService, public authService: AuthService ) { }

  ngOnInit(): void {
    this.rentarService.getRentas().subscribe(
      renta => this.renta = renta
    );
  }

  delete(renta: Rentar): void {
    const swalWithBootstrapButtons = Swal.mixin({
      customClass: {
        confirmButton: 'btn btn-success',
        cancelButton: 'btn btn-danger'
      },
      buttonsStyling: false
    })
    
    swalWithBootstrapButtons.fire({
      title: 'Estas seguro?',
      text: `¿Seguro que desea eliminar la renta ${renta.id}?`,
      icon: 'warning',
      showCancelButton: true,
      confirmButtonText: 'si, Eliminar!',
      cancelButtonText: 'No, Cancelar!',
      reverseButtons: true
    }).then((result) => {
      if (result.isConfirmed) {
        this.rentarService.delete(renta.id).subscribe(
          Response => {
            this.renta =  this.renta.filter(rent => rent !== rent)
            swalWithBootstrapButtons.fire(
              'Renta Eliminada!',
              'Renta eliminada con éxito.',
              'success'
            )
          }
        )

      }
    })
    
  }

}