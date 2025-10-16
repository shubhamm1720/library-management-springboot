# Use OpenJDK 21 base image
FROM openjdk:21-jdk-slim

# Copy jar file from target folder
COPY target/library-management-1.0.0.jar app.jar

# Expose port
EXPOSE 8080

# Run the jar
ENTRYPOINT ["java","-jar","/app.jar"]
