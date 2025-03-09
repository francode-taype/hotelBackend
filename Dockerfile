# Fase de construcción: Usar la imagen Maven para construir el .jar
FROM maven AS build

# Copiar el código fuente al contenedor
WORKDIR /app
COPY . .

# Construir el archivo .jar
RUN mvn clean package -DskipTests

# Fase final: Usar openjdk para ejecutar el .jar
FROM openjdk:21-jdk

# Asegurarse de que el archivo .jar está en la ruta correcta
ARG JAR_FILE=target/hotelBacked-0.0.1-SNAPSHOT.jar
COPY --from=build /app/${JAR_FILE} app_hotelBacked.jar

# Exponer el puerto 8080
EXPOSE 8080

# Ejecutar el .jar
ENTRYPOINT ["java", "-jar", "app_hotelBacked.jar"]
