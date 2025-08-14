import { Component } from '@angular/core';
import {
  ReactiveFormsModule,
  FormBuilder,
  FormGroup,
  Validators,
} from '@angular/forms';
import { HttpClient } from '@angular/common/http';
import { Router } from '@angular/router';
import { RouterModule } from '@angular/router';

@Component({
  selector: 'app-login',
  imports: [RouterModule, ReactiveFormsModule],
  templateUrl: './login.html',
  styleUrl: './login.css',
})
export class Login {
  form: FormGroup;

  constructor(
    private fb: FormBuilder,
    private http: HttpClient,
    private router: Router
  ) {
    this.form = this.fb.group({
      correo: ['', [Validators.required, Validators.email]],
      password: ['', Validators.required],
    });
  }
  verificarJWT(){
    console.log(localStorage.getItem('token'));
  }
  login() {
    const credentials = this.form.value;

    this.http
      .post<any>('http://localhost:9090/auth/login', credentials)
      .subscribe({
        next: (response) => {
          localStorage.removeItem('token');
          // Guardamos el token en el localStorage
          // Esto permite que el token esté disponible para el authGuard y authInterceptor
          localStorage.setItem('token', response.token); //Guardamos el JWT
          console.log(response.token);
          this.router.navigate(['/']);
        },
        error: (err) => {
          //Si en caso el correo no está registrado, ... etc.
          console.error('Error de login', err);
          alert('Credenciales incorrectas');
        },
      });
  }

}
