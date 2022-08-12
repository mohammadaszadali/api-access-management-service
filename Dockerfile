FROM openjdk:8-jre
ADD target/api-access-management-service-1.0.jar api-access-management-service.jar
RUN sh -c 'touch /api-access-management-service.jar'
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/api-access-management-service.jar"]