FROM openjdk:11
ADD ./health_gpt.jar health_gpt.jar
ENTRYPOINT ["java","-jar","health_gpt.jar"]