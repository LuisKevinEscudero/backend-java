FROM openjdk:19-jdk-alpine3.16@sha256:a8ac92087e997ddbb21211a57eb0fcb02d10e81edbfb88c451cc021d7f407aae
EXPOSE 8081
COPY /target/*.jar /usr/local/lib/spring.jar
ENTRYPOINT ["java","-jar","/usr/local/lib/spring.jar"]