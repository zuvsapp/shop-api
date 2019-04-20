# Alpine Linux with OpenJDK JRE
FROM maven:3.5.2-jdk-8-alpine

# copy JAR into image
COPY target/shop-api.jar /shop-api.jar

# run application with this command line
CMD ["/usr/bin/java", "-jar", "-Dspring.profiles.active=default", "/shop-api.jar"]