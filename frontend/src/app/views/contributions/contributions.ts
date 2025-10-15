import { Component, inject } from '@angular/core';
import { ContributionsService } from '../../services/contributions-service';
import { Router } from '@angular/router';
import { SnackBar } from '../../services/snack-bar';
import { Contribution } from '../../models/Contribution';
import { FormBuilder, FormGroup, Validators, ReactiveFormsModule } from '@angular/forms';
//Importamos para usar el formulario con angular material
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input';
import { MatButtonModule } from '@angular/material/button';
import { MatSelect } from '@angular/material/select';
import { MatOptionModule } from '@angular/material/core';
import { MatIconModule } from '@angular/material/icon';
import { CategoryService } from '../../services/category-service';
import { Categoria } from '../../models/Categoria';
import { Estado } from '../../models/Estado';
import { EstadoService } from '../../services/estado-service';
import { Auth } from '../../services/auth';
import { ArchivoService } from '../../services/archivo-service';
import { Archivo } from '../../models/Archivo';

@Component({
  selector: 'app-contributions',
  //Se importa para trabajar en el .html
  imports: [ReactiveFormsModule, MatFormFieldModule,
    MatInputModule, MatButtonModule, MatSelect, MatOptionModule, MatIconModule],
  templateUrl: './contributions.html',
  styleUrl: './contributions.css'
})

export class Contributions {
  auth = inject(Auth);
  private contributions = inject(ContributionsService);
  private router = inject(Router);
  private snackBar = inject(SnackBar);
  private categorias = inject(CategoryService);
  private estado = inject(EstadoService);
  private archivo = inject(ArchivoService);
  view: string = "contributions";
  selectedFile: File | null = null;
  form: FormGroup;
  fileName: string = '';

  //ARRAYS
  arrayContributions?: Contribution[];
  arrayCategorias?: Categoria[];
  arrayEstados?: Estado[];


  constructor(private fb: FormBuilder) {

    //Validaciones formulario
    this.form = this.fb.group({
      tituloContribucion: ['', Validators.required],
      descripcionContribucion: ['', Validators.required],
      categoria: ['', [Validators.required]],
      cantidadAproximada: ['', Validators.required],
      idEstado: ['', Validators.required],
      ubicacion: ['', Validators.required],
      urlFoto: ['', Validators.required],
      cantidadPuntos: [''], //opcional
      persona: ['']
    });

    //Se asigna la data de persona para mandarlo al backend y asignarlo en contribuciones
    this.form.get('persona')?.setValue(this.auth.getUserData());

    //Consultas
    this.consultarContribuciones();
    this.consultarCategorias();
    this.consultarEstados();
  }

  consultarCategorias() {
    this.categorias.consultar().subscribe({
      next: (response) => {
        this.arrayCategorias = response;
        this.snackBar.showSnackBar('Las categorias son: ' + response);
        console.log("Categorias cargadas:", this.arrayCategorias);
      },
      error: (err) => {
        console.error('Error de las contribuciones', err);
        this.snackBar.showSnackBar('Error al obtener las contribuciones');
      }
    });
  }
  consultarEstados() {
    this.estado.consultar().subscribe({
      next: (response) => {
        this.arrayEstados = response;
        this.snackBar.showSnackBar('Los estados son: ' + response);
        console.log("Estados cargados:", this.arrayEstados);
      },
      error: (err) => {
        console.error('Error de los estado', err);
        this.snackBar.showSnackBar('Error al obtener los estados');
      }
    });
  }
  onFileSelected(event: Event): void {
    const input = event.target as HTMLInputElement;
    //? Cuando se selecciona un archivo
    if (input.files && input.files.length > 0) {
      this.selectedFile = input.files[0];
      this.fileName = this.selectedFile.name;

      this.form.get('urlFoto')?.setValue(this.fileName);
      this.form.get('urlFoto')?.updateValueAndValidity();
    }
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

  agregarContribucion() {
    if (this.form.valid) {
      const datos_contribucion = this.form.value;
      console.log("los datos son: ", datos_contribucion);


      //* 1. Click en agregar contribución
      this.contributions.agregar(datos_contribucion).subscribe({
        next: (contribucionAgregada) => {
          console.log(datos_contribucion);
          this.snackBar.showSnackBar('Contribución realizada con éxito');

          //TODO 2.(Me retorna el dto guardado) 
          //* Crear la imagen /api/files //retorna url

          console.log("EL this.filename es: " + this.fileName);
          if (!this.selectedFile) {
            this.snackBar.showSnackBar('Selecciona un archivo antes de subir');
            return;
          }

          //SUBLLAMADA
          this.archivo.subirArchivoServer(this.selectedFile).subscribe({
            next: (response) => {
              this.snackBar.showSnackBar('Archivo subido al server con éxito');

              //* Vamos a crear el registro de Archivo

              const archivoData: Archivo = {
                rutaArchivo: response.urlFotoAlojada,
                idContribucion: contribucionAgregada
              };

              console.log("El archivoData que voy a pasar es: ", archivoData);
              // Pasas el objeto a agregarArchivo
              this.archivo.agregarArchivo(archivoData).subscribe({
                next: () => {
                  this.snackBar.showSnackBar('Archivo registrado en la BD con éxito');
                },
                error: (err) => {
                  console.error("Error a subir el archivo a la base de datos: ", err);
                }
              });
            },
            error: (err) => {
              this.snackBar.showSnackBar('Error al subir la foto al server (contribution.ts)', err);
              console.log(err)
            }
          })
        },
        error: (err) => {
          console.error('Error al agregar la contribución (contributions.ts): ', err);
          this.snackBar.showSnackBar('Error al agregar la contribución');
        }
      });
    }
  }

  getImagenUrl(rutaRelativa: string){
    return `http://localhost:9090${rutaRelativa}`;
  }
}
