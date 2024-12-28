# Use an appropriate base image for your Spring Boot application
FROM openjdk:17-jdk-slim

# Set the working directory inside the container
WORKDIR /app

# Copy the compiled JAR file into the container
COPY target/Managers-1.0-SNAPSHOT.jar /app/manager-service.jar

# Copy the DEI.csv file into the container
COPY src/main/java/org/example/DEI.csv /app/DEI.csv

# Expose the port your application will run on
EXPOSE 8082

# Run the Spring Boot application
ENTRYPOINT ["java", "-jar", "/app/manager-service.jar"]
