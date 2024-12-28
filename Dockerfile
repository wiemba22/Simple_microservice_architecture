# Use an appropriate base image for your Spring Boot application
FROM openjdk:17-jdk-slim

# Set the working directory inside the container
WORKDIR /app

# Copy the compiled JAR file into the container
COPY target/Gender_Manager-1.0-SNAPSHOT.jar /app/gender-service.jar


# Expose the port your application will run on
EXPOSE 8083

# Run the Spring Boot application
ENTRYPOINT ["java", "-jar", "/app/gender-service.jar"]
