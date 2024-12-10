# Usar imagen base de OpenJDK
FROM openjdk:22-slim

# Establecer directorio de trabajo
WORKDIR /app

# Copiar el archivo JAR del proyecto
COPY target/*.jar app.jar

# Exponer puerto del servicio
EXPOSE 8082

# Comando para ejecutar la aplicación
ENTRYPOINT ["java", "-jar", "/app/app.jar"]
