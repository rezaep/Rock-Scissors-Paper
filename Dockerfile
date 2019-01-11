# Base Alpine Linux based image with OpenJDK JRE only
FROM openjdk:8-jre-alpine

# Add the application's jar to the container
COPY /target/rock-scissors-paper-*.jar app.jar

# Specify default command
CMD ["/usr/bin/java", "-jar", "/app.jar"]