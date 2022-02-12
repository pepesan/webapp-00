# Ejemplo de uso de Arquetipo Webapp Maven
# Compilación
<code>$ mvn clena compile</code>
# Empaquetado
<code>$ mvn clean compile package</code>
# Despliegue en Tomcat7 Embebido
<code>$ mvn clean compile tomcat7:run</code>
# Despliegue en Tomcat 9 embebido
mvn org.codehaus.cargo:cargo-maven2-plugin:run
# Acceso a la aplicación
[URL a la aplicación](http://localhost:8080/ejemplo-webapp)