import { HttpClient } from '@angular/common/http';
import { inject, Injectable, signal } from '@angular/core';
import { Router } from '@angular/router';
import { Persona } from '../models/Persona';
import { Contribution } from '../models/Contribution';
import { Categoria } from '../models/Categoria';
@Injectable({
  providedIn: 'root'
})
export class ContributionsService {
  private http = inject(HttpClient);
  private router = inject(Router);
  private apiUrl = 'http://localhost:9090/api'; // URL base de la API de autenticación

  consultar() {
    return this.http.get<any>(this.apiUrl + "/contribuciones");
  }

  agregar(datos_contribucion:
    {
      persona: Persona, tituloContribucion: string, descripcionContribucion: string, categoria: Categoria,
      cantidadAproximada: number, estado: number, /*url_foto: string*/
    }) {
    return this.http.post<Contribution[]>(this.apiUrl + "/contribuciones", datos_contribucion);
  }
}
