import { Component, inject } from '@angular/core';
import { ContributionsService } from '../../services/contributions-service';
import { Router } from '@angular/router';
import { SnackBar } from '../../services/snack-bar';
import { Contribution } from '../../models/Contribution';

@Component({
  selector: 'app-contributions',
  imports: [],
  templateUrl: './contributions.html',
  styleUrl: './contributions.css'
})
export class Contributions {
  private contributions = inject(ContributionsService);
  private router = inject(Router);
  private snackBar = inject(SnackBar);

  arrayContributions?: Contribution[];
  constructor() {
    this.consultarContribuciones();
  }
  consultarContribuciones() {
    this.contributions.consultar().subscribe({
      next: (response) => {
        console.log(response);
        this.arrayContributions = response;
        // Redirigir tras login

        this.snackBar.showSnackBar('Contribuciones obtenidas con éxito');
      },
      error: (err) => {
        console.error('Error de las contribuciones', err);
        this.snackBar.showSnackBar('Error al obtener las contribuciones');
      }
    });
  }

}
