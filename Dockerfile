# Use Maven image to build the JAR
FROM maven:3.8.7-openjdk-17 AS build
WORKDIR /app

# Copy the project files
COPY pom.xml .
COPY src ./src

# Build the project and create the JAR file
RUN mvn clean package -DskipTests

# Use the OpenJDK image to create the final image
FROM openjdk:17
VOLUME /tmp
EXPOSE 8080

# Copy the JAR file from the build stage
COPY --from=build /app/target/TicoNetGamesServer-0.0.1-SNAPSHOT.jar app.jar

# Run the application
ENTRYPOINT ["java","-jar","/app.jar"]
