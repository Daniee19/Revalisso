import { bootstrapApplication } from '@angular/platform-browser';
import { appConfig } from './app/app.config';
import { App } from './app/app';
import { provideHttpClient, withInterceptors } from '@angular/common/http';

//ProvideRouter para manejar rutas (navegar)
import { provideRouter } from '@angular/router';
import { routes } from './app/app.routes';
import { authInterceptor } from './app/interceptors/auth.interceptor';

/**
 * ? Con el provideHttpClient y withInterceptors, se está configurando el cliente HTTP de Angular para que use el authInterceptor.
 * * Esto significa que todas las solicitudes HTTP realizadas por la aplicación pasarán por el authInterceptor.
 * * ? El authInterceptor se encargará de agregar el token de autenticación a las solicitudes salientes.
 * ? El provideRouter se utiliza para configurar las rutas de la aplicación.
 */
bootstrapApplication(App, {
  providers: [
    provideHttpClient(withInterceptors([authInterceptor])), 
    provideRouter(routes)
  ]
});