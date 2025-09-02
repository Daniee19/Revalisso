import { HttpClient } from '@angular/common/http';
import { inject, Injectable } from '@angular/core';
import { Router } from '@angular/router';

@Injectable({
  providedIn: 'root'
})
export class CategoryService {
  private http = inject(HttpClient);
  private router = inject(Router);
  private apiUrl = 'http://localhost:9090/api'; // URL base de la API de autenticación

  consultar() {
    return this.http.get<any>(this.apiUrl + "/categorias");
  }

}
