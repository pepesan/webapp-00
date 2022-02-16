# Ejemplo de uso de Arquetipo Webapp Maven
# Compilación
<code>$ mvn clena compile</code>
# Empaquetado
<code>$ mvn clean compile package</code>
# Despliegue en Tomcat7 Embebido
<code>$ mvn clean compile tomcat7:run</code>
Para cambiar el puerto de arranque modificar la línea del plugin de tomcat7 de 8080 a otro puerto
# Despliegue en Tomcat 9 embebido
mvn clean package org.codehaus.cargo:cargo-maven3-plugin:run

parámetro para cambiar el puerto:
-Dcargo.servlet.port=9001
# Acceso a la aplicación
[URL a la aplicación](http://localhost:8080/ejemplo-webapp)