import { Component, inject } from '@angular/core';
import { Router, RouterModule } from '@angular/router';
import { Auth } from '../../services/auth';

@Component({
  selector: 'app-header',
  imports: [RouterModule], //El RouterModule hacer que la página no se recargue
  templateUrl: './header.html',
  styleUrl: './header.css'
})
export class Header {
  
  public authService = inject(Auth);
  constructor() { }

  isLoggedIn(): boolean {
    /**
     * ? El método isLoggedIn verifica si el usuario está autenticado comprobando la existencia de un token.
     * ! Esto es útil para mostrar u ocultar elementos de la interfaz de usuario según el estado de autenticación.
     */
    return !!this.authService.getToken();
  }
  logout() {
    /**
     * ? El método logout elimina el token del localStorage y redirige al usuario a la página de inicio.
     * ! Esto es útil para cerrar sesión y evitar que el usuario acceda a rutas protegidas sin autenticación.
     */
    this.authService.logout();

  }
}
