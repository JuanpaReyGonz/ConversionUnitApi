# Etapa 1: Build de la app con Maven y Java 21
FROM maven:3.9.6-eclipse-temurin-21 AS builder

WORKDIR /app

# Copiar el pom.xml y descargar dependencias primero (cache optimizado)
COPY pom.xml .
RUN mvn dependency:go-offline

# Copiar el resto del código
COPY src ./src

# Compilar el proyecto y generar el JAR
RUN mvn clean package -DskipTests

# Etapa 2: Imagen final más liviana (solo con JDK)
FROM eclipse-temurin:21-jre

WORKDIR /app

# Copiar solo el jar desde la etapa anterior
COPY --from=builder /app/target/*.jar app.jar

EXPOSE 8081

# Levantar servicio
ENTRYPOINT ["java", "-jar", "app.jar"]