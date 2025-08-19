import { HttpInterceptorFn } from "@angular/common/http";
import { Auth } from "../services/auth";
import { inject } from "@angular/core";

export const authInterceptor: HttpInterceptorFn = (req, next) => {
    /**
     * * El authInterceptor es una función que se utiliza para interceptar solicitudes HTTP en una aplicación Angular.
     * ? Su propósito es agregar un token de autenticación a las solicitudes salientes (POST, GET, etc).
     * ! Si el token no existe, la solicitud se envía sin él.
     */
    const auth = inject(Auth);
    
    // Obtener el token de autenticación del servicio Auth
    const token = auth.getToken();

    // Rutas públicas donde NO queremos enviar token
    const publicPaths = ['/auth/login', '/auth/register'];

    //Peticiones que no necesitan token
    const isPublic = publicPaths.some(path => req.url.includes(path));
    /**
     * ? Si la solicitud es a una ruta pública, no se añade el token.
     * ! Esto es útil para evitar enviar el token en solicitudes que no lo requieren, como el registro o inicio de sesión.
     */
    if (token && !isPublic) {

        const cloneReq = req.clone({
            /**
             * ? Aquí se clona la solicitud original y se le añade el token de autorización en los encabezados.
             * ! Esto permite que el backend pueda verificar la autenticidad del usuario. 
             */
            setHeaders: {
                Authorization: `Bearer ${token}`
            }
        });
        return next(cloneReq);
    }
    /**
     * ? Si no hay token o la solicitud es a una ruta pública, se envía la solicitud original sin modificaciones.
     */
    return next(req);
}