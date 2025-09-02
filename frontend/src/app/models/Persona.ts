//Los atributos del backend deben de coincidir con los atributos definido desde la interface (frontend).
export interface Persona {
    id: number;
    nombre: string;
    apellido: string;
    celular: string;
    rol: string;
    correo: string;
    contribuciones: Object[];
    blogs: Object[];
}
