FROM maven:3.9.0-amazoncorretto-19

COPY . ./opt/app

WORKDIR /opt/app

RUN mvn dependency:go-offline

RUN mvn clean package -DskipTests

EXPOSE 8080 5005

CMD ["java", "-jar", "target/travelin-chat-0.0.1-SNAPSHOT.jar"]