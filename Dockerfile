FROM maven:latest AS BUILD
WORKDIR /usr/app/
COPY . .
RUN mvn -f pom.xml clean package

FROM amazoncorretto:17-alpine
ENV JAR_NAME=TestTask-1.0.0.jar
ENV APP_HOME=/usr/app/
WORKDIR $APP_HOME
COPY --from=BUILD $APP_HOME .
EXPOSE 8080
ENTRYPOINT exec java -jar $APP_HOME/target/$JAR_NAME
