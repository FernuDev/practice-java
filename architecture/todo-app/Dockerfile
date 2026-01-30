# Build
FROM eclipse-temurin:17-jdk AS build
WORKDIR /build
COPY . .
RUN ./mvnw clean package -DskipTests

# Runtime
FROM eclipse-temurin:17-jdk
WORKDIR /app
COPY --from=build /build/target/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]
