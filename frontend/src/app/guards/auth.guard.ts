import { inject } from "@angular/core";
import { CanActivateFn, Router } from "@angular/router";
import { Auth } from "../services/auth";

/**
 * Por el momento tiene 2 implementaciones:
 * Checkout y Profile
 */
export const authGuard: CanActivateFn = (route, state) => {
    /**
     * ? El authGuard es una función que se utiliza para proteger rutas en una aplicación Angular.
     * ? Verifica si el usuario está autenticado comprobando la existencia de un token en Amgular.
     * ! Si el token no existe, redirige al usuario a la página de login.
     */
    // Inyectar el servicio de autenticación
    /**
     * ? El inject(Router) facilita la inyección del servicio Router en el guard. (Guard -> acceso o no a la ruta frontend)
     * Esto permite acceder a las funcionalidades de navegación de Angular.
     */
    
    const authService = inject(Auth);

    if (authService.isAuthenticated()) {
        // Si el usuario está autenticado, permite el acceso a la ruta
        return true;
    }
    return false; // Si no está autenticado, redirige al login

}