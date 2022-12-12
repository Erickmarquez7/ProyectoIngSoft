import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { FontAwesomeModule } from '@fortawesome/angular-fontawesome';
import { HeaderComponent } from './header/header.component';
import { FooterComponent } from './footer/footer.component';
import { ProductosComponent } from './productos/productos.component';
import { RouterModule, Routes } from '@angular/router';
import { HttpClientModule } from '@angular/common/http';
import { FormComponent as ProductoFormComponent} from './productos/form.component';
import { FormsModule } from '@angular/forms';
import { LoginComponent } from './usuarios/login.component';
import { FormComponent as UsuarioFormComponent}  from './usuarios/form.component';
import { UsuariosComponent } from './usuarios/usuarios.component';
import { VistausuariosComponent } from './usuarios/vistausuarios.component';
import { VistaproductoComponent } from './productos/vistaproducto.component';
import { ReportesComponent } from './reportes/reportes.component';
import { HistorialComponent } from './historial/historial.component';


const routes: Routes = [
  { path: '', redirectTo: '/', pathMatch: 'full' },
  { path: 'productos', component: ProductosComponent },
  { path: 'productos/form', component: ProductoFormComponent },
  { path: 'productos/form/:id', component: ProductoFormComponent },
  { path: 'productos/:id', component: VistaproductoComponent},
  
  { path: 'login', component: LoginComponent },
  { path: 'usuarios', component: UsuariosComponent },
  { path: 'usuarios/form', component: UsuarioFormComponent },
  { path: 'usuarios/form/:id', component: UsuarioFormComponent },
  { path: 'usuarios/:id', component: VistausuariosComponent},
  { path: 'historial', component: HistorialComponent}
];
/**
 * Para poner las rutas que vamos a utilizar
 */
@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    FooterComponent,
    ProductosComponent,
    UsuarioFormComponent,
    UsuariosComponent,
    VistausuariosComponent,
    ProductoFormComponent,
    LoginComponent,
    UsuariosComponent,
    VistausuariosComponent,
    VistaproductoComponent,
    ReportesComponent,
    HistorialComponent
  ],
  imports: [
    BrowserModule,
    FontAwesomeModule,
    HttpClientModule,
    AppRoutingModule,
    FormsModule,
    BrowserAnimationsModule,
    RouterModule.forRoot(routes)
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
