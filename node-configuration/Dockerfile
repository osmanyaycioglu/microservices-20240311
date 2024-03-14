FROM openjdk:17-alpine3.14
LABEL authors="osman"
WORKDIR /conf

COPY target/node-configuration-1.0.0.jar config.jar
EXPOSE 80
ENTRYPOINT ["sh", "-c", "java -jar config.jar"]