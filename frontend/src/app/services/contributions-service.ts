import { HttpClient } from '@angular/common/http';
import { inject, Injectable, signal } from '@angular/core';
import { Router } from '@angular/router';
import { Persona } from '../models/Persona';
@Injectable({
  providedIn: 'root'
})
export class ContributionsService {
  private http = inject(HttpClient);
  private router = inject(Router);
  private apiUrl = 'http://localhost:9090/contributions'; // URL base de la API de autenticación

  consultar() {
    return this.http.get<any>(this.apiUrl);
  }
}
