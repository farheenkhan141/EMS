FROM openjdk:11
FROM maven:3.8-jdk-11 as builder

# Copy local code to the container image.
WORKDIR /app
#RUN mvn package -DskipTests=true

COPY target/employee-management-system-*.war  /employee-management-system.war

EXPOSE 8084

# Run the web service on container startup.
CMD java  -jar /employee-management-system.war
