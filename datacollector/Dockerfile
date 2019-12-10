FROM openjdk:8-jre-alpine

VOLUME /tmp
ADD /target/data-collector.jar /opt/data-collector/
EXPOSE 8080
WORKDIR /opt/data-collector/
CMD ["java", "-Djava.security.egd=file:/dev/./urandom", "-Xms512m", "-Xmx1g", "-jar", "data-collector.jar"]
