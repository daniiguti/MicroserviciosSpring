# Microservicios con Spring
### Proyecto realizado con Spring, en el utilizamos las herramientas más potentes que nos ofrece Spring Boot.
Versión de Java: 11
<br> Versión de Spring Boot: 2.7
<br> *Este programa se conecta a una bdd local de Oracle llamada PruebaWeb

## SPRING CLOUD
### IMPORTANTE
En el archivo: [bootstrap.yml](https://github.com/daniiguti/MicroserviciosSpring/blob/master/ms_config-service/src/main/resources/bootstrap.yml)
<br> cambiar ${GIT_USER} y ${GIT_PASSWORD} por user y password de tu github o configurar dos variables de entorno para ese proyecto con esos nombres.
### ¿Qué pasa cuando tenemos varios microservicios y nos interesa tener los archivos de configuración en el mismo sitio?
Para esto llega a nuestro rescate Spring Cloud, tenemos:
<br> [ms_products-service](https://github.com/daniiguti/MicroserviciosSpring/tree/master/ms_products-service)
<br> [ms_user-service](https://github.com/daniiguti/MicroserviciosSpring/tree/master/ms_user-service)
<br> Estos son nuestros microservicios, api sencilla de prueba, en nuestro bootstrap.yml de estos dos proyectos configuraremos el acceso
a donde están nuestros archivos de configuracion.

También tenemos:
<br> [ms_config-service](https://github.com/daniiguti/MicroserviciosSpring/tree/master/ms_config-service)
<br> Aquí configuramos el acceso a nuestro repositorio donde tenemos los dos archivos de configuracion de los proyectos

Por último tendremos una simple carpeta llamada:
<br> [ms_file-conf](https://github.com/daniiguti/MicroserviciosSpring/tree/master/ms_file-conf)
<br> Donde tendremos los archivos de configuración de nuestros proyectos.

### Muy bien ahora tenemos todos los archivos, ¿Pero cómo se conectan entre sí?
Lo que haremos será simple, en los archivos de configuración de nuestros proyectos le diremos que se conecten a un servidor
y a un archivo usando spring cloud, nuestro proyecto/server de spring cloud al cual se conectan todos los proyectos, 
controlará la seguridad, y además los redireccionará a los archivos de configuración que le hayamos dicho, estos estarán
en una carpeta de git.
<br>
Algo muy potente y muy útil, complejo de programar pero una vez hecho, te quitará calentamientos de cabeza futuros. 
<br> <br> Documentación oficial: [https://spring.io/projects/spring-cloud](https://spring.io/projects/spring-cloud)
