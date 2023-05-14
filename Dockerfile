# Dockerfile do projeto
# Linux Alpine e Java RE 17
FROM eclipse-temurin:17-jre-alpine
# Criando variável com o caminho do jar local na aplicação
ARG JAR_FILE=target/health_gpt.jar
# Copiando o jar e alterando o nome
COPY ${JAR_FILE} health_gpt.jar
# Execução da aplicação
ENTRYPOINT ["java","-jar","health_gpt.jar"]