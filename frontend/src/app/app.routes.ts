import { Routes } from '@angular/router';
import { Home } from './views/home/home';
import { About } from './views/about/about';
import { Contact } from './views/contact/contact';
import { Products } from './views/products/products';
import { Login } from './views/login/login';

export const routes: Routes = [
    { path: '', component: Home },
    { path: "about", component: About },
    { path: "contact", component: Contact },
    { path: "products", component: Products },
    { path: "login", component: Login },
    { path: "**", redirectTo: '' }
];
