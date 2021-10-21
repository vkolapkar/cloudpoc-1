FROM openjdk:8-jdk-alpine

RUN mvn install

ADD target/product-0.0.1-SNAPSHOT.jar app.jar

ENTRYPOINT ["java","-jar","app.jar"]
