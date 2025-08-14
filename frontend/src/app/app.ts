import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';

//Explicitamente traeme esos componentes a parte
import { Header } from './components/header/header';
import { Footer } from './components/footer/footer';
import { Router } from '@angular/router';

@Component({
  selector: 'app-root',
  //El "imports" permite usar las clases dentro del template de este componente (app.html)
  /**
   * El routeroutlet va a traer los componentes que se definieron en las rutas. 
   * El RouterOutlet cuando visito a una ruta (URL) por ejemplo /products, el contenido del <routerOutlet> se adaptará al template de products.
  */
  imports: [RouterOutlet, Header, Footer],
  templateUrl: './app.html',
  styleUrl: './app.css'
})

export class App {
  //El router se tuvo que poner como variable proveniente de la clase Router, para poder usarlo aquí
  constructor(public router: Router) { }

  isLoginRoute(): boolean {
    //Si la ruta de navegación es login da true
    return this.router.url === "/login";
  }
  isRegisterRoute(): boolean {
    //Si la ruta de navegación es login da true
    return this.router.url === "/register";
  }
  protected title = 'revalisso';

}
