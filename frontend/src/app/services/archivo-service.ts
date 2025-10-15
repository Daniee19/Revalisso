import { HttpClient } from '@angular/common/http';
import { inject, Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { Archivo } from '../models/Archivo';


@Injectable({
  providedIn: 'root'
})
export class ArchivoService {
  private http = inject(HttpClient);
  private router = inject(Router);
  private apiUrl = 'http://localhost:9090/api/files';

  subirArchivoServer(archivo: File | null) {
    if (!archivo) {
      throw new Error("No se ha seleccionado ningún archivo.");
    }
    const formData = new FormData();
    formData.append('file', archivo); //! El nombre debe ser "file" como en @RequestParam("file")

    return this.http.post<{urlFotoAlojada: string }>(this.apiUrl + "/upload", formData);
  }

  agregarArchivo(archivo: Archivo) {
    return this.http.post<{idArchivo: number}>(this.apiUrl + "/agregar", archivo);
  }

}