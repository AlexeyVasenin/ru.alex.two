FROM adoptopenjdk:8-jre-hotspot

RUN mkdir /usr/share/app

WORKDIR /usr/share/app

COPY target/ru.alex.two-1.0-SNAPSHOT.jar /usr/share/app/app.jar

ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom", "-jar", "app.jar"]
