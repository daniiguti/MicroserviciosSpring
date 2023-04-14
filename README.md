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
<br>
<br>
## EUREKA SERVER
### ¿Qué ocurre cuándo tenemos varios microservicios desplegados en distintas ips?¿Como saben los usuarios cual es la dirección de cada uno?
Para esto tenemos Eureka Server, tenemos:
<br> [ms_registry-service](https://github.com/daniiguti/MicroserviciosSpring/tree/master/ms_registry-service)
<br> Aquí tendremos que tener el servicio Servidor, anotar nuestra clase que lanza el programa con @EnableEurekaServer.

También tenemos:
<br> [registry_service.yml](https://github.com/daniiguti/MicroserviciosSpring/blob/master/ms_file-conf/registry_service.yml)
<br> Donde configuraremos nuestro acceso a EurekaServer.

*No olvidar configurar el bootstrap.yml del proyecto de Eureka para conectarlo a Spring Cloud y utlizar los ficheros de configuración
de aquí.

Todo lo que tendríamos que hacer es configurar nuestro archivo de configuracion de Eureka, y añadir tres lineas a los archivos de configuración de nuestros
microservicios y a las clases que lanzan dichos microservicios añadirle la anotación @EnableEurekaClient, con esto tendríamos una página donde tenemos
todos los microservicios disponibles para acceder a estos, algo simple, útil y fácil de implementar en cualquier proyecto.
<br><br>Documentación oficial: [https://cloud.spring.io/spring-cloud-netflix/multi/multi_spring-cloud-feign.html](https://cloud.spring.io/spring-cloud-netflix/multi/multi_spring-cloud-feign.html)
<br>
<br>
## SPRING OPEN-FEIGN
### ¿Qué ocurre cuándo tenemos un servicio API REST que necesita de otro servicio API REST?
por ejemplo, imaginaros que tenemos una api, que devuelve productos, y otra api, que devuelve facturas, ¿Qué ocurre cuando queremos que en esas facturas
se devuelva también toda la información de los productos que llevan nuestras facturas? Para esto tenemos Spring Open-Feign, para no tener que desarrollar
el acceso a nuestra bdd otra vez y cambiar toda nuestra estructura, Spring nos ofrece esto, simplemente creandonos una interfaz que tenga la anotación de
@FeignClient, con su configuración e implementando el metodo de la otra API
<br> [VER AQUÍ](https://github.com/daniiguti/MicroserviciosSpring/blob/master/ms_products-service/src/main/java/com/example/demo/Usuario/UserService.java)
<br> y, además introduciendo el objeto que queremos devolver dentro de la clase que ya devolviamos (anotado con @Transient para que no
lo añada a la bdd)
<br> [VER AQUÍ](https://github.com/daniiguti/MicroserviciosSpring/blob/master/ms_products-service/src/main/java/com/example/demo/Modelos/Producto.java)
<br> y configurando nuestro metodo que devolvía el objeto, para que ahora devuelva el objeto viejo y el objeto nuevo, obteniendolo a través del servicio
que ya estaba disponible(en mi caso, esto no se podía aplicar con sentido, por lo que decidí que en todos los productos se devolviera también el usuario "dani", por lo que si accedíamos a un producto en específico, también veriamos el usuario dani, pero bueno, era para probar que funcionaba correctamente).
<br> [VER AQUÍ](https://github.com/daniiguti/MicroserviciosSpring/blob/master/ms_products-service/src/main/java/com/example/demo/Modelos/Producto.java)
<br><br>Documentación oficial: [https://spring.io/guides/gs/service-registration-and-discovery/](https://spring.io/guides/gs/service-registration-and-discovery/)














