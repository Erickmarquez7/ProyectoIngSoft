import { Component, OnInit } from '@angular/core';
import { Producto } from './producto';
import { ActivatedRoute, Router } from '@angular/router';
import { ProductoService } from './producto.service';
import { AuthService } from '../usuarios/auth.service';




@Component({
  selector: 'app-vistaproducto',
  templateUrl: './vistaproducto.component.html',
  styleUrls: ['./vistaproducto.component.css']
})
export class VistaproductoComponent implements OnInit {
  producto: Producto = new Producto()

  constructor(private productoService: ProductoService, private router: Router, private activatedRoute: ActivatedRoute, public authService: AuthService) { 
    let params: any = this.activatedRoute.snapshot.params;

  }

  ngOnInit(): void {
    this.getProducto()
  }


  public getProducto(): void {
    const id = Number(this.activatedRoute.snapshot.paramMap.get('id'));
    this.productoService.getProducto(id).subscribe(producto => this.producto = producto);
  }

}
