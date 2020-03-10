### STAGE 1: Build ###
FROM openjdk:8-alpine
ADD target/notifications-MS.jar notifications-MS.jar
ENTRYPOINT ["java","-jar","/notifications-MS.jar"]
