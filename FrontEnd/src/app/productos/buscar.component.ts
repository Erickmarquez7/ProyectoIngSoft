import { Component, OnInit } from '@angular/core';
import { Producto } from './producto';
import { ProductoService } from './producto.service';
import { ActivatedRoute, Router } from '@angular/router';
import { AuthService } from '../usuarios/auth.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-buscar',
  templateUrl: './buscar.component.html',
  styleUrls: ['./buscar.component.css']
})
export class BuscarComponent implements OnInit {

  producto: Producto = new Producto();

  constructor(private productoService: ProductoService, private router: Router, private activatedRoute: ActivatedRoute, public authService: AuthService) {
    let params: any = this.activatedRoute.snapshot.params;
  }

  ngOnInit(): void {
    this.findUserByName();
  }

  public findUserByName() {
    const name = this.activatedRoute.snapshot.paramMap.get('name');
    this.productoService.getUsuarioByName(name).subscribe(producto => this.producto = producto);
  }

  delete(producto: Producto): void {
    const swalWithBootstrapButtons = Swal.mixin({
      customClass: {
        confirmButton: 'btn btn-success',
        cancelButton: 'btn btn-danger'
      },
      buttonsStyling: false
    })

    swalWithBootstrapButtons.fire({
      title: 'Estas seguro?',
      text: `¿Seguro que desea eliminaar el producto ${producto.nombre}?`,
      icon: 'warning',
      showCancelButton: true,
      confirmButtonText: 'si, Eliminar!',
      cancelButtonText: 'No, cancelar!',
      reverseButtons: true
    }).then((result) => {
      if (result.isConfirmed) {
        this.productoService.delete(producto.id).subscribe(
          Response => {
            // this.productos = this.productos.filter(prod => prod !== producto)
            swalWithBootstrapButtons.fire(
              'Producto Elimindo!',
              'Producto elminado con éxito.',
              'success'
            )
            this.router.navigate(['/productos']);
          }
        )

      }
    })

  }

}
