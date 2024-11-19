# Imagen base de OpenJDK para Java 21
FROM openjdk:21-jdk-slim

# Define el directorio de trabajo dentro del contenedor
WORKDIR /app

# Copia el archivo JAR generado en el contenedor
ARG JAR_FILE=target/demo-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} app.jar

# Copia el wallet dentro del contenedor
COPY Wallet_gestionProductos /app/wallet/

# Configura la variable de entorno para el wallet
ENV TNS_ADMIN=/app/wallet

# Expone el puerto que usa tu aplicación
EXPOSE 8080

# Comando para ejecutar la aplicación
ENTRYPOINT ["java", "-jar", "/app.jar"]
