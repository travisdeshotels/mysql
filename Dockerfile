FROM maven:3.9.5-amazoncorretto-17-debian
COPY src /usr/src/app/src
COPY pom.xml /usr/src/app
CMD ["mvn", "-e", "-f", "/usr/src/app/pom.xml", "clean", "test"]
