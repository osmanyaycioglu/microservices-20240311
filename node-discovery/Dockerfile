FROM openjdk:17-alpine3.14
LABEL authors="osman"
WORKDIR /conf

COPY target/node-discovery-1.0.0.jar discovery.jar
EXPOSE 80
ENTRYPOINT ["sh", "-c", "java -jar discovery.jar"]