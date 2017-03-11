FROM java:8-alpine
MAINTAINER Your Name <you@example.com>

ADD target/uberjar/websocket-example.jar /websocket-example/app.jar

EXPOSE 3000

CMD ["java", "-jar", "/websocket-example/app.jar"]
