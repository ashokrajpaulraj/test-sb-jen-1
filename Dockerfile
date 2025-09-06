# 1. Use OpenJDK image
#for docker
#FROM openjdk:17-jdk-slim
#for jenkins 
FROM eclipse-temurin:17-jdk 

# 2. Set working directory in container
WORKDIR /app

# 3. Copy jar file into container
COPY target/springboot-0.0.1-SNAPSHOT.jar app.jar

EXPOSE 8080

# 4. Run jar file
ENTRYPOINT ["java","-jar","app.jar"]
