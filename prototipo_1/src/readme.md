Breve explicación del funcionamiento de angular

Lo primero que se ejcuta es el _main.ts_ junto con _index.html_

Donde el archivo html solo define lo que conteniene la pestaña, mientras que el ts manda a llamar _app/app.component.ts_.

En _app.module.ts_ definimos las diferentes rutas de los componentes y modulos que estaremos utilizando

Para cada carpeta _header, footer, productos, usuarios, etc_ tendremos los siguientes archivos

- _nombre_.component.ts : Donde se define la parte lógica del programa, como el comportamiiento de los botones.

- _nombre_.component.html : Que es la vista del componente que queremos. Es en las etiquetas del lenguaje donde ponemos a que acción del comoponent.ts queremos que ejecute