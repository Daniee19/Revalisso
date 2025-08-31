import { Component, inject } from '@angular/core';
import {
  ReactiveFormsModule,
  FormBuilder,
  FormGroup,
  Validators,
} from '@angular/forms';
import { HttpClient } from '@angular/common/http';
import { Router } from '@angular/router';
import { RouterModule } from '@angular/router';
import { Auth } from '../../services/auth';
import { SnackBar } from '../../services/snack-bar';

@Component({
  selector: 'app-login',
  imports: [RouterModule, ReactiveFormsModule],
  templateUrl: './login.html',
  styleUrl: './login.css',
})
export class Login {

  private snackBar = inject(SnackBar);
  private authService = inject(Auth);
  form: FormGroup;
  // ? El FormBuilder permite crear formularios de manera más sencilla y declarativa.
  // ! El FormGroup es una colección de controles de formulario. (validaciones, etc.)
  constructor(private fb: FormBuilder, private http: HttpClient, private router: Router) {
    this.form = this.fb.group({
      correo: ['', [Validators.required, Validators.email]],
      password: ['', [Validators.required, Validators.minLength(6)]],
    });
  }

  verificarJWT() {
    this.snackBar.showSnackBar(this.authService.getToken() || 'No hay token');
  }
  login() {

    console.log(this.form.value); //Retorna el objeto con los valores del formulario
    this.authService.login(this.form.value).subscribe({
      next: (response) => {
        // Si el login es exitoso, se guarda el token en el servicio Auth
        this.authService.setToken(response.token);
        //Se hace otra llamada para traer los datos de ese usuario logueado exitosamente
        this.http.get('http://localhost:9090/api/user/profile')
          .subscribe((user: any) => {
            console.log("Lo traído del backend (login.ts) es: ", user)
            this.authService.setUserData(user);
          

          });

        // Redirigir tras login
        this.router.navigate(['/']);
        this.snackBar.showSnackBar('Logueado con éxito');
      },
      error: (err) => {
        //Si en caso el correo no está registrado, ... etc.
        console.error('Error de login', err);
        this.snackBar.showSnackBar('Credenciales incorrectas');
      },
    });
  }
}
