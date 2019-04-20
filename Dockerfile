# Alpine Linux with OpenJDK JRE
FROM openjdk:8-jre-alpine

# copy JAR into image
COPY target/shop-api.jar /shop-api.jar

# run application with this command line
CMD ["/usr/bin/java", "-jar", "-Dspring.profiles.active=default", "/shop-api.jar"]