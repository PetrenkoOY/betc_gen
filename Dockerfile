FROM openjdk:8-jre-alpine
COPY ./target/*.jar betc_gen.jar
COPY ./1/application.properties application.properties
CMD sleep 20 && java -jar betc_gen.jar