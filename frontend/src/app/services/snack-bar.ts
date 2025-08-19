import { inject, Injectable } from '@angular/core';
import { MatSnackBar } from '@angular/material/snack-bar';

@Injectable({
  providedIn: 'root'
})
export class SnackBar {
  private readonly snackBar = inject(MatSnackBar);

  showSnackBar(message: string, action: string = 'Cerrar', duration: number = 5000) {
    /**
     * * Muestra un mensaje de SnackBar con el mensaje, acción y duración especificados.
     * ? El mensaje es el texto que se mostrará en el SnackBar.
     * ! La acción es el texto del botón que se mostrará en el SnackBar.
     * ? La duración es el tiempo en milisegundos que el SnackBar estará visible.
     */
    this.snackBar.open(message, action, { duration });
  }
}
