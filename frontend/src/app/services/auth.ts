import { HttpClient } from '@angular/common/http';
import { inject, Injectable, signal } from '@angular/core';
import { Router } from '@angular/router';

@Injectable({
  providedIn: 'root'
})
/**
 * * El servicio Auth se encarga de manejar la autenticación del usuario.
 * ? Utiliza un signal para almacenar el estado del usuario.
 * ! El signal permite que los componentes se actualicen automáticamente cuando el estado del usuario cambia.
 */
export class Auth {

  /**
 * * Con estas variables ya no se necesita usar `localStorage` directamente en el componente.
 */
  private token: string | null = null;
  private userData: any = null;

  // user = signal<{ name: string } | null>(null);

  setToken(token: string) {
    this.token = token;
  }

  getToken(): string | null {
    return this.token;
  }

  setUserData(data: any) {
    this.userData = data;
  }

  getUserData(): any {
    return this.userData;
  }


  private http = inject(HttpClient);
  private router = inject(Router);
  private apiUrl = 'http://localhost:9090/auth'; // URL base de la API de autenticación

  // * El credentials es un objeto que contiene las credenciales del usuario (correo y password).
  login(credentials: { correo: string; password: string }) {
    // ! Como servicio se debe retornar un observable para que los componentes puedan suscribirse a él.
    return this.http.post<{ token: string }>(`${this.apiUrl}/login`, credentials);
  }

  logout() {
    this.token = null;
    this.userData = null;
    this.router.navigate(['/login']);
  }

  // ? Si existe el token retorna true, si no, retorna false
  isAuthenticated(): boolean {
    return !!this.getToken();
  }
}
