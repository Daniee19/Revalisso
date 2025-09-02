import { Archivo } from "./Archivo";
import { Categoria } from "./Categoria";
import { Estado } from "./Estado";
import { Persona } from "./Persona";

export interface Contribution {
    persona: Persona;
    estado: Estado;
    categoria: Categoria;
    archivos: Archivo[];
    fechaContribucion: Date;
    cantidadAproximada: number;
    tituloContribucion: string;
    descripcionContribucion: string;
}

//Falta especificar la interface porque sino dará problemas al compilar
/**
 * Si especificas el tipo correcto (ej. Contribution o { token: string }):

TypeScript valida que lo que devuelva tu backend coincida con lo que definiste.

Evitas errores silenciosos.

El IDE te sugiere y autocompleta.
 */