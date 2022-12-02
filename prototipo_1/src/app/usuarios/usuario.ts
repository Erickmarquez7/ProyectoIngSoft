export class Usuario {

    id:number;
    username:string;
    password:string;

    //info para las usuarios
    nombre:string;
    paterno:string;
    materno:string;
    carrera:string;
    celular: number;
    email:string;
    enabled: boolean;

    //roles del usario
    roles:string[]=[]

    //para los puma puntos 
    pumapuntos: number;
    fecha: number;

    //foto de perfil xd
    foto:string;


}