import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HeaderComponent } from './header/header.component';
import { FooterComponent } from './footer/footer.component';
import { ProductosComponent } from './productos/productos.component';
import { RouterModule, Routes } from '@angular/router';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule } from '@angular/forms';
import { LoginComponent } from './usuarios/login.component';
import { UsuariosComponent } from './usuarios/usuarios.component';
import { FormComponent as ProductosFormComponent}  from './productos/form.component';
import { FormComponent as UsuariosFormComponent } from './usuarios/form.component';


const routes: Routes = [
  {path: '', redirectTo: '/productos', pathMatch: 'full'},
  {path: 'productos', component: ProductosComponent},
  {path: 'productos/form', component: ProductosFormComponent},
  {path: 'productos/form/:id', component: ProductosFormComponent},
  {path: 'login', component: LoginComponent},
  { path: 'usuarios', component: UsuariosComponent },
  { path: 'usuarios/form', component: UsuariosFormComponent },
  { path: 'usuarios/form/:id', component: UsuariosFormComponent }
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
    ProductosFormComponent,
    UsuariosFormComponent,
    UsuariosComponent,
    LoginComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    AppRoutingModule,
    FormsModule,
    RouterModule.forRoot(routes)
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
