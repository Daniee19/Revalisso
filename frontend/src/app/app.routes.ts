import { Routes } from '@angular/router';
import { Home } from './views/home/home';
import { About } from './views/about/about';
import { Contact } from './views/contact/contact';
import { Contributions } from './views/contributions/contributions';
import { Login } from './views/login/login';
import { Register } from './views/register/register';
import { authGuard } from './guards/auth.guard';
import { Checkout } from './views/checkout/checkout';
import { Profile } from './views/profile/profile';
export const routes: Routes = [
    // Definición de las rutas de la aplicación
    // Cada ruta tiene un path y un componente asociado
    // ! Por el momento no se va a usar una validación para el token JWT
    // ! Por lo tanto, no se va a usar el authGuard
    // ? Las rutas públicas son las que no requieren autenticación
    // ? Las rutas protegidas son las que requieren autenticación
    // Rutas públicas
    { path: '', component: Home },
    { path: "about", component: About },
    { path: "contact", component: Contact },
    { path: "products", component: Contributions },
    { path: "login", component: Login },
    { path: "register", component: Register },
    // Rutas protegidas con guard
    { path: 'checkout', component: Checkout, canActivate: [authGuard] },
    { path: 'profile', component: Profile, canActivate: [authGuard] },
    // Ruta para manejar cualquier otra ruta no definida
    { path: "**", redirectTo: '' }
];
