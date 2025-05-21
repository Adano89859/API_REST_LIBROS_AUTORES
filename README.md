# PROYECTO API DE BIBLIOTECA (UT7-PRO)

# DESCRIPCIÓN:
Este proyecto trata sobre la creación de una API Rest de una biblioteca, con
conexión a una base de datos, donde se registran los Autores con sus
correspondientes obras.

Cada entidad tiene sus atributos y validaciones propias independientes 
que están conectados mediante una relación @OneToMany (Uno a muchos) y
@ManyToOne (Muchos a uno), todo ello vendrá impreso en una tabla donde
se verá impresa la información ordenada en sus filas y columnas correspondientes.

#INSTRUCCIONES:
1. Crear y activar una base de datos en MySQL Workbench o tu SGBD favorito con un
   nombre identificativo como por ejemplo: "BiblotecaDB".

2. Activar el programa XAMPP y los servicios de Apache y MySQL con puerto al
   MySQL recomendado: 3306 (default).

3. En tu IDE favorito, debes tener una extensión de herramientas llamada
   Spring Boot Extension Pack y descargarte todos los paquetes para que funcione
   la API

4. Configurar en el archivo que esta dentro de las carpetas main > resources >
   application.properties y configurar la siguiente conexión:
   
        spring.application.name=Libros_Autores
        
        spring.datasource.url=jdbc:mysql://localhost:3306/BibliotecaBD
        spring.datasource.username=root
        spring.datasource.password=tu_contraseña
        
        spring.jpa.hibernate.ddl-auto=update
        spring.jpa.show-sql=true
        spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQLDialect
        
        server.port=8080

5. Ejecutar el programa en el ejecutable que está dentro de la carpeta main > java
   el ejecutable se llama LibrosAutoresApplicacion.java > darle a "Run".

6. En tu IDE favorito, ir al apartado de Spring Dashboard y visualizar los los resultados,
   debe salir una página en blanco con un error 404 (Not Found) por defecto.

7. Probar con postman o con tu app de testeo de API favorita y ejecutar las sentencias
   básicas GET, POST, UPDATE y DELETE.

   
   
