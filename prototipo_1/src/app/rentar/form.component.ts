import { Component, OnInit } from '@angular/core';
import { Rentar } from './rentar';
import { RentarService } from '../rentar/rentar.service';
import { Router, ActivatedRoute } from '@angular/router';
import swal from 'sweetalert2';

@Component({
  selector: 'app-form',
  templateUrl: './form.component.html',
  styleUrls: ['./form.component.css']
})
export class FormComponent implements OnInit {

  titulo: string = 'Rentar Producto'

  rentar: Rentar = new Rentar()

  constructor(private RentarService: RentarService, private router: Router, private activateRoute: ActivatedRoute) { }

  ngOnInit(): void {
    this.cargarRenta();
  }

  cargarRenta(): void{
    this.activateRoute.params.subscribe(params => {
      let id = params['id']
      if(id){
        this.RentarService.getRenta(id).subscribe((rentar)=>this.rentar=this.rentar)
      }
    })
  }

  /**
   * Crea una renta, para ello inyectamos el servicio rentar
   * en el constructor
   */
  public create(): void{
    //console.log(this.producto)
      this.RentarService.create(this.rentar).subscribe(rentar =>
        {
          this.router.navigate(['/rentar'])
          swal.fire('Nueva renta', `Renta ${rentar.id} creada con éxito`, 'success')
        }
      )
    }
  
    public update(): void{
      this.RentarService.update(this.rentar).subscribe(rentar => {
        this.router.navigate(['/rentar'])
        swal.fire('Renta actualizada', `${this.rentar.id} actualizada con éxito`, 'success')
      })
    }
  
}
