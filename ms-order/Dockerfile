FROM openjdk:17-alpine3.14
LABEL authors="osman"
WORKDIR /order

COPY target/ms-order-1.0.0.jar order.jar
EXPOSE 80
ENV CSERVER=configserver:http://cofigserver
ENV DSERVER=http://discovery/eureka
ENTRYPOINT ["sh", "-c", "java -DCONFSERVER=$CSERVER -Ddiscovery_url=$DSERVER -jar order.jar"]