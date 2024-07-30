# Estágio de construção do Spring Boot
FROM eclipse-temurin:17-jdk-alpine AS build-java
WORKDIR /app
COPY pom.xml .
COPY mvnw .
COPY .mvn .mvn
COPY src ./src
RUN chmod +x mvnw
RUN ./mvnw clean package -DskipTests

# Estágio final: Executar o aplicativo Spring Boot
FROM eclipse-temurin:17-jdk-alpine
WORKDIR /app
COPY --from=build-java /app/target/*.jar ./app.jar
ENTRYPOINT ["java", "-jar", "./app.jar"]
EXPOSE 8080
