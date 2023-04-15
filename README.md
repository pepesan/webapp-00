# Ejemplo de uso de Arquetipo Webapp Maven
# Compilación
<code>$ mvn clean compile</code>
# Empaquetado
<code>$ mvn clean compile package</code>
# Despliegue en Tomcat 11 embebido
mvn clean package org.codehaus.cargo:cargo-maven3-plugin:run
## referencia
https://codehaus-cargo.github.io/cargo/Tomcat+11.x.html

parámetro para cambiar el puerto:
-Dcargo.servlet.port=9001
# Acceso a la aplicación
[URL a la aplicación](http://localhost:8080/webapp)