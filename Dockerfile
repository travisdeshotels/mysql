FROM maven:3.9.5-amazoncorretto-17-debian
COPY src /usr/src/app/src
COPY pom.xml /usr/src/app

ARG DB_URL
ARG DB_USERNAME
ARG DB_PASSWORD

ENV DB_URL=$DB_URL
ENV DB_USERNAME=$DB_USERNAME
ENV DB_PASSWORD=$DB_PASSWORD
CMD ["mvn", "-e", "-f", "/usr/src/app/pom.xml", "clean", "test"]
