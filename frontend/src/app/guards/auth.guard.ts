import { inject } from "@angular/core";
import { CanActivateFn, Router } from "@angular/router";

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
    const router = inject(Router);
    const token = localStorage.getItem('token');

    // Si no hay token, redirigir a la página de login
    if (!token) {
        router.navigateByUrl('/login');
        return false;
    }

    // Si hay token, permitir el acceso
    return true;
}