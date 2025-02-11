import { Component, OnInit } from '@angular/core';
import { Producto } from './producto';
import { ProductoService } from './producto.service';
import { Router, ActivatedRoute } from '@angular/router';
import swal from 'sweetalert2';

@Component({
  selector: 'app-form',
  templateUrl: './form.component.html',
  styleUrls: ['./form.component.css']
})
export class FormComponent implements OnInit {

  titulo: string = 'Agregar Producto'

  producto: Producto = new Producto()

  constructor(private productoService: ProductoService, private router: Router, private activateRoute: ActivatedRoute) { }

  ngOnInit(): void {
    this.cargarProducto();
  }

  
  /**
   * Editar un producto ya existente
   */
  cargarProducto(): void{
    this.activateRoute.params.subscribe(params => {
      let id = params['id']
      if(id){
        this.productoService.getProducto(id).subscribe((producto)=>this.producto=producto)
      }
    })
  }

  /**
   * Crea un producto, para ello inyectamos el servicio producto
   * en el constructor
   */
  public create(): void{
  //console.log(this.producto)
    this.productoService.create(this.producto).subscribe(producto =>
      {
        this.router.navigate(['/productos'])
        swal.fire('Nuevo Producto', `Producto ${producto.nombre} creado con éxito`, 'success')
      }
    )
  }

  public update(): void{
    this.productoService.update(this.producto).subscribe(producto => {
      this.router.navigate(['/productos'])
      swal.fire('Producto Actualizado', `${this.producto.nombre} actualizado con éxito`, 'success')
    })

  }
  
}