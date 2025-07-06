import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { Header } from './components/header/header';
import { Footer } from './components/footer/footer';

@Component({
  selector: 'app-root',
  imports: [RouterOutlet, Header, Footer], //El routeroutlet va a traer los componentes que se definieron en las rutas
  templateUrl: './app.html',
  styleUrl: './app.css'
}) 
export class App {
  protected title = 'canciones';
}
