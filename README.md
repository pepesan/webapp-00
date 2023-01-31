# Ejemplo de uso de Arquetipo Webapp Maven
# Compilación
<code>$ mvn clean compile</code>
# Empaquetado
<code>$ mvn clean compile package</code>
# Despliegue en Tomcat7 Embebido
<code>$ mvn clean compile tomcat7:run</code>
Para cambiar el puerto de arranque modificar la línea del plugin de tomcat7 de 8080 a otro puerto
## referencia
https://tomcat.apache.org/maven-plugin-2.0/tomcat7-maven-plugin/plugin-info.html
# Despliegue en Tomcat 9 embebido
mvn clean package org.codehaus.cargo:cargo-maven3-plugin:run
## referencia
https://codehaus-cargo.github.io/cargo/Tomcat+9.x.html

parámetro para cambiar el puerto:
-Dcargo.servlet.port=9001
# Acceso a la aplicación
[URL a la aplicación](http://localhost:8080/webapp)