import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators, ReactiveFormsModule } from '@angular/forms';
import { RouterLink } from '@angular/router';
import { HttpClient } from "@angular/common/http";
import { Router } from '@angular/router';

@Component({
  selector: 'app-register',
  templateUrl: './register.html',
  styleUrls: ['./register.css'],
  imports: [ReactiveFormsModule, RouterLink]
})
export class Register {
  form: FormGroup;

  constructor(
    private fb: FormBuilder,
    private http: HttpClient,
    private router: Router
  ) {
    this.form = this.fb.group({
      nombres: ['', Validators.required],
      apellidos: ['', Validators.required],
      correo: ['', [Validators.required, Validators.email]],
      password: ['', Validators.required],
      celular: [''] // opcional
    });

  }

  register() {
    if (this.form.valid) {
      const credentials = this.form.value;

      //La llamada al backend
      this.http.post<any>("http://localhost:9090/auth/register", credentials)
        .subscribe({
          next: response => {
            console.log(credentials);
            this.router.navigate(["/"]);
          },
          error: err => {
            console.error("Error de login", err);
            alert("Credenciales incorrectas");
          }

        });

      console.log('Formulario de registro enviado:', this.form.value);
      // Aquí iría tu llamada al backend


    }
  }
}
