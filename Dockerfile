FROM maven:3.6.0-jdk-8

WORKDIR /app

VOLUME /app

EXPOSE 8080

CMD ["mvn", "clean", "spring-boot:run", "-Dspring-boot.run.profiles=main.module.dev"]
