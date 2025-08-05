import { Component } from '@angular/core';
import { ReactiveFormsModule, FormBuilder, FormGroup, Validators } from "@angular/forms";
import { HttpClient } from '@angular/common/http';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  imports: [ReactiveFormsModule],
  templateUrl: './login.html',
  styleUrl: './login.css'
})
export class Login {

  form: FormGroup;

  constructor(
    private fb: FormBuilder,
    private http: HttpClient,
    private router: Router
  ) {
    this.form = this.fb.group({
      correo: ["", [Validators.required, Validators.email]],
      contrasena: ["", Validators.required]
    });
  }

  login() {
    const credentials = this.form.value;

    this.http.post<any>("http://localhost:8080/auth/login", credentials)
      .subscribe({
        next: response => {
          localStorage.setItem("token", response.token); //Guardamos el JWT
          this.router.navigate(["/"]);
        },
        error: err => {
          console.error("Error de login", err);
          alert("Credenciales incorrectas");
        }
      });

  }


}
