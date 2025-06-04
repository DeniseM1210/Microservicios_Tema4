# Etapa de construcción: usar Maven con JDK 17
FROM maven:3.8.5-openjdk-17 AS build

# Crear carpeta de trabajo
WORKDIR /app

# Copiar archivos del proyecto
COPY . .

# Construir el proyecto sin ejecutar los tests
RUN mvn clean package -DskipTests

# Etapa final: usar imagen liviana de Java
FROM openjdk:17-jdk-slim

# Crear carpeta de trabajo
WORKDIR /app

# Copiar el .jar desde la etapa anterior
COPY --from=build /app/target/*.jar app.jar

# Comando para ejecutar el jar
ENTRYPOINT ["java", "-jar", "app.jar"]
