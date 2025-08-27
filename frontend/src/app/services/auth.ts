import { HttpClient } from '@angular/common/http';
import { inject, Injectable, signal } from '@angular/core';
import { Router } from '@angular/router';
import { Persona } from '../models/Persona';
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
  // user = signal<{ name: string } | null>(null);

  setToken(token: string) {
    localStorage.setItem("token", token);
  }

  getToken(): string | null {
    return localStorage.getItem("token");
  }

  removeToken() {
    localStorage.removeItem("token");
  }

  setUserData(data: Persona) {
    localStorage.setItem("userData", JSON.stringify(data));
  }

  getUserData(): Persona | null {
    return localStorage.getItem("userData") ? JSON.parse(localStorage.getItem("userData")!) : null;
  }

  removeUserData() {
    localStorage.removeItem("userData");
  }
  
  private http = inject(HttpClient);
  private router = inject(Router);
  private apiUrl = 'http://localhost:9090/auth'; // URL base de la API de autenticación

  // * El credentials es un objeto que contiene las credenciales del usuario (correo y password).
  login(credentials: { correo: string; password: string }) {
    // ! Como servicio se debe retornar un observable para que los componentes puedan suscribirse a él.
    return this.http.post<{ token: string }>(`${this.apiUrl}/login`, credentials);
  }

  register(credentials: { nombres: string; apellidos: string; correo: string; password: string; celular?: string }) {
    return this.http.post<any>(`${this.apiUrl}/register`, credentials);
  }

  logout() {
    this.removeToken();
    this.removeUserData();
    this.router.navigate(['/login']);
  }

  // ? Si existe el token retorna true, si no, retorna false
  isAuthenticated(): boolean {
    return !!this.getToken();
  }
}
