# Microservicios con Spring
## Proyecto realizado con Spring, en el utilizamos las herramientas más potentes que nos ofrece Spring Boot.

## IMPORTANTE
En el archivo: ms_config-service/src/main/resources/bootstrap.yml  
<br> cambiar ${GIT_USER} y ${GIT_PASSWORD} por user y password de tu github o configurar dos variables de entorno para ese proyecto con esos nombres

## DE QUE TRATA SPRING CLOUD
### ¿Qué pasa cuando tenemos varios microservicios y nos interesa tener los archivos de configuracion en el mismo sitio?
Para esto llega a nuestro rescate Spring Cloud, tenemos:
<br> -ms_user-service  
-ms_products-service
<br> Estos son nuestros microservicios, api sencilla de prueba, en nuestro bootstrap.yml de estos dos proyectos configuraremos el acceso
a donde están nuestros archivos de configuracion.

También tenemos:
<br> -ms_config-service
<br> Aquí configuramos el acceso a nuestro repositorio donde tenemos los dos archivos de configuracion de los proyectos

Por último tendremos una simple carpeta llamada:
<br> -ms_file-conf
<br> Donde tendremos los archivos de configuración de nuestros proyectos.
