import { Component } from '@angular/core';
import { Router, RouterModule } from '@angular/router';

@Component({
  selector: 'app-header',
  imports: [RouterModule], //El RouterModule hacer que la página no se recargue
  templateUrl: './header.html',
  styleUrl: './header.css'
})
export class Header {
  constructor(private router: Router) { }
  logout() {
    /**
     * ? El método logout elimina el token del localStorage y redirige al usuario a la página de inicio.
     * ! Esto es útil para cerrar sesión y evitar que el usuario acceda a rutas protegidas sin autenticación.
     */
    localStorage.removeItem('token');
    this.router.navigate(['/login']);
    console.log("Sesión cerrada");
  }
}
