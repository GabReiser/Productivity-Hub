# Primeiro estágio: Construir o aplicativo Angular
FROM node:20.16.0 AS build-angular
WORKDIR /app
COPY ProductivityHub-FE/package*.json ./
RUN npm install
COPY ProductivityHub-FE/ .
RUN npm run build --prod

# Segundo estágio: Construir o aplicativo Spring Boot
FROM eclipse-temurin:17-jdk-alpine AS build-java
WORKDIR /app
COPY ProductivityHub-BE/pom.xml .
COPY ProductivityHub-BE/mvnw .
COPY ProductivityHub-BE/.mvn .mvn
COPY ProductivityHub-BE/src ./src
RUN chmod +x mvnw
RUN ./mvnw clean package -DskipTests

# Terceiro estágio: Configurar o contêiner final
FROM eclipse-temurin:17-jdk-alpine
WORKDIR /app
COPY --from=build-java /app/target/*.jar ./app.jar
COPY --from=build-angular /app/dist /public
ENTRYPOINT ["java", "-jar", "./app.jar"]
EXPOSE 8080